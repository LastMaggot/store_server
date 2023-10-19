package com.example.store_server.Service.CartService;

import com.example.store_server.Pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    /**
     * 获取用户购物车上所有商品
     * @param user_id
     * @return
     */
    public List<Goods> getCartGoods(Integer user_id);

    /**
     * 将商品加入到用户购物车上
     * @param user_id
     * @param goods_id
     * @param num
     * @return
     */
    public Boolean addToCart(Integer user_id, Integer goods_id, Integer num);

    /**
     * 删除用户购物车上的某一个商品
     * @param id
     * @return
     */
    public Boolean deleteFromCart(Integer id);

    public void buy(Integer cart_id,Integer goods_id, Integer num);
}
