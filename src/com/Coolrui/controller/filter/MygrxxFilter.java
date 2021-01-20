package com.Coolrui.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author MaRuiYa
 * @Date 2021/1/6 15:35
 */
@WebFilter(value = "/mygrxx.jsp")
public class MygrxxFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getRequestDispatcher("users?opt=profile").forward(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
