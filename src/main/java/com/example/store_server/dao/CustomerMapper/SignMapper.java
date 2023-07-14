package com.example.store_server.dao.CustomerMapper;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import com.example.store_server.Util.CustomerLevelTypeHandler;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SignMapper {

    @Insert("insert into user (account, password, username, registrationDate, email) VALUES (#{account},#{password},#{username},NOW(),#{email});")
    public Integer signUp(
            @Param("account") String account,
            @Param("password") String password,
            @Param("username") String username, @Param("email") String email
    );


    @Select("select id, account, username, level, registrationDate, " +
            "totalSpent, email from user where user.account = #{account} and user" +
            ".password = #{password};")
    public Customer signIn(
            @Param("account") String account, @Param("password") String password
    );
}
