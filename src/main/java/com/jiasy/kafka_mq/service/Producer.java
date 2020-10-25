package com.jiasy.kafka_mq.service;

import com.jiasy.kafka_mq.entity.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.UUID;

/**
 * @Author: jsy
 * @Date: 2019/10/12 10:56
 */
@Service
public class Producer {

    // public static void main(String[] args) {
    public void setProducer(User user) {

        // 创建配置对象
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        // 指定序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);  //key 是String，用StringSerializer
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ObjectCodec.class);     //这个是自定义的序列化器

        // 创建生产者对象
        KafkaProducer<String, User> producer = new KafkaProducer<>(properties);

        // 创建消息
        ProducerRecord<String, User> record = new ProducerRecord<>("t3", UUID.randomUUID().toString(), user);
        // 发布消息
        producer.send(record);

        // 提交
        producer.flush();
        producer.close();
        // }
    }
}
