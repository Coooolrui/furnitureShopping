package com.Coolrui.service.imple;

import com.Coolrui.dao.IOrdersDao;
import com.Coolrui.dao.imple.OrdersDaoImpl;
import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.OrderGoods;
import com.Coolrui.pojo.Orders;
import com.Coolrui.service.IOrdersService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 19:29
 */
public class OrdersServiceImpl implements IOrdersService {
    IOrdersDao iOrdersDao = new OrdersDaoImpl();
    @Override
    public int insertOrder(Orders orders) {
        return iOrdersDao.insertOrder(orders);
    }

    @Override
    public String makExpress() {
        //随机生成一位整数
        int random = (int) (Math.random()*9+1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if(hashCode<0){
            hashCode = -hashCode;
        }
        String value = valueOf + String.format("%015d", hashCode);
        return value;
    }

    @Override
    public int getOrderIdByExpress(String express) {
        return iOrdersDao.queryOrderIdByExpress(express);
    }

    @Override
    public Map<Integer, List<Orders>> getOrderGroupByOrderId(Integer userid) {
        List<Orders> ordersList = iOrdersDao.queryAllOrders(userid);
        Map<Integer, List<Orders>> collect = ordersList.stream().collect(Collectors.groupingBy(orders -> orders.getId(), Collectors.toList()));
        TreeMap<Integer, List<Orders>> treeMapCollect= new TreeMap<>(collect);
//        treeMapCollect.s
        return collect;
    }

    @Override
    public int getNoPayNum(int userid) {
        return iOrdersDao.queryOrderStatusNum(userid, 0);
    }

    @Override
    public int getNoReceiveNum(int userid) {
        return iOrdersDao.queryOrderStatusNum(userid, 1);
    }

    @Override
    public int getWeiAppressNum(int userid) {
        return iOrdersDao.queryOrderIsAppraiseNum(userid);
    }

    @Override
    public Orders queryMoneyExpPayway(String exp) {
        return iOrdersDao.queryMoneyExpPayway(exp);
    }

    @Override
    public Address queryAddress(String exp) {
        return iOrdersDao.queryAddress(exp);
    }

    @Override
    public List<OrderGoods> queryGoods(String exp) {
        return iOrdersDao.queryGoods(exp);
    }

    public static void main(String[] args) {
        System.out.println(new OrdersServiceImpl().queryGoods("7000000086666150"));
    }
}
