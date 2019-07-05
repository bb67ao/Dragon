<%--
  Created by IntelliJ IDEA.
  User: 79118
  Date: 2019/6/18
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regist</title>
</head>
<body>
<h1 align="center" style="color: #e62d38">Regist for your account</h1>
<div style="text-align: center">
    <form action="/market_war_exploded/com/account?op=R" method="post">
        <p>Realname:<input type="text" name="rname"></p>
        <p>Username:<input type="text" name="uname"></p>
        <p>Password:<input type="password" name="password1"></p>
        <p>Ensure &nbsp;&nbsp;&nbsp;&nbsp; :<input type="password" name="password2"></p>
        <input type="submit" value="submit">
    </form>
</div>
</body>
</html>
