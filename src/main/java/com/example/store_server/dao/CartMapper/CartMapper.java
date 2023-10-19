package com.example.store_server.dao.CartMapper;

import com.example.store_server.Pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select goods.id, name, manufacturer, pictureUrl, version, " +
            "description, publishingHouse, purchaseCost, retailPrice from user_goods join goods on user_goods.goods_id = " +
            "goods.id where user_id = #{user_id};")
    public List<Goods> getCartGoods(@Param("user_id") Integer user_id);

    @Insert("insert into user_goods (user_id, goods_id, nums) VALUES " +
            "(#{user_id},#{goods_id},#{nums})")
    public Integer addToCart(@Param("user_id") Integer user_id,
            @Param("goods_id") Integer goods_id,@Param("nums") Integer nums);

    @Delete("delete from user_goods where user_goods.id = #{id}")
    public void deleteFromCart(@Param("id") Integer id );

    @Update("update goods set inventory = inventory - #{num} where id = " +
            "#{goods_id}")
    public void deleteGoodsInventory(@Param("goods_id") Integer goods_id,
            @Param("num") Integer num );
}
