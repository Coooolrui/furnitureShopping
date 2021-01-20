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
                <div class="slide"><img src="img/class1.jpg" style="
                width: 1600px;height: 500px;"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/class6.jpg" style="object-fit:cover;width: 1600px;height: 500px;"/></div>
            </li>
        </ul>
    </div>
</div>
<!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
        <c:forEach items="${hots}" var="hot">
            <a href="goods?goodsId=${hot.id}"><img src="img/${hot.imgs[0]}" style="width: 260px; height: 350px;"/></a>
        </c:forEach>
    </div>
</div>
<!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper">
<%--        <h2><img src="img/ih1.jpg"/></h2>--%>
<%--        <div class="top clearfix">--%>
<%--            <a href="proDetail.jsp">--%>
<%--                <img src="img/n1.jpg"/>--%>
<%--                <p></p>--%>
<%--            </a>--%>
<%--            <a href="proDetail.jsp">--%>
<%--                <img src="img/n2.jpg"/>--%>
<%--                <p></p>--%>
<%--            </a>--%>
<%--            <a href="proDetail.jsp">--%>
<%--                <img src="img/n3.jpg"/>--%>
<%--                <p></p>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--        <div class="bott clearfix">--%>
<%--            <a href="proDetail.jsp"><img src="img/n4.jpg"/>--%>
<%--            <p></p></a><a href="proDetail.jsp"><img src="img/n5.jpg"/>--%>
<%--            <p></p></a><a href="proDetail.jsp"><img src="img/n6.jpg"/>--%>
<%--            <p></p></a></div>--%>

        <%-- 随机类型 --%>
<%--        ${goods}--%>
        <c:forEach items="${goods}" var="good">
            <h2><img src="img/ih2.jpg"/></h2>
            <c:set var="tmp" value="0"></c:set>
            <c:forEach items="${good.value}" step="3">
                <div class="flower clearfix tran">
                    <c:forEach items="${good.value}" var="g" begin="${tmp}" end="${tmp+2}">
                        <a href="goods?goodsId=${g.id}" class="clearfix">
                            <dl>
                                <dt>
                                    <span class="abl"></span>
                                    <img src="img/imgs/${g.imgs == null ? '404.png' : g.imgs[0]}" style="width: 356px; height: 356px;"/>
                                    <span class="abr"></span>
                                </dt>
                                <dd style="display:inline-block;width: 356px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">【${g.aClass.className}】${g.name}</dd>
                                <dd><span>¥ ${g.price}</span></dd>
                            </dl>
                        </a>
                    </c:forEach>
                    <c:set var="tmp">${tmp = tmp + 3}</c:set>
                </div>
            </c:forEach>
        </c:forEach>
    </div>
</div>
<!------------------------------ad------------------------------>
<a href="#" class="ad">
    <img src="img/ib1.jpg"/>
</a>
<!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper">
        <h2><img src="img/ih3.jpg"/></h2>
        <c:set var="tmp" value="0"></c:set>
        <c:forEach items="${goodsbottom}" var="goods">
            <c:forEach items="${goods.value}" step="4">
                <div class="pList clearfix tran">
                    <c:forEach items="${goods.value}" var="good" begin="${tmp}" end="${tmp+3}">
                        <a href="goods?goodsId=${good.id}">
                            <dl>
                                <dt>
                                    <span class="abl"></span>
                                    <img src="img/imgs/${good.imgs == null ? '404.png' : good.imgs[0]}" style="width: 268px; height: 268px;"/>
                                    <span class="abr"></span>
                                </dt>
                                <dd style="display:inline-block;width: 268px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">【${good.aClass.className}】${good.name}</dd>
                                <dd><span>￥${good.price}</span></dd>
                            </dl>
                        </a>
                    </c:forEach>
                </div>
                <c:set var="tmp">${tmp = tmp + 4}</c:set>
            </c:forEach>
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
</body>
</html>