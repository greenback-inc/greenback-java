package com.greenback.kit.model;

import java.io.IOException;

public class GreenbackException extends IOException {
    private static final long serialVersionUID = 1L;
    
    private final GreenbackError error;

    public GreenbackException(GreenbackError error) {
        super(error.getMessage());
        this.error = error;
    }

    public GreenbackException(GreenbackError error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
    }

    public GreenbackError getError() {
        return error;
    }

}