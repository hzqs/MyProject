<%--
  Created by IntelliJ IDEA.
  User: hzq
  Date: 2017/11/8
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>我的项目</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含 bootstrap 样式表 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body style="background-color: #bce8f1">



 <s:if test="#parameters.res[0]==1">
     <script type="text/javascript">alert("添加成功");history.back();</script>
 </s:if>
 <s:elseif test="#parameters.res[0]==2">
     <script type="text/javascript">alert("添加失败");history.back();</script>
 </s:elseif>
 <s:elseif test="#parameters.res[0]==3">
     <script type="text/javascript">alert("请完善信息！");history.back();</script>
 </s:elseif>

 <button  style="background:cornflowerblue;margin-top: 20px" id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
          type="button" onclick="su()"> 添加宿舍
 </button>
 <button  style="background:darkkhaki;margin-top: 20px" id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
          type="button" onclick="openstu()"> 添加学生
 </button>
 <a href="Manager.jsp"><button  style="background:darkkhaki;margin-left:600px;margin-top: 20px" id="fat-btnv" class="btn btn-primary" data-loading-text="Loading..."
          type="button" > 宿管详情
 </button></a>
 <a href="Public.jsp"><button  style="background:darkkhaki;margin-left:960px;margin-top: -34px" id="fat-btns" class="btn btn-primary" data-loading-text="Loading..."
                             type="button" > 宿舍公告
 </button></a>

 <!--天气预报接口-->
 <div style="margin-left: 300px;margin-top: -30px">
     <iframe id="fancybox-frame" name="fancybox-frame1511698961802" frameborder="0" scrolling="no" hspace="0"
             src="http://i.tianqi.com/index.php?c=code&a=getcode&id=38&h=60&w=610"></iframe>
 </div>


 <table id="mytab" class="table table-striped" style="margin-top: -50px">
     <caption style="color:royalblue">宿舍信息:</caption>
     <thead>
     <tr>
         <th>宿舍名</th>
         <th>人数</th>
         <th>费用</th>
         <th>宿管</th>
         <th>管理</th>
     </tr>
     </thead>
     <tbody>
     <tr>
         <td>C栋413</td>
         <td>10</td>
         <td>1600</td>
         <td>杨阿姨</td>
         <td><a href="">修改</a></td>
     </tr>
     <tr>
         <td>C栋409</td>
         <td>6</td>
         <td>1360</td>
         <td>李宿管</td>
         <td><a href="">修改</a></td>
     </tr>
     </tbody>
 </table>


 <div style="color:#28a4c9;margin-left: 530px;margin-top: 250px;"><img src="${pageContext.request.contextPath}/images/9.png">欢迎使用!,祝您愉快</div>


<!-- 添加宿舍-->
 <form  id="room" method="post" action="roomAction_addRoom" class="form-horizontal" role="form" style="margin-top:-200px;margin-left:-100px;display: none">
     <div class="form-group has-success">
         <label class="col-sm-2 control-label" for="inputSuccessv" style="font-size: 15px">宿舍号:</label>
         <div class="col-sm-10">
             <input name="room.rname" style="width: 200px;height: 28px" type="text" class="form-control" id="inputSuccessv">
            分配宿管: <select name="room.manager.mno">
                 <option value="">请选择宿管</option>
             </select><br/>
             <button type="submit" class="btn btn-default">添加</button>
             <input type="button" value="取消添加" onclick="celroom()">
         </div>
     </div>
 </form>
 <!--添加学生-->
 <form  id="stu" method="post"  class="form-horizontal" role="form" style="margin-top:-250px;margin-left:-100px;display: none">
     <div class="form-group has-success">
         <label class="col-sm-2 control-label" for="inputSuccessu" style="font-size: 15px">学生名:</label>
         <div class="col-sm-10">
             <input name="stu.sname" style="margin-left:-12px;width: 200px;height: 28px" type="text" class="form-control" id="inputSuccessu"><div id="stun"></div>
         </div>
     </div>

     <div class="form-group has-success" style="margin-top: -10px">
         <label class="col-sm-2 control-label" for="inputSuccessut" style="font-size: 15px">学生性别:</label>
         <div style="margin-top: 6px">
         <input type="radio" value="男" name="stu.ssex"  id="inputSuccessut" checked>男
         <input type="radio" value="男" name="stu.ssex"  id="inputSuccessuts" >女
         </div>
     </div>

     <div class="form-group has-success" style="margin-top: -10px">
         <label class="col-sm-2 control-label" for="inputSuccessul" style="font-size: 15px">学生电话:</label>
         <div class="col-sm-10">
             <input name="stu.stel" style=";margin-top:5px;margin-left:-12px;width: 200px;height: 28px" type="text" class="form-control" id="inputSuccessul"><div id="message"></div>
         </div>
     </div>
     <div class="form-group has-success" style="margin-top: -10px">
         <label class="col-sm-2 control-label" for="inputSuccessus" style="font-size: 15px">学生身份:</label>
         <div class="col-sm-10" style="margin-top: 6px;margin-left: -12px">
             <input type="radio" value="普通成员" name="stu.status"  id="inputSuccessus" checked>普通成员
             <input type="radio" value="寝室长" name="stu.status"  id="inputSuccessutss" >寝室长
         </div>
     </div>
     <!--给学生分配宿舍-->
     <div class="form-group has-success" style="margin-top: -6px;margin-left: 200px">
         <div class="col-sm-10">
             分配宿舍: <select name="stu.room.rno">
                          <option value="">请选择宿舍</option>
                       </select><br/>
             <input type="button"  value="添加" onclick="addStu()"></input>
             <input type="button" value="取消添加" onclick="celStu()">
         </div>
     </div>
 </form>


</body>
</html>
<script type="text/javascript">


 function su(){  //打开添加宿舍的表单
       $("#room").show();
 }
 function celroom(){  //关闭添加宿舍的表单
     $("#room").hide();
 }

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

function openstu(){
    $("#stu").show();
}
function celStu(){
    $("#stu").hide();

}
function addStu(){

    //验证手机号码
    var teg=/^1[358]\d{9}$/;
    var zn=$("input[name='stu.stel']");
    var name=$("input[name='stu.sname']").val();
    var ok=true;
    if(!teg.test(zn.val())){
        $("#message").css("color","red").html("电话格式不对！");
         ok=false;
    }
    /*if(name==null&&name.length==0){
         $("#stun").css("color","red").html("学生名不能为空");
    }*/
    if(ok==true){
     var param=$("#stu").serialize();
        $.post("stuAction_addStu",param,function(data){
          if(data.message==1){
              alert("添加成功");
          }else if(data.message==2){
              alert("添加失败");
          }if(data.message==3){
              alert("请完善信息");
            }
        },"json");
    }

}

//查询出宿舍详细信息
  function findRoomInfo(){



  }
window.onload=findRoomInfo;

</script>


