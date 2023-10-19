package com.example.store_server.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Order {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("user_id")
    private Integer user_id;
    @JsonProperty("goods_id")
    private Integer goods_id;
    @JsonProperty("num")
    private Integer num;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("create_time")
    private Timestamp create_time;

    public Order() {
    }

    public Order(
            Integer id, Integer user_id, Integer goods_id, Integer num,
            Integer price,
            Timestamp create_time
    ) {
        this.id = id;
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.num = num;
        this.price = price;
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", num=" + num +
                ", price=" + price +
                ", create_time=" + create_time +
                '}';
    }
}
