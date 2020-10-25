package com.jiasy.kafka_mq.controller;

import com.jiasy.kafka_mq.entity.User;
import com.jiasy.kafka_mq.service.UserService;
import com.jiasy.kafka_mq.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jsy
 * @Date: 2019/10/12 19:28
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/add")
    public String add(User user) {

        System.out.println(user);
        userService.add(user);
        return null;
    }
}
