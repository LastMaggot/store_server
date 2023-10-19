package com.example.store_server.Controller.GoodsController;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Result;
import com.example.store_server.Service.GoodsService.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/getAllGoods")
    public Result getAllGoods() {
        List<Goods> goodsList = goodsService.getAllGoods();
        if(goodsList == null) {
            return Result.error("未能找到对应的商品");
        }
        return Result.success(goodsList);
    }

    @GetMapping("/getById")
    public Result getById(@RequestParam(name = "id") Integer goods_id) {
        Goods goods = goodsService.getById(goods_id);
        if(goods == null) {
            return Result.error("未能找到该id的商品");
        }
        return Result.success(goods);
    }

    @GetMapping("/getByName")
    public Result getByName(@RequestParam(name = "name") String name) {
        List<Goods> goodsList = goodsService.getByName(name);
        if(goodsList == null) {
            return Result.error("未能找到含有该关键字的商品");
        }
        return Result.success(goodsList);
    }
}
