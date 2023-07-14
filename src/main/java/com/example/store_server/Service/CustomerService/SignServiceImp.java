package com.example.store_server.Service.CustomerService;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import com.example.store_server.dao.CustomerMapper.SignMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImp implements SignService {
    @Autowired
    SignMapper signMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Customer signIn(String account, String password) {
        try {
            Customer customer = signMapper.signIn(account, password);
            System.out.println(account +"," + password);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean signUp(Customer customer) {
        try {
            String account = customer.getAccount();
            String password = customer.getPassword();
            String username = customer.getUsername();
            String email = customer.getEmail();
            Integer statusCode = signMapper.signUp(account,password,username,email);
            return statusCode == 1;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
