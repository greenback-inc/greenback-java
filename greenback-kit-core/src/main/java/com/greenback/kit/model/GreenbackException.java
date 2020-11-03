package com.greenback.kit.model;

import java.io.IOException;

public class GreenbackException extends IOException {
    private static final long serialVersionUID = 1L;
    
    private final Error error;

    public GreenbackException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public GreenbackException(Error error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

}