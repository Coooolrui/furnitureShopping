package com.Coolrui.controller.servlet;

import com.Coolrui.service.IUsersService;
import com.Coolrui.service.imple.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author MaRuiYa
 * @Date 2021/1/12 15:25
 */
@WebServlet("/logReg")
public class LoginRegisterServlet extends HttpServlet {
    IUsersService iUsersService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "login":
                    doLogin(req, resp);
                    break;
                case "exit":
                    doExit(req, resp);
                case "verifyEmail":
                    doVerifyEmail(req, resp);
                    break;
                case "register":
                    doRegister(req, resp);
                    break;
                case "authCode":
                    doSendAuthCode(req, resp);
                    break;
                case "authCode2":
                    doSendAuthCode2(req, resp);
                    break;
                case "authCodeIsTrue":
                    doAuthCodeIsTrue(req, resp);
                    break;
                case "update":
                    doUpdatePass(req, resp);
                    break;
            }
        }
    }

    /**
     * 更新密码
     * @param req
     * @param resp
     */
    private void doUpdatePass(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        int i = iUsersService.updatePassword(email, pass);
        resp.getWriter().write(i+"");
    }

    /**
     * 判断验证码是否正确
     * @param req
     * @param resp
     */
    private void doAuthCodeIsTrue(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String authCode = req.getParameter("authCode");
        if (authCode.equals(req.getSession().getAttribute("authcode"))) {
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }

    /**
     * 忘记密码发送邮箱
     * @param req
     * @param resp
     */
    private void doSendAuthCode2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        //如果为true 则不存在此用户
        if (iUsersService.verifyEmail(email)){
            System.out.println(123465);
            resp.getWriter().write('0');
        }else {
            //获得验证码
            String authCode = iUsersService.makeAuthCode();
            //发送验证码
            iUsersService.sendAuthCode(email, authCode);
            HttpSession session = req.getSession();
            session.setAttribute("authcode", authCode);
            session.setMaxInactiveInterval(60*5);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 退出
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doExit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
        resp.sendRedirect("index.jsp");
    }

    /**
     * 向用户邮箱发送验证码
     * @param req
     * @param resp
     */
    private void doSendAuthCode(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        //获得验证码
        String authCode = iUsersService.makeAuthCode();
        //发送验证码
        iUsersService.sendAuthCode(email, authCode);
        HttpSession session = req.getSession();
        session.setAttribute("authcode", authCode);
        session.setMaxInactiveInterval(60*5);
    }

    /**
     * 用户信息注册
     * @param req
     * @param resp
     */
    private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String authcode = req.getParameter("authcode");
//        System.out.println("session中的值："+req.getSession().getAttribute("authcode"));
//        System.out.println("输入的验证码为："+authcode);
        if (authcode.equals(req.getSession().getAttribute("authcode"))) {
            int res = iUsersService.registerUser(email, password);
            if (res == 1){
                req.getSession().removeAttribute("authcode");
                resp.getWriter().write("1");
            }else {
                resp.getWriter().write("0");
            }
        }else {
            resp.getWriter().write("0");
        }
    }

    /**
     * 用户登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int id = iUsersService.login(username, password);
        if (id != -1){
            Cookie cookie = new Cookie("userid", id+"");
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);
            iUsersService.updateLoginMessage(req.getRemoteAddr(), id);
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }

    /**
     * 验证邮箱是否唯一
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doVerifyEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (iUsersService.verifyEmail(email)) {
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
