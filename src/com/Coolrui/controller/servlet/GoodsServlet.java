package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.ICartsService;
import com.Coolrui.service.IClassService;
import com.Coolrui.service.IGoodsService;
import com.Coolrui.service.imple.ClassServiceImpl;
import com.Coolrui.service.imple.GoodsServiceImpl;
import com.Coolrui.service.imple.CartsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/8 20:05
 */
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
    IGoodsService iGoodsService = new GoodsServiceImpl();
    IClassService iClassService = new ClassServiceImpl();
    ICartsService iCartsService = new CartsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("goodsId");
        Goods goods = iGoodsService.getGoodsByGid(Integer.valueOf(goodsId));
        Class oneClass = iClassService.showOneClassByOneId(goods.getClassId1());
        Class towClass = iClassService.showTowClassByTowId(goods.getClassId2());

        //猜你喜欢
        List<Goods> guessLike = iGoodsService.getShuffleGoods(goods.getClassId1(), 5 * 2);
        //向你推荐
        List<Goods> recommend = iGoodsService.getShuffleGoods2(goods.getClassId2(), 4);

//        //查询购物车中的的数量
//        int i = iCartsService.showCartsNum();
//        req.setAttribute("cartNum", i);

        req.setAttribute("goods", goods);
        req.setAttribute("oneClass", oneClass);
        req.setAttribute("towClass", towClass);
        req.setAttribute("guessLike", guessLike);
        req.setAttribute("recommend", recommend);
        req.getRequestDispatcher("proDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
