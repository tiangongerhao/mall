<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/29 0029
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <link rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script>
        function upload() {
            var x=new FormData(decument.getElementById("first"));
            $.ajax({
                url:"upLoad.do",
                methods:"post",
                data:x,
                contentType:false,
                processData:false,
                success:function (d) {
                    alert(d);
                }
            });
        }
    </script>
</head>
<body>
    <div style="width: 300px;height: 400px;margin: 10px 100px">
        <form id="first" action="/upLoad.do" method="post" enctype="multipart/form-data">
            <input type="file" name="ff"/>
        </form>
        <button onclick="upload()" class="btn btn-success btn-block">上传</button>
    </div>
</body>
</html>
