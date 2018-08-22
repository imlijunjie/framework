<%--
  Created by IntelliJ IDEA.
  User: Longruan
  Date: 2018/5/31
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common.jsp"/>
    <script>
        $(function () {
            $("#my_table").datagrid({
                url: "${pageContext.request.contextPath}/sys/getSysUserList",
                width: "100%",
                fit: true,
                border:false,
                striped: true,     //交替行换色
                pagination: true,  //显示底部分页
                fitColumns: true,//自动适应。先给列随便加个宽度
                toolbar: "#toolbar"
            });
        });
    </script>
</head>
<body>
<table id="my_table">
    <thead>
    <tr>
        <th field="id" width="100" align="center" checkbox="true"></th>
        <th field="username" width="100">用户名</th>
        <th field="status" width="100" align="center">状态</th>
        <th field="registerTime" width="100" align="center">注册时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <shiro:hasPermission name="user:add">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增用户</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:edit">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑用户</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:del">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除用户</a>
    </shiro:hasPermission>
</div>
</body>
</html>
