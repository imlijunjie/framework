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
    <style>
        #my_nav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #B3DFDA;
        }

        #my_nav > li {
            float: left;
        }

        #my_nav > li a {
            display: block;
            color: white;
            text-align: center;
            padding: 10px 10px 11px;
            text-decoration: none;
        }

        #my_nav > li a:hover:not(.active) {
            background-color: #4CAF50;
        }

        .active {
            background-color: #4CAF50;
        }
    </style>
    <script>
        $(function () {
            init();
        });

        function init(){
            loadNav();
        }

        //是否是叶子节点
        function isLeaf(target) {
            return $("#etree").tree('isLeaf', target);
        }

        //加载tabs
        function loadTab(node) {
            if ($('#tt').tabs('exists', node.text)){
                $('#tt').tabs('select', node.text);
            }else{
                if(node.obj.url){
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.obj.url+'" style="width:100%;height:100%;"></iframe>';

                }else {
                    var content = '空地址'
                }
                $('#tt').tabs('add',{
                    id:node.id,
                    title:node.text,
                    content:content,
                    closable:true
                });
            }
        }

        //加载顶层导航栏
        function loadNav(){
            $.get('home/getTopMenu',{id:0},function (r) {
                $.each(r,function () {
                    // $("#my_nav").append('<a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="loadTree('+this.id+')">'+this.name+'</a>')
                    $("#my_nav").append('<li><a id="'+this.id+'" href="javascript:;" onclick="loadTree('+this.id+')">'+this.name+'</a></li>')
                })
                $("#my_nav li:first-child a").addClass("active");
                loadTree($("#my_nav li:first-child a").attr('id'));
            });
        }



        //加载菜单
        function loadTree(id){
            $("#etree").tree({
                url: 'home/getZtreeJson',
                queryParams:{id:id},
                lines: true,
                onClick: function (node) {
                    console.info(node.text + isLeaf(node.target));
                    if (isLeaf(node.target)) {
                        loadTab(node);
                    }
                }
            });
        }

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
        <div data-options="region:'center',border:false">
            <ul id="my_nav"></ul>
        </div>
    </div>
</div>
<div id="p" data-options="region:'west'" title="导航" style="width:200px;padding:0px;">
    <ul id="etree"></ul>
</div>
<div data-options="region:'center',border:false">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true">
        <div title="首页" style="padding:10px">
            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
            <ul>
                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                <li>easyui provides essential functionality for building modem, interactive, javascript applications.
                </li>
                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by
                    writing some HTML markup.
                </li>
                <li>complete framework for HTML5 web page.</li>
                <li>easyui save your time and scales while developing your products.</li>
                <li>easyui is very easy but powerful.</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
