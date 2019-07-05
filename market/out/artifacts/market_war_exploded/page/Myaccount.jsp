<%@ page import="com.Mybean" %>
<%@ page import="com.UpdateAccount" %><%--
  Created by IntelliJ IDEA.
  User: 79118
  Date: 2019/6/23
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.UpdateAccount" %>
<html>
<head>
    <title>Myaccount</title>
</head>
<body>
<div style="text-align:center;">
    <h1 style="color: #ff3c39">
        <%=(String)session.getAttribute("login")%>
    </h1>
    <jsp:useBean id="user" scope="page" class="com.Mybean" >
    </jsp:useBean>
    <%
        out.print("<h3 style=\"color: #36ff3c\">我的购物车</h3>");
        user.setName((String)session.getAttribute("login"));
        out.print(user.getGoods());
        out.print("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                "总价："+user.getsum()+"元<br>");
    %>
    <a href="/market_war_exploded/page/Altpass.jsp">更改密码</a>
    <a href="/market_war_exploded/com/account?op=O">下线</a>
    <a href="/market_war_exploded/com/account?op=U">注销账户</a>
    </div>
</body>
</html>
