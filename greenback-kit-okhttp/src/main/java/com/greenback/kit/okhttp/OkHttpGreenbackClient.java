package com.greenback.kit.okhttp;

import com.greenback.kit.client.GreenbackCodec;
import com.greenback.kit.client.impl.AbstractGreenbackClient;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExporter;
import com.greenback.kit.model.TransactionExporterRequest;
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
        
        return this.execute(requestBuilder, this.codec::readUser);
    }
    
    @Override
    protected Paginated<Connect> getConnectsByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readConnects);
    }
    
    @Override
    protected Connect getConnectByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readConnect);
    }
    
    @Override
    protected Paginated<Account> getAccountsByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readAccounts);
    }
    
    @Override
    protected Account getAccountByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readAccount);
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
        
        return this.execute(requestBuilder, this.codec::readVision);
    }
    
    @Override
    protected Vision getVisionByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readVision);
    }
    
    //
    // Messages
    //
    
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
        
        return this.execute(requestBuilder, this.codec::readMessage);
    }
    
    @Override
    protected Paginated<Message> getMessagesByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readMessages);
    }
    
    @Override
    protected Message getMessageByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readMessage);
    }
    
    //
    // Transactions
    //
    
    @Override
    protected Paginated<Transaction> getTransactionsByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readTransactions);
    }
    
    @Override
    protected Transaction getTransactionByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readTransaction);
    }

    @Override
    protected TransactionExporter getTransactionExporterByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readTransactionExporter);
    }

    @Override
    protected TransactionExport saveTransactionExportByUrl(String url, TransactionExporterRequest transactionExporterRequest) throws IOException {
        
        final byte[] body = this.codec.writeBytes(transactionExporterRequest);

        final RequestBody requestBody = this.jsonRequestBody(body);

        final Request.Builder requestBuilder = new Request.Builder()
            .url(url)
            .post(requestBody);
        
        return this.execute(requestBuilder, this.codec::readTransactionExport);
    }

    @Override
    protected TransactionExport getTransactionExportByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url);
        
        return this.execute(requestBuilder, this.codec::readTransactionExport);
    }

    @Override
    protected TransactionExport deleteTransactionExportByUrl(String url) throws IOException {
        
        final Request.Builder requestBuilder = new Request.Builder()
            .url(url)
            .delete();
        
        return this.execute(requestBuilder, this.codec::readTransactionExport);
    }
    
}