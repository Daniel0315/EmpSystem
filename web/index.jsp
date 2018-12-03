<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
在线人数：${num}人<br><a href="exit">退出</a>
<a href="emplist">员工管理</a>
<a href="deptlist">部门管理</a>
<div>
    <c:if test="${sessionScope.user == null}">
        未登录
    </c:if>
    <c:if test="${sessionScope.user != null}">
       你好，${sessionScope.user.username}
    </c:if>
</div>
</body>
</html>
