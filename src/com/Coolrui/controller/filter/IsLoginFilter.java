package com.Coolrui.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 22:08
 */
public class IsLoginFilter implements Filter {
    public static String defaultUrl;
    // 不拦截的资源类型
    private static String[] ignoreTypes;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
//        System.out.println(url);
        boolean isIgnoreType = false;
        if(ignoreTypes != null){
            for (int i = 0; i < ignoreTypes.length; i++) {
                if (url.endsWith("." + ignoreTypes[i])) {
                    isIgnoreType = true;
                    break;
                }
            }
        }else{
            chain.doFilter(request, response);
        }

        if(url.indexOf("/search") > -1 || url.equals("/") || url.indexOf("/login.jsp") > -1||url.indexOf("/index.jsp") > -1||url.indexOf("/reg.jsp") > -1||
                url.indexOf("/class") > -1||url.indexOf("/logReg")>-1||url.indexOf("/goods")>-1 ||
                url.indexOf("/forget.jsp") > -1 ||isIgnoreType==true){
//            System.out.println(url+"这是登录入口或者静态资源，放行");
            chain.doFilter(request, response);
        }else{
//            String name = (String)request.getSession().getAttribute("UserName");
            boolean flag = false;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userid")) {
                    flag = true;
                }
            }
            if(flag == false){
                response.sendRedirect(contextPath+"/login.jsp");
            }else{
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        defaultUrl = filterConfig.getInitParameter("defaultUrl");
        String ignoreTypes = filterConfig.getInitParameter("ignoreTypes");
        if(ignoreTypes != null && !ignoreTypes.trim().equals("")){
            this.ignoreTypes = ignoreTypes.split(",");
        }
    }
}
