package com.greenback.kit.demo;

import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;
import java.io.File;
import static java.util.Optional.ofNullable;
import java.util.Properties;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisionDemo {
    static private final Logger log = LoggerFactory.getLogger(VisionDemo.class);
 
    static public final void main(String[] args) throws Exception {
        
        // try to load props from ~/.greenback.conf if it exists
        final Properties config = DemoHelper.userProperties();
        final OkHttpClient httpClient = DemoHelper.httpClient(log);
        final String baseUrl = ofNullable(config.getProperty("base_url"))
            .orElse(GreenbackConstants.ENDPOINT_PRODUCTION);
        final String accessToken = ofNullable(config.getProperty("access_token"))
            .orElse("access-token-here");

        try {
            final GreenbackClient client = new OkHttpGreenbackClient(
                httpClient,
                baseUrl,
                new JacksonGreenbackCodec(),
                accessToken);

            Vision vision = client.createVision(new VisionRequest()
                .setAsync(true)
                .setDocument(new File("../7eleven_sample.jpg")));

            log.debug("Vision: id={}, name={}, status={}, updated={}",
                vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
            
            while (!vision.getStatus().isTerminal()) {
                vision = client.getVisionById(vision.getId());
                
                log.debug("Vision: id={}, name={}, status={}, updated={}",
                    vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
                
                Thread.sleep(100L);
            }
        }
        catch (Exception e) {
            log.error("Uh oh!", e);
        }
        finally {
            OkHttpHelper.shutdown(httpClient);
        }
    }
    
}