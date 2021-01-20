package com.Coolrui.service;

import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.OrderGoods;
import com.Coolrui.pojo.Orders;

import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 19:28
 */
public interface IOrdersService {
    /**
     * 添加订单
     * @param orders
     * @return
     */
    int insertOrder(Orders orders);

    /**
     * 生成16位运单号
     * @return
     */
    String makExpress();

    /**
     * 通过运单号得到订单id
     * @param express
     * @return
     */
    int getOrderIdByExpress(String express);

    /**
     * 通过用户id得到订单
     * @param userid
     * @return
     */
    Map<Integer, List<Orders>> getOrderGroupByOrderId(Integer userid);

    /**
     * 待支付 0
     * 待收货 1
     * 已收货 2
     * 已关闭 3
     */
    /**
     * 得到待支付的数量
     * @return
     */
    int getNoPayNum(int userid);

    /**
     * 得到待收货的数量
     * @return
     */
    int getNoReceiveNum(int userid);

    /**
     * 得到未评价的数量
     * @param userid
     * @return
     */
    int getWeiAppressNum(int userid);

    /**
     * 得到订单详情
     * @param exp
     * @return
     */
    Orders queryMoneyExpPayway(String exp);

    /**
     * 查询订单的 收货的地址
     * @param exp
     * @return
     */
    Address queryAddress(String exp);

    /**
     * 通过订单查询商品信息
     * @param exp
     * @return
     */
    List<OrderGoods> queryGoods(String exp);
}
