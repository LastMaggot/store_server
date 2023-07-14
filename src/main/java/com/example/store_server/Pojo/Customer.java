package com.example.store_server.Pojo;
import java.sql.Date;

public class Customer extends User {
    private CustomerLevel level;
    private Date registrationDate;
    private Double totalSpent;
    private String phoneNumber;
    private String email;

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

    @Override
    public String toString() {
        return "Customer{" +
                "level=" + level +
                ", registrationDate=" + registrationDate +
                ", totalSpent=" + totalSpent +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer(Integer id, String account, String userName, String password, CustomerLevel level, Date registrationDate, Double totalSpent, String phoneNumber, String email) {
        super(id, account, userName, password);
        this.level = level;
        this.registrationDate = registrationDate;
        this.totalSpent = totalSpent;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
