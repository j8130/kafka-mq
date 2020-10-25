package com.jiasy.kafka_mq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Description username  为发送用户的登录账号
 * password  为发送用户的登录密码
 */
@Service
public class NetEaseSendEmailUtil {

    //个人邮箱名    发送邮箱必须是网易
    @Value("${neteasy.mail.username:123}")
    public String username;
    //开启SMTP协议设置的密码,是授权码  ，不是登录密码
    @Value("${neteasy.mail.password:123}")
    private String password;

    public void sendMessage(String email, String message) {

        //构建会话对象   包括会话类型   和 会话账号密码
        Properties props = System.getProperties();
        //设置主机类型
        props.setProperty("mail.smtp.host", "smtp.163.com");

        Session session = Session.getDefaultInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(true);

        //构建 会话内容
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            //设置发送地址
            InternetAddress fromAddress = new InternetAddress(username);
            mimeMessage.setFrom(fromAddress);

            //设置接收人
            InternetAddress reciAddress = new InternetAddress(email);
            mimeMessage.setRecipient(RecipientType.TO, reciAddress);

            //设置邮件的头
            mimeMessage.setSubject("书籍到货通知！");
            mimeMessage.setContent(message, "text/plain;charset=UTF-8");

            //构建连接
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.163.com", username, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            System.out.println("send Message SuccessFul!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("send Message fail!");
            e.printStackTrace();
        }

    }

}
