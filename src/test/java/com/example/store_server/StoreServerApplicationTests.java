package com.example.store_server;

import com.example.store_server.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class StoreServerApplicationTests {

    @Test
    void userUnitTest() {
        User user = new User();
        log.debug(user.toString());
    }

    @Test
    void contextLoads() {

    }
}
