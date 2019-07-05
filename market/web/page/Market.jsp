<%--
  Created by IntelliJ IDEA.
  User: 79118
  Date: 2019/6/13
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <style type="text/css">
    .main{
      width: 1000px;
      height: 600px;
      /*border: 1px solid red;*/
      margin:0px auto;
    }
    div{
      /*border:1px solid green;*/
      font-size: 12px;
    }
    img{
      display: block;
    }
    .detail{
      font-size:0px;
    /* background: url(./img/coin.png) no-repeat 190px center;
      background-color: #f3f5f6;*/
      border:1px solid #e64ec0;
    }
    .details{
      display: inline-block;
      padding-right: 13px;
      border-right: 1px solid #e64ec0;
      text-align: center;
      text-indent: 1.2em;
    }
    .show{
      width: 220px;
      display: inline-block;
      margin-left: 20px;
    }
    .content{
      font-size: 0px;
      margin-bottom: 10px;
    }
    .price{
      font-size: 16px;
      color: red;
      font-weight: bold;
    }
    .store{
      color: #7F7F7F;
      text-decoration: underline;
      margin-bottom: 5px;
    }
    mark{
      background-color:transparent;
      color:#E5C45A;
    }
    span{
      color: #8236E5;
    }
  </style>
</head>
<body>
<h1 align="center" style="color: red">Welcome to my market</h1>
<%
    if (session.isNew()){
      session.setAttribute("login","0");
    }

    if (session.getAttribute("login").equals("0")){
    	out.print("<div style=\"text-align:center;\">\n" +
                "  <a href=\"Login.jsp\"><h2>Login</h2></a>\n" +
                "  <a href=\"Regist.jsp\"><h2>Regist</h2></a>\n" +
                "</div>");
    }
    else{
    	out.print("<h3 align=\"center\" style=\"color: deeppink\">\n" +
                "  <a href=\"/market_war_exploded/page/Myaccount.jsp\">\n" +
                session.getAttribute("login")+"\n" +
                "  </a>\n" +
                "</h3>");
    }
%>

<div class="main">
  <div class="content">
    <div class="show">
      <div class="imgbg">
        <img src="./img/j1.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥29.00
      </div>
      <div class="introduce">
        香甜猕猴桃
      </div>
      <div class="store">
        <a href="./goodsdetail/Kiwifruit.jsp">Goodsdetail</a>
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j2.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥20.00
      </div>
      <div class="introduce">
        黄河大西瓜
      </div>
      <div class="store">
          <a href="./goodsdetail/Watermelon.jsp">Goodsdetail</a>
      </div>
      <div class="detail">
        <div class="details">月成交2102笔</div>
        <div class="details">评价2192</div>

      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j3.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥35.00
      </div>
      <div class="introduce">
        紫火龙果
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j4.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥10.00
      </div>
      <div class="introduce">
        江西水蜜桃
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
  </div>
  <div class="content">
    <div class="show">
      <div class="imgbg">
        <img src="./img/j5.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥9.00
      </div>
      <div class="introduce">
        甜橙
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j6.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥8.00
      </div>
      <div class="introduce">
        灵宝大苹果
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交2102笔</div>
        <div class="details">评价2192</div>
        <div class="details">

        </div>
      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j7.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥29.00
      </div>
      <div class="introduce">
        海南木瓜
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
    <div class="show">
      <div class="imgbg">
        <img src="./img/j8.jpg" width="200" height="100">
      </div>
      <div class="price">
        ￥39.00
      </div>
      <div class="introduce">
        冰雪荔枝
      </div>
      <div class="store">
        贪玩蓝月
      </div>
      <div class="detail">
        <div class="details">月成交<mark>2102笔</mark></div>
        <div class="details">评价<span>2192</span></div>

      </div>
    </div>
  </div>
</div>
</body>
</html>

