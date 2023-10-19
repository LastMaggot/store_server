package com.example.store_server.dao.OrderMapper;

import com.example.store_server.Pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select id, user_id, goods_id, num, price, create_time from " +
            "`order`where user_id = #{user_id}")
    List<Order> getOrders(@Param("user_id") Integer user_id);

    @Insert("insert into `order`(user_id, goods_id, num, price) VALUES " +
            "(#{user_id},#{goods_id},#{num},#{price})")
    Boolean createOrder(@Param("user_id") Integer user_id,
            @Param("goods_id") Integer goods_id,@Param("num") Integer num,
            @Param("price") Integer price);

    @Update("update user set totalSpent = #{totalSpent} where id = #{id}")
    Boolean buy(@Param("totalSpent") Double totalSpent,
            @Param("id") Integer user_id);
}
