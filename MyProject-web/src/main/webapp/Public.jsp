<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/16
  Time: 20:17
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
<body style="background-color: #faf2cc">
<h2>宿舍公告</h2>
<button  style="background:darkkhaki;margin-top: 20px" id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
         type="button" onclick="openAdd()"> 发布公告
</button>

<h3>公告信息</h3>
<s:if test="#parameters.res[0]==1">
    <p style="color:green">发布成功！</p>
</s:if>
<s:elseif test="#parameters.res[0]==2">
    <p style="color:red">发布失败！</p>
</s:elseif>
<s:elseif test="#parameters.res[0]==3">
    <p style="color:red">发布内容不能为空！</p>
</s:elseif>
<table id="mytab" border="1">
    <tr>
        <td><a href="javascript:selectAll()">全选/反选</a></td>
        <td>公告信息</td>
    </tr>


</table>
<input style="margin-left: 400px" type="button" value="删除" onclick="deleteInfo()"/>


<form id="pinfo" method="post" action="${pageContext.request.contextPath}/roominfoAction_addRoomInfo" style="height:100px;width:400px;background-color: #ec971f;margin-left: 250px;margin-top: -340px;display: none">
    <div style="margin-top: 20px">公告内容：</div>
    <div style="margin-left: 80px;margin-top: -10px">
        <textarea name="roomPubInfo.rinfo" id="" cols="40" rows="2"></textarea></div>
       <input type="submit" value="发布" style="margin-left: 20px">
       <input type="button" value="取消" style="" onclick="cancel()">

</form>



</body>
</html>
<script type="text/javascript">
    function openAdd(){
      $("#pinfo").show();

    }
    function cancel(){

        $("#pinfo").hide();

    }

    function selectAll(){
        if($(":checkbox:checked").length>0){
            $(":checkbox").prop("checked",false);
        }else{
            $(":checkbox").prop("checked",true);
        }
    }
  function Data() {
     $.post("roominfoAction_findRoomInfo","",function (data) {
         $.each(data.roominfolist,function(i,v){
             //日期转换
             var date=new Date();
             var now = "";
             now = date.getFullYear()+"-"; //读英文就行了
             now = now + (date.getMonth()+1)+"-";//取月的时候取的是当前月-1如果想取当前月+1就可以了
             now = now + date.getDate()+" ";
             now = now + date.getHours()+":";
             now = now + date.getMinutes()+":";
             now = now + date.getSeconds()+"";

             var tr="<tr>";
                 tr+="<td><input name='rno' value="+v.rno+" type='checkbox'>"+"</td>";
                 tr+="<td>"+v.rinfo+":&nbsp &nbsp &nbsp"+now+"</td>";
                 tr+="</tr>";
                 $("#mytab").append(tr);
         });
     },"json");
  }

    function deleteInfo(){
        var ids=$(":checkbox:checked");
        if(ids.length==0){
            alert("请选择要删除的公告");
        }else{
            var param=$(":checkbox").serialize();
             $.post("roominfoAction_deleteRoomInfo",param,function(data){
               if(data.res==1){
                   alert("删除成功");
               }else{
                   alert("删除失败");
               }
             },"json");
        }
    }
    window.onload=Data;
</script>