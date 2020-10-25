package com.jiasy.kafka_mq.service;

/**
 * @Author: jsy
 * @Date: 2019/10/14 21:28
 */

import org.apache.commons.lang.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
import java.util.Map;

/**
 * 自定义对象的编解码器类
 */
public class ObjectCodec implements Serializer, Deserializer {

    /**
     * bytes[] ---> Object
     *
     * @param s
     * @param bytes
     * @return
     */
    @Override
    public Object deserialize(String s, byte[] bytes) {
        return SerializationUtils.deserialize(bytes);
    }

    @Override
    public void configure(Map map, boolean b) {

    }

    /**
     * Object ---> bytes[]
     *
     * @param s
     * @param o
     * @return
     */
    @Override
    public byte[] serialize(String s, Object o) {
        return SerializationUtils.serialize((Serializable) o);
    }

    @Override
    public void close() {

    }
}