<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${classTow.className} - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head.jsp"></jsp:include>
<!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img src="img/temp/banner2.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a><span>/</span>
        <a href="class?opt=one&parentId=${classOne.id}">${classOne.className}</a><span>/</span>
        <a href="#" class="on">${classTow.className}</a></div>
</div>
<!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix">
        <h3 class="fl">${classTow.className}</h3>
        <div class="fr choice">
            <c:choose>
                <c:when test="${select == 'new'}"><p class="default">新品上市</p></c:when>
                <c:when test="${select == 'sales0'}"><p class="default">销量从高到低</p></c:when>
                <c:when test="${select == 'sales1'}"><p class="default">销量从低到高</p></c:when>
                <c:when test="${select == 'price0'}"><p class="default">价格从高到低</p></c:when>
                <c:when test="${select == 'price1'}"><p class="default">价格从低到高</p></c:when>
                <c:otherwise><p class="default">排序方式</p></c:otherwise>
            </c:choose>
            <ul class="select">
                <a href="class?opt=tow&id=${classTow.id}&sort=new"><li>新品上市</li></a>
                <a href="class?opt=tow&id=${classTow.id}&sort=sales0"><li>销量从高到低</li></a>
                <a href="class?opt=tow&id=${classTow.id}&sort=sales1"><li>销量从低到高</li></a>
                <a href="class?opt=tow&id=${classTow.id}&sort=price0"><li>价格从高到低</li></a>
                <a href="class?opt=tow&id=${classTow.id}&sort=price1"><li>价格从低到高</li></a>
            </ul>
        </div>
    </div>
</div>
<!----------------proList------------------------->
<ul class="proList wrapper clearfix">
    <c:forEach items="${towGoods}" var="goods">
        <li>
            <a href="goods?goodsId=${goods.id}">
                <dl>
                    <dt><img src="img/imgs/${goods.imgs == null ? '404.png' : goods.imgs[0]}" style="width: 268px; height: 268px;"/></dt>
                    <dd style="display:inline-block;width: 268px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">【${goods.aClass.className}】${goods.name}</dd>
                    <dd>￥${goods.price}</dd>
                </dl>
            </a>
        </li>
    </c:forEach>
</ul>
<!----------------mask------------------->
<div class="mask"></div>
<!-------------------mask内容------------------->
<div class="proDets">
    <img class="off" src="img/temp/off.jpg"/>
    <div class="tit clearfix">
        <h4 class="fl">【KL】非洲菊仿真花干花</h4>
        <span class="fr">￥17.90</span>
    </div>
    <div class="proCon clearfix">
        <div class="proImg fl">
            <img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix">
                <img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg">
                <img src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg">
                <img src="img/temp/proDet03.jpg" data-src="img/temp/proDet03_big.jpg">
                <img src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg">
            </div>
        </div>
        <div class="fr">
            <div class="proIntro">
                <p>颜色分类</p>
                <div class="smallImg clearfix categ">
                    <p class="fl">
                        <img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支KL花" data-src="img/temp/proBig01.jpg">
                    </p>
                    <p class="fl">
                        <img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草" data-src="img/temp/proBig02.jpg">
                    </p>
                    <p class="fl">
                        <img src="img/temp/prosmall03.jpg" alt="20支KL花" data-src="img/temp/proBig03.jpg">
                    </p>
                    <p class="fl">
                        <img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg">
                    </p>
                </div>
                <p>数量&nbsp;&nbsp;库存<span>2096</span>件</p>
                <div class="num clearfix">
                    <img class="fl sub" src="img/temp/sub.jpg">
                    <span class="fl" contentEditable="true">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                    <p class="please fl">请选择商品属性!</p>
                </div>
            </div>
            <div class="btns clearfix">
                <a href="#2">
                    <p class="buy fl">立即购买</p>
                </a>
                <a href="#2">
                    <p class="cart fr">加入购物车</p>
                </a>
            </div>
        </div>
    </div>
    <a class="more" href="proDetail.jsp">查看更多细节</a>
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>