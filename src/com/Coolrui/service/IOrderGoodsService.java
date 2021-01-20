package com.Coolrui.service;

import com.Coolrui.pojo.OrderGoods;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 20:45
 */
public interface IOrderGoodsService {
    /**
     * 添加商品
     * @param orderGoods
     * @return
     */
    int addOrderGoodsItem(OrderGoods orderGoods);
}
