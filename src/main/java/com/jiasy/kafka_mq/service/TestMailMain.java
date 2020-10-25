package com.jiasy.kafka_mq.service;

/**
 * @Author: jsy
 * @Date: 2020/5/11 23:48
 */
public class TestMailMain {
    public static void main(String[] args) {


        NetEaseSendEmailUtil netEaseSendEmailUtil = new NetEaseSendEmailUtil();

        String code = "2333";

        String context = "【小可爱】您好，您当前正在进行小可爱的注册，您的验证码为：" + code + "。为了给" +
                "您提供更好的服务，请您尽快完成注册。！";
        //参数    要接收邮件的邮箱 ,发送的内容
        netEaseSendEmailUtil.sendMessage("aa@qq.com", context);
    }
}
// 发送日志
/*
DEBUG: setDebug: JavaMail version 1.6.2
DEBUG: getProvider() returning javax.mail.Provider[TRANSPORT,smtp,com.sun.mail.smtp.SMTPTransport,Oracle]
DEBUG SMTP: useEhlo true, useAuth false
DEBUG SMTP: trying to connect to host "smtp.163.com", port 25, isSSL false
220 163.com Anti-spam GT for Coremail System (163com[20141201])
DEBUG SMTP: connected to host "smtp.163.com", port: 25
EHLO jsy
250-mail
250-PIPELINING
250-AUTH LOGIN PLAIN
250-AUTH=LOGIN PLAIN
250-coremail 1Uxr2xKj7kG0xkI17xGrU7I0s8FY2U3Uj8Cz28x1UUUUU7Ic2I0Y2UrZEaD8UCa0xDrUUUUj
250-STARTTLS
250 8BITMIME
DEBUG SMTP: Found extension "PIPELINING", arg ""
DEBUG SMTP: Found extension "AUTH", arg "LOGIN PLAIN"
DEBUG SMTP: Found extension "AUTH=LOGIN", arg "PLAIN"
DEBUG SMTP: Found extension "coremail", arg "1Uxr2xKj7kG0xkI17xGrU7I0s8FY2U3Uj8Cz28x1UUUUU7Ic2I0Y2UrZEaD8UCa0xDrUUUUj"
DEBUG SMTP: Found extension "STARTTLS", arg ""
DEBUG SMTP: Found extension "8BITMIME", arg ""
DEBUG SMTP: protocolConnect login, host=smtp.163.com, user=15237353722@163.com, password=<non-null>
DEBUG SMTP: Attempt to authenticate using mechanisms: LOGIN PLAIN DIGEST-MD5 NTLM XOAUTH2
DEBUG SMTP: Using mechanism LOGIN
DEBUG SMTP: AUTH LOGIN command trace suppressed
DEBUG SMTP: AUTH LOGIN succeeded
DEBUG SMTP: use8bit false
MAIL FROM:<15237353722@163.com>
250 Mail OK
RCPT TO:<122969720@qq.com>
250 Mail OK
DEBUG SMTP: Verified Addresses
DEBUG SMTP:   122969720@qq.com
DATA
354 End data with <CR><LF>.<CR><LF>
Date: Mon, 11 May 2020 23:51:04 +0800 (CST)
From: 15237353722@163.com
To: 122969720@qq.com
Message-ID: <2121744517.0.1589212273100@jsy>
Subject: =?UTF-8?B?eHjnvZHpqozor4HnoIHvvIE=?=
MIME-Version: 1.0
Content-Type: text/plain;charset=UTF-8
Content-Transfer-Encoding: base64

44CQ5bCP5Y+v54ix44CR5oKo5aW977yM5oKo5b2T5YmN5q2j5Zyo6L+b6KGM5bCP5Y+v54ix55qE
5rOo5YaM77yM5oKo55qE6aqM6K+B56CB5Li677yaMjMzM+OAguS4uuS6hue7meaCqOaPkOS+m+ab
tOWlveeahOacjeWKoe+8jOivt+aCqOWwveW/q+WujOaIkOazqOWGjOOAgu+8gQ==
.
250 Mail OK queued as smtp8,DMCowAD3jVJfdLleDUr9BQ--.51014S2 1589212273
DEBUG SMTP: message successfully delivered to mail server
QUIT
221 Bye
send Message SuccessFul!

Process finished with exit code 0

*/

