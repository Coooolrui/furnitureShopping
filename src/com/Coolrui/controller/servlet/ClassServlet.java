package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IClassService;
import com.Coolrui.service.IGoodsService;
import com.Coolrui.service.imple.ClassServiceImpl;
import com.Coolrui.service.imple.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 11:59
 */
@WebServlet(urlPatterns = {"/class"})
public class ClassServlet extends HttpServlet {
    IClassService iClassService = new ClassServiceImpl();
    IGoodsService iGoodsService =new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "one":
                    doQueryOne(req, resp);
                    break;
                case "tow":
                    doQueryTow(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doQueryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parentId = req.getParameter("parentId");
        Class aClass = iClassService.showOneClassByOneId(Integer.valueOf(parentId));
        Map<String, List<Goods>> goodsMap = iGoodsService.getGoodsByClassOneId2Map(Integer.valueOf(parentId));
        req.setAttribute("oneClass", aClass);
        req.setAttribute("goodsMap", goodsMap);
        req.getRequestDispatcher("paint.jsp").forward(req, resp);
    }

    protected void doQueryTow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Class aClass1 = iClassService.showOneClassByOneId(Integer.valueOf(id.substring(0, 1)));
        Class aClass2 = iClassService.showTowClassByTowId(Integer.valueOf(id));
        List<Goods> towGoods = iGoodsService.getGoodsByClassTowId2List(Integer.valueOf(id));
        // 判断是否排序
        String sort = req.getParameter("sort");
        if (sort != null){
            switch (sort){
                case "new":
                    towGoods = iGoodsService.sortGoodsByDateDesc2List(towGoods);
                    req.setAttribute("select", "new");
                    break;
                case "sales1":
                    towGoods = iGoodsService.sortGoodsBySales2List(towGoods, 1);
                    req.setAttribute("select", "sales1");
                    break;
                case "sales0":
                    towGoods = iGoodsService.sortGoodsBySales2List(towGoods, 0);
                    req.setAttribute("select", "sales0");
                    break;
                case "price1":
                    towGoods = iGoodsService.sortGoodsByPrice2List(towGoods, 1);
                    req.setAttribute("select", "price1");
                    break;
                case "price0":
                    towGoods = iGoodsService.sortGoodsByPrice2List(towGoods, 0);
                    req.setAttribute("select", "price0");
                    break;
            }
        }

        req.setAttribute("classOne", aClass1);
        req.setAttribute("classTow", aClass2);
        req.setAttribute("towGoods", towGoods);
        req.getRequestDispatcher("proList.jsp").forward(req, resp);
    }
}
