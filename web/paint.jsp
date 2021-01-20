<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${oneClass.className} - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head.jsp"></jsp:include>
<!-----------------banner------------------------------->
<div class="banner">
    <a href="#"><img src="img/temp/banner2.jpg"/></a>
</div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a><span>/</span><a href="class?opt=one&parentId=${oneClass.id}" class="on">${oneClass.className}</a>
    </div>
</div>
<!-----------------paintCon------------------------------->
<div class="paintCon">
    <c:forEach items="${goodsMap}" var="good">
        <section class="wrapper">
                <%--<h3><img src="img/temp/tit01.jpg"></h3>--%>
            <h3>${good.key}</h3>
<%--            <img src="img/temp/paint01.jpg"/>--%>
            <div class="paintList">
                <c:forEach items="${good.value}" var="g">
                    <a href="goods?goodsId=${g.id}">
                        <dl>
                            <dt><img src="img/imgs/${g.imgs == null ? '404.png' : g.imgs[0]}" style="height: 356px; width: 356px"/></dt>
                            <dd style="display:inline-block;width: 356px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">${g.name}</dd>
                            <dd>${g.price}</dd>
                        </dl>
                    </a>
                </c:forEach>
            </div>
        </section>
    </c:forEach>
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
</a><a href="users?opt=myCenter">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p></p></div>
<div class="msk"></div><!--footer-->
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
<!--<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>--></body>
</html>