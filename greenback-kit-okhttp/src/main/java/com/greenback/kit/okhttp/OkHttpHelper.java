package com.greenback.kit.okhttp;

import okhttp3.OkHttpClient;

public class OkHttpHelper {
 
    static public OkHttpClient build() {
        return new OkHttpClient.Builder()
            .build();
    }
    
    static public void shutdown(OkHttpClient httpClient) {
        if (httpClient != null) {
            httpClient.dispatcher().executorService().shutdown();
            httpClient.connectionPool().evictAll();
        }
    }
    
}