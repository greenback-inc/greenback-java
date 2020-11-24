package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.model.GreenbackException;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Query;
import com.greenback.kit.util.IoFunction;
import com.greenback.kit.util.StreamingPaginated;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import java.util.stream.StreamSupport;

public class ClientHelper {
 
    private static final DateTimeFormatter DTF_ISO_WITH_MILLIS = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .withZone(ZoneId.of("UTC"));
    
    static public String toInstantParameter(
            Instant instant) {
        
        if (instant != null) {
            return DTF_ISO_WITH_MILLIS.format(instant);
        }
        
        return null;
    }
    
    static public Optional<Integer> toLimitQueryParameter(
            Query<?> query) {
        
        if (query == null) {
            return Optional.empty();
        }
        
        return ofNullable(query.getLimit());
    }
 
    static public Optional<String> toExpandQueryParameter(
            Query<?> query) {
        
        if (query == null) {
            return Optional.empty();
        }
        
        return ofNullable(toListQueryParameter(query.getExpands()));
    }
 
    static public Optional<String> toExpandQueryParameter(
            Iterable<String> expands) {
        
        return ofNullable(toListQueryParameter(expands));
    }
 
    static public String toListQueryParameter(
            Iterable<?> expands) {
        
        if (expands == null) {
            return null;
        }
        
        final String param = StreamSupport.stream(expands.spliterator(), false)
            .map(v -> Objects.toString(v))
            .collect(joining(","));
        
        if (param == null || param.isEmpty()) {
            return null;
        }
        
        return param;
    }
    
    static public <T> T toValue(ClientIoConsumeHandler<T> consumer) throws IOException {
        try {
            // run the deserializer (it also checks for json-based errors
            return consumer.apply();
        } catch (GreenbackException e) {
            final String category = ofNullable(e.getError())
                .map(v -> v.getCategory())
                .orElse(null);
            
            if (category != null && "not_found".equalsIgnoreCase(category)) {
                return null;
            }
            
            throw e; // rethrow it
        }
    }
    
    static public <T> Paginated<T> toStreamingPaginated(
            String url,
            IoFunction<String,Paginated<T>> method) throws IOException {
        
        Paginated<T> paginated = method.apply(url);

        // convert into a streaming version
        StreamingPaginated<T> streamingPaginated = new StreamingPaginated<>();
        streamingPaginated.setPagination(paginated.getPagination());
        streamingPaginated.setValues(paginated.getValues());
        
        // setup streaming pagination
        streamingPaginated.nextMethod(v -> {
            final String nextUrl = new MutableUri(url)
                .setQuery("cursor", v.getNext())
                .toString();
            return toStreamingPaginated(nextUrl, method);
        });
        
        return streamingPaginated;
    }
    
}