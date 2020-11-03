package com.greenback.kit.demo;

import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageRequest;
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

public class MailboxDemo {
    static private final Logger log = LoggerFactory.getLogger(MailboxDemo.class);
 
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

            Message message = client.createMessage(new MessageRequest()
                .setAsync(true)
                .setDocument(new File("../samples/disney_sample.msg")));

            log.debug("Message: id={}, name={}, status={}, updated={}",
                message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());
            
            while (!message.getStatus().isTerminal()) {
                message = client.getMessageById(message.getId());
                
                log.debug("Message: id={}, name={}, status={}, updated={}",
                    message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());
             
                Thread.sleep(500L);
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