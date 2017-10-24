package com.cszjo.tiffany.core.serialize.impl;

import com.cszjo.tiffany.core.serialize.Serializable;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.FastInput;
import com.esotericsoftware.kryo.io.FastOutput;
import com.esotericsoftware.kryo.io.KryoObjectInput;
import com.esotericsoftware.kryo.io.KryoObjectOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 使用Kryo序列化
 * Created by hansiming on 2017/10/16.
 */
public class KryoSerializetion implements Serializable {

    private Kryo kryo = new Kryo();

    public byte[] serialize(Object data) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        KryoObjectOutput out = new KryoObjectOutput(kryo, new FastOutput(bos));
        out.writeObject(data);
        out.flush();
        return bos.toByteArray();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        kryo.register(clazz);
        KryoObjectInput in = new KryoObjectInput(kryo, new FastInput(new ByteArrayInputStream(data)));
        return (T) in.readObject();
    }
}
