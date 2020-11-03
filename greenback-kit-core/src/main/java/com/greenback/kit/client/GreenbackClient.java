package com.greenback.kit.client;

import com.greenback.kit.model.Account;
import com.greenback.kit.model.AccountQuery;
import com.greenback.kit.model.Connect;
import com.greenback.kit.model.Message;
import com.greenback.kit.model.MessageQuery;
import com.greenback.kit.model.MessageRequest;
import com.greenback.kit.model.Paginated;
import com.greenback.kit.model.User;
import com.greenback.kit.model.Vision;
import com.greenback.kit.model.VisionRequest;
import java.io.IOException;

public interface GreenbackClient {

    String getBaseUrl();
    
    GreenbackCodec getCodec();
    
    User getUserById(String userId) throws IOException;
    
    Paginated<Connect> getConnects() throws IOException;
    
    Connect getConnectByLabel(String connectLabel) throws IOException;
    
    Paginated<Account> getAccounts(AccountQuery accountQuery) throws IOException;
    
    Account getAccountById(String accountId) throws IOException;

    Vision createVision(VisionRequest visionRequest) throws IOException;
    
    Vision getVisionById(String visionId) throws IOException;

    Paginated<Message> getMessages(MessageQuery messageQuery) throws IOException;
    
    Message createMessage(MessageRequest messageRequest) throws IOException;
    
    Message getMessageById(String messageId) throws IOException;

    
    
//    GBPaginatedResponse<GBAccount> getAccountsNext(
//        GBPaginatedResponse<GBAccount> previous) throws IOException;
//
//    GBSync createAccountSync(
//        String accountId) throws IOException;
//
//    GBSync getSync(
//        String syncId) throws IOException;
    
}