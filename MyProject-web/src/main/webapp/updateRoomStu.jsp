<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/12/26
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body style="background-color: #bce8f1">
<h2>修改宿舍学生信息</h2>
<br/>
<s:if test="#parameters.res[0]==1">
    <p style="color: green">修改成功</p>
</s:if>
<s:elseif test="#parameters.res[0]==2">
    <p style="color: green">修改失败</p>
</s:elseif>
<s:elseif test="#parameters.res[0]==3">
    <p style="color: green">请完善信息</p>
</s:elseif>

<s:form method="post" action="roomAction_updateRoomStu">
    <s:hidden name="stu.sno"/>
    学生姓名:<s:textfield name="stu.sname"/><br/>
    学生电话:<s:textfield name="stu.stel"/><br/>
     身份:<s:radio list="#{0:'普通成员',1:'寝室长'}"  name="stu.status" /><br/>
    分配宿舍: <select name="stu.room.rno">
    <option value="">请选择宿舍</option>
     </select><br/>
    <s:submit value="修改"/>
</s:form>

<a href="main.jsp">返回主页</a>


</body>
</html>
<script type="text/javascript">
    $(function(){
        //取出所有的宿舍
        $(":input[name='stu.room.rno'] option:not(:first)").remove();
        $.post("roomAction_findRoomList","",function(data){
            $.each(data.roomList,function(i,v){
                var option="<option value='"+v.rno+"'>"+v.rname+"</option>";
                $(":input[name='stu.room.rno']").append(option);
            });
        },"json");
    });

</script>