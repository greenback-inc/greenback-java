package com.greenback.kit.client.impl;

import java.io.IOException;
import java.io.InputStream;

public interface ClientDeserializeHandler<T> {

    public T apply(InputStream input) throws IOException;
    
}