package com.jiasy.kafka_mq.service;

import com.jiasy.kafka_mq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: jsy
 * @Date: 2019/10/12 19:31
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    //
    // @Autowired
    // private UserMapper userMapper;
    @Autowired
    private Producer producer;

    @Override
    public void add(User user) {

        // userMapper.add(user);

        System.out.println("before producer service");
        producer.setProducer(user);

    }
}
