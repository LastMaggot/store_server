package com.example.store_server.dao.AdminMapper;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    //登入
    @Select("select id, account, password from admin where account = " +
            "#{account} and password = #{password} ")
    User signIn(@Param("account") String account, @Param("password") String password);

    //用户管理
    @Select("select id, account, username, level, registrationDate, " +
            "totalSpent, email  from user")
    List<Customer> getAllCustomerInfo();

    @Select("select id, account, username, level, registrationDate, " +
            "totalSpent, email from user where id = #{id}")
    List<Customer> getCustomerInfoById(@Param("id") Integer id);

    @Select("select id, account, username, level, registrationDate, " +
            "totalSpent, email from user where username like CONCAT('%', " +
            "#{username}, '%')")
    List<Customer> getCustomerInfoByName(@Param("username") String username);

    @Delete("delete from user where id = #{id}")
    Boolean deleteCustomerById(@Param("id") Integer id);

    @Update("update user set password = 'password123456' where account = " +
            "#{account} ")
    Boolean resetPassword(@Param("account") String account);

    @Update("update admin set password = #{password} where account = " +
            "#{account}")
    Boolean resetAdminPassword(@Param("account") String account, @Param(
            "password") String password);

    //商品管理
    @Select("select id, name, manufacturer, pictureUrl, version, description, publishingHouse, purchaseCost, retailPrice from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where goods.id = #{id}")
    List<Goods> getGoodsById(@Param("id") Integer id);

    @Select("SELECT * FROM goods WHERE goods.name LIKE CONCAT('%', #{name}, '%')")
    List<Goods> getGoodsByName(@Param("name") String name);

    @Insert("INSERT INTO goods (name, manufacturer, pictureUrl, version, " +
            "description, publishingHouse, purchaseCost, retailPrice, inventory) " +
            "VALUES (#{goods.name}, #{goods.manufacturer}, #{goods" +
            ".pictureUrl}, #{goods.version}, #{goods.description}, #{goods" +
            ".publishingHouse}, #{goods.purchaseCost}, #{goods.retailPrice}, " +
            "#{goods.inventory})")
    void addGoods(@Param("goods") Goods goods);

    @Delete("delete from goods where goods.id = #{id}")
    void delGoods(@Param("id") Integer goods_id);

    @Update("UPDATE goods SET goods.name = #{goods.name}, goods.manufacturer = #{goods.manufacturer}, " +
            "goods.pictureUrl = #{goods.pictureUrl}, goods.version = #{goods.version}, " +
            "goods.publishingHouse = #{goods.publishingHouse}, goods.description = #{goods.description}, " +
            "goods.retailPrice = #{goods.retailPrice}, goods.purchaseCost = " +
            "#{goods.purchaseCost}, goods.inventory = #{goods.inventory} " +
            "where goods.id = #{goods.id}")
    void updGoods(@Param("goods") Goods goods);

}
