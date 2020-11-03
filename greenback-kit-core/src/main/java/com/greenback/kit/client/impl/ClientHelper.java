package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.model.GreenbackException;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Query;
import com.greenback.kit.util.IoFunction;
import com.greenback.kit.util.StreamingPaginated;
import java.io.IOException;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import java.util.stream.StreamSupport;

public class ClientHelper {
 
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
        
        return toExpandQueryParameter(query.getExpands());
    }
 
    static public Optional<String> toExpandQueryParameter(
            Iterable<String> expands) {
        
        if (expands == null) {
            return Optional.empty();
        }
        
        final String expand = StreamSupport.stream(expands.spliterator(), false)
            .collect(joining(","));
        
        if (expand == null || expand.isEmpty()) {
            return null;
        }
        
        return ofNullable(expand);
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