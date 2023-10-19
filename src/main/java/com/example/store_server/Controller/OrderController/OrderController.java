package com.example.store_server.Controller.OrderController;

import com.example.store_server.Pojo.Order;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Service.OrderService.OrderService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getOrders")
    public Result getOrders(@NonNull @RequestParam(name = "user_id") Integer user_id) {
        return Result.success(orderService.getOrders(user_id));
    }

    @PostMapping("/createOrder")
    public Result createOrder(@NonNull @RequestBody Order order) {
        return Result.success(orderService.createOrder(order.getUser_id(),
                                                       order.getGoods_id(),
                                                       order.getNum(),
                                                       order.getPrice()));
    }

}
