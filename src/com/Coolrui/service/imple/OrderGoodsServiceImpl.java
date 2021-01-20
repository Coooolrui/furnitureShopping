package com.Coolrui.service.imple;

import com.Coolrui.dao.IOrderGoodsDao;
import com.Coolrui.dao.imple.OrderGoodsDaoImpl;
import com.Coolrui.pojo.OrderGoods;
import com.Coolrui.service.IOrderGoodsService;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 20:46
 */
public class OrderGoodsServiceImpl implements IOrderGoodsService {
    IOrderGoodsDao iOrderGoodsDao = new OrderGoodsDaoImpl();
    @Override
    public int addOrderGoodsItem(OrderGoods orderGoods) {
        return iOrderGoodsDao.addOrderGoodsItem(orderGoods);
    }
}
