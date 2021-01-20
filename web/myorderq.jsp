<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head2.jsp"></jsp:include>

<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.jsp" class="fl">首页</a><span>/</span>
        <a href="users?opt=myCenter">个人中心</a><span>/</span>
        <a href="order?opt=queryAll" class="on">我的订单</a>
    </div>
</div>

<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="zuo.jsp"></jsp:include>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix">
                    <input type="text" name="" id="" value="" placeholder="请输入商品名称、订单号"/>
                    <input type="button" name="" id="" value=""/>
                </form>
            </div>

            <c:forEach items="${orders}" var="order">
                    <c:choose>
                        <c:when test="${order.value.get(0).status == 0}">
                            <div class="dkuang deng">
                                <p class="one">待支付</p>
                                <div class="word clearfix">
                                    <ul class="fl clearfix">
                                        <li>${order.value.get(0).createTime}</li>
                                        <li>${order.value.get(0).shouName}</li>
                                        <li>订单号:${order.value.get(0).expressNo}</li>
                                        <li>在线支付</li>
                                    </ul>
                                    <p class="fr">订单金额：<span>${order.value.get(0).money}</span>元</p>
                                </div>
                                <c:forEach items="${order.value}" var="o">
                                    <div class="shohou clearfix">
                                        <a href="#" class="fl"><img src="img/imgs/${o.orderGoods.goodsImg}"/></a>
                                        <p class="fl"><a href="#">${o.orderGoods.goodsName}</a><a href="#">¥${o.orderGoods.goodsPrice}×${o.orderGoods.goodsNum}</a></p>
                                        <p class="fr">
                                            <a href="#">立即支付</a>
                                            <a href="order?opt=xq&exp=${o.expressNo}">订单详情</a>
                                        </p>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                        <c:when test="${order.value.get(0).status == 1}">
                            <div class="dkuang clearfix deng">
                                <p class="one">待收货</p>
                                <div class="word clearfix">
                                    <ul class="fl clearfix">
                                        <li>${order.value.get(0).createTime}</li>
                                        <li>${order.value.get(0).shouName}</li>
                                        <li>订单号:${order.value.get(0).expressNo}</li>
                                        <li>在线支付</li>
                                    </ul>
                                    <p class="fr">订单金额：<span>${order.value.get(0).money}</span>元</p>
                                </div>
                                <c:forEach items="${order.value}" var="o">
                                    <div class="shohou clearfix">
                                        <a href="#" class="fl"><img src="img/imgs/${o.orderGoods.goodsImg}"/></a>
                                        <p class="fl"><a href="#">${o.orderGoods.goodsName}</a><a href="#">¥${o.orderGoods.goodsPrice}×${o.orderGoods.goodsNum}</a></p>
                                        <p class="fr">
                                            <a href="#">确认收货</a>
                                            <a href="order?opt=xq&exp=${o.expressNo}">订单详情</a>
                                        </p>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                        <c:when test="${order.value.get(0).status == 2}">
                            <div class="dkuang">
                                <p class="one">已收货</p>
                                <div class="word clearfix">
                                    <ul class="fl clearfix">
                                        <li>${order.value.get(0).createTime}</li>
                                        <li>${order.value.get(0).shouName}</li>
                                        <li>订单号:${order.value.get(0).expressNo}</li>
                                        <li>在线支付</li>
                                    </ul>
                                    <p class="fr">订单金额：<span>${order.value.get(0).money}</span>元</p>
                                </div>
                                <c:forEach items="${order.value}" var="o">
                                    <div class="shohou clearfix">
                                        <a href="#" class="fl"><img src="img/imgs/${o.orderGoods.goodsImg}"/></a>
                                        <p class="fl"><a href="#">${o.orderGoods.goodsName}</a><a href="#">¥${o.orderGoods.goodsPrice}×${o.orderGoods.goodsNum}</a></p>
                                        <p class="fr">
                                            <a href="#">待评价</a>
                                            <a href="order?opt=xq&exp=${o.expressNo}">订单详情</a>
                                        </p>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                        <c:when test="${order.value.get(0).status == 3}">
                            <div class="dkuang">
                                <p class="one">已关闭</p>
                                <div class="word clearfix">
                                    <ul class="fl clearfix">
                                        <li>${order.value.get(0).createTime}</li>
                                        <li>${order.value.get(0).shouName}</li>
                                        <li>订单号:${order.value.get(0).expressNo}</li>
                                        <li>在线支付</li>
                                    </ul>
                                    <p class="fr">订单金额：<span>${order.value.get(0).money}</span>元</p>
                                </div>
                                <c:forEach items="${order.value}" var="o">
                                    <div class="shohou clearfix">
                                        <a href="#" class="fl"><img src="img/imgs/${o.orderGoods.goodsImg}"/></a>
                                        <p class="fl"><a href="#">${o.orderGoods.goodsName}</a><a href="#">¥${o.orderGoods.goodsPrice}×${o.orderGoods.goodsNum}</a></p>
                                        <p class="fr">
                                            <a href="#">交易失败</a>
                                            <a href="order?opt=xq&exp=${o.expressNo}">订单详情</a>
                                        </p>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                    </c:choose>
            </c:forEach>
            <div class="fenye clearfix">
                <a href="#"><img src="img/zuo.jpg"/></a>
                <a href="#">1</a><a href="#"><img src="img/you.jpg"/></a>
            </div>
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
</body>
</html>