<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/12/25
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body style="background-color: antiquewhite">
<h2>宿舍学生信息列表</h2>
<br/>
<table border="1" width="400">
    <tr>
        <td>宿舍名</td>
        <td>学生名</td>
        <td>学生电话</td>
        <td>身份</td>
        <td>管理</td>
    </tr>
 <s:iterator  value="#request.stulistName" var="i"  >
         <tr>

                 <td>${i[0]}</td>
                 <td>${i[2]}</td>
                 <td>${i[3]}</td>
                 <td>${i[4]==0?"普通成员":"寝室长"}</td>
             <td>
                 <a href="roomAction_findStuById?stu.sno=${i[1]}">修改</a>
             </td>
         </tr>
 </s:iterator>
</table>
<br/>
<br/>

<a href="${pageContext.request.contextPath}/main.jsp">返回主页</a>
</body>
</html>
