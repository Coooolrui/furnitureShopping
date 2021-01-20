<%--
  Created by IntelliJ IDEA.
  User: Mori
  Date: 2021/1/6
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <h1 class="fl">
                <a href="index.jsp"><img src="img/logo.png"/></a>
            </h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <c:choose>
                        <c:when test="${cookie.userid.value == null}">
                            <a href="login.jsp" id="login">登录</a>
                            <a href="reg.jsp" id="reg">注册</a>
                        </c:when>
                        <c:when test="${cookie.userid.value != null}">
                            <a>欢迎回来！！</a>
                            <a href="logReg?opt=exit">退出</a>
                        </c:when>
                    </c:choose>
                </p>
                <form class="fl">
                    <input type="text" id="searchinput" placeholder="热门搜索：客厅" value="${key != null ? key : ""}"/>
                    <input type="button" onclick="return false" id="start"/>
                </form>
                <div class="btn fl clearfix">
                    <a href="users?opt=myCenter"><img src="img/grzx.png"/></a>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <a href="carts?opt=queryAll"><img src="img/gwc.png"/></a>
                    <p>
                        <a href="#"><img src="img/smewm.png" style="width: 75px;height: 75px;"/></a>
                    </p>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="#">所有商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix">
                        <c:forEach items="${goodsMain}" var="good">
                            <a href="class?opt=one&parentId=${good.aClass.id}">
                                <dl>
                                    <dt><img src="img/${good.imgs[0]}"/></dt>
                                    <dd>${good.aClass.className}</dd>
                                </dl>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </li>

            <c:forEach items="${classMap}" var="item">
                <li>
                    <a href="class?opt=one&parentId=${item.value.get(0).parentId}">${item.key}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach items="${item.value}" var="n">
                                <a href="class?opt=tow&id=${n.id}">${n.className}</a>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(function (){
        $("#start").click(function (){
            if ($("#searchinput").val() != ""){
                window.location.href = "search?key="+$("#searchinput").val()
            }
        })
        $("#searchinput").keyup(function(event){
            if ($("#searchinput").val() != ""){
                if(event.keyCode == 13){
                    window.location.href = "search?key="+$("#searchinput").val()
                }
            }
            return false
        });
    })
</script>

