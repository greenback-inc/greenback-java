package com.greenback.kit.client;

import com.greenback.kit.model.AutoExportQuery;
import com.greenback.kit.model.*;

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
    
    default Connect getConnectByLabel(String connectLabel) throws IOException {
        return this.getConnectByLabel(connectLabel, null);
    }
    
    Connect getConnectByLabel(String connectLabel, Iterable<String> expands) throws IOException;
    
    // Connect Intents
    
    ConnectIntent beginConnectIntent(String connectLabel) throws IOException;
    
    ConnectIntent reconnectAccountIntent(String accountId) throws IOException;
    
    ConnectIntent authorizeConnectIntent(
        String token,
        ConnectIntentAuthorize authorize) throws IOException;
    
    ConnectIntent completeConnectIntent(
        String token,
        ConnectIntentComplete complete) throws IOException;
    
    // Accounts
    
    Account createAccount(Account account) throws IOException;
    
    Account updateAccount(Account account) throws IOException;
    
    Paginated<Account> getAccounts(AccountQuery accountQuery) throws IOException;
    
    default Account getAccountById(String accountId) throws IOException {
        return this.getAccountById(accountId, null);
    }
    
    Account getAccountById(String accountId, Iterable<String> expands) throws IOException;

    Account deleteAccountById(String accountId) throws IOException;
    
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

    Transaction createTransaction(Transaction transaction) throws IOException;
    
    Transaction updateTransaction(Transaction transaction) throws IOException;
    
    default Transaction getTransactionById(String transactionId) throws IOException {
        return this.getTransactionById(transactionId, null);
    }
    
    Transaction getTransactionById(String transactionId, Iterable<String> expands) throws IOException;

    Paginated<Transaction> getTransactions(TransactionQuery transactionQuery) throws IOException;
    
    Transaction deleteTransactionById(String transactionId) throws IOException;
    
    // Exports
    
    default TransactionExportIntent getTransactionExportIntent(
            String transactionId,
            String accountId,
            TransactionExportIntentRequest transactionExportIntentRequest) throws IOException {
        
        return this.getTransactionExportIntent(transactionId, accountId, null, transactionExportIntentRequest);
    }
    
    TransactionExportIntent getTransactionExportIntent(
            String transactionId,
            String accountId,
            String targetId,
            TransactionExportIntentRequest transactionExportIntentRequest) throws IOException;
    
    TransactionExport applyTransactionExportIntent(
            String transactionId,
            String accountId,
            TransactionExportIntentRequest transactionExportIntentRequest) throws IOException;
    
    TransactionExport getTransactionExportById(
            String transactionExportId) throws IOException;
    
    TransactionExport deleteTransactionExportById(
            String transactionExportId,
            TransactionExportDeleteMode deleteMode) throws IOException;

    // Transforms

    Paginated<Transform> getTransforms(TransformQuery transformQuery) throws IOException;
    
    Transform createTransform(Transform transform) throws IOException;

    Transform updateTransform(Transform transform) throws IOException;

    Transform getTransformById(String transformId) throws IOException;
    
    Transform deleteTransformById(String transformId, DeleteMode deleteMode) throws IOException;
    
    // Auto Exports

    AutoExport createAutoExport(AutoExport autoExport) throws IOException;

    AutoExport updateAutoExport(AutoExport autoExport) throws IOException;

    Paginated<AutoExport> getAutoExports(AutoExportQuery autoExportQuery) throws IOException;

    default AutoExport getAutoExportById(String autoExportId) throws IOException {
        return this.getAutoExportById(autoExportId, null);
    }

    AutoExport getAutoExportById(String autoExportId, Iterable<String> expands) throws IOException;

    AutoExport deleteAutoExportById(String autoExportId) throws IOException;

    // Auto Export Runs

    ExportRun createAutoExportRun(String autoExportId, ExportRun exportRun) throws IOException;

    default ExportRun getExportRunById(String exportRunId) throws IOException {
        return this.getExportRunById(exportRunId, null);
    }

    ExportRun getExportRunById(String exportRunId, Iterable<String> expands) throws IOException;

    default Paginated<ExportRun> getExportRunsByAutoExportId(String autoExportId) throws IOException {
        return this.getExportRunsByAutoExportId(autoExportId, null);
    }

    Paginated<ExportRun> getExportRunsByAutoExportId(String autoExportId, Iterable<String> expands) throws IOException;

}