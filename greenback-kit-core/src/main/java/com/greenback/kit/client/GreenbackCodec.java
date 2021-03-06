package com.greenback.kit.client;

import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.ConnectIntent;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Sync;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExportIntent;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface GreenbackCodec {

    String prettyPrint(Object value) throws IOException;
    
    Map<String,Object> toFlattenedMap(Object value) throws IOException;
    
    byte[] writeBytes(Object value) throws IOException;
    
    User readUser(InputStream input) throws IOException;
    
    Paginated<User> readUsers(InputStream input) throws IOException;
    
    Connect readConnect(InputStream input) throws IOException;
    
    Paginated<Connect> readConnects(InputStream input) throws IOException;

    ConnectIntent readConnectIntent(InputStream input) throws IOException;
    
    Account readAccount(InputStream input) throws IOException;

    Paginated<Account> readAccounts(InputStream input) throws IOException;

    Vision readVision(InputStream input) throws IOException;
    
    Paginated<Vision> readVisions(InputStream input) throws IOException;
    
    Message readMessage(InputStream input) throws IOException;
    
    Paginated<Message> readMessages(InputStream input) throws IOException;
    
    Transaction readTransaction(InputStream input) throws IOException;
    
    Paginated<Transaction> readTransactions(InputStream input) throws IOException;

    Sync readSync(InputStream input) throws IOException;
    
    Paginated<Sync> readSyncs(InputStream input) throws IOException;

    TransactionExport readTransactionExport(InputStream input) throws IOException;

    TransactionExportIntent readTransactionExporter(InputStream input) throws IOException;
    
}