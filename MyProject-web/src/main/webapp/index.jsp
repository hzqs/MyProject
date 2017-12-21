<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/6
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的项目</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body style="width: 100%;height: 100%">



<img  width="100%" height="100%" src="${pageContext.request.contextPath}/images/24.jpg">

<form class="form-horizontal" role="form" id="myform"  method="post" action="userAction_loginUser">

    <div class="form-group">
        <h2 style="margin-left: 140px;margin-top: -80px">学生宿舍管理系统</h2>
        <label for="firstname" class="col-sm-2 control-label">姓名:</label>

        <div class="col-sm-10">
            <input style="width: 200px" type="text" name="user.uname" class="form-control" id="firstname"
                   placeholder="请输入姓名">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-10">
            <input style="width: 200px" type="password"  name="user.upwd" class="form-control" id="lastname"
                   placeholder="请输入密码">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
            <a href="${pageContext.request.contextPath}/register.jsp"><input type="button" value="注册"></a>
        </div>
    </div>
</form>
</body>
</html>
<script type="text/javascript">

    $("#myform").css("margin-left","420px")
                .css("margin-top","-340px");

</script>
