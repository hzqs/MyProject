<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/9
  Time: 20:06
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
<body style="background-color: #c8e5bc">


<h2>宿管详情</h2>
<s:if test="#parameters.res[0]==1">
    <p style="color:green">删除成功！</p>
</s:if>
<s:elseif test="#parameters.res[0]==2">
    <p style="color:red">删除失败！</p>
</s:elseif>

<button  style="background:yellowgreen;margin-top: 0px" id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
         type="button" onclick="gu()"> 添加宿管
</button>
<table id="mytab" class="table table-striped" style="margin-top: 30px">
    <caption style="color:royalblue">宿管详细信息:</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>宿管名</th>
        <th>电话</th>
        <th>管理</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<!--添加宿管-->

<form  id="aG" method="post" class="form-horizontal" role="form" style="position:absolute;background-color: #9acfea;height:130px;width:400px;margin-top:-300px;margin-left:330px;display: none">
    <div class="form-group has-success">
        <label class="col-sm-2 control-label" for="inputSuccess" style="font-size: 15px">名称:</label>
        <div class="col-sm-10">
            <input name="manager.mname" style="margin-top:10px;width: 200px;height: 28px" type="text" class="form-control" id="inputSuccess">
        </div>
    </div>

    <div class="form-group has-success">
        <label class="col-sm-2 control-label" for="inputSuccessd" style="font-size: 15px">电话:</label>
        <div class="col-sm-10">
            <input name="manager.mtel" style="width: 200px;height: 28px" type="text" class="form-control" id="inputSuccessd"><div id="addStuMessage" style="position:absolute;margin-left: 200px;margin-top: -20px"></div>
            <input type="button" value="添加" onclick="addManager()">
            <input type="button" value="取消" onclick="cance()"/>
        </div>
    </div>

</form>




<a href="${pageContext.request.contextPath}/main.jsp">返回主页</a>

</body>
</html>
<script type="text/javascript">

  $.post("managerAction_findManagerList","",function (data){
    $.each(data.magList,function(i,v){
        var tr="<tr>";
         tr+="<td>"+(i+1)+"</td>";
         tr+="<td>"+v.mname+"</td>";
         tr+="<td>"+v.mtel+"</td>";
         tr+="<td><a href='managerAction_findMangerById?manager.mno="+v.mno+"'>修改</a>&nbsp;|<a href='managerAction_deleteManager?manager.mno="+v.mno+"'>删除</a></td>"
         tr+="</tr>";
         $("#mytab").append(tr);
    });
  });

  function gu() {  //打开添加宿管的表单
      $("#aG").show();
  }
  function cance(){
      $("#aG").hide();//关闭添加宿管的表单
  }

  function addManager(){

       //用正则表达式验证手机号码
      var ok=true;
      var teg=/^1[358]\d{9}$/;
      var mtel=$("input[name='manager.mtel']");
      if(!teg.test(mtel.val())){
          $("#addStuMessage").css("color","red").html("电话格式不对");
          ok=false;
      }
      if(ok==true){
          var param=$("#aG").serialize();
          $.post("managerAction_addManager",param,function(data){
               if(data.res==1){
                   alert("添加成功");
               }else if(data.res==2){
                   alert("添加失败");
               }else if(data.res==3){
                   alert("添加内容不能为空");
               }
          });
      }




  }

</script>

