
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加部门信息</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#dname").blur(function () {
                var dname=$(this).val();
                var res="/^[\u4e00-\u9fa5]{2,4}$/";
                if(res.test(dname)){
                    $(".checkDname").addClass("has-success");
                }else {
                    $(".checkDname").addClass("has-error");
                }
            })
            $("#location").blur(function () {
                var location=$(this).val();
                var res="/^[\u4e00-\u9fa5]{2,4}$/";
                if(res.test(location)){
                    $(".checkLocation").addClass("has-success").removeClass("has-error");
                }else {
                    $(".checkLocation").addClass("has-error").removeClass("has-success");
                }
            })
            $(".sub").click(function () {
                $(".add").submit();
            })

        })

    </script>
</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal add" action="addDept" method="post">
            <div class="form-group checkDname">
                <label for="dname" class="col-sm-2 control-label">部门名称</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="dname" placeholder="dname" name="dname">
                </div>
            </div>
            <div class="form-group checkLocation">
                <label for="location" class="col-sm-2 control-label">工作地点</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="location" placeholder="location" name="location">
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