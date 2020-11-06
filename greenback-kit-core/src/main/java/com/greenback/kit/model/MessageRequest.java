package com.greenback.kit.model;

import com.greenback.kit.util.Bytes;
import java.io.File;
import java.util.Objects;

public class MessageRequest {
 
    private Boolean async;
    private Bytes document;

    public Boolean getAsync() {
        return async;
    }

    public MessageRequest setAsync(Boolean async) {
        this.async = async;
        return this;
    }

    public Bytes getDocument() {
        return document;
    }

    public MessageRequest setDocument(Bytes document) {
        this.document = document;
        return this;
    }
    
    public MessageRequest setDocument(File file) {
        Objects.requireNonNull(file, "file was null");
        this.document = Bytes.of(file);
        return this;
    }
    
    public MessageRequest setDocument(byte[] bytes) {
        Objects.requireNonNull(bytes, "bytes was null");
        this.document = Bytes.of(bytes);
        return this;
    }
    
    public MessageRequest setDocument(byte[] bytes, String name) {
        Objects.requireNonNull(bytes, "bytes was null");
        this.document = Bytes.of(bytes, name);
        return this;
    }
    
}