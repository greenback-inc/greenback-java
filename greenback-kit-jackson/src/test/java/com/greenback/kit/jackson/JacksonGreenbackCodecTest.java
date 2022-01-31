package com.greenback.kit.jackson;

import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.model.TransactionType;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import org.junit.Test;

public class JacksonGreenbackCodecTest {
 
    static private final JacksonGreenbackCodec CODEC = new JacksonGreenbackCodec();
    
    @Test
    public void writeEnum() throws IOException {
        final String json1 = new String(CODEC.writeBytes(TransactionType.SALES_RECEIPT), StandardCharsets.UTF_8);
        
        assertThat(json1, is("\"sales_receipt\""));
        
        
        final Map<TransactionType,String> data = new LinkedHashMap<>();
        data.put(TransactionType.INVOICE, "a");
        data.put(TransactionType.SALES_RECEIPT, "b");
        
        final String json2 = new String(CODEC.writeBytes(data), StandardCharsets.UTF_8);
        
        assertThat(json2, is("{\"invoice\":\"a\",\"sales_receipt\":\"b\"}"));
    }
    
    @Test
    public void toFlattenedMap() throws IOException {
        final TransactionQuery query = new TransactionQuery()
            .setMinTransactedAt(Instant.parse("2022-01-22T01:02:03.456Z"))
            .setMaxTransactedAt(Instant.parse("2022-01-22T01:02:03.000Z"));
        
        final Map<String,Object> flattenedMap = CODEC.toFlattenedMap(query);
        
        assertThat(flattenedMap, hasEntry("min_transacted_at", "2022-01-22T01:02:03.456Z"));
        assertThat(flattenedMap, hasEntry("max_transacted_at", "2022-01-22T01:02:03.000Z"));
        
    }
    
}