package com.example.store_server.dao.AdminMapper;

import com.example.store_server.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminGetMapper {
    @Select("select id, account, username, level, registrationDate, totalSpent, email from user")
    List<User> getUsers();
}
