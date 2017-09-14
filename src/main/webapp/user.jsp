<%--新添加的标签库--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="first"></div>
<%--弹出的窗口;默认窗口隐藏;--%>
<div id="window_adduser" style="width: 400px;height: 300px;display: flex;justify-content: center;align-items: center;flex-flow: column" class="easyui-window"
     data-options="closed:true,modal:true">
    <form id="form_adduser" action="adduser.do" class="from-group">
        <input id="user_id" type="hidden" name="id" value="0">
        <div class="input-group" style="margin-bottom: 20px">
           <span class="input-group-addon">账号</span>
            <input name="account" class="form-control" type="text">
        </div>
        <div class="input-group" style="margin-bottom: 20px">
            <span class="input-group-addon">密码</span>
            <input name="pwd" class="form-control" type="password">
        </div>
    </form>
    <div>
        <button onclick="save()" class="btn btn-success btn-block">保存</button>
    </div>
    <div>
        <button onclick="fenp()" class="btn btn-success btn-block">分配权限</button>
    </div>
</div>
<div id="window_permission" class="easyui-window" style="width: 300px;height: 400px;" data-options="closed:true,modal:true">
    <div id="treegrid_permission"></div>
</div>
<div>
    <button onclick="saveParms()" class="btn btn-success btn-block">保存</button>
</div>
<script>
    function init() {
        //读取id 为first的div，创建表格。datagrid：数据表格
        $("#first").datagrid({
            pagination:true,//pagination分页。
            title: "用户管理", //标题
            url: "findAllUser.do",//供应数据的服务接口
            //定义表格的列
            columns: [[
                {field: "id", checkbox: true},
                {field: "account", title: "账号", width: 100},
                {field: "pwd", title: "密码", width: 100}
            ]],
            toolbar: [
                //handler:指定处理函数
                //判断是否有user：create权限
                <shiro:hasPermission name="user:create">
                {
                    text: "添加", iconCls: "icon-add", handler: function () { //icon-add:添加图标，icon:图标
                    openAdd();
                }
                },
                </shiro:hasPermission>
                <shiro:hasPermission name="user:edit">
                {
                    text: "修改", iconCls: "icon-edit", handler: function () {
                    edituser();
                }
                },
                </shiro:hasPermission>
                <shiro:hasPermission name="user:edit">
                {
                    text: "删除", iconCls: "icon-remove", handler: function () {
                    deleteUser();
                }
                },
                </shiro:hasPermission>
                <shiro:hasPermission name="user:fenp">
                {
                    "text":"分配权限",iconCls:"icon-searh",handler:function(){
                        fenp();
                }
                }
                </shiro:hasPermission>
            ]
        });
        load2(1, 2);
    }
    //    加载数据
    function load2(page, size) {
        $.get("findAllUser.do", {page: page, size: size}, function (data) {
            var json = JSON.parse(data);
//            填充数据
            $("#first").datagrid("loadData", json);
//            获取分页组件
            var pager = $("#first").datagrid("getPager");
            pager.pagination({
                total: 8,
                pageSize: 3,
                pageNumber: page,
                pageList: [1, 2, 3],
                //翻页时调用
                onSelectPage: function (page, size) {
                    load2(page, size);
                }
            });
        });
    }
    $(init);//页面渲染完毕再调用init()
    function openAdd() {
//        alert("123");
        $("#form_adduser").form("clear");
        $("#user_id").val(0);
        //打开窗口
        $("#window_adduser").window("open");
    }

    function save() {
        alert("hhh");
        //异步提交数据到adduser.do
        $("#form_adduser").form("submit", {
            //指定回调函数
            success: function (d) {
//                alert(d);
                //刷新
//                $("#first").datagrid("reload");
                load2(1,2);
                //关闭窗口
                $("#window_adduser").window("close");
            }
        });
    }
    //        删除多条数据

    function deleteUser() {
//            获取多条数据
        var data = $("#first").datagrid("getSelections");
        //声明一个数组，存放着所有的id
        var ids = new Array();
        for (var i = 0; i < data.length; i++) {
            //定义数组。减少数据传输量
            ids[i] = data[i].id;
        }
        //包装为json字符串，stringify()方法的作用是，把任何类型的数据包装成json,JSON是js自带的
        var json = JSON.stringify(ids);
        //提交json数据
        $.ajax({
            url: "deleteUser.do",//服务接口地址
            method: "post",      //请求方法，一般都是post方式提交
            data: json,          //提交数据
            contentType: "application/json",//指定所提交数据的格式。
            success: function (d) {
                //刷新
                alert("d");
//                $("#first").datagrid("reload");
                load2(1,2);
            }
        });
    }
    function deleteUser2() {
        //选中一条数据
        var data = $("#first").datagrid("getSelected");
        if (data) {
            //使用jQuery进行异步提交
            $.get("deleteUser2.do", {id: data.id}, function (d) {
                //刷新
                $("#first").datagrid("reload");
            });
        } else {
            //弹出对话框
            $.messager.alert("系统提示","请选择一条数据");
        }
    }
    //        修改用户
    function edituser() {
        var data = $("#first").datagrid("getSelected");
//            填充form表单
        $("#form_adduser").form("load", {
            id: data.id,
            account: data.account,
            pwd: data.pwd
        });
        //弹出窗口
        $("#window_adduser").window("open");
    }
    //分配权限
    function fenp() {
        $("#treegrid_permission").treegrid({
            idField:"id",
            treeField:"text",
            singleSelect:false,
            columns:[[
                {field:"id",title:"id",width:50,checkbox:true},
                {filed:"text",title:"资源名称",width:100},
                {filed:"url",title:"资源路径",width:100}
            ]]
        });
        $.get("findAllResForPerm.do",function (d) {
           var p2=/\"_parentId\":0/g;
           var data=d.replace(p2,"\"root\":0");
           var d2="{\"rows\":"+data+"}";
           alert(d2);
           var x=JSON.parse(d2);
           //填充数据
            $("#treegrid_permission").treegrid("loadData",x);
            $("#window_permission").window("open");
        });
    }
    function saveParms() {
        //要分配权限的用户
        var user=$("#first").datagrid("getSelected");
        var res=$("#treegrid_permission").treegrid("getSelections");
        var ds=[user.id];
        for (var i=0;i<res.length;i++){
            ds[i+1]=res[i].id;
        }
        var json=JSON.stringify(ds);
        $.ajax({
            url:"fenp.do",
            method:"post",
            data:json,
            contentType:"application/json",
            success:function (d) {
                $("#window_permission").window("close");
                $.messager.alert("系统提示","保存成功");
            }
        });
    }
</script>