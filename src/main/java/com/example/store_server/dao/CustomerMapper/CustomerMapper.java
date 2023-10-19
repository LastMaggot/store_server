package com.example.store_server.dao.CustomerMapper;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CustomerMapper {

    @Insert("insert into user (account, password, username, registrationDate, email) VALUES (#{account},#{password},#{username},NOW(),#{email});")
    public Integer signUp(
            @Param("account") String account,
            @Param("password") String password,
            @Param("username") String username, @Param("email") String email
    );

    @Select("select id, account, address ,username, level, registrationDate, " +
            "totalSpent, email from user where user.account = #{account} and user" +
            ".password = #{password};")
    public Customer signIn(
            @Param("account") String account, @Param("password") String password
    );

    @Update("update user set token = #{token} where user.account = #{account}")
    public Boolean updateToken(@Param("token") String token,
            @Param("account") String account);

    @Update("update user set password = #{password} where user.id = #{id}")
    public Boolean resetPassword(@Param("password") String password,
            @Param("id") Integer id);

    @Update("update user set password = #{mailcode} where account = " +
            "#{account} and email = #{email}")
    public Boolean updateMailCode(@Param("mailcode") String mailcode, @Param(
            "account") String account,@Param("email") String email);

    @Select("select id, account, username, address, level, registrationDate, " +
            "totalSpent, email from user where user.token = #{token}")
    public Customer loginByToken(@Param("token") String token);

    @Update("update user SET " +
            "    account = #{account}, " +
            "    password = #{password}, " +
            "    username = #{username}, " +
            "    address = #{address}, " +
            "    email = #{email} " +
            "where id = #{id} " )
    public Boolean updateUserInfo(@Param("id") Integer id,
            @Param("account") String account,
            @Param("password") String password,
            @Param("username") String username,
            @Param("address") String address,
            @Param("email") String email);

}
