<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
    <!-------------------login-------------------------->
    <div class="login">
        <form>
            <h1>
                <a href="index.jsp"><img src="img/logo.png" style="width: 68px; height: 68px;"></a>
            </h1>
            <p></p>
            <div class="msg-warn hide">
                <b>公共场所不建议自动登录，以防账号丢失</b>
            </div>
            <p>
                <input type="text" id="username" name="username" value="" placeholder="昵称/邮箱/手机号">
            </p>
            <p>
                <input type="password" id="password" name="password" value="" placeholder="密码">
            </p>
            <p id="err" style="color: red"></p>
            <p>
                <input type="submit" id="btn" onclick="return false" name="" value="登  录"/>
            </p>
            <p class="txt">
                <a class="" href="reg.jsp">免费注册</a><a href="forget.jsp">忘记密码？</a>
            </p>
        </form>
    </div>

    <script src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function (){
            //登录提交
            $("#btn").click(function () {
                if ($("#username").val() != "" && $("#password").val() != ""){
                    $.post(
                        "logReg",
                        {
                            "opt":"login",
                            "username":$("#username").val(),
                            "password":$("#password").val()
                        },
                        function(data){
                            if (data == "1"){
                                alert("登录成功");
                                window.location.href = "index.jsp"
                            }else if (data == "0") {
                                $("#err").text("用户名或密码错误")
                            }
                        },
                        "html"
                    )
                }else {
                    alert("请输入用户名或密码！")
                }
            })
            //输入消除错误信息
            $("#username").focus(function (){
                $("#err").text("");
            })
            $("#password").focus(function (){
                $("#err").text("");
            })
        })
    </script>
</body>
</html>