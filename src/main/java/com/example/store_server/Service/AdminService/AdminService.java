package com.example.store_server.Service.AdminService;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.Pojo.Customer;
import com.example.store_server.Pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    /**
     * 登入
     * @param account
     * @param password
     * @return
     */
    public User signIn(String account, String password);

    /**
     * 获取所有用户信息
     * @return
     */
    public List<Customer> getAllCustomerInfo();

    /**
     * 通过id获取用户信息
     * @return
     */
    public List<Customer> getCustomerInfoById(Integer id);

    /**
     * 用户名模糊匹配获取用户信息
     * @return
     */
    public List<Customer> getCustomerInfoByName(String Customername);

    /**
     * 通过id 删除用户信息
     * @param id
     * @return
     */
    public Boolean deleteCustomerById(Integer id);

    /**
     * 管理员通过账号重置用户密码 password123456
     * @param account
     * @return
     */
    public Boolean resetPassword(String account);

    /**
     * 管理员重置自己的密码
     * @param password
     * @return
     */
    public Boolean resetAdminPassword(String account,String password);

    /**
     * 获取所有商品
     * @return
     */
    public List<Goods> getAllGoods();

    /**
     * 获取id 商品
     * @param id
     * @return
     */
    public List<Goods> getGoodsById(Integer id);

    /**
     * 通过name获取商品
     * @param name
     * @return
     */
    public List<Goods> getGoodsByName(String name);

    /**
     * 添加商品
     * @param goods
     */
    public void addGoods(Goods goods);

    /**
     * 通过id删除商品
     * @param id
     */
    public void delGoods(Integer id);

    /**
     * 修改商品信息
     * @param goods
     */
    public void updGoods(Goods goods);
}
