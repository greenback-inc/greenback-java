package com.greenback.kit.okhttp;

import com.greenback.kit.client.GreenbackCodec;
import com.greenback.kit.client.impl.AbstractGreenbackClient;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.okhttp.impl.BaseOkHttpClient;
import com.greenback.kit.util.Bytes;
import java.io.IOException;
import static java.util.Optional.ofNullable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpGreenbackClient extends AbstractGreenbackClient implements BaseOkHttpClient {
        
    protected final OkHttpClient httpClient;
    
    public OkHttpGreenbackClient(
            OkHttpClient httpClient,
            String baseUrl,
            GreenbackCodec codec,
            String accessToken) {
        
        super(baseUrl, codec, accessToken);
        this.httpClient = httpClient;
    }

    @Override
    public OkHttpClient getHttpClient() {
        return this.httpClient;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
    
    @Override
    protected User getUserByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final User value
            = this.execute(requestBuilder, this.codec::readUser);
        
        return value;
    }
    
    @Override
    protected Paginated<Connect> getConnectsByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Paginated<Connect> connects
            = this.execute(requestBuilder, this.codec::readConnects);
        
        return connects;
    }
    
    @Override
    protected Connect getConnectByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Connect value
            = this.execute(requestBuilder, this.codec::readConnect);
        
        return value;
    }
    
    @Override
    protected Paginated<Account> getAccountsByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Paginated<Account> accounts
            = this.execute(requestBuilder, this.codec::readAccounts);
        
        return accounts;
    }
    
    @Override
    protected Account getAccountByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Account value
            = this.execute(requestBuilder, this.codec::readAccount);
        
        return value;
    }
    
    private RequestBody toRequestBody(Bytes bytes) {
        if (bytes.getFile() != null) {
            return RequestBody.create(MediaType.parse("application/octet-stream"), bytes.getFile());
        }
        else {
            return RequestBody.create(MediaType.parse("application/octet-stream"), bytes.getBytes());
        }
    }
    
    @Override
    protected Vision createVisionByUrl(
            String url,
            Bytes documentBytes) throws IOException {
        
        final String name = ofNullable(documentBytes.getName()).orElse("file");
        
        final MultipartBody multipartBody = new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file", name, toRequestBody(documentBytes))
            .build();

        final Request.Builder requestBuilder = new Request.Builder()
            .url(url)
            .post(multipartBody);
        
        final Vision value
            = this.execute(requestBuilder, this.codec::readVision);
        
        return value;
    }
    
    @Override
    protected Vision getVisionByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Vision value
            = this.execute(requestBuilder, this.codec::readVision);
        
        return value;
    }
    
    @Override
    protected Message createMessageByUrl(
            String url,
            Bytes documentBytes) throws IOException {
        
        final String name = ofNullable(documentBytes.getName()).orElse("file");
        
        final MultipartBody multipartBody = new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("file", name, toRequestBody(documentBytes))
            .build();

        final Request.Builder requestBuilder = new Request.Builder()
            .url(url)
            .post(multipartBody);
        
        final Message value
            = this.execute(requestBuilder, this.codec::readMessage);
        
        return value;
    }
    
    @Override
    protected Paginated<Message> getMessagesByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Paginated<Message> messages
            = this.execute(requestBuilder, this.codec::readMessages);
        
        return messages;
    }
    
    @Override
    protected Message getMessageByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        final Message message
            = this.execute(requestBuilder, this.codec::readMessage);
        
        return message;
    }
    
    
//    @Override
//    public Account getAccount(
//            String id,
//            String expand) throws IOException {
//        
//        String url = this.buildBaseUri()
//            .path("api/v1/accounts/" + id)
//            .queryIfPresent("expand", ofNullable(expand))
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url);
//        
//        return this.execute(requestBuilder, this.codec::deserializeAccount);
//    }
//    
//    @Override
//    public PaginatedResponse<Account> getAccounts(
//            String expand,
//            Long limit) throws IOException {
//        
//        return this.getAccounts(expand, limit, null);
//    }
//    
//    @Override
//    public PaginatedResponse<Account> getAccountsNext(
//            PaginatedResponse<Account> previous) throws IOException {
//        
//        if (!previous.hasNext()) {
//            return null;
//        }
//        
//        return this.getAccounts(
//            previous.getExpand(),
//            previous.getPagination().getLimit(),
//            previous.getPagination().getNext());
//    }
//    
//    private PaginatedResponse<Account> getAccounts(
//            String expand,
//            Long limit,
//            String cursor) throws IOException {
//
//        String url = this.buildBaseUri()
//            .path("api/v1/accounts")
//            .queryIfPresent("expand", ofNullable(expand))
//            .queryIfPresent("limit", ofNullable(limit))
//            .queryIfPresent("cursor", ofNullable(cursor))
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url);
//        
//        PaginatedResponse<Account> response
//            = this.execute(requestBuilder, this.codec::deserializePaginatedAccounts);
//        
//        response.setNextMethod(v -> this.getAccountsNext(v));
//        response.setExpand(expand);
//        ofNullable(response.getPagination())
//            .ifPresent(v -> v.setLimit(limit));
//        
//        return response;
//    }
//    
//    @Override
//    public Sync createAccountSync(
//            String accountId) throws IOException {
//
//        return this.createAccountSync(null, accountId, new SyncRequest());
//    }
//    
//    public Sync createAccountSync(
//            Boolean preview,
//            String accountId,
//            SyncRequest syncRequest) throws IOException {
//        
//        String url = this.buildBaseUri()
//            .path("api/v1/accounts/" + accountId + "/syncs")
//            .queryIfPresent("preview", ofNullable(preview))
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .post(RequestBody.create(MediaType.parse("application/json"),
//                this.codec.getObjectMapper().writeValueAsBytes(syncRequest)));
//
//        return this.execute(requestBuilder, this.codec::deserializeSync);
//    }
//    
//    public GBBoolean nextAccountSync(
//            String accountId,
//            SyncRequest nextSyncRequest) throws IOException {
//        
//        String url = this.buildBaseUri()
//            .path("api/v1/accounts/" + accountId + "/syncs")
//            .query("next", true)
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .post(RequestBody.create(MediaType.parse("application/json"),
//                this.codec.getObjectMapper().writeValueAsBytes(nextSyncRequest)));
//
//        return this.execute(requestBuilder,
//            v -> this.codec.getObjectMapper().readValue(v, GBBoolean.class));
//    }
//    
//    @Override
//    public Sync getSync(
//            String id) throws IOException {
//        
//        String url = this.buildBaseUri()
//            .path("api/v1/syncs/" + id)
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url);
//        
//        return this.execute(requestBuilder, this.codec::deserializeSync);
//    }
//    
//    public JsonNode getProfitLoss(
//            String accountId) throws IOException {
//        
//        String url = this.buildBaseUri()
//            .path("api/v1/accounts/" + accountId + "/profit_loss")
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url);
//        
//        return this.execute(requestBuilder, v -> this.codec.getObjectMapper().readValue(v, JsonNode.class));
//    }
//   
//    //
//    // Transactions
//    //
//    
//    //@Override
//    public PaginatedResponse<Transaction> getTransactions(
//            String accessToken,
//            String flag,
//            Boolean descending,
//            String expand,
//            Long limit) throws IOException {
//        
//        return this.getTransactions(accessToken, flag, descending, expand, limit, null);
//    }
//    
//    //@Override
//    public PaginatedResponse<Transaction> getTransactionsNext(
//            String accessToken,
//            String flag,
//            Boolean descending,
//            PaginatedResponse<Transaction> previous) throws IOException {
//        
//        if (!previous.hasNext()) {
//            return null;
//        }
//        
//        return this.getTransactions(
//            accessToken,
//            flag,
//            descending,
//            previous.getExpand(),
//            previous.getPagination().getLimit(),
//            previous.getPagination().getNext());
//    }
//    
//    private PaginatedResponse<Transaction> getTransactions(
//            String accessToken,
//            String flag,
//            Boolean descending,
//            String expand,
//            Long limit,
//            String cursor) throws IOException {
//
//        String url = this.buildBaseUri()
//            .path("api/v2/transactions")
//            .queryIfPresent("flag", ofNullable(flag))
//            .queryIfPresent("descending", ofNullable(descending))
//            .queryIfPresent("expand", ofNullable(expand))
//            .queryIfPresent("limit", ofNullable(limit))
//            .queryIfPresent("cursor", ofNullable(cursor))
//            .toString();
//        
//        Request.Builder requestBuilder = new Request.Builder()
//            .url(url)
//            .addHeader("Authorization", "Bearer " + accessToken);
//        
//        PaginatedResponse<Transaction> response
//            = this.execute(requestBuilder, this.codec::deserializePaginatedTransactions);
//        
//        response.setNextMethod(v -> this.getTransactionsNext(accessToken, flag, descending, v));
//        response.setExpand(expand);
//        ofNullable(response.getPagination())
//            .ifPresent(v -> v.setLimit(limit));
//        
//        return response;
//    }
//    
//    public TransactionExporter getTransactionExporter(
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
//    public TransactionExport saveTransactionExport(
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