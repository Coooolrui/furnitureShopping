package com.Coolrui.service;

import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 21:09
 */
public interface ISearchService {
    List<Goods> search(String key);
}
