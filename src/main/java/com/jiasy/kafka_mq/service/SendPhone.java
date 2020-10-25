package com.jiasy.kafka_mq.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author: jsy
 * @Date: 2019/10/14 20:39
 */
@Service
public class SendPhone {

    private PhoneMessageVerificationCode phone = new PhoneMessageVerificationCode();

    //生成随机数字
    public static String getRandom(int n) {
        char[] code = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(code[new Random().nextInt(code.length)]);
        }
        return sb.toString();
    }

    public String sendPhone(String phones) {

        //生成随机数  参数:随机数的位数
        String random = getRandom(6);

        String message = null;

        try {
            SendSmsResponse sendSmsResponse = phone.testPhones(phones, "小甜甜", "SMS_169903144", "{\"code\":\"" + random + "\"}");

            //接收回执信息
            String code = sendSmsResponse.getCode();
            //判断回执信息
            if (code.equals("OK")) {
                message = "发送成功";
            } else {
                if (code.equals("isv.AMOUNT_NOT_ENOUGH")) {
                    System.out.println("账户余额不足");
                    message = "账户余额不足";
                } else {
                    System.out.println("发送失败");
                    message = "发送失败";
                }
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return message;
    }
}
