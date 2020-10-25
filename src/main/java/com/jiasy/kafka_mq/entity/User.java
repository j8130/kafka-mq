package com.jiasy.kafka_mq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: jsy
 * @Date: 2019/10/12 19:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private String password;
    private String phone;
    private String email;

}
