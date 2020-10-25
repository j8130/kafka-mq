package com.jiasy.kafka_mq.service;

import org.springframework.stereotype.Service;

/**
 * @Author: jsy
 * @Date: 2019/10/14 8:58
 */
@Service
public class SendEmail {

    NetEaseSendEmailUtil netEaseSendEmailUtil = new NetEaseSendEmailUtil();

    public void sendEmail(String email) {
//		由于没有lang3包，这里验证码生写
//		String code = RandomStringUtils.random(6, "0123456789");
        String code = "2333";

        String context = "【小可爱】您好，您当前正在进行小可爱的注册，您的验证码为：" + code + "。为了给" +
                "您提供更好的服务，请您尽快完成注册。！";
        //参数    要接收邮件的邮箱 ,发送的内容
        netEaseSendEmailUtil.sendMessage(email, context);
    }

    public void sendBookEmail(String email, String bookName) {
        String context = "您的书籍：《" + bookName + "》 已到货！！";
        //参数    要接收邮件的邮箱 ,发送的内容
        netEaseSendEmailUtil.sendMessage(email, context);
    }
}
