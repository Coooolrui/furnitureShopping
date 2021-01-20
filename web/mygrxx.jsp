<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
</div>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%-------------左半部分---------------%>
        <jsp:include page="zuo.jsp"></jsp:include>
        <div class="you fl">
            <h2>个人信息</h2>
            <div class="gxin">
                <div class="tx"><a href="#">
                    <img src="${users.userPhoto}" style="width: 90px; height: 90px; border-radius: 45px;"/>
                    <p id="avatar">修改头像</p></a>
                </div>
                <div class="xx">
                    <h3 class="clearfix">
                        <strong class="fl">基础资料</strong>
                        <a href="#" class="fr" id="edit1">编辑</a>
                    </h3>
                    <div id="name1">姓名：${users.name == null ? "请完善信息" : users.name}</div>
                    <div id="birthday1">生日：${users.birthday == null ? "请完善信息" : users.birthday}</div>
                    <div id="gender1">性别：${users.gender == null ? "请完善信息" : (users.gender == 1 ? "男" : "女")}</div>
                    <div id="nickname1">昵称：${users.nickname == null ? "请完善信息" : users.nickname}</div>
                    <div id="phone1">电话：${users.userphone == null ? "请完善信息" : users.userphone}</div>
                    <div id="email1">邮箱：${users.email}</div>
                    <h3>高级设置</h3><!--<div><span class="fl">银行卡</span><a href="#" class="fr">管理</a></div>-->
                    <div>
                        <span class="fl">账号地区：${users.area == null ? "请完善信息" : users.area}</span>
                        <a href="#" class="fr" id="edit2">修改</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--遮罩-->
<div class="mask"></div>
<!--编辑弹框-->
<div class="bj">
    <div class="clearfix">
        <a href="#" class="fr gb"><img src="img/icon4.png"/></a>
    </div>
    <h3>编辑基础资料</h3>
    <form>
        <p><label>姓名：</label><input type="text" id="name" name="name" value="${users.name}"/></p>
        <p><label>生日：</label><input type="date" id="birthday" name="bitrhday" value="${users.birthday}"/></p>
        <p>
            <label>性别：</label>
            <span><input name="gender" ${users.gender == 1 ? "checked" : ""} value="1" type="radio"/>男</span>
            <span><input name="gender" ${users.gender == 0 ? "checked" : ""} value="0" type="radio"/>女</span>
        </p>
        <p><label>昵称：</label><input type="text" id="nickname" name="nickname" value="${users.nickname}"/></p>
        <p><label>电话：</label><input type="text" id="phone" name="phone" value="${users.userphone}"/></p>
        <p><label>邮箱：</label><input type="text" id="email" name="email" value="${users.email}"/></p>
        <input hidden name="opt" value="update">
        <p id="err" style="color: red"></p>
        <div class="bc1">
            <input type="submit" onclick="return false" id="updateProfile" value="保存"/>
            <input type="button" id="cancel" value="取消"/>
        </div>
    </form>
</div>
<!--高级设置修改-->
<div class="xg">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>切换账号地区</h3>
    <form action="#" method="get"><p><label>地区：</label><input type="text" id="area" value="${users.area}"/></p>
        <div class="bc1"><input type="button" id="areaBtn" value="保存"/><input type="button" id="cancale2" value="取消"/></div>
    </form>
</div>
<!--修改头像-->
<div class="avatar">
    <div class="clearfix">
        <a href="#" class="fr gb"><img src="img/icon4.png"/></a>
    </div>
    <h3>修改头像</h3>
    <form action="users" method="post" enctype="multipart/form-data">
        <h4>请上传图片</h4>
        <input type="file" name="photo"/>
        <p>jpg或png，大小不超过2M</p>
        <input type="submit" value="提交"/>
        <input hidden name="opt" value="upload">
    </form>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="carts?opt=queryAll">
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
<script type="text/javascript">
    $(function (){
        $("#updateProfile").click(function (){
            // alert(123465)
            //提交修改个人信息
            // alert("hhh")
            if ($("#name").val() != "" && document.getElementById("birthday").value !=""
                && $('input[name="gender"]:checked').val() != "" && $("#phone").val() != "" && $("#email").val() != ""
            && $("#nickname").val() != ""){
                $.post(
                    "users",
                    {
                        "opt":"update",
                        "name":$("#name").val(),
                        "birthday":document.getElementById("birthday").value,
                        "gender":$('input[name="gender"]:checked').val(),
                        "phone":$("#phone").val(),
                        "email":$("#email").val(),
                        "nickname":$("#nickname").val()
                    },
                    function(data){
                        window.location.href = "mygrxx.jsp"
                    },
                    "html"
                )
            }
        })

        $("#areaBtn").click(function (){
            $.post(
                "users",
                {
                    "opt":"upArea",
                    "area":$("#area").val()
                },
                function(data){
                    window.location.href = "mygrxx.jsp"
                },
                "html"
            )
        })

        $("#nickname").blur(function (){
            if ($("#nickname").val() != ""){
                $.post(
                    "users",
                    {
                        "nickname":$("#nickname").val(),
                        "opt":"verifyNick"
                    },
                    function (data){
                        if (data == "0"){
                            $("#err").text("用户名不可用")
                        }
                    }
                )
            }
        })
        $("#phone").blur(function (){
            if ($("#phone").val() != ""){
                $.post(
                    "users",
                    {
                        "phone":$("#phone").val(),
                        "opt":"verifyPhone"
                    },
                    function (data){
                        if (data == "0"){
                            $("#err").text("手机号不可用")
                        }
                    }
                )
            }
        })
        $("#email").blur(function (){
            if ($("#email").val() != ""){
                $.post(
                    "users",
                    {
                        "email":$("#email").val(),
                        "opt":"verifyEmail2"
                    },
                    function (data){
                        if (data == "0"){
                            $("#err").text("邮箱不可用")
                        }
                    }
                )
            }
        })
        //清除错误信息
        $("#nickname").focus(function (){
            $("#err").text("")
        })
        $("#phone").focus(function (){
            $("#err").text("")
        })
        $("#email").focus(function (){
            $("#err").text("")
        })


        /**
         * 取消
         */
        $("#cancel").click(function (){
            $(".readd").hide()
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide()
            $("#add").val("")
        })

        $("#cancale2").click(function (){
            $(".readd").hide()
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide()
            $("#add").val("")
        })

    })
</script>
</body>
</html>