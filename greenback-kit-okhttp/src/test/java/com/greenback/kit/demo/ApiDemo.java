package com.greenback.kit.demo;

import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;

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

            
//            final Paginated<Connect> connects = client.getConnects(new ConnectQuery()
//                .setExpands("card")
//                .setLimit(2));
//            
//            for (Connect connect : connects) {
//                log.debug("Connect: id={}, name={}, type={}, state={}", connect.getId(), connect.getName(), connect.getType(), connect.getState());
//            }
//            final ConnectIntent ci = client.beginConnectIntent("saw");
//            
//            client.authorizeConnectIntent(ci.getToken(), new ConnectIntentAuthorize()
//                .addParameter("username", "hford")
//                .addParameter("password", "test"));
//            
//            client.completeConnectIntent(ci.getToken(), new ConnectIntentComplete()
////                .setAction(ConnectIntentConfirm.CONFIRM)
//                );
//            final ConnectIntent ci = client.beginConnectIntent("xero");
//            
//            client.authorizeConnectIntent(ci.getToken(), new ConnectIntentAuthorize()
//                );
//
//            
//            Thread.sleep(20000L);
//
//            
//            client.completeConnectIntent(ci.getToken(), new ConnectIntentComplete()
//                .addParameter("profile", "dfad74ac-8d43-4afe-92f9-b4c13d913e22")
////                .setAction(ConnectIntentConfirm.CONFIRM)
//                );
//            User user = client.getUserById("me");
//            
//            log.debug("User: id={}, created={}", user.getId(), user.getCreatedAt());
//            final Paginated<Account> accounts = client.getAccounts(new AccountQuery()
//                .setExpands("connect", "syncs")
//                .setLimit(1));
//            
//            for (Account account : accounts) {
//                log.debug("Account: id={}, defaultName={}", account.getId(), account.getDefaultName());
//            }


            Connect shoeboxConnect = client.getConnectByLabel("amazon");

            client.createAccount(new Account()
                .setConnectId(shoeboxConnect.getId())
                .setDefaultName("My Account"));


            
//            client.deleteAccountById("ZaWKjv0Gaz");
            
            
//            final Paginated<Message> messages = client.getMessages(new MessageQuery()
////                .setExpands("links")
//                .setLimit(2));
//
//            log.debug("Messages class: {}", messages.getClass());
//            
//            for (Message message : messages) {
//                log.debug("Message: id={}, posted={}", message.getId(), message.getPostedAt());
//            }


//            final Paginated<Transaction> transactions = client.getTransactions(new TransactionQuery()
////                .setAccountIds("ZY3DKB7PnM")
////                .setExpands("account")
////                .setFlags(DocumentFlag.ARCHIVED)
////                .setTypes(TransactionType.BILL)
//                .setQuery("visa")
////                .setMinTransactedAt(Instant.parse("2021-03-01T16:49:00.000Z"))
////                .setMinUpdatedAt(Instant.parse("2021-04-07T16:49:00.000Z"))
////                .setMaxUpdatedAt(Instant.parse("2021-04-07T16:49:00.000Z"))
//                .setLimit(1));
//            
//            for (Transaction transaction : transactions) {
//                log.debug("Transaction: id={}, transactedAt={}", transaction.getId(), transaction.getTransactedAt());
//            }

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