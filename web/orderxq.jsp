<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head2.jsp"></jsp:include>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="myorderq.jsp"
                                                                                        class="on">我的订单</a><span>/</span><a
            href="#" class="on">订单详情</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="zuo.jsp"></jsp:include>
        <div class="you fl">
            <div class="my clearfix"><h2>订单详情<a href="#">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span>${order.expressNo}</span></h3></div>
            <div class="orderList">
                <div class="orderList1">
                    <c:choose>
                        <c:when test="${order.status == 0}">
                            <h3>待支付</h3>
                        </c:when>
                        <c:when test="${order.status == 1}">
                            <h3>待收货</h3>
                        </c:when>
                        <c:when test="${order.status == 2}">
                            <h3>已收货</h3>
                        </c:when>
                        <c:when test="${order.status == 3}">
                            <h3>已关闭</h3>
                        </c:when>
                    </c:choose>
                    <c:forEach items="${goods}" var="g">
                        <div class="clearfix" style="margin-bottom: 10px">
                            <a href="goods?goodsId=${g.goodsId}" class="fl"><img src="img/imgs/${g.goodsImg}" style="width: 65px; height: 65px;"/></a>
                            <p class="fl">
                                <a href="#">${g.goodsName}</a>
                                <a href="#">¥${g.goodsPrice}×${g.goodsNum}</a>
                            </p>
                        </div>
                    </c:forEach>
                </div>
                <div class="orderList1">
                    <h3>收货信息</h3>
                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>${address.userName}</span></p>
                    <p>联系电话：<span>${address.userPhone}</span></p>
                    <p>收货地址：<span>${address.province.name} ${address.city.name} ${address.area.name} ${address.street.name}</span></p>
                </div>
                <div class="orderList1">
                    <h3>支付方式及送货时间</h3>
                    <p>支付方式：
                        <c:choose>
                            <c:when test="${order.paymentId != 4}">
                                <span>在线支付</span>
                            </c:when>
                            <c:otherwise>
                                <span>货到付款</span>
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <p>送货时间：<span>不限送货时间</span></p>
                </div>
                <div class="orderList1 hei">
                    <h3><strong>商品总价：</strong><span>¥${order.money}</span></h3>
                    <p><strong>运费：</strong><span>¥0</span></p>
                    <p><strong>订单金额：</strong><span>¥${order.money}</span></p>
                    <p><strong>实付金额：</strong><span>¥${order.money}</span></p></div>
            </div>
        </div>
    </div>
</div>
<<!--返回顶部-->
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
</body>
</html>