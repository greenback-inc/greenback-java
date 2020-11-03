package com.greenback.kit.util;

import java.io.IOException;

public interface IoFunction<P,R> {
    
    R apply(P p) throws IOException;
    
}