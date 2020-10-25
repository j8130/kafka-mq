package com.jiasy.kafka_mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jsy.kafka_mq.mapper")
public class KafkaMqApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaMqApplication.class, args);
    }

}
