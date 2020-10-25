package com.jiasy.kafka_mq.service;

import com.jiasy.kafka_mq.entity.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: jsy
 * @Date: 2019/10/12 13:57
 */
@Service
public class Consumer {

    private static SendEmail sendEmail = new SendEmail();
    private static SendPhone sendPhone = new SendPhone();

    public static void main(String[] args) {

        // 创建配置对象
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ObjectCodec.class);

        // 指定消费组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "g2");

        KafkaConsumer<String, User> consumer = new KafkaConsumer<>(properties);

        // 订阅主题Topic
        consumer.subscribe(Arrays.asList("t3"));

        while (true) {
            ConsumerRecords<String, User> records = consumer.poll(Duration.ofSeconds(5L));
            for (ConsumerRecord<String, User> record : records) {

                sendEmail.sendEmail(record.value().getEmail());
                sendPhone.sendPhone(record.value().getPhone());

            }
        }
    }

}

