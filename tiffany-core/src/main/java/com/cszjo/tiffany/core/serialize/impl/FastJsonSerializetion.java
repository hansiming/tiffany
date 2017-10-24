package com.cszjo.tiffany.core.serialize.impl;

import com.cszjo.tiffany.core.serialize.Serializable;

/**
 * Created by hansiming on 2017/10/24.
 */
public class FastJsonSerializetion implements Serializable {

    public byte[] serialize(Object data) throws Exception {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return null;
    }
}
