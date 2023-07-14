package com.example.store_server.Service.CustomerService;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface SignService {

    /**
     * 登入业务
     * @return
     */
    public Customer signIn(String account, String password);

    /**
     * 注册业务
     * @return
     */
    public Boolean signUp(Customer customer);
}
