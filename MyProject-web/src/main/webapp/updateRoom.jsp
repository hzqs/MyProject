<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/12/26
  Time: 19:50
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

<h2>修改宿舍信息</h2>
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

<form id="myform" method="POST">
      <input type="hidden" name="room.rno" value="${room.rno}"/>
    宿舍名：<input  name="room.rname" value="${room.rname}"/><br/>
    宿舍费用:<input name="room.rpay" value="${room.rpay}"/><br/>
    分配宿管: <select name="room.manager.mno">
    <option value="">请选择宿管</option>
            </select><br/>
     <input type="button" value="修改" onclick="updateRoom()">
</form>


<a href="main.jsp">返回主页</a>

</body>
</html>
<script type="text/javascript">
    $(function(){
        //取出所有的宿管
        $(":input[name='room.manager.mno'] option:not(:first)").remove();
        $.post("managerAction_findManagerList","",function(data){
            $.each(data.magList,function(i,v){
                var option="<option value='"+v.mno+"'>"+v.mname+"</option>";
                $(":input[name='room.manager.mno']").append(option);
            });
        },"json");
    });


    //修改宿舍信息
    function updateRoom() {

       var ok=true;
        var mn=$(":input[name='room.manager.mno']").val();
        var rn=$(":input[name='room.rname']").val();
        if(rn=null||rn.length==0){
            alert("请填写宿舍名");
            ok=false;
        }
        if(mn==null||mn.length==0){
            alert("请选择宿管");
            ok=false;
        }
        if(ok==true){
            var param=$("#myform").serialize();
             $.post("roomAction_updateRoom",param,function(data){
                 if(data.res==1){
                     alert("修改成功");;
                 }else if(data.res==2){
                     alert("修改失败");
                 }
             },"json");
        }



    }
</script>