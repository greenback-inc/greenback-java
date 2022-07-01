package com.greenback.kit.client.impl;

import com.fizzed.crux.uri.MutableUri;
import com.greenback.kit.model.AutoExportQuery;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackCodec;
import static com.greenback.kit.client.impl.ClientHelper.toExpandQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toInstantParameter;
import static com.greenback.kit.client.impl.ClientHelper.toListQueryParameter;
import static com.greenback.kit.client.impl.ClientHelper.toStreamingPaginated;
import static com.greenback.kit.client.impl.ClientHelper.toValue;
import com.greenback.kit.model.*;
import com.greenback.kit.util.Bytes;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
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

    protected Map<String,String> toQueryMap(Object value) throws IOException {
        final Map<String,String> map = new LinkedHashMap<>();

        if (value != null) {
            final Map<String,Object> flattenedMap = this.codec.toFlattenedMap(value);
            if (flattenedMap != null) {
                flattenedMap.forEach((k,v) -> {
                    map.put(k, ClientHelper.toStringParameter(v));
                });
            }
        }

        return map;
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
            .queryIfPresent("expands", ofNullable(toListQueryParameter(expands)))
            .toString();
        
        return toValue(() -> this.getUserByUrl(url));
    }
    
    abstract protected User getUserByUrl(
            String url) throws IOException;

    @Override
    public Entitlements getEntitlements() throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/entitlements")
            .toString();

        return toValue(() -> this.getEntitlementsByUrl(url));
    }

    abstract protected Entitlements getEntitlementsByUrl(
        String url) throws IOException;

    //
    // Connects
    //
    
    @Override
    public Paginated<Connect> getConnects(
            ConnectQuery connectQuery) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/connects")
            .query(this.toQueryMap(connectQuery))
            .toString();
        
        return toStreamingPaginated(url, v -> this.getConnectsByUrl(v));
    }
    
    @Override
    public Connect getConnectByLabel(
            String connectLabel,
            Iterable<String> expands) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/connects")
            .rel(connectLabel)
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getConnectByUrl(url));
    }
    
    abstract protected Paginated<Connect> getConnectsByUrl(
            String url) throws IOException;
    
    abstract protected Connect getConnectByUrl(
            String url) throws IOException;
    
    //
    // Connect Intents
    //
    
    @Override
    public ConnectIntent beginConnectIntent(
            String connectLabel) throws IOException {

        Objects.requireNonNull(connectLabel, "connectLabel was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/connects")
            .rel(connectLabel)
            .rel("begin")
            .toString();
        
        return toValue(() -> this.getConnectIntentByUrl(url));
    }
    
    @Override
    public ConnectIntent reconnectAccountIntent(
            String accountId) throws IOException {

        Objects.requireNonNull(accountId, "accountId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .rel(accountId)
            .rel("reconnect")
            .toString();
        
        return toValue(() -> this.getConnectIntentByUrl(url));
    }
    
    @Override
    public ConnectIntent authorizeConnectIntent(
            String token,
            ConnectIntentAuthorize request) throws IOException {

        Objects.requireNonNull(token, "token was null");
        Objects.requireNonNull(request, "request was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/connect_intents")
            .rel(token)
            .toString();
        
        return toValue(() -> this.postConnectIntentRequestByUrl(url, request));
    }
    
    @Override
    public ConnectIntent completeConnectIntent(
            String token,
            ConnectIntentComplete request) throws IOException {

        Objects.requireNonNull(token, "token was null");
        Objects.requireNonNull(request, "request was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/connect_intents")
            .rel(token)
            .rel("complete")
            .toString();
        
        return toValue(() -> this.postConnectIntentRequestByUrl(url, request));
    }
    
    abstract protected ConnectIntent getConnectIntentByUrl(
            String url) throws IOException;
    
    abstract protected ConnectIntent postConnectIntentRequestByUrl(
            String url,
            Object request) throws IOException;
    
    //
    // Accounts
    //
    
    @Override
    public Account createAccount(
            Account account) throws IOException {

        Objects.requireNonNull(account, "account was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .toString();
        
        return this.postAccountByUrl(url, account);
    }
    
    @Override
    public Account updateAccount(
            Account account) throws IOException {

        Objects.requireNonNull(account, "account was null");
        Objects.requireNonNull(account.getId(), "account id was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .rel(account.getId())
            .toString();
        
        return this.postAccountByUrl(url, account);
    }
    
    @Override
    public Paginated<Account> getAccounts(
            AccountQuery accountQuery) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .query(this.toQueryMap(accountQuery))
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
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getAccountByUrl(url));
    }
    
    @Override
    public Account deleteAccountById(
            String accountId) throws IOException {

        Objects.requireNonNull(accountId, "accountId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/accounts")
            .rel(accountId)
            .toString();
        
        return toValue(() -> this.deleteAccountByUrl(url));
    }
    
    abstract protected Account postAccountByUrl(
            String url,
            Object request) throws IOException;
    
    abstract protected Paginated<Account> getAccountsByUrl(
            String url) throws IOException;
    
    abstract protected Account getAccountByUrl(
            String url) throws IOException;
    
    abstract protected Account deleteAccountByUrl(
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
            .queryIfPresent("expands", toExpandQueryParameter(expands))
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
            .query(this.toQueryMap(messageQuery))
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
            .queryIfPresent("expands", toExpandQueryParameter(expands))
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
    public Transaction createTransaction(
            Transaction transaction) throws IOException {

        Objects.requireNonNull(transaction, "transaction was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .toString();
        
        return this.postTransactionByUrl(url, transaction);
    }
    
    @Override
    public Transaction updateTransaction(
            Transaction transaction) throws IOException {

        Objects.requireNonNull(transaction, "transaction was null");
        Objects.requireNonNull(transaction.getId(), "transaction id was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transaction.getId())
            .toString();
        
        return this.postTransactionByUrl(url, transaction);
    }
    
    @Override
    public Paginated<Transaction> getTransactions(
            TransactionQuery transactionQuery) throws IOException {
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .query(this.toQueryMap(transactionQuery))
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
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();
        
        return toValue(() -> this.getTransactionByUrl(url));
    }

    @Override
    public Transaction deleteTransactionById(
            String transactionId) throws IOException {

        Objects.requireNonNull(transactionId, "transactionId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId)
            .toString();
        
        return toValue(() -> this.deleteTransactionByUrl(url));
    }
    
    abstract protected Paginated<Transaction> getTransactionsByUrl(
            String url) throws IOException;
    
    abstract protected Transaction getTransactionByUrl(
            String url) throws IOException;
    
    abstract protected Transaction postTransactionByUrl(
            String url,
            Object request) throws IOException;
    
    abstract protected Transaction deleteTransactionByUrl(
            String url) throws IOException;
    
    @Override
    public TransactionExportIntent getTransactionExportIntent(
            String transactionId,
            String accountId,
            String targetId,
            TransactionExportIntentRequest transactionExportIntentRequest) throws IOException {

        Objects.requireNonNull(transactionId, "transactionId was null");
        Objects.requireNonNull(accountId, "accountId was null");
        
        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId, "exporters", accountId)
            .relIfPresent(ofNullable(targetId))
            .queryIfPresent("payment", ofNullable(transactionExportIntentRequest).map(v -> v.getPayment()))
            .queryIfPresent("itemized", ofNullable(transactionExportIntentRequest).map(v -> v.getItemized()))
            .queryIfPresent("verified_by", ofNullable(transactionExportIntentRequest).map(v -> toInstantParameter(v.getVerifiedBy())))
            .queryIfPresent("expands", toExpandQueryParameter(transactionExportIntentRequest.getExpands()))
            .toString();
        
        return toValue(() -> this.getTransactionExporterByUrl(url));
    }
    
    abstract protected TransactionExportIntent getTransactionExporterByUrl(
            String url) throws IOException;
    
    @Override
    public TransactionExport applyTransactionExportIntent(
            String transactionId,
            String accountId,
            TransactionExportIntentRequest transactionExportIntentRequest) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/transactions")
            .rel(transactionId, "exporters", accountId)
            .queryIfPresent("payment", ofNullable(transactionExportIntentRequest).map(v -> v.getPayment()))
            .queryIfPresent("itemized", ofNullable(transactionExportIntentRequest).map(v -> v.getItemized()))
            .queryIfPresent("verified_by", ofNullable(transactionExportIntentRequest)
                .map(v -> toInstantParameter(v.getVerifiedBy())))
            .toString();
        
        // we have to have a clean exporter w/ only parameters, so create new object
        final TransactionExportIntentRequest request = new TransactionExportIntentRequest();
        
        if (transactionExportIntentRequest != null) {
            request.setParameters(transactionExportIntentRequest.getParameters());
        }
        
        return toValue(() -> this.postTransactionExportByUrl(url, request));
    }
    
    abstract protected TransactionExport postTransactionExportByUrl(
            String url,
            TransactionExportIntentRequest transactionExporterRequest) throws IOException;
    
    @Override
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
    
    @Override
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

    //
    // Transforms
    //

    @Override
    public Paginated<Transform> getTransforms(
            TransformQuery transformQuery) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/transforms")
            .query(this.toQueryMap(transformQuery))
            .toString();

        return this.getTransformsByUrl(url);
    }
    
    @Override
    public Transform createTransform(
            Transform transform) throws IOException {

        Objects.requireNonNull(transform, "transform was null");

        final String url = this.buildBaseUrl()
            .path("v2/transforms")
            .toString();

        return this.postTransformByUrl(url, transform);
    }

    @Override
    public Transform updateTransform(
            Transform transform) throws IOException {

        Objects.requireNonNull(transform, "transform was null");
        Objects.requireNonNull(transform.getId(), "transform id was null");

        final String url = this.buildBaseUrl()
            .path("v2/transforms")
            .rel(transform.getId())
            .toString();

        transform.setId(null);
        
        return this.postTransformByUrl(url, transform);
    }

    @Override
    public Transform getTransformById(
            String transformId) throws IOException {

        Objects.requireNonNull(transformId, "transformId was null");

        final String url = this.buildBaseUrl()
            .path("v2/transforms")
            .rel(transformId)
            //.queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();

        return toValue(() -> this.getTransformByUrl(url));
    }

    @Override
    public Transform deleteTransformById(
            String transformId,
            DeleteMode deleteMode) throws IOException {

        Objects.requireNonNull(transformId, "autoExportId was null");

        final String url = this.buildBaseUrl()
            .path("v2/transforms")
            .rel(transformId)
            .queryIfPresent("mode", ofNullable(deleteMode))
            .toString();

        return toValue(() -> this.deleteTransformByUrl(url));
    }

    
    abstract protected Transform postTransformByUrl(
        String url,
        Object request) throws IOException;

    abstract protected Paginated<Transform> getTransformsByUrl(
        String url) throws IOException;

    abstract protected Transform getTransformByUrl(
        String url) throws IOException;
    
    abstract protected Transform deleteTransformByUrl(
        String url) throws IOException;
    
    //
    // Auto Exports
    //

    @Override
    public AutoExport createAutoExport(
            AutoExport autoExport) throws IOException {

        Objects.requireNonNull(autoExport, "autoExport was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .toString();

        return this.postAutoExportByUrl(url, autoExport);
    }

    @Override
    public AutoExport updateAutoExport(
            AutoExport autoExport) throws IOException {

        Objects.requireNonNull(autoExport, "autoExport was null");
        Objects.requireNonNull(autoExport.getId(), "autoExport id was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .rel(autoExport.getId())
            .toString();

        return this.postAutoExportByUrl(url, autoExport);
    }

    @Override
    public Paginated<AutoExport> getAutoExports(
            AutoExportQuery autoExportQuery) throws IOException {

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .query(this.toQueryMap(autoExportQuery))
            .toString();

        return this.getAutoExportsByUrl(url);
    }

    @Override
    public AutoExport getAutoExportById(
        String autoExportId,
        Iterable<String> expands) throws IOException {

        Objects.requireNonNull(autoExportId, "autoExportId was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .rel(autoExportId)
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();

        return toValue(() -> this.getAutoExportByUrl(url));
    }

    @Override
    public AutoExport deleteAutoExportById(
        String autoExportId) throws IOException {

        Objects.requireNonNull(autoExportId, "autoExportId was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .rel(autoExportId)
            .toString();

        return toValue(() -> this.deleteAutoExportByUrl(url));
    }

    abstract protected AutoExport postAutoExportByUrl(
        String url,
        Object request) throws IOException;

    abstract protected Paginated<AutoExport> getAutoExportsByUrl(
        String url) throws IOException;

    abstract protected AutoExport getAutoExportByUrl(
        String url) throws IOException;

    abstract protected AutoExport deleteAutoExportByUrl(
        String url) throws IOException;


    //
    // Auto Export Runs
    //

    @Override
    public ExportRun createAutoExportRun(String autoExportId, ExportRun exportRun) throws IOException {
        Objects.requireNonNull(exportRun, "ExportRun was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .rel(autoExportId, "runs")
            .toString();

        return this.postExportRunByUrl(url, exportRun);
    }

    @Override
    public ExportRun getExportRunById(String exportRunId, Iterable<String> expands) throws IOException {
        Objects.requireNonNull(exportRunId, "exportRunId was null");

        //TODO JB: need to implement this route in lens
        final String url = this.buildBaseUrl()
            .path("v2/export_runs")
            .rel(exportRunId)
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();

        return toValue(() -> this.getExportRunByUrl(url));
    }

    @Override
    public Paginated<ExportRun> getExportRunsByAutoExportId(String autoExportId, Iterable<String> expands) throws IOException {
        Objects.requireNonNull(autoExportId, "autoExportId was null");

        final String url = this.buildBaseUrl()
            .path("v2/auto_exports")
            .rel(autoExportId, "runs")
            .queryIfPresent("expands", toExpandQueryParameter(expands))
            .toString();

        return toValue(() -> this.getExportRunsByUrl(url));
    }

    abstract protected ExportRun postExportRunByUrl(
        String url,
        Object request) throws IOException;

    abstract protected Paginated<ExportRun> getExportRunsByUrl(
        String url) throws IOException;

    abstract protected ExportRun getExportRunByUrl(
        String url) throws IOException;

}