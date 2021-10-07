package com.greenback.kit.jackson;

import com.greenback.kit.model.TransactionType;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
    
}