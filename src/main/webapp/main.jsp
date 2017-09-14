<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/24 0024
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台首页</title>
    <link  rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script>
        function init() {
            $("#tree_left").tree({
                onClick: function (node) {
                    //判断指定名称的tab是否存在
                    var isHad = $("#work").tabs("exists", node.text);
                    //存在就打开
                    if (isHad) {
                        $("#work").tabs("select", node.text);
                    } else {
                        //创建
                        $("#work").tabs("add", {
                            title: node.text,
                            closable: true,
                            href: node.url  //把目标页面的内容异步加载到当前页面
                        });
                    }
                }
            });
        }
        $(init);//页面渲染完毕再调用init()函数;
    </script>
</head>
<body>
<div class="easyui-layout" style="width: 100%;height: 100%;">
    <div data-options="region:'north'" style="width: 100%;height: 100px;background-color: #555">
        <p class="text-right" style="color: white"><a href="logout.do">退出</a></p>
    </div>
    <div data-options="region:'north'" style="width: 100%;height: 100px;background-color: #3c763d ;display: flex;align-items: center;justify-content: center" >
        <h1>欢迎来到冒险岛</h1>
    </div>
    <div data-options="region:'west'" style="width: 20%;height: 100%;">
        <ul id="tree_left" class="easyui-tree" data-options="url:'findAllRes.do'"></ul>
    </div>
    <div id="work" data-options="region:'center'" class="easyui-tabs" style="height: 100%;margin-left: -1px"></div>
</div>
</body>
</html>






