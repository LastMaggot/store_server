package com.example.store_server.Service.CustomerService;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import org.springframework.stereotype.Service;

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

    /**
     * 更新用户token
     * @param token
     * @param account
     * @return
     */
    public Boolean updateToken(String token,String account);

    /**
     * 忘记密码
     * @param account
     * @param email
     * @return
     */
    public String forgetPassword(String account, String email);

    public Customer loginByToken(String token);

    public void updateUserInfo(Customer customer);
}
