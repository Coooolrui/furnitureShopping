package com.Coolrui.controller.servlet;

import com.Coolrui.dao.IAddressDao;
import com.Coolrui.pojo.*;
import com.Coolrui.service.*;
import com.Coolrui.service.imple.*;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 15:29
 */
@WebServlet("/order")
public class OrdersServlet extends HttpServlet {
    IAddressService iAddressService = new AddressServiceImpl();
    IPaymentsService iPaymentsService = new PaymentsServiceImpl();
    ITransportSrevice iTransportSrevice = new TransportServiceImpl();
    ICartsService iCartsService = new CartsServiceImpl();
    IOrdersService iOrdersService = new OrdersServiceImpl();
    IOrderGoodsService iOrderGoodsService = new OrderGoodsServiceImpl();
    IGoodsService iGoodsService = new GoodsServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "show":
                    ShowMessage(req, resp);
                    break;
                case "add":
                    addOrder(req, resp);
                    break;
                case "queryAll":
                    doQueryAllOrder(req, resp);
                    break;
                case "xq":
                    doGetOrderXQ(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    private void doGetOrderXQ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exp = req.getParameter("exp");
        Orders orderXq = iOrdersService.queryMoneyExpPayway(exp);
        Address address = iOrdersService.queryAddress(exp);
        List<OrderGoods> orderGoods = iOrdersService.queryGoods(exp);
        req.setAttribute("order", orderXq);
        req.setAttribute("address", address);
        req.setAttribute("goods", orderGoods);

        req.getRequestDispatcher("orderxq.jsp").forward(req, resp);
    }

    /**
     * 查询所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doQueryAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                Map<Integer, List<Orders>> orders = iOrdersService.getOrderGroupByOrderId(Integer.valueOf(cookie.getValue()));
                req.setAttribute("orders", orders);
                req.getRequestDispatcher("myorderq.jsp").forward(req, resp);
            }
        }
    }

    /**
     * 添加订单
     * @param req
     * @param resp
     * @throws IOException
     */
    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String addrId = req.getParameter("addr");
        String payId = req.getParameter("pay");
        String tranId = req.getParameter("tran");
        String money = req.getParameter("money");
        String goods = req.getParameter("goods");
        //快递单号
        String express = iOrdersService.makExpress();
        //商品详细信息
        String[] goodss = goods.substring(0, goods.length() - 1).split(",");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                Orders orders = new Orders(Integer.valueOf(cookie.getValue()),
                        1, new BigDecimal(money), Integer.valueOf(payId),
                        Integer.valueOf(tranId),
                        Integer.valueOf(addrId), express);
                //插入订单
                int i = iOrdersService.insertOrder(orders);
                System.out.println(orders);
//                //删除购物车中已经选中的商品
                iCartsService.deleteAllChecked(Integer.valueOf(cookie.getValue()));

//                //添加订单对应的商品、
                int orderId = iOrdersService.getOrderIdByExpress(express);
                for (String s : goodss) {
                    String[] split = s.split("-");
                    iOrderGoodsService.addOrderGoodsItem(new OrderGoods(orderId,
                            Integer.valueOf(split[0]),
                            Integer.valueOf(split[1]),
                            new BigDecimal(split[2]),
                            split[3],
                            split[4]));
                }
                resp.getWriter().write(""+i);
            }
        }
    }

    /**
     * 展示支付页面信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void ShowMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                List<Address> address = iAddressService.getAllAddressByUserId(Integer.valueOf(cookie.getValue()), 1);
                //默认收货地址
                List<Address> address2 = iAddressService.getAllAddressByUserId(Integer.valueOf(cookie.getValue()), 0);
                if (address2.size() > 0 ){
                    Address defaultAddress = address2.get(0);
                    req.setAttribute("defaultAddress", defaultAddress);
                }
                //支付方式查询
                List<Payments> payments = iPaymentsService.getAllPayments();
                //运输方式
                List<Transports> transports = iTransportSrevice.getAllTransports();

                List<Carts> checked = new ArrayList<>();
                //判断换时候是立即购买
                String instant = req.getParameter("instant");
                if (instant != null){
                    String num = req.getParameter("num");
                    Goods good = iGoodsService.getGoodsByGid(Integer.valueOf(instant));
                    Carts carts = new Carts();
                    carts.setCartNum(Integer.valueOf(num));
                    carts.setGoods(new Goods(good.getId(), good.getName(), good.getImgs(), good.getPrice()));
                    checked.add(carts);
                }else {
                    //显示选中的商品
                    checked = iCartsService.getAllChecked(Integer.valueOf(cookie.getValue()));
                }
                req.setAttribute("address", address);
                req.setAttribute("payments", payments);
                req.setAttribute("transports", transports);
                req.setAttribute("checked", checked);
            }
        }
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
