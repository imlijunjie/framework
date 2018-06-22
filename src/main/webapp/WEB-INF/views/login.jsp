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
<script>
    function randomcode_refresh(){
        var obj = document.getElementById("randomcode_img");
        obj.src = "${pageContext.request.contextPath}/validatecode.jsp?rnd"+Math.random();
    }
</script>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input id="randomcode" name="randomcode" size="8"><img style="cursor: pointer" src="${pageContext.request.contextPath}/validatecode.jsp" id="randomcode_img" onclick="randomcode_refresh()"></td>
        </tr>
        <tr>
            <td>自动登录：</td>
            <td><input type="checkbox" name="rememberMe"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
        <tr><td><a href="register.jsp">注册</a></td></tr>
        <tr>
            <td>${msg}</td>
            <td>${validateCode}</td>
        </tr>
    </table>
</form>
</body>
</html>
