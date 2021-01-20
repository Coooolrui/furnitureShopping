package com.Coolrui.dao;

import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.OrderGoods;
import com.Coolrui.pojo.Orders;

import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 14:21
 */
public interface IOrdersDao {
    /**
     * 添加订单
     * @param orders
     * @return
     */
    int insertOrder(Orders orders);

    /**
     * 通过快递单号查询订单id
     * @param express
     * @return
     */
    int queryOrderIdByExpress(String express);

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> queryAllOrders(Integer userid);

    /**
     * 查询订单状态 数量
     * @param userid
     * @param status
     * @return
     */
    int queryOrderStatusNum(int userid, int status);

    /**
     * 查询待评价订单的数量
     * @param userid
     * @return
     */
    int queryOrderIsAppraiseNum(int userid);

    /**
     * 查询订单的 总额 订单号 支付方式
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
