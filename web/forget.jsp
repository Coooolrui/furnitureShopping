<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>forget</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/forget.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!----------------------------------------order------------------>
<div class="order cart">
    <!-----------------logo------------------->
    <div class="logo"><h1 class="wrapper clearfix"><a href="index.jsp"><img class="fl" src="img/logo.png" style="width: 68px; height: 68px;"></a>
    </h1></div>
    <div class="forCon">
        <p>安全设置-找回密码</p>
        <ul>
            <li class="on"><span>01/</span>输入登录名</li>
<%--            <li><span>02/</span>验证信息</li>--%>
            <li><span>02/</span>重置密码</li>
        </ul>
        <div class="formCon">
            <!--步骤1-->
            <form class="one">
                <input type="text" value="" placeholder="邮箱" id="email"><br>
                <input type="text" value="" placeholder="验证码" id="authcode">
                <button id="btnn" style="display:inline-block;margin-left: 20px; padding: 10px; background-color: rgb(193,0,0); border-radius: 8px; color: white;">获取验证码</button><br>
                <p id="err" style="color: red"></p>
                <input type="button" value="下一步" class="next">
            </form>
<%--            <!--步骤2-->--%>
<%--            <form action="#" method="post" class="two">--%>
<%--                <p>电子邮箱：<span>114081*****qq.com</span></p>--%>
<%--                <p class="tip">验证邮件已发往你的电子邮箱，请点击邮件中的链接完成验证</p>--%>
<%--                <input type="button" value="去邮箱验证" class="next1"></form>--%>
            <!--步骤3-->
            <form action="#" method="post" class="two">
                <label>新密码：</label>
                <input type="password" value="" id="newpass"><br/>
                <label>确认密码：</label><input id="repatpass" type="password" value=""><br/>
                <p id="err2" style="color: red"></p>
                <input type="button" id="ok" value="完成">
            </form>
        </div>
    </div>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(function (){
        $("#btnn").click(function () {
            var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            if ($("#email").val() != "" && reg.test($("#email").val())){
                $.post(
                    "logReg",
                    {
                        "opt":"authCode2",
                        "email":$("#email").val(),
                    },
                    function (data){
                        if (data == '0'){
                            $("#err").text("此用户没有注册")
                        }
                    }
                )
            }else {
                alert("请输入正确的邮箱！")
            }
            return false
        })

        $("#ok").click(function (){
            if ($("#newpass").val() != "" && $("#repatpass").val() != "" && $("#newpass").val() == $("#repatpass").val()){
                $.post(
                    'logReg?opt=update',
                    {
                        'email':$("#email").val(),
                        'pass':$("#newpass").val()
                    },
                    function (data){
                        if (data == '1'){
                            alert("密码修改成功！请登录")
                            window.location.href = "login.jsp"
                        }
                    }
                )
            }else {
                $("#err2").text("手滑！请再次输入")
            }
        })

        $("#authcode").focus(function (){
            $("#err").text("")
        })
        $("#email").focus(function (){
            $("#err").text("")
        })

        $("#newpass").focus(function (){
            $("#err2").text("")
        })
        $("#repatpass").focus(function (){
            $("#err2").text("")
        })
    })
</script>
</body>
</html>