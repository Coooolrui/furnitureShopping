package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.dao.IOrdersDao;
import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.OrderGoods;
import com.Coolrui.pojo.Orders;
import com.Coolrui.pojo.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 14:21
 */
public class OrdersDaoImpl implements IOrdersDao {
    @Override
    public int insertOrder(Orders orders) {
        String sql = "INSERT INTO jj_orders(userid, status, money, paymentId, transportId, addressId, isAppraise, expressNo, createTime) VALUE (?, ?, ?, ?, ?, ?, 0, ?, NOW())";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setInt(1, orders.getUserId());
            pstat.setInt(2, orders.getStatus());
            pstat.setBigDecimal(3, orders.getMoney());
            pstat.setInt(4, orders.getPaymentId());
            pstat.setInt(5, orders.getTransportId());
            pstat.setInt(6, orders.getAddressId());
            pstat.setString(7, orders.getExpressNo());
        });
    }

    @Override
    public int queryOrderIdByExpress(String express) {
        String sql = "SELECT id FROM jj_orders WHERE expressNo = ?";
        Orders orders = new Orders();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, express);
        }, rs -> {
            if (rs.next()) {
                orders.setId(rs.getInt(1));
            }
        });
        return orders.getId();
    }

    @Override
    public List<Orders> queryAllOrders(Integer userid) {
        String sql = "SELECT o.id, o.status, o.money, o.expressNo, o.createTime, o.`isAppraise`, a.`userName`, og.`goodsNum`, og.`goodsPrice`,og.`goodsName`, og.`goodsImg`\n" +
                "FROM `jj_orders` o INNER JOIN jj_order_goods og ON o.`Id` = og.`orderId` INNER JOIN jj_address a ON o.`addressId` = a.`Id` WHERE a.`userId` = ? ORDER BY o.`createTime` DESC";

        List<Orders> ordersList = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            while (rs.next()) {
                ordersList.add(new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getBigDecimal(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getString(7),
                        new OrderGoods(rs.getInt(8),
                                rs.getBigDecimal(9),
                                rs.getString(10),
                                rs.getString(11))));
            }
        });
        return ordersList;
    }

    @Override
    public int queryOrderStatusNum(int userid, int status) {
        String sql = "SELECT count(STATUS) FROM jj_orders WHERE STATUS = ? AND userid = ?";
        Orders orders = new Orders();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, status);
            pstat.setInt(2, userid);
        }, rs -> {
            if (rs.next()) {
                orders.setStatus(rs.getInt(1));
            }
        });
        return orders.getStatus();
    }

    @Override
    public int queryOrderIsAppraiseNum(int userid) {
        String sql = "SELECT count(isAppraise) FROM jj_orders WHERE isAppraise = 0 AND userid = ?";
        Orders orders = new Orders();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            if (rs.next()) {
                orders.setIsAppraise(rs.getInt(1));
            }
        });
        return orders.getIsAppraise();
    }

    @Override
    public Address queryAddress(String exp) {
        String sql = "SELECT a.`userName`, a.`userPhone`, a.`userAddress`,\n" +
                "b.`NAME`, c.`NAME`, d.`NAME`, e.`NAME` FROM jj_address a \n" +
                "INNER JOIN cn_region b ON a.`provinceid` = b.`ID` \n" +
                "INNER JOIN cn_region c ON a.`cityid` = c.`ID` \n" +
                "INNER JOIN cn_region d ON a.`areaId` = d.`ID`\n" +
                "INNER JOIN cn_region e ON a.`streetId` = e.`ID`\n" +
                "INNER JOIN jj_orders o ON o.`userId` = a.`userId`\n" +
                "WHERE o.`expressNo` = ?";
        Address address = new Address();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, exp);
        }, rs -> {
            if (rs.next()) {
                Region pro = new Region();
                pro.setName(rs.getString(4));
                Region city = new Region();
                city.setName(rs.getString(5));
                Region area = new Region();
                area.setName(rs.getString(6));
                Region street = new Region();
                street.setName(rs.getString(7));
                address.setUserName(rs.getString(1));
                address.setUserPhone(rs.getString(2));
                address.setUserAddress(rs.getString(3));
                address.setProvince(pro);
                address.setCity(city);
                address.setArea(area);
                address.setStreet(street);
            }
        });
        return address;
    }

    @Override
    public List<OrderGoods> queryGoods(String exp) {
        String sql = "SELECT o1.`goodsId`, o1.`goodsNum`, o1.`goodsPrice`, o1.`goodsName`, o1.`goodsImg` FROM jj_order_goods o1\n" +
                "INNER JOIN jj_orders o2 ON o1.`orderId` = o2.`Id` WHERE o2.`expressNo` = ?";

        List<OrderGoods> list = new ArrayList<>();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, exp);
        }, rs -> {
            while (rs.next()) {
                list.add(new OrderGoods(rs.getInt(1),
                        rs.getInt(2),
                        rs.getBigDecimal(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        });
        return list;
    }

    @Override
    public Orders queryMoneyExpPayway(String exp) {
        String sql = "SELECT money, expressNo, paymentId, STATUS FROM jj_orders WHERE expressNo = ?";
        Orders orders = new Orders();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setString(1, exp);
        }, rs -> {
            if (rs.next()) {
                orders.setMoney(rs.getBigDecimal(1));
                orders.setExpressNo(rs.getString(2));
                orders.setPaymentId(rs.getInt(3));
                orders.setStatus(rs.getInt(4));
            }
        });
        return orders;
    }


    public static void main(String[] args) {
        System.out.println(new OrdersDaoImpl().queryAddress("6000000507477761"));
    }
}
