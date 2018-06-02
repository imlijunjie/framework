<%--
  Created by IntelliJ IDEA.
  User: Longruan
  Date: 2018/5/31
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login"  method="post">
        账号：<input type="text" name="username" id="username">
        密码：<input type="password" name="password" id="password">

        <input type="submit" value="登录">
        <input type="reset" value="取消">
    </form>
    ${ex.printStackTrace()}
</body>
</html>
