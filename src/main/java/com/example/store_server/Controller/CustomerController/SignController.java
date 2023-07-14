package com.example.store_server.Controller.CustomerController;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Pojo.User;
import com.example.store_server.Service.CustomerService.SignService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@CrossOrigin
public class SignController {
    @Autowired
    SignService signService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/signIn")
    public Result signIn(
            @NonNull @RequestParam(name = "account") String account,
            @NonNull @RequestParam(name = "password") String password
    ) {
        Customer customer = signService.signIn(account, password);
        if(customer == null) return Result.dataBaseConnectionFailure();
        return Result.success("登入成功",customer);
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
}
