package com.greenback.kit.demo;

import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;
import static java.util.Optional.ofNullable;
import java.util.Properties;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionDemo {
    static private final Logger log = LoggerFactory.getLogger(TransactionDemo.class);
 
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

            Paginated<Transaction> transactions = client.getTransactions(new TransactionQuery()
//                .setTypes(TransactionType.PURCHASE)
//                .setFlags(DocumentFlag.DEFAULT)
//                .setQuery("2160p")
//                .setMinTransactedAt(Instant.parse("2019-06-01T00:00:00.000Z"))
//                .setMaxTransactedAt(Instant.parse("2019-06-11T00:00:00.000Z"))
            );
            
            for (Transaction transaction : transactions) {
                log.debug("Transaction: {}", transaction.getId());
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