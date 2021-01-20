package com.Coolrui.controller.filter;

import com.Coolrui.pojo.Class;
import com.Coolrui.pojo.Goods;
import com.Coolrui.service.ICartsService;
import com.Coolrui.service.IClassService;
import com.Coolrui.service.imple.CartsServiceImpl;
import com.Coolrui.service.imple.ClassServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author MaRuiYa
 * @Date 2021/1/7 15:29
 */
@WebFilter(urlPatterns = {"/head.jsp", "/head2.jsp"}, dispatcherTypes = {
        DispatcherType.INCLUDE
})
public class HeadFilter implements Filter {
    IClassService iClassService = new ClassServiceImpl();
    ICartsService iCartsService = new CartsServiceImpl();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, List<Class>> stringListMap = iClassService.showClass();
        List<Goods> goodsList = iClassService.showMainClass();

        boolean flag = false;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("userid")) {
                //查询购物车中的的数量
                int i = iCartsService.showCartsNum(Integer.valueOf(cookie.getValue()));
                servletRequest.setAttribute("cartNum", i);
                flag = true;
                break;
            }
        }
        if (!flag){
            servletRequest.setAttribute("cartNum", 0);
        }

        servletRequest.setAttribute("goodsMain", goodsList);
        servletRequest.setAttribute("classMap", stringListMap);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
