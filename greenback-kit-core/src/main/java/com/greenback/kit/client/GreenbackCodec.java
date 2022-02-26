package com.greenback.kit.client;

import com.greenback.kit.model.*;

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

    Transform readTransform(InputStream input) throws IOException;

    Paginated<Transform> readTransforms(InputStream input) throws IOException;
    
    AutoExport readAutoExport(InputStream input) throws IOException;

    Paginated<AutoExport> readAutoExports(InputStream input) throws IOException;

    AutoExportRun readAutoExportRun(InputStream input) throws IOException;

    Paginated<AutoExportRun> readAutoExportRuns(InputStream input) throws IOException;
    
}