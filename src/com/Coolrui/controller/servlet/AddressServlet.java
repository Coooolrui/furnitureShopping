package com.Coolrui.controller.servlet;

import com.Coolrui.pojo.Address;
import com.Coolrui.pojo.Region;
import com.Coolrui.service.IAddressService;
import com.Coolrui.service.IRegionServie;
import com.Coolrui.service.imple.AddressServiceImpl;
import com.Coolrui.service.imple.RegionServieImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author MaRuiYa
 * @Date 2021/1/11 17:00
 */
@WebServlet("/address")
public class AddressServlet extends HttpServlet {
    IAddressService iAddressService = new AddressServiceImpl();
    IRegionServie iRegionServie = new RegionServieImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        if (opt != null){
            switch (opt){
                case "update":
                    doUpdateAddress(req, resp);
                    break;
                case "delete":
                    doDeleteAddress(req, resp);
                    break;
                case "add":
                    doAddAddress(req, resp);
                    break;
                case "updateDef":
                    doUpdateDef(req, resp);
                    break;
                case "queryArea":
                    doQueryArea(req, resp);
                    break;
                case "queryAddress":
                    doQueryAddress(req, resp);
                    break;
                case "queryAllAddress":
                    doQueryAllAddress(req, resp);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 查询所有地址
     * @param req
     * @param resp
     */
    private void doQueryAllAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                List<Address> allAddressByUserId = iAddressService.getAllAddressByUserId(Integer.valueOf(cookie.getValue()), 0);
                List<Address> allAddressByUserId1 = iAddressService.getAllAddressByUserId(Integer.valueOf(cookie.getValue()), 1);
                allAddressByUserId.addAll(allAddressByUserId1);
                req.setAttribute("allAddress", allAddressByUserId);
                req.getRequestDispatcher("address.jsp").forward(req, resp);
            }
        }
    }

    /**
     * 通过地址id 和 用户 id 查看用户收货信息
     * @param req
     * @param resp
     */
    private void doQueryAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String aid = req.getParameter("aid");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                Address address = iAddressService.getAddressByUserIdaid(Integer.valueOf(cookie.getValue()), Integer.valueOf(aid));
                resp.setCharacterEncoding("utf-8");
                String s = JSON.toJSONString(address);
                resp.getWriter().write(s);
            }
        }
    }

    /**
     * 地区四级联动
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doQueryArea(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        List<Region> regions = iRegionServie.getRegionByCode(code);
        System.out.println(123465);
//        resp.getWriter().write();
        resp.setCharacterEncoding("UTF-8");
        String s = JSON.toJSONString(regions);
        System.out.println(s);
        resp.getWriter().write(s);
    }

    private void doUpdateDef(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String instant = req.getParameter("instant");
        String num = req.getParameter("num");
//        System.out.println("default==="+id);
        iAddressService.changeDefaultAddress(Integer.valueOf(id));
        if (instant == null || num == null){
            resp.sendRedirect("order?opt=show");
        }else {
            resp.sendRedirect("order?opt=show&instant="+instant+"&num="+num);
        }

    }

    private void doAddAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String pro = req.getParameter("pro");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String street = req.getParameter("street");
        String xaddr = req.getParameter("xaddr");
        String postcode = req.getParameter("postcode");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                int i = iAddressService.addAddress(Integer.valueOf(cookie.getValue()),
                        name, phone, Integer.valueOf(pro), Integer.valueOf(city), Integer.valueOf(area), Integer.valueOf(street),
                        xaddr, postcode);
                resp.getWriter().write(""+i);
            }
        }
        System.out.println(name+phone+pro+city+area+street+xaddr+postcode);
    }

    /**
     * 删除地址
     * @param req
     * @param resp
     */
    private void doDeleteAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String instant = req.getParameter("instant");
        String num = req.getParameter("num");
        System.out.println(id);
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                iAddressService.deleteAddress(Integer.valueOf(id), Integer.valueOf(cookie.getValue()));
                if (instant == null || num == null){
                    resp.sendRedirect("order?opt=show");
                }else {
                    resp.sendRedirect("order?opt=show&instant="+instant+"&num="+num);
                }
            }
        }
    }

    /**
     * 更新地址
     * @param req
     * @param resp
     * @throws IOException
     */
    private void doUpdateAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String pro = req.getParameter("pro");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String street = req.getParameter("street");
        String xaddr = req.getParameter("xaddr");
        String postcode = req.getParameter("postcode");
        String aid = req.getParameter("aid");
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("userid")) {
                int i = iAddressService.updateAddress(Integer.valueOf(aid),
                        Integer.valueOf(cookie.getValue()),
                        name, phone, Integer.valueOf(pro), Integer.valueOf(city), Integer.valueOf(area), Integer.valueOf(street),
                        xaddr, postcode);
                resp.getWriter().write(""+i);
            }
        }
        System.out.println(name+phone+pro+city+area+street+xaddr+postcode+"====="+aid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
