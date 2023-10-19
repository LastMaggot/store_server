package com.example.store_server.Service.CartService;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Service.CartService.CartService;
import com.example.store_server.dao.CartMapper.CartMapper;
import com.example.store_server.dao.GoodsMapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<Goods> getCartGoods(
            Integer user_id
    ) {
        try {
            List<Goods> goodsList = cartMapper.getCartGoods(user_id);
            return goodsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addToCart(
            Integer user_id, Integer goods_id, Integer num
    ) {
        try{
            Integer code = cartMapper.addToCart(user_id, goods_id, num);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteFromCart(Integer id) {
        try{
            cartMapper.deleteFromCart(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void buy(Integer cart_id,Integer goods_id, Integer num) {
            Goods goods = goodsMapper.getById(goods_id);
            if(goods.getInventory() < num) throw new RuntimeException("库存不足");
            cartMapper.deleteFromCart(cart_id);
            cartMapper.deleteGoodsInventory(goods_id,num);
            return;
    }
}
