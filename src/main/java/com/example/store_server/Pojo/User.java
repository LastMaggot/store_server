package com.example.store_server.Pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private Integer id;
    private String account;
    private String userName;
    private String password;
    private CustomerLevel level;
    private Date registrationDate;
    private Double totalSpent;
    private String phoneNumber;
    private String email;

    public User(Integer id, String account, String userName, String password, CustomerLevel level, Date registrationDate, Double totalSpent, String phoneNumber, String email) {
        this.id = id;
        this.account = account;
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.registrationDate = registrationDate;
        this.totalSpent = totalSpent;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
