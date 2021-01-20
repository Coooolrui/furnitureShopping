package com.Coolrui.controller.filter;

import com.Coolrui.pojo.Goods;
import com.Coolrui.service.IClassService;
import com.Coolrui.service.IGoodsService;
import com.Coolrui.service.IHotsService;
import com.Coolrui.service.imple.ClassServiceImpl;
import com.Coolrui.service.imple.GoodsServiceImpl;
import com.Coolrui.service.imple.HotsServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 16:14
 */
@WebFilter(urlPatterns = {"/index.jsp", "/"})
public class IndexFilter implements Filter {
    IClassService iClassService = new ClassServiceImpl();
    IGoodsService iGoodsService = new GoodsServiceImpl();
    IHotsService iHotsService = new HotsServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Integer> idsNum = iClassService.shuffleClassId(2);
        // 首页底部的商品展示，为了避免和上面两个分类冲突，采用几何的差集
        List<Integer> idsNum2 = iClassService.shuffleClassId(3);
        idsNum2.removeAll(idsNum);
        List<Integer> idsNum22 = idsNum2.subList(0, 1);
        Map<String, List<Goods>> shuffleGoods = iGoodsService.getShuffleGoods(idsNum, 6);
        Map<String, List<Goods>> shuffleGoods1 = iGoodsService.getShuffleGoods(idsNum22, 12);


        //精品展示
        List<Goods> hotsGoods = iHotsService.showHotsByNum(3);

        servletRequest.setAttribute("goods", shuffleGoods);
        servletRequest.setAttribute("goodsbottom", shuffleGoods1);
        servletRequest.setAttribute("hots", hotsGoods);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
