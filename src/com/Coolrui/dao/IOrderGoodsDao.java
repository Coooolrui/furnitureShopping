package com.Coolrui.dao;

import com.Coolrui.pojo.OrderGoods;

import java.math.BigDecimal;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 20:38
 */
public interface IOrderGoodsDao {
    /**
     * 添加商品
     * @param orderGoods
     * @return
     */
    int addOrderGoodsItem(OrderGoods orderGoods);
}
