
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>addEmp</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<form action="login" method="post">
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" placeholder="username" name="username" value="${user.username}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password" value="${user.password}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</body>
</html>