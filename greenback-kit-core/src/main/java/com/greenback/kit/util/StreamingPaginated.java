package com.greenback.kit.util;

import com.greenback.kit.model.Paginated;
import com.greenback.kit.util.IoFunction;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;
import static java.util.Optional.ofNullable;
import java.util.concurrent.atomic.AtomicReference;

public class StreamingPaginated<T> extends Paginated<T> {

    private IoFunction<Paginated<T>,Paginated<T>> nextMethod;

    public IoFunction<Paginated<T>,Paginated<T>> nextMethod() {
        return this.nextMethod;
    }

    public void nextMethod(IoFunction<Paginated<T>,Paginated<T>> nextMethod) {
        this.nextMethod = nextMethod;
    }

    @Override
    public Iterator<T> iterator() {
        final AtomicReference<Paginated<T>> responseRef = new AtomicReference<>(this);
        final AtomicReference<Iterator<T>> iterRef = new AtomicReference<>(ofNullable(this.getValues())
            .map(v -> v.iterator())
            .orElse(null));
        
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                final Iterator<T> iter = iterRef.get();
                
                if (iter == null || !iter.hasNext()) {
                    if (!responseRef.get().hasNext()) {
                        return false;
                    }
                    
                    try {
                        Paginated<T> nextPage = ((StreamingPaginated<T>)responseRef.get())
                            .nextMethod()
                            .apply(responseRef.get());

                        responseRef.set(nextPage);
                        
                        Iterator<T> nextPageIterator = ofNullable(nextPage)
                            .map(v -> v.getValues())
                            .map(v -> v.iterator())
                            .orElse(null);
                        
                        iterRef.set(nextPageIterator);

                        if (iterRef.get() == null) {
                            return false;   // done
                        }

                        return iterRef.get().hasNext();
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
                
                return true;
            }

            @Override
            public T next() {
                return iterRef.get().next();
            }
        };
    }
    
}