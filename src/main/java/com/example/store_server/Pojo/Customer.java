package com.example.store_server.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Customer extends User {
    @JsonProperty("level")
    private CustomerLevel level;
    @JsonProperty("registrationDate")
    private Date registrationDate;
    @JsonProperty("totalSpent")
    private Double totalSpent;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerLevel getLevel() {
        return level;
    }

    public void setLevel(CustomerLevel level) {
        this.level = level;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isValid() {
        if(getAccount() == null) {
            return false;
        }
        if(getPassword() == null) {
            return false;
        }
        if(getEmail() == null) {
            return  false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "level=" + level +
                ", registrationDate=" + registrationDate +
                ", totalSpent=" + totalSpent +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer() {
    }

    public Customer(
            Integer id, String account, String userName, String password,
            CustomerLevel level,
            Date registrationDate,
            Double totalSpent,
            String phoneNumber,
            String address,
            String email
    ) {
        super(id, account, userName, password);
        this.level = level;
        this.registrationDate = registrationDate;
        this.totalSpent = totalSpent;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }
}
