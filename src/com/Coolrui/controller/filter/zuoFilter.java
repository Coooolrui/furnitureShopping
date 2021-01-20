package com.Coolrui.controller.filter;

import com.Coolrui.pojo.Users;
import com.Coolrui.service.IUsersService;
import com.Coolrui.service.imple.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author MaRuiYa
 * @Date 2021/1/7 11:22
 */
@WebFilter(value = "/zuo.jsp", dispatcherTypes = {
        DispatcherType.INCLUDE,
        DispatcherType.REQUEST
})
public class zuoFilter implements Filter {
    IUsersService iUsersService = new UserServiceImpl();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        System.out.println(123456);
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("userid")) {
//                System.out.println(cookie.getValue());
                Users user = iUsersService.getPhotoNickname(Integer.valueOf(cookie.getValue()));
                request.setAttribute("phoneNick", user);
//                request.getRequestDispatcher("/zuo.jsp").forward(request, response);
                break;
            }
        }
        filterChain.doFilter(request, response);
    }
}
