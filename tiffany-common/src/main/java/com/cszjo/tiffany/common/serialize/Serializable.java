package com.cszjo.tiffany.common.serialize;

/**
 * 序列化接口
 * Created by hansiming on 2017/10/16.
 */
public interface Serializable {

    byte[] serialize (Object data) throws  Exception;

    <T> T deserialize(byte[] data, Class<T> clazz) throws Exception;
}
