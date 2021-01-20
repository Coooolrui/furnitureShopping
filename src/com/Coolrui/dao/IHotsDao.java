package com.Coolrui.dao;

import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 11:28
 */
public interface IHotsDao {
    /**
     * 查询所有的精品商品
     * @return
     */
    List<Goods> queryAllHots();

    List<Goods> queryAll();
}
