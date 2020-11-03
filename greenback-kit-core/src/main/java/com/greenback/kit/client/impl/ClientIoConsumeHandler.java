package com.greenback.kit.client.impl;

import java.io.IOException;

public interface ClientIoConsumeHandler<T> {

    public T apply() throws IOException;
    
}