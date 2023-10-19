package com.example.store_server;

import com.example.store_server.Pojo.CustomerLevel;
import com.example.store_server.Pojo.User;
import com.example.store_server.Util.MailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class StoreServerApplicationTests {

    @Autowired
    MailService mailService;
    @Test
    void userUnitTest() {
        User user = new User(1,"1","1","1");
        System.out.println(user.toString());
    }

    @Test
    void SendMail() throws MessagingException {
        mailService.sendMail("2039043647@qq.com","store1234");
    }

    @Test
    void CustomerLevelUnitTest() {
        CustomerLevel level = CustomerLevel.gold;
        System.out.println(level.ordinal());
    }

    @Test
    void contextLoads() {

    }
}
