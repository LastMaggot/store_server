package com.example.store_server.Controller.CustomerController;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Pojo.User;
import com.example.store_server.Service.CustomerService.SignService;
import com.example.store_server.Util.JWTUtil;
import com.example.store_server.Util.MailService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;


@Slf4j
@RestController
@CrossOrigin
public class SignController {
    @Autowired
    private SignService signService;

    @Autowired
    MailService mailService;

    @Autowired
    private JWTUtil jwtUtil;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/signIn")
    public Result signIn(
            @NonNull @RequestParam(name = "account") String account,
            @NonNull @RequestParam(name = "password") String password
    ) {
        Customer customer = signService.signIn(account, password);
        if(customer == null) return Result.dataBaseConnectionFailure();
        String token = jwtUtil.createToken(customer);
        Boolean res = signService.updateToken(token,account);
        if(res == true) return Result.success(token,customer);
        return Result.success("登入成功，更新Token失败",customer);
    }

    @PostMapping("/signUp")
    public Result signUp(
            @RequestBody Customer customer
    ) {
        if(!customer.isValid()) return Result.httpConnectionFailure();
        Boolean res = signService.signUp(customer);
        if(res) {
            return Result.success();
        }
        else return Result.dataBaseConnectionFailure();
    }

    @PostMapping("/forgetPassword")
    public Result forgetPassword(@NonNull @RequestParam(name = "account") String account,@NonNull @RequestParam(name = "email") String email) {
        try {
            String mailcode  = signService.forgetPassword(account, email);
            mailService.sendMail(email,mailcode);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error("发送邮件失败");
        }
    }

    @GetMapping("/loginByToken")
    public Result loginByToken(@NonNull @RequestParam String token) {
        try {
            System.out.println(token);
            Customer customer = signService.loginByToken(token);
            if(customer == null) {
                throw new SQLException();
            }
            System.out.println(customer.toString());
            return Result.success("登入成功",customer);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error("Token过期");
        }
    }
}
