package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IGoodsService;
import com.Coolrui.service.imple.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author MaRuiYa
 * @Date 2021/1/10 21:37
 */
@WebServlet("/ok")
public class OKServlet extends HttpServlet {
    IGoodsService iGoodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("goodsId");
        System.out.println(goodsId);
        List<String> goodsList = Arrays.asList(goodsId.substring(0, goodsId.length() - 1).split(","));
        List<Integer> collect = goodsList.stream().map(goods -> Integer.valueOf(goods)).collect(Collectors.toList());
        List<Integer> oneClassId = iGoodsService.getGoodsOneIdByGoodsId(collect);

        //猜你喜欢的商品
        List<Goods> list = iGoodsService.getShuffleGoods2List(oneClassId, 5 * 2);

        req.setAttribute("guessLike", list);
        req.getRequestDispatcher("ok.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
