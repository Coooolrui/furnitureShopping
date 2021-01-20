package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IOrderGoodsDao;
import com.Coolrui.pojo.OrderGoods;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 20:40
 */
public class OrderGoodsDaoImpl implements IOrderGoodsDao {
    @Override
    public int addOrderGoodsItem(OrderGoods orderGoods) {
        String sql = "INSERT INTO jj_order_goods (orderId, goodsId, goodsNum, goodsPrice, goodsName, goodsImg) VALUE (?, ?, ?, ?, ?, ?)";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, orderGoods.getOrderId());
            pstat.setInt(2, orderGoods.getGoodsId());
            pstat.setInt(3, orderGoods.getGoodsNum());
            pstat.setBigDecimal(4, orderGoods.getGoodsPrice());
            pstat.setString(5, orderGoods.getGoodsName());
            pstat.setString(6, orderGoods.getGoodsImg());
        });
    }
}
