package com.greenback.kit.model;

import java.time.Instant;

public class User {
 
    private String id;
    private UserType type;
    private UserState state;
    private String name;
    private String email;
    private UserEmailState emailState;
    private UserPasswordState passwordState;
    private Integer memberCount;
    private Instant createdAt;
    private Instant updatedAt;
    
    // expand
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEmailState getEmailState() {
        return emailState;
    }

    public void setEmailState(UserEmailState emailState) {
        this.emailState = emailState;
    }

    public UserPasswordState getPasswordState() {
        return passwordState;
    }

    public void setPasswordState(UserPasswordState passwordState) {
        this.passwordState = passwordState;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}