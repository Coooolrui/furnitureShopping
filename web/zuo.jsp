<%--
  Created by IntelliJ IDEA.
  User: Mori
  Date: 2021/1/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="zuo fl">
    <h3>
        <a href="#"><img src="${phoneNick.userPhoto}" style="width: 90px; height: 90px; border-radius: 45px;"/></a>
        <p class="clearfix">
            <span class="fl">[${phoneNick.nickname == null ? "亲~" : phoneNick.nickname}]</span>
            <span class="fr"><a href="logReg?opt=exit">[退出登录]</a></span>
        </p>
    </h3>
    <div>
        <h4>我的交易</h4>
        <ul>
            <li><a href="carts?opt=queryAll">我的购物车</a></li>
            <li id="order"><a href="order?opt=queryAll">我的订单</a></li>
            <li id="myprod"><a href="myprod.jsp">评价晒单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li id="users"><a href="users?opt=myCenter">我的中心</a></li>
            <li id="address"><a href="address?opt=queryAllAddress">地址管理</a></li>
        </ul>
        <h4>账户管理</h4>
        <ul>
            <li id="mygrxx"><a href="mygrxx.jsp">个人信息</a></li>
            <li id="remima"><a href="remima.jsp">修改密码</a></li>
        </ul>
    </div>
</div>
<script src="js/jquery.js"></script>
<script type="text/javascript">
    $(function (){
        let cururl = window.location.href
        if (cururl.indexOf("/order") > 0){
            $("#order").addClass("on")
        }else if (cururl.indexOf("/users") > 0){
            $("#users").addClass("on")
        }else if (cururl.indexOf("/mygrxx") > 0){
            $("#mygrxx").addClass("on")
        }else if (cururl.indexOf("/remima") > 0){
            $("#remima").addClass("on")
        }else if (cururl.indexOf("/address") > 0){
            $("#address").addClass("on")
        }else if (cururl.indexOf("/myprod") > 0){
            $("#myprod").addClass("on")
        }
        console.log(cururl.indexOf("remima"))
    })
</script>
