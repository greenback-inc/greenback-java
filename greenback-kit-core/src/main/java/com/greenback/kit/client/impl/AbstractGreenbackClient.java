package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackCodec;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.GreenbackException;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import com.greenback.kit.util.Bytes;
import com.greenback.kit.util.IoFunction;
import com.greenback.kit.util.StreamingPaginated;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import static java.util.Optional.ofNullable;

abstract public class AbstractGreenbackClient implements GreenbackClient {
    
    protected final String baseUrl;
    protected final GreenbackCodec codec;
    protected final String accessToken;

    protected AbstractGreenbackClient(
            String baseUrl,
            GreenbackCodec codec,
            String accessToken) {
        
        Objects.requireNonNull(baseUrl, "baseUrl was null");
        Objects.requireNonNull(codec, "codec was null");
        Objects.requireNonNull(accessToken, "accessToken was null");
        
        this.codec = codec;
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }
    
    @Override
    public GreenbackCodec getCodec() {
        return this.codec;
    }
    
    private MutableUri buildBaseUri() {
        
        MutableUri uri = new MutableUri(this.baseUrl);
        
        return uri;
    }

    static public interface ResponseHandler<T> {
        public T deserialize(InputStream input) throws IOException;
    }

    static public interface ConsumeHandler<T> {
        public T apply() throws IOException;
    }
    
    static public <T> T toValue(ConsumeHandler<T> consumer) throws IOException {
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
    
    //
    // Users
    //
    
    @Override
    public User getUserById(
            String userId) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/users")
            .rel(userId)
            .toString();
        
        return this.toValue(() -> this.getUserByUrl(url));
    }
    
    abstract protected User getUserByUrl(
            String url) throws IOException;
    
    //
    // Connects
    //
    
    @Override
    public Paginated<Connect> getConnects(
            ) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/connects")
            .toString();
        
        return this.getConnectsByUrl(url);
    }
    
    @Override
    public Connect getConnectByLabel(
            String connectLabel) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/connects")
            .rel(connectLabel)
            .toString();
        
        return this.toValue(() -> this.getConnectByUrl(url));
    }
    
    abstract protected Paginated<Connect> getConnectsByUrl(
            String url) throws IOException;
    
    abstract protected Connect getConnectByUrl(
            String url) throws IOException;
    
    //
    // Accounts
    //
    
    @Override
    public Paginated<Account> getAccounts(
            AccountQuery accountQuery) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/accounts")
            .queryIfPresent("limit", ofNullable(accountQuery).map(v -> v.getLimit()))
            .queryIfPresent("expand", ofNullable(accountQuery).map(v -> v.toParameter()))
            .toString();
        
        return this.getAccountsByUrl(url);
    }
    
    @Override
    public Account getAccountById(
            String accountId) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/accounts")
            .rel(accountId)
            .toString();
        
        return this.toValue(() -> this.getAccountByUrl(url));
    }
    
    abstract protected Paginated<Account> getAccountsByUrl(
            String url) throws IOException;
    
    abstract protected Account getAccountByUrl(
            String url) throws IOException;

    //
    // Visions
    //
    
    @Override
    public Vision createVision(
            VisionRequest visionRequest) throws IOException {
        
        final String url = this.buildBaseUri()
            .path("v2/visions")
            .queryIfPresent("async", ofNullable(visionRequest.getAsync()))
            .toString();
        
        return this.toValue(() -> this.createVisionByUrl(
            url, visionRequest.getDocument()));
    }
    
    abstract protected Vision createVisionByUrl(
            String url,
            Bytes documentBytes) throws IOException;
    
    @Override
    public Vision getVisionById(
            String visionId) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/visions")
            .rel(visionId)
            .toString();
        
        return this.toValue(() -> this.getVisionByUrl(url));
    }
    
    abstract protected Vision getVisionByUrl(
            String url) throws IOException;
    
    
    //
    // Messages
    //
    
    @Override
    public Paginated<Message> getMessages(
            MessageQuery messageQuery) throws IOException {
        
        final String url = this.buildBaseUri()
            .path("v2/messages")
            .queryIfPresent("expand", ofNullable(messageQuery).map(v -> v.toParameter()))
            .queryIfPresent("limit", ofNullable(messageQuery).map(v -> v.getLimit()))
            .toString();
        
        return this.toStreamingPaginated(url, v -> this.getMessagesByUrl(v));
    }

    @Override
    public Message createMessage(
            MessageRequest messageRequest) throws IOException {
        
        final String url = this.buildBaseUri()
            .path("v2/messages")
            .queryIfPresent("async", ofNullable(messageRequest.getAsync()))
            .toString();
        
        return this.toValue(() -> this.createMessageByUrl(
            url, messageRequest.getDocument()));
    }
    
    @Override
    public Message getMessageById(
            String messageId) throws IOException {

        final String url = this.buildBaseUri()
            .path("v2/messages")
            .rel(messageId)
            .toString();
        
        return this.toValue(() -> this.getMessageByUrl(url));
    }

    abstract protected Paginated<Message> getMessagesByUrl(
            String url) throws IOException;
    
    abstract protected Message createMessageByUrl(
            String url,
            Bytes documentBytes) throws IOException;
    
    abstract protected Message getMessageByUrl(
            String url) throws IOException;
    
}