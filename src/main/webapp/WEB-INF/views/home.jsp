<%--
  Created by IntelliJ IDEA.
  User: Longruan
  Date: 2018/6/1
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Platform Demo</title>
    <jsp:include page="common.jsp"/>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
        <shiro:principal/>
        <a href="logout" style="display: block;text-decoration: none">注销</a>
    </div>
    <div id="p" data-options="region:'west'" title="导航" style="width:200px;padding:10px">
        <p>width: 200px</p>
    </div>
    <div data-options="region:'center'">
    </div>
</body>
</html>
