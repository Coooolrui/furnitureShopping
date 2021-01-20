package com.Coolrui.dao;

import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 21:03
 */
public interface ISearchDao {
    List<Goods> search(String key);
}
