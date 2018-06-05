<%--
  Created by IntelliJ IDEA.
  User: Longruan
  Date: 2018/6/5
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="WEB-INF/views/common.jsp"/>
<html>
<head>
    <title>Title</title>
    <script>
        function register() {
            $.post('user/doRegister',$("form").serialize(),function(r){
                if(r>0){
                    $.messager.show({
                        title:'My Title',
                        msg:'注册成功',
                        showType:'show'
                    });
                }else{
                    $.messager.show({
                        title:'My Title',
                        msg:'注册失败',
                        showType:'show'
                    });
                }
            })
        }
    </script>
</head>
<body>
<form method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="button" onclick="register()" value="注册">
    <input type="reset" value="取消">
</form>
</body>
</html>
