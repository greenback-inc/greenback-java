package com.greenback.kit.client;

import com.greenback.kit.model.Account;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Sync;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExporter;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import java.io.IOException;
import java.io.InputStream;

public interface GreenbackCodec {

    String prettyPrint(Object value) throws IOException;
    
    User readUser(InputStream input) throws IOException;
    
    Paginated<User> readUsers(InputStream input) throws IOException;
    
    Connect readConnect(InputStream input) throws IOException;
    
    Paginated<Connect> readConnects(InputStream input) throws IOException;

    Account readAccount(InputStream input) throws IOException;

    Paginated<Account> readAccounts(InputStream input) throws IOException;

    Vision readVision(InputStream input) throws IOException;
    
    Paginated<Vision> readVisions(InputStream input) throws IOException;
    
    Message readMessage(InputStream input) throws IOException;
    
    Paginated<Message> readMessages(InputStream input) throws IOException;
    
    Paginated<Transaction> readTransactions(InputStream input) throws IOException;

    Sync readSync(InputStream input) throws IOException;

    TransactionExport readTransactionExport(InputStream input) throws IOException;

    TransactionExporter readTransactionExporter(InputStream input) throws IOException;
    
}