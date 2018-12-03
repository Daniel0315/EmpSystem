<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加员工信息</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
       $(function () {
           var isName;
           var isPhone;

           $("#name").blur(function () {
               var name=$(this).val();
              var rep=/^[\u4e00-\u9fa5]{2,4}$/;
              if(rep.test(name)){
                  $(".checkName").addClass("has-success").removeClass("has-error");
                  isName=true;
              }else{
                  $(".checkName").addClass("has-error").removeClass("has-success");
                  isName=false
              }
           })
           $("#phone").blur(function () {
               var phone=$(this).val();
               var rep=/^[1][3,5,7,8][0-9]{9}$/;
               if(rep.test(phone)){
                   $(".checkPhone").addClass("has-success").removeClass("has-error");
                   isPhone=true;
               }else{
                   $(".checkPhone").addClass("has-error").removeClass("has-success");
                   isPhone=false;
               }
           })
           $("#salary").blur(function () {
               var salary=$(this).val();
               var rep=/^[0-9]{1,}$/;
               if(rep.test(salary)){
                   $(".checkSalary").addClass("has-success").removeClass("has-error");
               }else{
                   $(".checkSalary").addClass("has-error").removeClass("has-success");
               }
           })
           $(".sub").click(function () {
               if(isName&&isPhone){
                   $(".add").submit()
               }
               else{
                   if(!isName){
                       alert("名字格式输入错误!");
                   }
                   else if (!isPhone){
                       alert("手机号码格式输入错误！");
                   }else if(!isPhone&&!isName){
                       alert("名字格式输入错误!");
                       alert("手机号码格式输入错误！");
                   }
               }
           })
       })

    </script>
</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal add" action="addEmp" method="post">
            <div class="form-group checkName">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" placeholder="name" name="name">
                </div>
            </div>
            <div class="form-group checkPhone">
                <label for="phone" class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="phone" placeholder="phone" name="phone" onkeyup="value=value.replace(/[^\d]/g,'')">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>
                <div class="col-sm-6">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio1" value="男" checked> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
                    </label>

                </div>
            </div>

            <div class="form-group checkSalary">
                <label for="salary" class="col-sm-2 control-label">薪资</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="salary" placeholder="salary" name="salary"  onkeyup="value=value.replace(/[^\d]/g,'')">
                </div>
            </div>

            <div class="form-group">
                <label for="salary" class="col-sm-2 control-label">部门</label>
                <div class="col-sm-6">
                    <select class="form-control" name="dept_id">
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.dept_id}">${dept.dname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-primary sub">提交</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>