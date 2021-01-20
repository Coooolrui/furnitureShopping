package com.Coolrui.service;

import com.Coolrui.pojo.Goods;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 11:38
 */
public interface IHotsService {
    /**
     * 展示指定个数的精品商品
     * @param num
     * @return
     */
    List<Goods> showHotsByNum(int num);
}
