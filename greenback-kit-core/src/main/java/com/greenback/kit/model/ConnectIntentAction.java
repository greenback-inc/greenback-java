package com.greenback.kit.model;

public enum ConnectIntentAction {
    
    /** A form should be displayed asking questions */
    INPUT,
    /** The user agent (browser) needs to visit a url to complete auth */
    REDIRECT,
    /** The authorization was issued, ready for complete to the called */
    ISSUED,
    /** The authorization could be fully completed with confirmation */
    CONFIRM,
    /** The authorization is fully completed, account created */
    COMPLETED,
    /** A simple 200 OK response is required **/
    OK,
    /** An error occurred with the authorization */
    ERROR;
    
}