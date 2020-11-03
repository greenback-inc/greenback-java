package com.greenback.kit.demo;

import com.fizzed.crux.okhttp.OkHttpLoggingInterceptor;
import com.fizzed.crux.okhttp.OkLoggingLevel;
import com.fizzed.crux.util.MessageLevel;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;
import java.nio.file.Paths;
import static java.util.Optional.ofNullable;
import java.util.Properties;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiDemo {
    static private final Logger log = LoggerFactory.getLogger(ApiDemo.class);
 
    static public final void main(String[] args) throws Exception {
        
        // try to load props from ~/.greenback.conf if it exists
        final Properties config = DemoHelper.userProperties();
        
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

//            final Paginated<Connect> connects = client.getConnects();
//            
//            for (Connect connect : connects) {
//                log.debug("Connect: id={}, name={}, type={}, state={}", connect.getId(), connect.getName(), connect.getType(), connect.getState());
//            }

            User user = client.getUserById("me");
            
            log.debug("User: id={}, created={}", user.getId(), user.getCreatedAt());
            
            
//            final Paginated<Account> accounts = client.getAccounts(new AccountQuery()
//                .setExpands("connect", "syncs")
//                .setLimit(1));
//            
//            for (Account account : accounts) {
//                log.debug("Account: id={}, defaultName={}", account.getId(), account.getDefaultName());
//            }
            
            final Paginated<Message> messages = client.getMessages(new MessageQuery()
//                .setExpands("links")
                .setLimit(2));

            log.debug("Messages class: {}", messages.getClass());
            
            for (Message message : messages) {
                log.debug("Message: id={}, posted={}", message.getId(), message.getPostedAt());
            }
            
//            Vision vision = client.createVision(new VisionRequest()
////                .setAsync(true)
//                .setAsync(false)
////                .setDocument(Bytes.of(Paths.get("../disney_sample.pdf"))));
//                .setDocument(Paths.get("../7eleven_sample.jpg")));
//
//            log.debug("Vision: id={}, name={}, status={}, updated={}",
//                vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
//            
//            while (!vision.getStatus().isTerminal()) {
//                vision = client.getVision(vision.getId());
//                
//                log.debug("Vision: id={}, name={}, status={}, updated={}",
//                    vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
//                
//                Thread.sleep(100L);
//            }

//            Message message = client.createMessage(new MessageRequest()
//                .setAsync(true)
//                .setDocument(Paths.get("../disney_sample.msg")));
//
//            log.debug("Message: id={}, name={}, status={}, updated={}",
//                message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());
//            
//            while (!message.getStatus().isTerminal()) {
//                message = client.getMessageById(message.getId());
//                
//                log.debug("Message: id={}, name={}, status={}, updated={}",
//                    message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());
//                
//                Thread.sleep(100L);
//            }

//            Connect connect = client.getConnect("amazon-seller-na");
//            
//            log.debug("Connect: id={}, name={}, type={}, state={}", connect.getId(), connect.getName(), connect.getType(), connect.getState());
            
        }
        catch (Exception e) {
            log.error("Uh oh!", e);
        }
        finally {
            OkHttpHelper.shutdown(httpClient);
        }
    }
    
}