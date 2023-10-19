package com.example.store_server.Util;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Resource
    private JavaMailSenderImpl mailSender;

    public void sendMail(String mailAddress, String mailcode) throws MessagingException {
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("15080051875@163.com");
        simpleMailMessage.setTo(mailAddress);
        simpleMailMessage.setSubject("蓝天购物平台登入验证服务");
        simpleMailMessage.setText("您正在使用蓝天购物平台登入密码找回服务，您的新密码为："+mailcode+
                                          "。如非您本人操作，请无视" );
        mailSender.send(simpleMailMessage);
    }
}
