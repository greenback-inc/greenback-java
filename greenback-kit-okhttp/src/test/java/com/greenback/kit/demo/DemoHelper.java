package com.greenback.kit.demo;

import com.fizzed.crux.okhttp.OkHttpLoggingInterceptor;
import com.fizzed.crux.okhttp.OkLoggingLevel;
import com.fizzed.crux.util.MessageLevel;
import com.greenback.kit.okhttp.OkHttpHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;

public class DemoHelper {
 
    static public Properties userProperties() throws IOException {
        Path file = Paths.get(System.getProperty("user.home"), ".greenback.conf");
        
        final Properties props = new Properties();
        
        if (Files.exists(file)) {
            try (InputStream input = Files.newInputStream(file)) {
                props.load(input);
            }
        }
        
        return props;
    }
    
    static public OkHttpClient httpClient(Logger log) {
        final OkHttpLoggingInterceptor loggingInterceptor = new OkHttpLoggingInterceptor();
        loggingInterceptor.setLogger(log);
        loggingInterceptor.setMessageLevel(MessageLevel.DEBUG);
        loggingInterceptor.setRequestLoggingLevel(OkLoggingLevel.BODY);
        loggingInterceptor.setMaxResponseBodySize(200000000L);
        loggingInterceptor.setResponseLoggingLevel(OkLoggingLevel.BODY);
        final OkHttpClient httpClient = OkHttpHelper.build()
            .newBuilder()
            .addNetworkInterceptor(loggingInterceptor)
            .build();
        return httpClient;
    }
    
}