package com.example.store_server.Controller.AdminController;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Pojo.User;
import com.example.store_server.Service.AdminService.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/signIn")
    Result signIn(@NonNull @RequestParam(name = "account") String account,
            @NonNull @RequestParam(name = "password") String password) {
        User user = adminService.signIn(account, password);
        if(user == null) return Result.error("无效的用户名或密码");
        return Result.success(user);
    }

    //用户管理

    @GetMapping("/getAllCustomerInfo")
    Result getAllCustomerInfo() {
        return Result.success(adminService.getAllCustomerInfo());
    }

    @GetMapping("/getCustomerInfoById")
    Result getCustomerInfoById(@NonNull @RequestParam(name =
            "id") Integer id) {
        return Result.success(adminService.getCustomerInfoById(id));
    }

    @GetMapping("/getCustomerInfoByName")
    Result getCustomerInfoByName(@NonNull @RequestParam(name =
            "name") String name) {
        return Result.success(adminService.getCustomerInfoByName(name));
    }

    @DeleteMapping("/deleteCustomerById")
    Result deleteCustomerById(@NonNull @RequestParam(name = "id") Integer id) {
        return Result.success(adminService.deleteCustomerById(id));
    }

    @PostMapping("/resetPassword")
    Result resetPassword(@NonNull @RequestParam(name = "account") String account) {
        return Result.success(adminService.resetPassword(account));
    }

    @PostMapping("/resetAdminPassword")
    Result resetAdminPassword(@NonNull @RequestBody User user) {
        return Result.success(adminService.resetAdminPassword(user.getAccount(),user.getPassword()));
    }

    //商品管理
    @GetMapping("/getAllGoods")
    Result getAllGoods() {
        return Result.success(adminService.getAllGoods());
    }

    @GetMapping("/getGoodsById")
    Result getGoodsById(@NonNull @RequestParam(name = "id") Integer id) {
        return Result.success(adminService.getGoodsById(id));
    }

    @GetMapping("/getGoodsByName")
    Result getGoodsById(@NonNull @RequestParam(name = "name") String name) {
        return Result.success(adminService.getGoodsByName(name));
    }

    @PostMapping("/addGoods")
    Result addGoods(@NonNull @RequestBody Goods goods) {
        adminService.addGoods(goods);
        return Result.success();
    }

    @DeleteMapping("/delGoods")
    Result delGoods(@NonNull @RequestParam(name = "id") Integer id) {
        adminService.delGoods(id);
        return Result.success();
    }

    @PostMapping("/updGoods")
    Result updGoods(@NonNull @RequestBody Goods goods) {
        adminService.updGoods(goods);
        return Result.success();
    }
}
