package com.example.store_server.Service.AdminService;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import com.example.store_server.dao.AdminMapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public User signIn(
            String account, String password
    ) {
        return adminMapper.signIn(account, password);
    }

    @Override
    public List<Customer> getAllCustomerInfo() {
        return adminMapper.getAllCustomerInfo();
    }

    @Override
    public List<Customer> getCustomerInfoById(
            Integer id
    ) {
        return adminMapper.getCustomerInfoById(id);
    }

    @Override
    public List<Customer> getCustomerInfoByName(
            String Customername
    ) {
        return adminMapper.getCustomerInfoByName(Customername);
    }

    @Override
    public Boolean deleteCustomerById(Integer id) {
        return adminMapper.deleteCustomerById(id);
    }

    @Override
    public Boolean resetPassword(String account) {
        return adminMapper.resetPassword(account);
    }

    @Override
    public Boolean resetAdminPassword(String account, String password) {
        return adminMapper.resetAdminPassword(account, password);
    }

    @Override
    public List<Goods> getAllGoods() {
        return adminMapper.getAllGoods();
    }

    @Override
    public List<Goods> getGoodsById(Integer id) {
        return adminMapper.getGoodsById(id);
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        return adminMapper.getGoodsByName(name);
    }

    @Override
    public void addGoods(Goods goods) {
        adminMapper.addGoods(goods);
    }

    @Override
    public void delGoods(Integer id) {
        adminMapper.delGoods(id);
    }

    @Override
    public void updGoods(Goods goods) {
        adminMapper.updGoods(goods);
    }
}
