package com.greenback.kit.model;

import java.time.Instant;
import java.util.List;

public class Message extends Document {
    
    private String id;
    private String referenceId;
    private ProcessingStatus status;
    private Integer size;
    private String subject;
    private String snippet;
    private List<Attachment> attachments;
    private EmailAddress from;
    private List<EmailAddress> replyTo;
    private List<EmailAddress> to;
    private List<EmailAddress> cc;
    private List<EmailAddress> bcc;
    private List<QuotedMessage> quoted;
    private String fullText;
    private Instant postedAt;
    private Instant createdAt;
    private Instant updatedAt;
    
    // expand
    
    private List<Transaction> transactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return referenceId;
    }

    public void setName(String name) {
        this.referenceId = name;
    }

    public ProcessingStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessingStatus status) {
        this.status = status;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public EmailAddress getFrom() {
        return from;
    }

    public void setFrom(EmailAddress from) {
        this.from = from;
    }

    public List<EmailAddress> getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(List<EmailAddress> replyTo) {
        this.replyTo = replyTo;
    }

    public List<EmailAddress> getTo() {
        return to;
    }

    public void setTo(List<EmailAddress> to) {
        this.to = to;
    }

    public List<EmailAddress> getCc() {
        return cc;
    }

    public void setCc(List<EmailAddress> cc) {
        this.cc = cc;
    }

    public List<EmailAddress> getBcc() {
        return bcc;
    }

    public void setBcc(List<EmailAddress> bcc) {
        this.bcc = bcc;
    }

    public List<QuotedMessage> getQuoted() {
        return quoted;
    }

    public void setQuoted(List<QuotedMessage> quoted) {
        this.quoted = quoted;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public Instant getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Instant postedAt) {
        this.postedAt = postedAt;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}