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
    <title>登录</title>
</head>
<style type="text/css" media="screen">
    html, body {
        margin: 0;
        padding: 0;
        border: 0;
        background: url("${pageContext.request.contextPath}/images/bg.jpg") no-repeat;
        background-size: 100%
    }

    #loginPanel {
        background: none;
        position: absolute;
        top: 50%;
        left: 50%;
        width: 270px;
        height: 160px;
        margin-left: -145px;
        margin-top: -80px;
    }

    .form-input{
        /*background: transparent;*/
        background-color: transparent;
        border: 1px solid rgba(255,255,255,0.2);
        /*box-shadow: inset 0 0 4px rgba(255,255,255,0.2),0 0 4px rgba(255,255,255,0.2);*/
    }

</style>
<script>
    function randomcode_refresh() {
        var obj = document.getElementById("randomcode_img");
        obj.src = "${pageContext.request.contextPath}/validatecode.jsp?rnd" + Math.random();
    }
</script>
<body>
<div id="loginPanel">
    <form action="login" method="post">
        <table>
            <tr>
                <td style="color: white">账号：</td>
                <td colspan="2"><input class="form-input" type="text" name="username" id="username"></td>
            </tr>
            <tr>
                <td style="color: white">密码：</td>
                <td colspan="2"><input class="form-input" type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td style="color: white">验证码：</td>
                <td><input class="form-input" id="randomcode" name="randomcode" size="8"></td>
                <td><img style="cursor: pointer" src="${pageContext.request.contextPath}/validatecode.jsp"
                         id="randomcode_img" onclick="randomcode_refresh()"></td>
            </tr>
            <tr>
                <td style="color: white">自动登录：</td>
                <td><input type="checkbox" name="rememberMe"></td>
            </tr>
            <tr>
                <td colspan="3"><input id="loginBtn" type="submit" value="登录" style="background: #0092DC;width: 100%;height: 30px"></td>
            </tr>
            <tr>
                <td><a href="register.jsp">注册</a></td>
            </tr>
            <tr>
                <td colspan="3">${msg}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
