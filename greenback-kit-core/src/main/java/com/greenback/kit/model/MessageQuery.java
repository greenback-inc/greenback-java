package com.greenback.kit.model;

import java.time.Instant;

public class MessageQuery extends DocumentQuery<MessageQuery> {
    
    protected String query;
    protected Instant minPostedAt;          // start
    protected Instant maxPostedAt;          // end

    public String getQuery() {
        return query;
    }

    public MessageQuery setQuery(String query) {
        this.query = query;
        return this;
    }

    public Instant getMinPostedAt() {
        return minPostedAt;
    }

    public MessageQuery setMinPostedAt(Instant minPostedAt) {
        this.minPostedAt = minPostedAt;
        return this;
    }

    public Instant getMaxPostedAt() {
        return maxPostedAt;
    }

    public MessageQuery setMaxPostedAt(Instant maxPostedAt) {
        this.maxPostedAt = maxPostedAt;
        return this;
    }

}