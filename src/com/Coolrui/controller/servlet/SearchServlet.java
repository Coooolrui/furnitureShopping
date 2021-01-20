package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Goods;
import com.Coolrui.service.ISearchService;
import com.Coolrui.service.imple.SearchServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 20:29
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    ISearchService iSearchService = new SearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        List<Goods> search = iSearchService.search(key);
        req.setAttribute("search", search);
        req.setAttribute("key", key);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
