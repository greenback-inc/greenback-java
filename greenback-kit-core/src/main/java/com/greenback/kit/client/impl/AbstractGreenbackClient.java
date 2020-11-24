package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackCodec;
import static com.greenback.kit.client.impl.ClientHelper.toExpandQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toInstantParameter;
import static com.greenback.kit.client.impl.ClientHelper.toLimitQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toListQueryParameter;
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
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExportDeleteMode;
import com.greenback.kit.model.TransactionExporterQuery;
import com.greenback.kit.model.TransactionExporter;
import com.greenback.kit.model.TransactionExporterRequest;
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
            .queryIfPresent("expand", ofNullable(toListQueryParameter(expands)))
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
            .queryIfPresent("account", ofNullable(messageQuery).map(v -> toListQueryParameter(v.getAccountIds())))
            .queryIfPresent("flag", ofNullable(messageQuery).map(v -> toListQueryParameter(v.getFlags())))
            .queryIfPresent("query", ofNullable(messageQuery).map(v -> v.getQuery()))
            .queryIfPresent("start", ofNullable(messageQuery).map(v -> toInstantParameter(v.getMinPostedAt())))
            .queryIfPresent("end", ofNullable(messageQuery).map(v -> toInstantParameter(v.getMaxPostedAt())))
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
            .queryIfPresent("account", ofNullable(transactionQuery).map(v -> toListQueryParameter(v.getAccountIds())))
            .queryIfPresent("type", ofNullable(transactionQuery).map(v -> toListQueryParameter(v.getTypes())))
            .queryIfPresent("flag", ofNullable(transactionQuery).map(v -> toListQueryParameter(v.getFlags())))
            .queryIfPresent("query", ofNullable(transactionQuery).map(v -> v.getQuery()))
            .queryIfPresent("start", ofNullable(transactionQuery).map(v -> toInstantParameter(v.getMinTransactedAt())))
            .queryIfPresent("end", ofNullable(transactionQuery).map(v -> toInstantParameter(v.getMaxTransactedAt())))
            .queryIfPresent("descending", ofNullable(transactionQuery).map(v -> v.getDescending()))
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
    
    @Override
    public TransactionExporter getTransactionExporterById(
            String transactionId,
            String accountId,
            String targetId,
            TransactionExporterQuery transactionExportQuery) throws IOException {

        Objects.requireNonNull(transactionId, "transactionId was null");
        Objects.requireNonNull(accountId, "accountId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId, "exporters", accountId)
            .relIfPresent(ofNullable(targetId))
            .queryIfPresent("payment", ofNullable(transactionExportQuery).map(v -> v.getPayment()))
            .queryIfPresent("itemized", ofNullable(transactionExportQuery).map(v -> v.getItemized()))
            .queryIfPresent("verified_by", ofNullable(transactionExportQuery)
                .map(v -> toInstantParameter(v.getVerifiedBy())))
            .queryIfPresent("expand", toExpandQueryParameter(transactionExportQuery))
            .toString();
        
        return toValue(() -> this.getTransactionExporterByUrl(url));
    }
    
    abstract protected TransactionExporter getTransactionExporterByUrl(
            String url) throws IOException;
    
    @Override
    public TransactionExport saveTransactionExport(
            String transactionId,
            String accountId,
            TransactionExporterRequest transactionExporterRequest) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId, "exporters", accountId)
            .queryIfPresent("payment", ofNullable(transactionExporterRequest).map(v -> v.getPayment()))
            .queryIfPresent("itemized", ofNullable(transactionExporterRequest).map(v -> v.getItemized()))
            .queryIfPresent("verified_by", ofNullable(transactionExporterRequest)
                .map(v -> toInstantParameter(v.getVerifiedBy())))
            .toString();
        
        // we have to have a clean exporter w/ only parameters, so create new object
        final TransactionExporterRequest request = new TransactionExporterRequest();
        
        if (transactionExporterRequest != null) {
            request.setParameters(transactionExporterRequest.getParameters());
        }
        
        return toValue(() -> this.saveTransactionExportByUrl(url, request));
    }
    
    abstract protected TransactionExport saveTransactionExportByUrl(
            String url,
            TransactionExporterRequest transactionExporterRequest) throws IOException;
    
    public TransactionExport getTransactionExportById(
            String transactionExportId) throws IOException {
        
        Objects.requireNonNull(transactionExportId, "transactionExportId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transaction_exports")
            .rel(transactionExportId)
            .toString();

        return toValue(() -> this.getTransactionExportByUrl(url));
    }
    
    abstract protected TransactionExport getTransactionExportByUrl(
            String url) throws IOException;
    
    public TransactionExport deleteTransactionExportById(
            String transactionExportId,
            TransactionExportDeleteMode deleteMode) throws IOException {

        Objects.requireNonNull(transactionExportId, "transactionExportId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transaction_exports")
            .rel(transactionExportId)
            .queryIfPresent("mode", ofNullable(deleteMode))
            .toString();

        return toValue(() -> this.deleteTransactionExportByUrl(url));
    }
    
    abstract protected TransactionExport deleteTransactionExportByUrl(
            String url) throws IOException;
    
}