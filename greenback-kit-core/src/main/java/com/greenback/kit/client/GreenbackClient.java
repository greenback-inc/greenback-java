package com.greenback.kit.client;

import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.ConnectQuery;
import com.greenback.kit.model.ConnectAuthorizeRequest;
import com.greenback.kit.model.ConnectCompleteRequest;
import com.greenback.kit.model.ConnectIntent;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionExport;
import com.greenback.kit.model.TransactionExportDeleteMode;
import com.greenback.kit.model.TransactionExporterQuery;
import com.greenback.kit.model.TransactionExporterRequest;
import com.greenback.kit.model.TransactionExporter;
import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import java.io.IOException;

public interface GreenbackClient {

    String getBaseUrl();
    
    GreenbackCodec getCodec();
    
    // Users
    
    default User getUserById(String userId) throws IOException {
        return this.getUserById(userId, null);
    }
    
    User getUserById(String userId, Iterable<String> expands) throws IOException;
    
    // Connects
    
    Paginated<Connect> getConnects(ConnectQuery connectQuery) throws IOException;
    
    Connect getConnectByLabel(String connectLabel) throws IOException;
    
    // Connect Intents
    
    ConnectIntent beginConnectIntent(String connectLabel) throws IOException;
    
    ConnectIntent reconnectConnectIntent(String accountId) throws IOException;
    
    ConnectIntent authorizeConnectIntent(
        String token,
        ConnectAuthorizeRequest connectAuthorizeRequest) throws IOException;
    
    ConnectIntent completeConnectIntent(
        String token,
        ConnectCompleteRequest connectCompleteRequest) throws IOException;
    
    // Accounts
    
    Account createAccount(Account account) throws IOException;
    
    Account updateAccount(Account account) throws IOException;
    
    Paginated<Account> getAccounts(AccountQuery accountQuery) throws IOException;
    
    default Account getAccountById(String accountId) throws IOException {
        return this.getAccountById(accountId, null);
    }
    
    Account getAccountById(String accountId, Iterable<String> expands) throws IOException;

    // Visions
    
    Vision createVision(VisionRequest visionRequest) throws IOException;
    
    default Vision getVisionById(String visionId) throws IOException {
        return this.getVisionById(visionId, null);
    }
    
    Vision getVisionById(String visionId, Iterable<String> expands) throws IOException;

    // Messages
    
    Paginated<Message> getMessages(MessageQuery messageQuery) throws IOException;
    
    Message createMessage(MessageRequest messageRequest) throws IOException;
    
    default Message getMessageById(String messageId) throws IOException {
        return this.getMessageById(messageId, null);
    }
    
    Message getMessageById(String messageId, Iterable<String> expands) throws IOException;
    
    // Transactions
    
    default Transaction getTransactionById(String transactionId) throws IOException {
        return this.getTransactionById(transactionId, null);
    }
    
    Transaction getTransactionById(String transactionId, Iterable<String> expands) throws IOException;

    Paginated<Transaction> getTransactions(TransactionQuery transactionQuery) throws IOException;
    
    // Transaction Exports
    
    default TransactionExporter getTransactionExporterById(
            String transactionId,
            String accountId,
            TransactionExporterQuery transactionExporterQuery) throws IOException {
        
        return this.getTransactionExporterById(transactionId, accountId, null, transactionExporterQuery);
    }
    
    TransactionExporter getTransactionExporterById(
            String transactionId,
            String accountId,
            String targetId,
            TransactionExporterQuery transactionExporterQuery) throws IOException;
    
    TransactionExport saveTransactionExport(
            String transactionId,
            String accountId,
            TransactionExporterRequest transactionExporterRequest) throws IOException;
    
    TransactionExport getTransactionExportById(
            String transactionExportId) throws IOException;
    
    TransactionExport deleteTransactionExportById(
            String transactionExportId,
            TransactionExportDeleteMode deleteMode) throws IOException;
    
}