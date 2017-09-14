<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/28 0028
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script>
        function commo_init() {
            alert("bbbbbbbbbb"),
                $("#commodity_datagrid").datagrid({
                    url: "findAllCommo.do",
                    columns: [[
                        {field: "id", checkbox: true},
                        {field: "name", title: "名称", width: 100},
                        {field: "catagoryid", title: "类别", width: 100}
                    ]],
                    toolbar: [
                        {
                            text: "添加", iconCls: "icon_add", handler: function () {
                            addCommo();
                        }
                        },
                        {
                            text: "上传图片", iconCls: "icon-save", handler: function () {
                            uploadImage();
                        }
                        }
                    ]
                });
            //初始化编辑器  CKEDITOR：在线编辑器
            CKEDITOR.replace("commo_content");
        }
        $(commo_init);
        function addCommo() {
            $("#window_addCommo").window("open");
        }
        function sava_commo() {
            var data = CKEDITOR.instances.commo_content.getData();
            $("#commo_content_hidden").val(data);
            $("#form_commo").form("submit", {
                success: function (d) {
                    alert("添加成功！");
                }
            });
        }
        //打开窗口
        function uploadImage() {
            $("#window_uploadImage").window("open");
        }
        alert("123");
        function upload() {
            var x = new FormData(document.getElementById("first"));
            var commodity = $("#commodity_datagrid").datagrid("getSelected");
            //添加指定商品的id
            x.append("commodityId", commodity.id);
            alert("hhhhhhhhh");
            $.ajax({
                url: "upload.do",
                method: "post",
                data: x,
                contentType: false,
                processData: false,
                success: function (d) {
                    alert("添加成功！");
                }
            });
        }
        alert("qqqqqqq");
    </script>
</head>
<body>
<div id="commodity_datagrid"></div>
<div id="window_addCommo" class="easyui-window" data-options="closed:true,modal:true"
     style="width: 80%;height: 600px;padding: 30px 30px">
    <form id="form_commo" action="addCommo.do" method="post">
        <input type="hidden" id="commo_content_hidden" name="content"/>
        <div style="margin-bottom: 20px">
            <input name="name" class="easyui-textbox" data-options="prompt:'请输出名称'"
                   style="width: 100%;height: 100%;height:30px"/>
        </div>
        <div style="margin-bottom: 20px">
            <input name="categoryid" class="easyid-combotree" style="width: 100%;height: 30px"
                   data-options="url:'findAllCate.do',prompt:'请选择类别'"/>
        </div>
    </form>
    <textarea style="width: 100%;height: 400px" rows="3" cols="3" class="ckeditor" name="commo_content"></textarea>
    <div>
        <button onclick="sava_commo()" class="bun btn-success btn-block">保存</button>
    </div>
</div>
<%--上传文件窗口--%>
<div id="#window_uploadImage" class="easyui-window" data-options="closed:true,modal:true">
    <div style="width: 300px;height: 400px;margin: 10px 100px">
        <form id="first" action="/upLoad.do" method="post" enctype="multipart/form-data">
            <input type="file" name="ff"/>
        </form>
        <button onclick="uploadImage()" class="btn btn-success btn-block">上传123</button>
    </div>
</div>
</body>
</html>
