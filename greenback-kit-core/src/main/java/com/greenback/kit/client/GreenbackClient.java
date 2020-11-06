package com.greenback.kit.client;

import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.ConnectQuery;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.Transaction;
import com.greenback.kit.model.TransactionQuery;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import java.io.IOException;

public interface GreenbackClient {

    String getBaseUrl();
    
    GreenbackCodec getCodec();
    
    default User getUserById(String userId) throws IOException {
        return this.getUserById(userId, null);
    }
    
    User getUserById(String userId, Iterable<String> expands) throws IOException;
    
    Paginated<Connect> getConnects(ConnectQuery connectQuery) throws IOException;
    
    default Connect getConnectByLabel(String connectLabel) throws IOException {
        return this.getConnectByLabel(connectLabel, null);
    }
    
    Connect getConnectByLabel(String connectLabel, Iterable<String> expands) throws IOException;
    
    Paginated<Account> getAccounts(AccountQuery accountQuery) throws IOException;
    
    default Account getAccountById(String accountId) throws IOException {
        return this.getAccountById(accountId, null);
    }
    
    Account getAccountById(String accountId, Iterable<String> expands) throws IOException;

    Vision createVision(VisionRequest visionRequest) throws IOException;
    
    default Vision getVisionById(String visionId) throws IOException {
        return this.getVisionById(visionId, null);
    }
    
    Vision getVisionById(String visionId, Iterable<String> expands) throws IOException;

    Paginated<Message> getMessages(MessageQuery messageQuery) throws IOException;
    
    Message createMessage(MessageRequest messageRequest) throws IOException;
    
    default Message getMessageById(String messageId) throws IOException {
        return this.getMessageById(messageId, null);
    }
    
    Message getMessageById(String messageId, Iterable<String> expands) throws IOException;
    
    default Transaction getTransactionById(String transactionId) throws IOException {
        return this.getTransactionById(transactionId, null);
    }
    
    Transaction getTransactionById(String transactionId, Iterable<String> expands) throws IOException;

    Paginated<Transaction> getTransactions(TransactionQuery messageQuery) throws IOException;
    
}