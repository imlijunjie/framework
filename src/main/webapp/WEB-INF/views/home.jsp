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
    <script>
        $(function(){
            $("#etree").tree({
                url: 'home/getZtreeJson',
                lines:true
            });
        });
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:40px;background:#B3DFDA;">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'west',border:false" style="width:200px;background:#B3DFDA;">Logo</div>
            <div data-options="region:'east',border:false" style="width:100px;background:#B3DFDA;">
                <shiro:principal/>
                <a href="logout" style="display:block;text-decoration: none">注销</a>
            </div>
            <div data-options="region:'center',border:false" style="background:#B3DFDA;"></div>
        </div>
    </div>
    <div id="p" data-options="region:'west'" title="导航" style="width:200px;padding:0px;">
        <ul id="etree"></ul>
    </div>
    <div data-options="region:'center'">
    </div>
</body>
</html>
