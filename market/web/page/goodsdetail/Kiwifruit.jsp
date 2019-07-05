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
    <title>Kiwifruit</title>
</head>
<body>
<div style="text-align:center;">
    <h1>香甜猕猴桃</h1>
<div class="imgbg">
    <img src="../img/j1.jpg" width="400" height="400">
</div>
<div class="price">
    <h1>￥39</h1>
</div>
<div class="introduce">
    <h2>
        <form action="/market_war_exploded/com/account?op=F&good=香甜猕猴桃&price=39" method="post">
            <p>数量:<input type="text" name="number"></p>
            <input type="submit" value="购买">
        </form>
    </h2>
</div>
<div class="store">
    <h1 align="center" style="color: red">
        猕猴桃的质地柔软，口感酸甜。味道被描述为草莓、香蕉、菠萝三者的混合。猕猴桃除含有猕猴桃碱、蛋白水解酶、单宁果胶和糖类等有机物，以及钙、钾、硒、锌、锗等微量元素和人体所需17种氨基酸外，还含有丰富的维生素C、葡萄酸、果糖、柠檬酸、苹果酸、脂肪。
    </h1>
</div>
</div>
</body>
</html>
