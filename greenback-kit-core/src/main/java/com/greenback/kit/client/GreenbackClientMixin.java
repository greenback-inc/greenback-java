package com.greenback.kit.client;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static com.greenback.kit.util.Utils.toStringList;

public interface GreenbackClientMixin {
    default Map<String,String> toQueryMap(Object value, GreenbackCodec codec) throws IOException {
        final Map<String,String> map = new LinkedHashMap<>();

        if (value != null) {
            final Map<String,Object> flattenedMap = codec.toFlattenedMap(value);
            if (flattenedMap != null) {
                flattenedMap.forEach((k,v) -> {
                    if (v instanceof Iterable) {
                        map.put(k, toStringList((Iterable)v));
                    } else {
                        map.put(k, Objects.toString(v, ""));
                    }
                });
            }
        }

        return map;
    }
}
