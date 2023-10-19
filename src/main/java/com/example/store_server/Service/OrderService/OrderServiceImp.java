package com.example.store_server.Service.OrderService;

import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.Order;
import com.example.store_server.dao.AdminMapper.AdminMapper;
import com.example.store_server.dao.OrderMapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Order> getOrders(
            Integer user_id
    ) {
        return orderMapper.getOrders(user_id);
    }

    @Override
    public Boolean createOrder(
            Integer user_id, Integer goods_id, Integer num, Integer price
    ) {
        List<Customer> customerList = adminMapper.getCustomerInfoById(user_id);
        Customer customer = customerList.get(0);
        Double totalSpent = customer.getTotalSpent() + price;
        orderMapper.buy(totalSpent,user_id);
        return orderMapper.createOrder(user_id, goods_id, num, price);
    }
}
