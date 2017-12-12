<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/16
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: azure">

<h2>修改宿管</h2>

<s:if test="#parameters.res[0]==1">
    <p style="color: green">修改成功</p>
</s:if>
<s:elseif test="#parameters.res[0]==2">
    <p style="color: green">修改失败</p>
</s:elseif>
<s:elseif test="#parameters.res[0]==3">
    <p style="color: green">宿管名不能为空</p>
</s:elseif>



<s:form method="post" action="managerAction_updateManager">
   <s:hidden name="manager.mno"/>
    宿管名:<s:textfield name="manager.mname"/><br/>
    宿管电话:<s:textfield name="manager.mtel"/><br/>
    <s:submit value="修改" />
</s:form>

<a href="${pageContext.request.contextPath}/Manager.jsp">返回上一页</a>
</body>
</html>
