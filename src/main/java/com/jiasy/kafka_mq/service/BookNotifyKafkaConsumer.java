package com.jiasy.kafka_mq.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.jiasy.kafka_mq.util.Java2Unicode;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: jsy
 * @Date: 2020/10/24 17:42
 */
public class BookNotifyKafkaConsumer {
    private static SendEmail sendEmail = new SendEmail();
    private static SendPhone sendPhone = new SendPhone();

    static {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger root = loggerContext.getLogger("root");
        root.setLevel(Level.INFO);

    }

    public static void main(String[] args) {

        // 创建配置对象
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.124.102:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        // 指定消费组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 订阅主题Topic
        consumer.subscribe(Arrays.asList("sendMail"));
        // consumer.subscribe(Arrays.asList("pyTest"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5L));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("发了一封邮件" + record);
                sendEmail.sendBookEmail("aa@qq.com", Java2Unicode.unicodeToCn(record.value()));
            }
        }
    }
}
