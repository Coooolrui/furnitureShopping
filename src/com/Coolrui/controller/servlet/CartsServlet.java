package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Carts;
import com.Coolrui.service.ICartsService;
import com.Coolrui.service.imple.CartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 9:28
 */
@WebServlet("/carts")
public class CartsServlet extends HttpServlet {
    ICartsService iCartsService = new CartsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "changeNum":
                    doCartNum(req, resp);
                    break;
                case "queryAll":
                    doQueryAll(req, resp);
                    break;
                case "delete":
                    doDeleteOne(req, resp);
                    break;
                case "update":
                    doUpdateStatus(req, resp);
                    break;
                case "hasCheck":
                    doHasCheck(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 查询是否有选中的上平
     * @param req
     * @param resp
     */
    private void doHasCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println("进来了");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                List<Carts> allChecked = iCartsService.getAllChecked(Integer.valueOf(cookie.getValue()));
//                System.out.println("====size======="+allChecked.size());
                if (allChecked.size() == 0){
//                    System.out.println(123465);
                    resp.getWriter().write('0');
                }else {
                    resp.getWriter().write('1');
                }
            }
        }
    }

    private void doUpdateStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cartid = req.getParameter("cartid");
        int i = iCartsService.updateCartStatusByCarti(Integer.valueOf(cartid));
        resp.getWriter().write(i+"");
    }

    /**
     * 删除购物车中的商品
     * @param req
     * @param resp
     */
    private void doDeleteOne(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        iCartsService.deleteCartByCartIds(Arrays.asList(Integer.valueOf(id)));
    }

    /**
     * 查询所有购物车中的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doQueryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                List<Carts> carts = iCartsService.queryAllCartsByuserId(Integer.valueOf(cookie.getValue()));
                System.out.println(carts);
                req.setAttribute("carts", carts);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
            }
        }
    }

    /**
     * 改变购物车中的数量
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doCartNum(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num = req.getParameter("num");
        String goodsId = req.getParameter("goodsId");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                iCartsService.changeCartsOfGoods(Integer.valueOf(cookie.getValue()), Integer.valueOf(goodsId), Integer.valueOf(num));

                //查询购物车中的数量
                int i = iCartsService.showCartsNum(Integer.valueOf(cookie.getValue()));
//                System.out.println("cartservlet===="+i);
                resp.getWriter().write(i+"");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
