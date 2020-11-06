package com.greenback.kit.okhttp.impl;

import com.greenback.kit.client.impl.ClientDeserializeHandler;
import com.greenback.kit.model.GreenbackException;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public interface BaseOkHttpClient {
 
    public OkHttpClient getHttpClient();
    
    public String getAccessToken();
        
    default public <T> T execute(
            Request.Builder requestBuilder,
            ClientDeserializeHandler<T> deserializeHandler) throws IOException {
        
        if (this.getAccessToken() != null) {
            requestBuilder.addHeader("Authorization", "Bearer " + this.getAccessToken());
        }
        
        requestBuilder.addHeader("Accept", "application/json");
        
        // make sure response is always closed
        try (Response response = this.getHttpClient().newCall(requestBuilder.build()).execute()) {
            String contentType = response.header("Content-Type");

            // we can only handle json
            if (contentType == null || !contentType.toLowerCase().contains("application/json")) {
                throw new IOException("content is not application/json (status=" + response.code() + ", actual=" + contentType + ")");
            }

            try (InputStream input = response.body().byteStream()) {

                // if response was not successful and isn't json
                if (!response.isSuccessful()) {
                    if (!response.header("Content-Type").toLowerCase().startsWith("application/json")) {
                        throw new IOException("Unable to cleanly execute request (status " + response.code() + ")");
                    }
                }
                
                try {
                    // run the deserializer (it also checks for json-based errors
                    return deserializeHandler.apply(input);
                } catch (GreenbackException e) {
                    throw e; // rethrow it
                }
            }
        }
    }
    
    default public RequestBody jsonRequestBody(
            byte[] bytes) {
        
        return RequestBody.create(MediaType.parse("application/json"), bytes);
    }
    
}