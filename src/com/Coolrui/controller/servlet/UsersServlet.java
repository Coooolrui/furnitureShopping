package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Users;
import com.Coolrui.service.IOrdersService;
import com.Coolrui.service.IUsersService;
import com.Coolrui.service.imple.OrdersServiceImpl;
import com.Coolrui.service.imple.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.UUID;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 20:51
 */
@WebServlet("/users")
@MultipartConfig
public class UsersServlet extends HttpServlet {
    IUsersService iUsersService = new UserServiceImpl();
    IOrdersService iOrdersService = new OrdersServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "profile":
                    doProfile(req, resp);
                    break;
                case "update":
                    doProfileUpdate(req, resp);
                    break;
                case "upArea":
                    doAreaUpdate(req, resp);
                    break;
                case "upload":
                    doUploadPhoto(req, resp);
                    break;
                case "verifyNick":
                    doverifyNick(req, resp);
                    break;
                case "verifyPhone":
                    doVerifyPhone(req, resp);
                    break;
                case "verifyEmail2":
                    doVerifyEmail2(req, resp);
                    break;
                case "modifyPassword":
                    doModifyPassword(req, resp);
                    break;
                case "myCenter":
                    doQueryMyCenter(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 我的中心显示
     * @param req
     * @param resp
     */
    private void doQueryMyCenter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(123456);
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                Users nickEmail = iUsersService.getNickEmail(Integer.valueOf(cookie.getValue()));
                req.setAttribute("nickEmail",nickEmail);
                int noPayNum = iOrdersService.getNoPayNum(Integer.valueOf(cookie.getValue()));
                int noReceiveNum = iOrdersService.getNoReceiveNum(Integer.valueOf(cookie.getValue()));
                int weiAppressNum = iOrdersService.getWeiAppressNum(Integer.valueOf(cookie.getValue()));
                System.out.println("weiAppressNum=="+weiAppressNum);
                req.setAttribute("noPayNum", noPayNum);
                req.setAttribute("noReceiveNum", noReceiveNum);
                req.setAttribute("weiAppressNum", weiAppressNum);
                req.getRequestDispatcher("mygxin.jsp").forward(req, resp);
            }
        }
    }

    /**
     * 修改密码
     * @param req
     * @param resp
     */
    private void doModifyPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String old = req.getParameter("old");
        String aNew = req.getParameter("new");
        String authCode = req.getParameter("authCode");

        //查找cookie id
        int id = -1;
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                id = Integer.valueOf(cookie.getValue());
                break;
            }
        }

        if (authCode.equals(req.getSession().getAttribute("authcode"))) {
            int res = iUsersService.modifyPassword(old, aNew, id);
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
     * 验证修改的邮箱是否可用
     * @param req
     * @param resp
     */
    private void doVerifyEmail2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                if (iUsersService.verifyEmail(email, Integer.valueOf(cookie.getValue()))) {
                    resp.getWriter().write("1");
                }else {
                    resp.getWriter().write("0");
                }
                break;
            }
        }
    }

    /**
     * 修改个人信息时，验证电话是否可用
     * @param req
     * @param resp
     */
    private void doVerifyPhone(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String phone = req.getParameter("phone");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                if (iUsersService.verifyPhone(phone, Integer.valueOf(cookie.getValue()))) {
                    resp.getWriter().write("1");
                }else {
                    resp.getWriter().write("0");
                }
                break;
            }
        }
    }

    /**
     * 修改个人信息时，验证是否是可用昵称
     * @param req
     * @param resp
     */
    private void doverifyNick(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nickname = req.getParameter("nickname");
        System.out.println(nickname);
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                if (iUsersService.verifyNick(nickname, Integer.valueOf(cookie.getValue()))) {
                    resp.getWriter().write("1");
                }else {
                    resp.getWriter().write("0");
                }
                break;
            }
        }
    }

    /**
     * 上传图片
     * @param req
     * @param resp
     */
    private void doUploadPhoto(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part part = req.getPart("photo");
        String serverpath = req.getServletContext().getRealPath("img");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                iUsersService.uploadPhoto(part, serverpath, Integer.valueOf(cookie.getValue()));
                break;
            }
        }
        resp.sendRedirect("mygrxx.jsp");
    }

    /**
     * 修改跟新地区
     * @param req
     * @param resp
     */
    private void doAreaUpdate(HttpServletRequest req, HttpServletResponse resp) {
        String area = req.getParameter("area");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                iUsersService.AreaChange(area, Integer.valueOf(cookie.getValue()));
                break;
            }
        }
    }

    /**
     * 修改更新个人信息
     * @param req
     * @param resp
     */
    private void doProfileUpdate(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String nickname = req.getParameter("nickname");
        System.out.println(name+"=="+birthday+"=="+gender+"=="+email+"=="+phone+"=="+nickname);
        Date birthdayDate = Date.valueOf(birthday);
        String userid = null;
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                userid = cookie.getValue();
                break;
            }
        }
        iUsersService.updateProfile(name, birthdayDate, gender, Integer.valueOf(userid), email, phone, nickname);
    }

    /**
     * 显示个人信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = null;
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                userid = cookie.getValue();
            }
        }
        Users users = iUsersService.doShowProfile(Integer.valueOf(userid));
        req.setAttribute("users", users);
        req.getRequestDispatcher("mygrxx.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
