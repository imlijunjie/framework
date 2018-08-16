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
    <title>Framework</title>
    <jsp:include page="common.jsp"/>
    <style>
        #my_nav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: dodgerblue;
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
            background-color: royalblue;
        }

        .active {
            background-color: royalblue;
        }
    </style>
    <script>
        $(function () {
            init();
        });

        function init() {
            loadNav();
            $("#my_nav").on("click", "li", function () {
                console.info($(this).text());
                if (!$(this).hasClass('active')) {
                    loadTree($(this).children("a:first").attr('id'));
                }
                $(this).addClass("active").siblings().removeClass("active");
            });
        }

        //是否是叶子节点
        function isLeaf(target) {
            return $("#etree").tree('isLeaf', target);
        }

        //加载tabs
        function loadTab(node) {
            if ($('#tt').tabs('exists', node.text)) {
                $('#tt').tabs('select', node.text);
            } else {
                if (node.obj.url) {
                    var content = '<iframe scrolling="auto" frameborder="0"  src="' + node.obj.url + '" style="width:100%;height:100%;"></iframe>';

                } else {
                    var content = '空地址'
                }
                $('#tt').tabs('add', {
                    id: node.id,
                    title: node.text,
                    content: content,
                    closable: true
                });
            }
        }

        //加载顶层导航栏
        function loadNav() {
            $.get('home/getTopMenu?random='+Math.random(), {id: 0}, function (r) {
                $.each(r, function () {
                    $("#my_nav").append('<li><a id="' + this.id + '" href="javascript:;" >' + this.name + '</a></li>')
                });
                //选中第一个导航
                $("#my_nav li:first").addClass("active");
                //加载第一个导航下属菜单
                loadTree($("#my_nav li:first-child a").attr('id'));
            });
        }

        //加载菜单
        function loadTree(id) {
            $("#etree").tree({
                url: 'home/getZtreeJson',
                queryParams: {id: id},
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
<div data-options="region:'north',border:false" style="height:40px;background:dodgerblue">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',border:false" style="width:200px;background:dodgerblue;color: white;">Logo</div>
        <div data-options="region:'east',border:false" style="width:100px;background:dodgerblue;color: white;">
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
        </div>
    </div>
</div>
</body>
</html>
