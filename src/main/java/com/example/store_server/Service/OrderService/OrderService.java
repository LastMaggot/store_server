package com.example.store_server.Service.OrderService;

import com.example.store_server.Pojo.Order;
import com.example.store_server.dao.OrderMapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> getOrders(Integer user_id);

    Boolean createOrder(Integer user_id, Integer goods_id,Integer num,
            Integer price);
}
