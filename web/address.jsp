<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>Coolrui</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<!------------------------------head------------------------------>
<jsp:include page="head2.jsp"></jsp:include>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.jsp" class="fl">首页</a><span>/</span>
        <a href="mygxin.jsp">个人中心</a><span>/</span>
        <a href="address.jsp" class="on">地址管理</a>
    </div>
</div>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="zuo.jsp"></jsp:include>
        <div class="you fl"><h2>收货地址</h2>
            <div class="add">
                <div>
                    <a href="#2" id="addxad">
                    <img src="img/jia.png"/></a><span>添加新地址</span>
                </div>
<%--                ${allAddress}--%>
                <c:forEach items="${allAddress}" var="address">
                    <div class="dizhi">
                        <p>${address.userName}</p>
                        <p>${address.userPhone}</p>
                        <p>${address.province.name}${address.city.name}${address.area.name}${address.street.name}</p>
                        <p>${address.userAddress}</p>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!--编辑弹框--><!--遮罩-->
<div class="mask"></div>
<div class="adddz">
    <form>
        <input type="text" placeholder="姓名" class="on"/>
        <input type="text" placeholder="手机号"/>
        <div class="city"><select name="">
            <option value="省份/自治区">省份/自治区</option>
        </select><select>
            <option value="城市/地区">城市/地区</option>
        </select><select>
            <option value="区/县">区/县</option>
        </select><select>
            <option value="配送区域">配送区域</option>
        </select></div>
        <textarea name="" rows="" cols="" placeholder="详细地址"></textarea>
        <input type="text" placeholder="邮政编码"/>
        <div class="bc">
            <input type="button" value="保存"/>
            <input type="button" value="取消"/>
        </div>
    </form>
</div>
<div class="readd">
    <form action="#" method="get">
        <input type="text" class="on" value="六六六"/>
        <input type="text" value="13717997174"/>
        <div class="city"><select name="">
            <option value="省份/自治区">广西省</option>
        </select><select>
            <option value="城市/地区">柳州市</option>
        </select><select>
            <option value="区/县">鱼峰区</option>
        </select><select>
            <option value="配送区域">双环大道</option>
        </select></div>
        <textarea name="" rows="" cols="" placeholder="详细地址">双福雅苑</textarea>
        <input type="text" placeholder="邮政编码" value=""/>
        <div class="bc">
            <input type="button" value="保存"/>
            <input type="button" value="取消"/>
        </div>
    </form>
</div><!--返回顶部-->
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