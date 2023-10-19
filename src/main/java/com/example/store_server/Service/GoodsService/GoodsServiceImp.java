package com.example.store_server.Service.GoodsService;

import com.example.store_server.Pojo.Goods;
import com.example.store_server.dao.GoodsMapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public Goods getById(Integer goods_id) {
        Goods goods = goodsMapper.getById(goods_id);
        return goods;
    }

    @Override
    public List<Goods> getByName(String name) {
        return goodsMapper.getByName(name);
    }

    @Override
    public Boolean addGoods(Goods goods) {
        try {
            return (goodsMapper.addGoods(goods) != null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delGoods(Integer goods_id) {
        try {
            goodsMapper.delGoods(goods_id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updGoods(Goods goods) {
        try {
            goodsMapper.updGoods(goods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
