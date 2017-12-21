<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/12/20
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body style="background-color: #afd9ee">
<h2>用户注册</h2>

<s:if test="#parameters.res[0]==1">
    <p style="color:green">注册成功！</p>
</s:if>
<s:elseif test="#parameters.res[0]==2">
    <p style="color:red">注册失败！</p>
</s:elseif>
<s:elseif test="#parameters.res[0]==3">
    <p style="color:red">用户名不能为空，密码长度为6-12位！</p>
</s:elseif>

<form style="margin-top: 40px;margin-left: 20px" action="userAction_addUser" method="POST">
   用户名:<input name="user.uname"/><br/>
   密 码:<input name="user.upwd"/><br/>
       <input type="submit" value="注册">
</form>


<a style="font-size: 15px" href="${pageContext.request.contextPath}/index.jsp">去登录</a>

</body>
</html>
