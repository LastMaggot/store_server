package com.example.store_server.dao.GoodsMapper;

import com.example.store_server.Pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where goods.id = #{id}")
    Goods getById(@Param("id") Integer id);

    @Select("SELECT * FROM goods WHERE goods.name LIKE CONCAT('%', #{name}, '%')")
    List<Goods> getByName(@Param("name") String name);

    @Insert("INSERT INTO goods (name, manufacturer, pictureUrl, version, " +
            "description, publishingHouse, purchaseCost, retailPrice) VALUES (#{goods.name}, #{goods.manufacturer}, #{goods.pictureUrl}, #{goods.version}, #{goods.description}, #{goods.publishingHouse}, #{goods.purchaseCost}, #{goods.retailPrice})")
    Integer addGoods(@Param("goods") Goods goods);

    @Delete("delete from goods where goods.id = #{id}")
    void delGoods(@Param("id") Integer goods_id);

    @Update("UPDATE goods SET goods.name = #{goods.name}, goods.manufacturer = #{goods.manufacturer}, " +
            "goods.pictureUrl = #{goods.pictureUrl}, goods.version = #{goods.version}, " +
            "goods.publishingHouse = #{goods.publishingHouse}, goods.description = #{goods.description}, " +
            "goods.retailPrice = #{goods.retailPrice}, goods.purchaseCost = " +
            "#{goods.purchaseCost}, goods.inventory = #{goods.inventory}")
    void updGoods(@Param("goods") Goods goods);
}
