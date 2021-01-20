<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>订单 - Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!----------------------------------------order------------------>
<jsp:include page="head2.jsp"></jsp:include>

<div class="order cart mt">
    <!-----------------site------------------->
    <div class="site">
        <p class="wrapper clearfix">
            <span class="fl">订单确认</span>
            <img class="top" src="img/temp/cartTop02.png">
        </p>
    </div>
    <!-----------------orderCon------------------->
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl">
            <!--------h3---------------->
            <h3>收件信息<a style="cursor: pointer" id="new" class="fr">新增地址</a></h3>

            <!--------addres---------------->
            <div class="addres clearfix">
                <%--判断是否是默认--%>

                <c:if test="${defaultAddress != null}">
                    <div class="addre fl on">
                        <div class="tit clearfix">
                            <p class="fl">${defaultAddress.userName} <span class="default" ids="${defaultAddress.id}">[默认地址]</span></p>
                            <p class="fr">
                                <span></span><a style="cursor: pointer" class="delete" aid="${defaultAddress.id}" ids="${defaultAddress.id}">删除</a>
                                <%--href="address?opt=delete&id=${defaultAddress.id}"--%>
                                <span>|</span><a style="cursor: pointer" class="edit" ids="${defaultAddress.id}">编辑</a></p>
                        </div>
                        <div class="addCon">
                            <p>${defaultAddress.province.name}&nbsp;${defaultAddress.city.name}&nbsp;${defaultAddress.area.name}&nbsp;${defaultAddress.street.name}&nbsp;${addre.userAddress}</p>
                            <p>${defaultAddress.userPhone}</p>
                        </div>
                        <input hidden value="${defaultAddress.id}">
                    </div>
                </c:if>
                <c:forEach items="${address}" var="addre">
                    <div class="addre fl">
                        <div class="tit clearfix">
                            <p class="fl">${addre.userName}</p>
                            <p class="fr">
                                <a style="cursor: pointer" class="moren" aid="${addre.id}">设为默认</a>
                                <%-- href="address?opt=updateDef&id=${addre.id}"--%>
                                <span></span><a style="cursor: pointer" class="delete" aid="${addre.id}">删除</a>
                                <%--href="address?opt=delete&id=${addre.id}"--%>
                                <span>|</span><a style="cursor: pointer" class="edit" ids="${addre.id}">编辑</a></p>
                        </div>
                        <div class="addCon">
                            <p>${addre.province.name}&nbsp;${addre.city.name}&nbsp;${addre.area.name}&nbsp;${addre.street.name}&nbsp;${addre.userAddress}</p>
                            <p>${addre.userPhone}</p>
                        </div>
                        <input hidden value="${addre.id}">
                    </div>
                </c:forEach>
            </div>
            <h3>支付方式</h3>
            <!--------way---------------->
            <div class="way clearfix">
<%--                <img class="on" src="img/temp/way01.jpg">--%>
<%--                <img src="img/temp/way02.jpg">--%>
<%--                <img src="img/temp/way03.jpg">--%>
                <c:forEach items="${payments}" var="payment" varStatus="stat">
                    <img class="${stat.index == 0 ? "on" : ''}" src="img/${payment.img}" payid="${payment.id}">
                </c:forEach>
            </div>
            <h3>选择快递</h3>
            <!--------dis---------------->
            <div class="dis clearfix">
                <c:forEach items="${transports}" var="transport" varStatus="stat">
                    <span class="${stat.index == 0 ? "on" : ''}" transport="${transport.id}">${transport.name}</span>
                </c:forEach>
            </div>
        </div>
        <div class="orderR fr">
            <div class="msg">
                <h3>订单内容<a href="carts?opt=show" class="fr">返回购物车</a></h3>
                <!--------ul---------------->
                <c:set var="tmp" value="0"></c:set>
                <c:set var="goods" value=""></c:set>
                <c:set var="goodsId" value=""></c:set>

                <c:forEach items="${checked}" var="check">
                    <ul class="clearfix">
                        <li class="fl"><img style="width: 87px; height: 87px;" src="img/imgs/${check.goods.imgs[0]}"></li>
                        <li class="fl">
                            <p style="display:inline-block;width: 144px;overflow: hidden;text-overflow: ellipsis;white-space:nowrap;">${check.goods.name}</p>
<%--                            <p>颜色分类：烟灰色玻璃瓶</p>--%>
                            <p>数量：${check.cartNum}</p>
                        </li>
                        <li class="fr">￥${check.goods.price}</li>
                    </ul>
                    <c:set var="tmp">${tmp = tmp + check.cartNum * check.goods.price}</c:set>
                    <c:set var="goods">${goods = goods.concat(check.goods.id).concat("-").concat(check.cartNum).concat("-").concat(check.goods.price).concat("-").concat(check.goods.name).concat("-").concat(check.goods.imgs[0]).concat(",")}</c:set>
                    <c:set var="goodsId">${goodsId = goodsId.concat(check.goods.id).concat(",")}</c:set>
                </c:forEach>
            </div>
            <!--------tips---------------->
            <div class="tips">
                <p><span class="fl">商品金额：</span><span class="fr">￥${tmp}</span></p>
                <p><span class="fl">优惠金额：</span><span class="fr">￥0.00</span></p>
                <p><span class="fl">运费：</span><span class="fr">免运费</span></p>
            </div>
            <!--------tips count---------------->
            <div class="count tips">
                <p>
                    <span class="fl">合计：</span>
                    <span class="fr">￥${tmp}</span>
                </p>
            </div>
            <!--<input type="button" name="" value="去支付">-->
            <a style="cursor: pointer" class="pay">去支付</a></div>
    </div>
</div>
<!--编辑弹框--><!--遮罩-->
<div class="mask"></div>
<div class="adddz editAddre">
    <form>
        <input type="text" placeholder="姓名" class="on" id="name"/>
        <input type="text" placeholder="手机号" id="phone"/>
        <div class="city">
            <select id="pro">
                <option value="省份/自治区">省份/自治区</option>
            </select>
            <select id="city">
                <option value="城市/地区">城市/地区</option>
            </select>
            <select id="qu">
                <option value="区/县">区/县</option>
            </select>
            <select id="area">
                <option value="配送区域">配送区域</option>
            </select>
        </div>
        <textarea name="" rows="" cols="" placeholder="详细地址" id="xaddr"></textarea>
        <input type="text" placeholder="邮政编码" id="postcode"/>
        <div class="bc">
            <input type="button" id="save" value="保存"/>
            <input type="button" value="取消"/>
        </div>
    </form>
    <input hidden id="add" value="">
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
</a><a href="mygxin.jsp">
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
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    $(function (){
    //    href="ok.jsp"
        $(".pay").click(function (){
            if ($(document.querySelector(".on input")).attr('value') == null || $(document.querySelector(".way img.on")).attr('payid') == null
                ||$(document.querySelector(".dis span.on")).attr('transport') == null){
                alert("请填写正确的货运信息")
            }else {
                $.post(
                    "order?opt=add",
                    {
                        'addr':$(document.querySelector(".on input")).attr('value'),
                        'pay':$(document.querySelector(".way img.on")).attr('payid'),
                        'tran':$(document.querySelector(".dis span.on")).attr('transport'),
                        'money':'${tmp}',
                        'goods':'${goods}'
                    },
                    function (data){
                        if (data != 0){
                            window.location.href = 'ok?goodsId=${goodsId}'
                        }
                    }
                )
            }
        })


        //监听省份的变化
        $("#pro").change(function (){
            // alert($("#pro").val().split("-"))
            $.get(
                "address?opt=queryArea",
                {
                    'code':$("#pro").val().split("-")[1]
                },
                function (data){
                    $("#city")[0].innerHTML = '<option value="城市/地区">城市/地区</option>'
                    $("#qu")[0].innerHTML = '<option value="区/县">区/县</option>'
                    $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
                    let areas = JSON.parse(data);
                    for (let i in areas){
                        $('#city').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
                    }
                }
            )
        })


        //监听市的变化
        $("#city").change(function (){
            // alert($("#pro").val().split("-"))
            // console.log($("#city").val().split("-")[1])
            $.get(
                "address?opt=queryArea",
                {
                    'code':$("#city").val().split("-")[1]
                },
                function (data){
                    $("#qu")[0].innerHTML = '<option value="区/县">区/县</option>'
                    $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
                    let areas = JSON.parse(data);
                    for (let i in areas){
                        $('#qu').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
                    }
                }
            )
        })

        //监听区域的变化
        $("#qu").change(function (){
            // alert($("#pro").val().split("-"))
            $.get(
                "address?opt=queryArea",
                {
                    'code':$("#qu").val().split("-")[1]
                },
                function (data){
                    $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
                    let areas = JSON.parse(data);
                    for (let i in areas){
                        $('#area').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
                    }
                }
            )
        })

        //新增地址
        $("#new").click(function () {
            // alert(123465)
            $("#add").val("add")
            $.get(
                "address?opt=queryArea",
                {
                    'code':'000000'
                },
                function (data){
                    $("#name").val("")
                    $("#phone").val("")
                    $("#xaddr").val("")
                    $("#postcode").val("")
                    $("#pro")[0].innerHTML = '<option value="省份/自治区">省份/自治区</option>'
                    $("#city")[0].innerHTML = '<option value="城市/地区">城市/地区</option>'
                    $("#qu")[0].innerHTML = '<option value="区/县">区/县</option>'
                    $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
                    let areas = JSON.parse(data);
                    for (let i in areas){
                        $('#pro').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
                    }
                }
            )
            $(".mask").show();
            $(".adddz").show()
        });


        $(".delete").click(function (){
            // alert(window.location.href)
            let add = window.location.href
            add = add.replace("#", '')
            if (add.indexOf("instant") > -1){
                let part = add.substr(add.indexOf("instant")).split('&')
                window.location.href = "address?opt=delete&id="+$(this).attr("aid")+'&instant='+part[0].split("=")[1]+'&num='+part[1].split("=")[1]
            }else {
                window.location.href = "address?opt=delete&id="+$(this).attr("aid")
            }
        })

        $(".moren").click(function (){
            // alert($(this).attr("aid"))
            let url = window.location.href
            url = url.replace("#", '')
            if (url.indexOf("instant") > -1){
                let part = url.substr(url.indexOf("instant")).split('&')
                window.location.href = "address?opt=updateDef&id="+$(this).attr("aid")+'&instant='+part[0].split("=")[1]+'&num='+part[1].split("=")[1]
            }else {
                window.location.href = "address?opt=updateDef&id="+$(this).attr("aid")
            }
        })
    })
</script>
</body>
</html>