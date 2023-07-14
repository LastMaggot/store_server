package com.example.store_server.Pojo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class User {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("account")
    private String account;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public User() {
    }

    public User(Integer id, String account, String userName, String password) {
        this.id = id;
        this.account = account;
        this.username = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id == ((User) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password);
    }
}
