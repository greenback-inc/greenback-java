package com.greenback.kit.jackson;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fizzed.crux.jackson.EnumDeserializeStrategy;
import com.fizzed.crux.jackson.EnumSerializeStrategy;
import com.fizzed.crux.jackson.EnumStrategyModule;
import com.greenback.kit.client.GreenbackCodec;
import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.ConnectIntent;
import com.greenback.kit.model.GreenbackError;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Sync;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExporter;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Value;
import com.greenback.kit.model.GreenbackException;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.Vision;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JacksonGreenbackCodec implements GreenbackCodec {
    
    protected final ObjectMapper objectMapper;
    
    public JacksonGreenbackCodec() {
        this.objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .setSerializationInclusion(Include.NON_NULL)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JavaTimeModule())
            .registerModule(new EnumStrategyModule(EnumSerializeStrategy.LOWER_CASE, EnumDeserializeStrategy.IGNORE_CASE)
                .setNullOnUnknown(true));
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.objectMapper.setDateFormat(df);
    }
    
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
    protected void verifySuccess(JsonNode rootNode) throws IOException, GreenbackException {
        // has error?
        if (rootNode.has("error")) {
            GreenbackError error = this.objectMapper.treeToValue(rootNode.get("error"), GreenbackError.class);
            
            throw new GreenbackException(error);
        }
    }
    
    protected <T> T read(
            InputStream input,
            TypeReference<T> typeReference) throws IOException, GreenbackException {
        
        final JsonNode rootNode = this.objectMapper.readTree(input);
        
        this.verifySuccess(rootNode);
        
        return this.objectMapper.convertValue(rootNode, typeReference);
    }
    
    static private final TypeReference<Paginated<User>> TYPEREF_USERS
        = new TypeReference<Paginated<User>>() {};
    static private final TypeReference<Value<User>> TYPEREF_USER
        = new TypeReference<Value<User>>() {};
    static private final TypeReference<Paginated<Connect>> TYPEREF_CONNECTS
        = new TypeReference<Paginated<Connect>>() {};
    static private final TypeReference<Value<Connect>> TYPEREF_CONNECT
        = new TypeReference<Value<Connect>>() {};
    static private final TypeReference<Value<ConnectIntent>> TYPEREF_CONNECT_INTENT
        = new TypeReference<Value<ConnectIntent>>() {};
    static private final TypeReference<Paginated<Account>> TYPEREF_ACCOUNTS
        = new TypeReference<Paginated<Account>>() {};
    static private final TypeReference<Value<Account>> TYPEREF_ACCOUNT
        = new TypeReference<Value<Account>>() {};
    static private final TypeReference<Paginated<Vision>> TYPEREF_VISIONS
        = new TypeReference<Paginated<Vision>>() {};
    static private final TypeReference<Value<Vision>> TYPEREF_VISION
        = new TypeReference<Value<Vision>>() {};
    static private final TypeReference<Paginated<Message>> TYPEREF_MESSAGES
        = new TypeReference<Paginated<Message>>() {};
    static private final TypeReference<Value<Message>> TYPEREF_MESSAGE
        = new TypeReference<Value<Message>>() {};
    static private final TypeReference<Paginated<Sync>> TYPEREF_SYNCS
        = new TypeReference<Paginated<Sync>>() {};
    static private final TypeReference<Value<Sync>> TYPEREF_SYNC
        = new TypeReference<Value<Sync>>() {};
    static private final TypeReference<Paginated<Transaction>> TYPEREF_TRANSACTIONS
        = new TypeReference<Paginated<Transaction>>() {};
    static private final TypeReference<Value<Transaction>> TYPEREF_TRANSACTION
        = new TypeReference<Value<Transaction>>() {};
    static private final TypeReference<Value<TransactionExporter>> TYPEREF_TRANSACTION_EXPORTER
        = new TypeReference<Value<TransactionExporter>>() {};
    static private final TypeReference<Value<TransactionExport>> TYPEREF_TRANSACTION_EXPORT
        = new TypeReference<Value<TransactionExport>>() {};

    @Override
    public String prettyPrint(Object value) throws IOException {
        return this.objectMapper.writeValueAsString(value);
    }
    
    @Override
    public byte[] writeBytes(Object value) throws IOException {
        if (value == null) {
            return new byte[0];
        }
        return this.objectMapper.writeValueAsBytes(value);
    }
    
    @Override
    public Paginated<User> readUsers(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_USERS);
    }
    
    @Override
    public User readUser(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_USER).getValue();
    }
    
    @Override
    public Paginated<Connect> readConnects(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_CONNECTS);
    }
    
    @Override
    public Connect readConnect(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_CONNECT).getValue();
    }
    
    @Override
    public ConnectIntent readConnectIntent(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_CONNECT_INTENT).getValue();
    }
    
    @Override
    public Paginated<Account> readAccounts(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_ACCOUNTS);
    }
    
    @Override
    public Account readAccount(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_ACCOUNT).getValue();
    }
    
    @Override
    public Paginated<Vision> readVisions(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_VISIONS);
    }
    
    @Override
    public Vision readVision(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_VISION).getValue();
    }
    
    @Override
    public Paginated<Message> readMessages(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_MESSAGES);
    }
    
    @Override
    public Message readMessage(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_MESSAGE).getValue();
    }
    
    @Override
    public Paginated<Sync> readSyncs(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_SYNCS);
    }
    
    @Override
    public Sync readSync(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_SYNC).getValue();
    }
    
    @Override
    public Paginated<Transaction> readTransactions(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_TRANSACTIONS);
    }
    
    @Override
    public Transaction readTransaction(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_TRANSACTION).getValue();
    }
    
    @Override
    public TransactionExporter readTransactionExporter(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_TRANSACTION_EXPORTER).getValue();
    }
    
    @Override
    public TransactionExport readTransactionExport(
            InputStream input) throws IOException {
        
        return this.read(input, TYPEREF_TRANSACTION_EXPORT).getValue();
    }

}