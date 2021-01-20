<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Coolrui! 我喜欢</title>
    <meta name="viewport" content="width=1160px, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/indexx.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<%--头部导航栏--%>
<jsp:include page="head.jsp"></jsp:include>
<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
</div>
<div class="news">
    <div class="wrapper">
        <c:set var="tmp" value="0"></c:set>
        <c:forEach items="${search}">
            <div class="flower clearfix tran">
                <c:forEach items="${search}" var="g" begin="${tmp}" end="${tmp+2}">
                    <a href="goods?goodsId=${g.id}" class="clearfix">
                        <dl>
                            <dt>
                                <span class="abl"></span>
                                <img src="img/imgs/${g.imgs == null ? '404.png' : g.imgs[0]}" style="width: 356px; height: 356px;"/>
                                <span class="abr"></span>
                            </dt>
                            <dd style="display:inline-block;width: 356px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">${g.name}</dd>
                            <dd><span>¥ ${g.price}</span></dd>
                        </dl>
                    </a>
                </c:forEach>
                <c:set var="tmp">${tmp = tmp + 3}</c:set>
            </div>
        </c:forEach>
    </div>
</div>
<!--返回顶部-->
<div class="gotop">
    <a href="carts?opt=queryAll">
        <dl class="goCart">
            <dt><img src="img/gt1.png"/></dt>
            <dd>去购<br/>物车</dd>
            <span style="background: #c10000; visibility:${cartNum == 0 ? 'hidden' : ''}">${cartNum}</span>
        </dl>
    </a>

    <a href="#" class="dh">
        <dl>
            <dt><img src="img/gt2.png"/></dt>
            <dd>联系<br/>客服</dd>
        </dl>
    </a>
    <a href="users?opt=myCenter">
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
    <p></p>
</div>
<!-------------------login-------------------------->
<!--footer-->
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
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</script>
</body>
</html>