package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackCodec;
import static com.greenback.kit.client.impl.ClientHelper.toExpandQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toLimitQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toStreamingPaginated;
import static com.greenback.kit.client.impl.ClientHelper.toValue;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.ConnectQuery;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import com.greenback.kit.util.Bytes;
import java.io.IOException;
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
    
    protected MutableUri buildBaseUrl() {
        final MutableUri url = new MutableUri(this.baseUrl);
        // protect against someone include params on the base url that get included
        url.setQuery(null);
        url.fragment(null);
        return url;
    }

    //
    // Users
    //
    
    @Override
    public User getUserById(
            String userId,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(userId, "userId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/users")
            .rel(userId)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getUserByUrl(url));
    }
    
    abstract protected User getUserByUrl(
            String url) throws IOException;
    
    //
    // Connects
    //
    
    @Override
    public Paginated<Connect> getConnects(
            ConnectQuery connectQuery) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/connects")
            .queryIfPresent("expand", toExpandQueryParameter(connectQuery))
            .queryIfPresent("limit", toLimitQueryParameter(connectQuery))
            .toString();
        
        return toStreamingPaginated(url, v -> this.getConnectsByUrl(v));
    }
    
    @Override
    public Connect getConnectByLabel(
            String connectLabel,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(connectLabel, "connectLabel was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/connects")
            .rel(connectLabel)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getConnectByUrl(url));
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

        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .queryIfPresent("expand", toExpandQueryParameter(accountQuery))
            .queryIfPresent("limit", toLimitQueryParameter(accountQuery))
            .toString();
        
        return this.getAccountsByUrl(url);
    }
    
    @Override
    public Account getAccountById(
            String accountId,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(accountId, "accountId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .rel(accountId)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getAccountByUrl(url));
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
        
        Objects.requireNonNull(visionRequest, "visionRequest was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/visions")
            .queryIfPresent("async", ofNullable(visionRequest.getAsync()))
            .toString();
        
        return toValue(() -> this.createVisionByUrl(
            url, visionRequest.getDocument()));
    }
    
    abstract protected Vision createVisionByUrl(
            String url,
            Bytes documentBytes) throws IOException;
    
    @Override
    public Vision getVisionById(
            String visionId,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(visionId, "visionId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/visions")
            .rel(visionId)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getVisionByUrl(url));
    }
    
    abstract protected Vision getVisionByUrl(
            String url) throws IOException;
    
    
    //
    // Messages
    //
    
    @Override
    public Paginated<Message> getMessages(
            MessageQuery messageQuery) throws IOException {
        
        final String url = this.buildBaseUrl()
            .path("v2/messages")
            .queryIfPresent("expand", toExpandQueryParameter(messageQuery))
            .queryIfPresent("limit", toLimitQueryParameter(messageQuery))
            .toString();
        
        return toStreamingPaginated(url, v -> this.getMessagesByUrl(v));
    }

    @Override
    public Message createMessage(
            MessageRequest messageRequest) throws IOException {
        
        final String url = this.buildBaseUrl()
            .path("v2/messages")
            .queryIfPresent("async", ofNullable(messageRequest.getAsync()))
            .toString();
        
        return toValue(() -> this.createMessageByUrl(
            url, messageRequest.getDocument()));
    }
    
    @Override
    public Message getMessageById(
            String messageId,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(messageId, "messageId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/messages")
            .rel(messageId)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getMessageByUrl(url));
    }

    abstract protected Paginated<Message> getMessagesByUrl(
            String url) throws IOException;
    
    abstract protected Message createMessageByUrl(
            String url,
            Bytes documentBytes) throws IOException;
    
    abstract protected Message getMessageByUrl(
            String url) throws IOException;
    
    
    //
    // Transactions
    //
    
    @Override
    public Paginated<Transaction> getTransactions(
            TransactionQuery transactionQuery) throws IOException {
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .queryIfPresent("expand", toExpandQueryParameter(transactionQuery))
            .queryIfPresent("limit", toLimitQueryParameter(transactionQuery))
            .toString();
        
        return toStreamingPaginated(url, v -> this.getTransactionsByUrl(v));
    }
    
    @Override
    public Transaction getTransactionById(
            String transactionId,
            Iterable<String> expands) throws IOException {

        Objects.requireNonNull(transactionId, "transactionId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId)
            .queryIfPresent("expand", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getTransactionByUrl(url));
    }

    abstract protected Paginated<Transaction> getTransactionsByUrl(
            String url) throws IOException;
    
    abstract protected Transaction getTransactionByUrl(
            String url) throws IOException;
    
//    public GBTransactionExporter getTransactionExporter(
//            String accessToken,
//            String transactionId,
//            String accountId,
//            DateTime verifiedBy,
//            String expand) throws IOException {
//
//        String url = this.buildBaseUri()
//            .path("api/v2/transactions").rel(transactionId, "exporters", accountId)
//            .queryIfPresent("verified_by", ofNullable(verifiedBy))
//            .queryIfPresent("expand", ofNullable(expand))
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .addHeader("Authorization", "Bearer " + accessToken);
//        
//        return this.execute(requestBuilder, this.codec::deserializeTransactionExporter);
//    }
//    
//    public GBTransactionExport saveTransactionExport(
//            String accessToken,
//            String transactionId,
//            String accountId,
//            String targetId,
//            DateTime verifiedBy,
//            Map<String,String> parameters) throws IOException {
//
//        String url = this.buildBaseUri()
//            .path("api/v2/transactions").rel(transactionId, "exporters", accountId)
//            .relIfPresent(ofNullable(targetId))
//            .queryIfPresent("verified_by", ofNullable(verifiedBy))
////            .queryIfPresent("expand", ofNullable(expand))
//            .toString();
//        
//        Map<String,Object> data = new LinkedHashMap<>();
//        data.put("parameters", parameters);
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .addHeader("Authorization", "Bearer " + accessToken)
//            .post(RequestBody.create(MediaType.parse("application/json"),
//                this.codec.getObjectMapper().writeValueAsBytes(data)));
//
//        return this.execute(requestBuilder, this.codec::deserializeTransactionExport);
//    }
//    
//    public void deleteTransactionExport(
//            String accessToken,
//            String transactionId) throws IOException {
//
//        final String url = this.buildBaseUri()
//            .path("api/v2/transaction_exports").rel(transactionId)
////            .queryIfPresent("verified_by", ofNullable(verifiedBy))
////            .queryIfPresent("expand", ofNullable(expand))
//            .toString();
//
//        final Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .addHeader("Authorization", "Bearer " + accessToken)
//            .delete();
//
//        this.execute(requestBuilder, this.codec::deserializeMap);
//    }
    
    
}