package com.greenback.kit.demo;

import static com.fizzed.crux.util.Maps.mapOf;
import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.model.Item;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Payment;
import com.greenback.kit.model.PaymentMethod;
import com.greenback.kit.model.TotalsItem;
import com.greenback.kit.model.TotalsItemType;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExportIntentRequest;
import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.model.TransactionTotals;
import com.greenback.kit.model.TransactionType;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;
import java.time.Instant;
import static java.util.Arrays.asList;
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
            
            
//            Transaction t = new Transaction();
////            t.setId("2qpaP0aWXm");
//            t.setAccountId("za5ygRK6am");
//            t.setType(TransactionType.SALES_RECEIPT);
//            t.setCurrencyCode("usd");
//            t.setReferenceId("113-456-71234");
//            t.setDeposits(asList(
//                new Payment()
//                    .setMethod(PaymentMethod.PAYPAL)
//                    .setAmount(3.74d)
//                    .setPaidAt(Instant.parse("2021-04-02T01:02:03.456Z"))));
//            t.setItems(asList(
//                new Item()
//                    .setGrn("it:sku:WIDGET-1")
//                    .setName("Widget")
//                    .setUnitPrice(1.12d)
//                    .setQuantity(2.0d)
//                    .setAmount(2.24d)));
//            t.setTotals(new TransactionTotals()
//                .setSub(2.24d)
//                .setItems(asList(
//                    new TotalsItem()
//                        .setType(TotalsItemType.TAX)
//                        .setName("Tax")
//                        .setAmount(1.50d)))
//                .setTax(1.50d)
//                .setGrand(3.74d));
//            t.setTransactedAt(Instant.parse("2021-04-01T01:02:03.456Z"));
//            
//            t = client.createTransaction(t);
//            t = client.updateTransaction(t);
//            log.debug("Created transaction {}", t.getId());

            
            final Instant verifiedBy = Instant.now();

            client.getTransactionExportIntent("e5waKyOnRv", "oxo1glP1Yy", new TransactionExportIntentRequest()
                .setExpands("form", "account")
                .setItemized(true)
                .setVerifiedBy(verifiedBy));

            client.applyTransactionExportIntent("e5waKyOnRv", "oxo1glP1Yy", new TransactionExportIntentRequest()
                .setItemized(true)
                .setVerifiedBy(verifiedBy)
                .setParameters(mapOf(
                    "customer", "c-194",
                    "account", "a-1256",
                    "lines[0].category", "item-89",
                    "tax", "taxcode-NOT_APPLICABLE_TAX_CODE")));
            
        }
        catch (Exception e) {
            log.error("Uh oh!", e);
        }
        finally {
            OkHttpHelper.shutdown(httpClient);
        }
    }
    
}