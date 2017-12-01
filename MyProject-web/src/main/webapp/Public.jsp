<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/16
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
<h2>宿舍公告</h2>
<button  style="background:darkkhaki;margin-top: 20px" id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
         type="button" onclick="openstu()"> 发布公告
</button>

<h3>公告信息</h3>


</body>
</html>
