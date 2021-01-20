<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>支付成功 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!----------------------------------------order------------------>
<jsp:include page="head2.jsp"></jsp:include>

<div class="order mt cart">
    <div class="site"><p class="wrapper clearfix"><span class="fl">支付成功</span><img class="top"
                                                                                   src="img/temp/cartTop03.png"></p>
    </div>
    <p class="ok">支付成功！剩余<span>5</span>秒<a href="order?opt=queryAll">返回订单页</a></p></div>
<div class="like">
    <h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd">
            <span class="prev"><img src="img/temp/prev.png"></span>
            <span class="next"><img src="img/temp/next.png"></span>
        </div>
        <div class="imgCon wrapper bd">
            <div class="likeList clearfix">
<%--                <div>--%>
<%--                    <a href="proDetail.jsp">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/temp/like01.jpg"></dt>--%>
<%--                            <dd>【KL】复古文艺风玻璃花瓶</dd>--%>
<%--                            <dd>￥193.20</dd>--%>
<%--                        </dl>--%>
<%--                    </a>--%>
<%--                </div>--%>
                <%--2个div 每个div 5个--%>
                <c:set var="tmp" value="0"></c:set>
                <c:forEach items="${guessLike}" step="5">
                    <div>
                        <c:forEach items="${guessLike}" var="like" begin="${tmp}" end="${tmp+4}">
                            <a href="goods?goodsId=${like.id}">
                                <dl>
                                    <dt><img src="img/imgs/${like.imgs == null ? '404.png' : like.imgs[0]}"></dt>
                                    <dd>【${like.aClass.className}】${like.name}</dd>
                                    <dd>￥${like.price}</dd>
                                </dl>
                            </a>
                        </c:forEach>
                    </div>
                    <c:set var="tmp">${tmp += 5}</c:set>
                </c:forEach>
            </div>
        </div>
    </div>
</div><!--footer-->
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>