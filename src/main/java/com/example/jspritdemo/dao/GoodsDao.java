package com.example.jspritdemo.dao;

import com.example.jspritdemo.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

    List<Goods> getAllGoods();
}
