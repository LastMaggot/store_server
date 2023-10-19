package com.example.store_server.Service.CustomerService;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Util.MailService;
import com.example.store_server.dao.CustomerMapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SignServiceImp implements SignService {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    MailService mailService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Customer signIn(String account, String password) {
        try {
            Customer customer = customerMapper.signIn(account, password);
            if(customer == null) {
                System.out.println("没有找到对应的customer");
                return null;
            }
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
            Integer statusCode = customerMapper.signUp(account, password, username, email);
            return statusCode == 1;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateToken(String token,String account) {
        try {
            customerMapper.updateToken(token, account);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String forgetPassword(String account, String email) {
        Random random = new Random();
        Integer mailcodeInt = random.nextInt(1000,9999);
        String mailcode = "Store" + mailcodeInt.toString();
        customerMapper.updateMailCode(mailcode.toString(),account,email);
        return mailcode;
    }

    @Override
    public Customer loginByToken(String token) {
        Customer customer = customerMapper.loginByToken(token);
        return customer;
    }

    @Override
    public void updateUserInfo(Customer customer) {
        Integer id = customer.getId();
        String account = customer.getAccount();
        String password = customer.getPassword();
        String username = customer.getUsername();
        String address = customer.getAddress();
        String email = customer.getEmail();
        customerMapper.updateUserInfo(id,account,password,username,address,
                                      email);
    }
}
