<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head2.jsp"></jsp:include>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.jsp" class="fl">首页</a><span>/</span>
        <a href="users?opt=myCenter" class="on">个人信息</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
<%--        <div class="zuo fl">--%>
<%--            <h3><a href="#"><img src="img/tx.png"/></a>--%>
<%--                <p class="clearfix"><span class="fl">[羊羊羊]</span><span class="fr">[退出登录]</span></p></h3>--%>
<%--            <div><h4>我的交易</h4>--%>
<%--                <ul>--%>
<%--                    <li><a href="cart.jsp">我的购物车</a></li>--%>
<%--                    <li><a href="myorderq.jsp">我的订单</a></li>--%>
<%--                    <li><a href="myprod.jsp">评价晒单</a></li>--%>
<%--                </ul>--%>
<%--                <h4>个人中心</h4>--%>
<%--                <ul>--%>
<%--                    <li><a href="mygxin.jsp">我的中心</a></li>--%>
<%--                    <li><a href="address.jsp">地址管理</a></li>--%>
<%--                </ul>--%>
<%--                <h4>账户管理</h4>--%>
<%--                <ul>--%>
<%--                    <li><a href="mygrxx.jsp">个人信息</a></li>--%>
<%--                    <li class="on"><a href="remima.jsp">修改密码</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <%@include file="zuo.jsp"%>--%>
        <jsp:include page="zuo.jsp"></jsp:include>
        <div class="you fl"><h2>修改密码</h2>
            <form class="remima">
<%--                <p><span>选择验证身份方式：</span>--%>
<%--                    <input type="checkbox"/>密码验证 <input type="checkbox"/>邮箱验证</p>--%>
                <p>
                    <span>原密码：</span>
                    <input type="password" id="old"/>
                </p>
                <p class="op">输入原密码</p>
                <p>
                    <span>新密码：</span>
                    <input type="password" id="new"/>
                </p>
                <p class="op">6-16 个字符，需使用字母、数字或符号组合，不能使用纯数字、纯字母、纯符号</p>
                <p>
                    <span>重复新密码：</span>
                    <input type="password" id="repeat"/>
                </p>
                <p class="op">请再次输入密码</p>
                <p>
                    <span>邮箱验证码：</span>
                    <input type="text" id="authCode"/>
                    <button id="btnn" style="margin-left: 20px; padding: 10px; background-color: rgb(193,0,0); border-radius: 8px; color: white;">获取验证码</button>
<%--                    <img src="img/temp/code.jpg" alt=""/>--%>
                </p>
<%--                <p></p>--%>
<%--                <p class="op">按右图输入验证码，不区分大小写</p>--%>
                <input type="submit" id="up" value="提交"/>
                <p id="err" style="color: red"></p>
            </form>

        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="carts?opt=queryAll">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="users?opt=myCenter">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p></p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">Coolrui家居&copy;家的呼唤，心的选择<br/>本网站数据用作学习交流使用</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script>

    $(function (){
        //请求获得验证码
        $("#btnn").click(function () {
            // alert(123456)
            $.post(
                "logReg",
                {
                    "opt":"authCode",
                    "email":'${phoneNick.email}',
                },
                function (data){

                }
            )
            return false
        })

        $("#repeat").blur(function (){
            if ($("#new").val() != $("#repeat").val()){
                $("#err").text("两次密码不一致")
            }
        })

        $("#up").click(function (){
            if ($("#old").val() != "" && $("#new").val() != "" && $("#authCode").val() != "" && $("#repeat").val() != ""){
                $.post(
                    "users",
                    {
                        "old":$("#old").val(),
                        "new":$("#new").val(),
                        "authCode":$("#authCode").val(),
                        "opt":"modifyPassword"
                    },
                    function (data){
                        if (data == '0'){
                            $("#err").text("验证信息有误")
                        }else {
                            window.location.href = "mygxin.jsp"
                        }
                    }
                )
            }
            return false
        })

        $("#old").focus(function (){
            $("#err").text("");
        })
        $("#new").focus(function (){
            $("#err").text("");
        })
        $("#repeat").focus(function (){
            $("#err").text("");
        })
        $("#authCode").focus(function (){
            $("#err").text("");
        })
    })
</script>
</body>
</html>