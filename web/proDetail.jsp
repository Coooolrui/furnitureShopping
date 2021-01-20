<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${goods.name} - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head.jsp"></jsp:include>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a><span>/</span>
        <a href="class?opt=one&parentId=${oneClass.id}">${oneClass.className}</a><span>/</span>
        <a href="class?opt=tow&id=${towClass.id}">${towClass.className}</a><span>/</span>
        <a href="#" class="on">【${towClass.className}】${goods.name}</a>
    </div>
</div>
<!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
                <img class="det" src="img/imgs/${goods.imgs == null ? '404.png' : goods.imgs[0]}"/>
                <div class="smallImg clearfix">
                    <c:forEach items="${goods.imgs}" var="img">
                        <img src="img/imgs/${img}" data-src="img/imgs/${img}">
                    </c:forEach>
<%--                    <img src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg">--%>
<%--                    <img src="img/temp/proDet03.jpg" data-src="img/temp/proDet03_big.jpg">--%>
<%--                    <img src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg">--%>
                </div>
            </div>
            <div class="fr intro">
                <div class="title">
                    <h4 style="display:inline-block;width: 530px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">${goods.name}</h4>
                    <p>${goods.gdesc}</p>
                    <span>￥${goods.price}</span>
                </div>
                <div class="proIntro1">
<%--                    <p>颜色分类</p>--%>
<%--                    <div class="smallImg clearfix categ">--%>
<%--                        <p class="fl">--%>
<%--                            <img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支KL花" data-src="img/temp/proBig01.jpg">--%>
<%--                        </p>--%>
<%--                        <p class="fl">--%>
<%--                            <img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草" data-src="img/temp/proBig02.jpg">--%>
<%--                        </p>--%>
<%--                        <p class="fl">--%>
<%--                            <img src="img/temp/prosmall03.jpg" alt="20支KL花" data-src="img/temp/proBig03.jpg">--%>
<%--                        </p>--%>
<%--                        <p class="fl">--%>
<%--                            <img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg">--%>
<%--                        </p>--%>
<%--                    </div>--%>
                    <p>数量&nbsp;&nbsp;库存<span>${goods.stock}</span>件</p>
                    <div class="num clearfix">
                        <img class="fl sub" src="img/temp/sub.jpg">
                        <span id="num" class="fl" contentEditable="true">1</span>
                        <img class="fl add" src="img/temp/add.jpg">
<%--                        <p class="please fl">请选择商品属性!</p>--%>
                    </div>
                </div>
                <div class="btns clearfix">
                    <a href="#2"><p class="buy fl" instant="${goods.id}" >立即购买</p></a>
                    <p class="cart fr">加入购物车</p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix">
            <a class="on">商品详情</a>
            <a>所有评价</a>
        </div>
        <div class="msgAll">
            <div class="msgImgs">
                <c:forEach items="${goods.info}" var="img">
                    <img src="img/imgs/${img}">
                </c:forEach>
            </div>
            <div class="eva">
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="msgR fr">
        <h4>为你推荐</h4>
        <%--推荐同类型的，同二级id--%>
<%--        <div class="seeList" style="width: 201px">--%>
<%--            &lt;%&ndash;4个&ndash;%&gt;--%>
<%--            <c:forEach items="${recommend}" var="rec">--%>
<%--                <a href="#">--%>
<%--                    <dl style="width: 161px;">--%>
<%--                        <dt><img src="img/temp/see01.jpg"></dt>--%>
<%--                        <dd>【KL】${rec.name}</dd>--%>
<%--                        <dd>￥${rec.price}</dd>--%>
<%--                    </dl>--%>
<%--                </a>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
        <div class="seeList">
            <c:forEach items="${recommend}" var="rec">
                <a href="goods?goodsId=${rec.id}">
                    <dl>
                        <dt><img src="img/imgs/${rec.imgs == null ? '404.png' : rec.imgs[0]}" style="width: 161px; height: 243px;"></dt>
                        <dd style="display:inline-block;width: 150px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">【KL】${rec.name}</dd>
                        <dd>￥${rec.price}</dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<div class="like">
    <h4>猜你喜欢</h4>
    <%--同一级id的商品， 10个--%>
    <div class="bottom">
        <div class="hd">
            <span class="prev"><img src="img/temp/prev.png"></span>
            <span class="next"><img src="img/temp/next.png"></span>
        </div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
<script type="text/javascript">
    $(function (){
        $(".cart").click(function (){
            // alert(123)
            $.post(
                "carts?opt=changeNum",
                {
                    'num':$("#num").text(),
                    'goodsId': '${goods.id}'
                },
                function (data){
                    if (data != '0' && data.length <= 2){
                        $(".goCart span").text(data)
                        $(".goCart span").css("visibility", "")
                    }else {
                        window.location.href = "login.jsp"
                    }
                }
            )
        })

        $(".buy").click(function (){
            window.location.href = "order?opt=show&instant="+$(".buy").attr("instant")+"&num="+$("#num").text()
        })
    })
</script>
</body>
</html>