package com.example.store_server.Controller.CartController;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Service.CartService.CartService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/getCartGoods")
    public Result getCartGoods(@NonNull @RequestParam(name = "user_id") Integer user_id) {
        List<Goods> goodsList = cartService.getCartGoods(user_id);
        return Result.success(goodsList);
    }

    @PostMapping("/addToCart")
    public Result addToCart(@NonNull @RequestParam(name = "user_id") Integer user_id,@NonNull @RequestParam(name = "goods_id") Integer goods_id,@RequestParam(name = "num",defaultValue = "1") Integer num) {
        Boolean status = cartService.addToCart(user_id, goods_id, num);
        if(status == false) {
            return Result.dataBaseConnectionFailure();
        }else {
            return Result.success("成功添加到购物车");
        }
    }

    @DeleteMapping("/deleteFromCart")
    public Result deleteFromCart(Integer id) {
        Boolean status = cartService.deleteFromCart(id);
        if(status == false) {
            return Result.dataBaseConnectionFailure();
        } else {
            return Result.success("移除成功");
        }
    }

    @PutMapping("/buy")
    public Result buy(@NonNull @RequestParam(name = "cart_id") Integer id,
            @NonNull @RequestParam(name =
            "goods_id") Integer goods_id, @RequestParam(name = "num") Integer num) {
        try{
            cartService.buy(id, goods_id, num);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }
}
