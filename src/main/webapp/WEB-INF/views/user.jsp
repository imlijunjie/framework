<%--
  Created by IntelliJ IDEA.
  User: Longruan
  Date: 2018/5/31
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common.jsp"/>
    <script>
        $(function () {
            $("#ttree").tree({
                url: '${pageContext.request.contextPath}/home/getZtreeJson',
                queryParams: {id: 0},
                lines: true,
                checkbox:true
            });
        });

        function getCheckNode() {
            var nodes = $('#ttree').tree('getChecked', ['checked','indeterminate']);
            parent.$.messager.alert('Info','选中：'+nodes.length);
        }
    </script>
</head>
<body>
    <a id="btn" onclick="getCheckNode()" class="easyui-linkbutton" data-options="plain:true">获取选中节点</a>
    <ul id="ttree">
    </ul>
</body>
</html>
