package com.example.store_server.Service.GoodsService;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.dao.GoodsMapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {

    /**
     * 获取所有商品信息
     * @return
     */
    public List<Goods> getAllGoods();

    /**
     * 根据商品id获取商品信息
     * @return
     */
    public Goods getById(Integer goods_id);

    /**
     * 根据商品名，获取商品信息
     * @return
     */
    public List<Goods> getByName(String name);

    /**
     * 向数据库中添加商品
     * @return
     */
    public Boolean addGoods(Goods goods);

    /**
     * 删除商品信息
     * @return
     */
    public Boolean delGoods(Integer goods_id);

    /**
     * 修改商品信息
     * @return
     */
    public Boolean updGoods(Goods goods);
}
