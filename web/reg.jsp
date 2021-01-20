<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
    <!-------------------reg-------------------------->
    <div class="reg">
        <form>
            <h1>
                <a href="index.jsp"><img src="img/logo.png" style="width: 68px; height: 68px"></a>
            </h1>
            <p>用户注册</p>
            <p><input type="text" id="email" name="email" value="" placeholder="请输入邮箱"></p>
            <p><input type="password" id="password" name="password" value="" placeholder="请输入密码"></p>
            <p><input type="password" id="password2" value="" placeholder="请确认密码"></p>
            <p class="txtL txt">
                <input class="code" type="text" id="authcode" name="authcode" value="" placeholder="验证码">
<%--                <img src="img/temp/code.jpg">--%>
                <button id="btnn" style="margin-left: 20px; padding: 10px; background-color: rgb(193,0,0); border-radius: 8px; color: white;">获取验证码</button>
            </p>
            <p id="err" style="color: red"></p>
            <p><input type="submit" id="btn" onclick="return false" name="" value="注册"></p>
            <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#"><使用条款和隐私策略></a></p>
            <p class="txt">
                <a href="login.jsp"><span>已有账号登录</span></a>
            </p>
            <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
        </form>
    </div>
    <script src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function (){
            //检查邮箱是否可用
            let flag = false
            $("#email").blur(function (){
                if ($("email").val() != ""){
                    $.post(
                        "logReg",
                        {
                            "opt":"verifyEmail",
                            "email":$("#email").val(),
                        },
                        function(data){
                            if (data == "0") {
                                $("#err").text("邮箱不可用！")
                                flag = false
                            }else {
                                flag = true
                            }
                        },
                        "html"
                    )
                }
            })

            //注册提交
            $("#btn").click(function () {
                if (flag){
                    if ($("#email").val() != "" && $("#password").val() != "" && $("#password2").val() != "" && $("#authcode").val() != "" && $("#password").val() == $("#password2").val()){
                        $.post(
                            "logReg",
                            {
                                "opt":"register",
                                "email":$("#email").val(),
                                "password":$("#password").val(),
                                "authcode":$("#authcode").val()
                            },
                            function(data){
                                if (data == "1"){
                                    alert("注册成功，请登录！");
                                    window.location.href = "index.jsp"
                                }else if (data == "0") {
                                    $("#err").text("注册失败")
                                }
                            },
                            "html"
                        )
                    }else {
                        alert("请输入正确的注册信息！")
                    }
                }else {
                    alert("邮箱不可用")
                }
            })


            //请求获得验证码
            $("#btnn").click(function () {
                if ($("#email").val() != ""){
                    if (flag){
                        $.post(
                            "logReg",
                            {
                                "opt":"authCode",
                                "email":$("#email").val(),
                            },
                            function (data){

                            }
                        )
                    }else {
                        alert("邮箱不可用")
                    }
                }else {
                    alert("请输入邮箱！")
                }
                return false
            })

            //错误信息提示
            $("#password2").blur(function (){
                let val = $("#password").val();
                let val1 = $("#password2").val();
                if (val != val1){
                    $("#err").text("两次密码不一致")
                }
            })
            //清除错误信息
            $("#email").focus(function (){
                $("#err").text("")
            })
            $("#password").focus(function (){
                $("#err").text("")
            })
            $("#password2").focus(function (){
                $("#err").text("")
            })
            $("#authcode").focus(function (){
                $("#err").text("")
            })



        })
    </script>
</body>
</html>