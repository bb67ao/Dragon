<%--
  Created by IntelliJ IDEA.
  User: 79118
  Date: 2019/6/19
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Watermelon</title>
</head>
<body>
<div style="text-align:center;">
    <h1>黄河大西瓜</h1>
    <div class="imgbg">
        <img src="../img/j2.jpg" width="400" height="400">
    </div>
    <div class="price">
        <h1>￥20</h1>
    </div>
    <div class="introduce">
        <h2>
            <form action="/market_war_exploded/com/account?op=F&good=黄河大西瓜&price=20" method="post">
                <p>数量:<input type="text" name="number"></p>
                <input type="submit" value="购买">
            </form>
        </h2>
    </div>
    <div class="store">
        <h1 align="center" style="color: red">
            西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。
        </h1>

    </div>
</div>
</body>
</html>
