<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="cate-datagrid"></div>
<div id="window_addCate" class="easyui-window" data-options="closed:true,modal:true" style="width: 300px;height:300px">
    <form id="form_cate" class="form-group">
        <div class="input-group">
            <span class="input-group-addon">类别名称</span>
            <input class="form-control" name="text" id="form_cate_text"/>
        </div>
    </form>
    <div>
        <button onclick="save_cate()" class="btn btn-success btn-block">保存</button>
    </div>
</div>
    <script>
        function cate_init() {
            $("#cate_datagrid").treegrid({
                //title:"分类管理",
                //url:"findAllCate.do",
                idField:"id",
                treeField:"text",
                columns:[[
                    {field:"id",title:"id",width:100},
                    {field:"text",title:"名称",width:100}
                ]],
            toolbar:[
                {text:"添加",iconCls:"icon-add",handler:function () {
                    addCate();
                }}
            ]
            });
            cate_load();
        }
        cate_init();
        function cate_load() {
            //异步加载数据
            $.get("findAllCate2.do",function (data){
              // var x=data.replace("parentId","_parentId");
                //定义正则表达式；g:表示全部
               var p1=/pid/g;
               //把符合p1的字符串替换为_parentId
                var x = data.replace(p1,"_parentId");
                var p2=/\"_parentId\":0/g;
                var y = x.replace(p2,"\"root\":0");
                //将string转换为json
                var json=JSON.parse(y);
                alert("replace");
                //填充数据到grid
                $("#cate_datagrid").treegrid("loadData",json);
            });
        }
        function addCate() {
            $("#window_addCate").window("open");
        }
        function save_cate() {
            //；类别名称
            var name=$("#form_cate_text").val();
            var parent=$("#cate_datagrid").treegrid("getSelected");
            $.post("addCate.do",{text:name,pid:parent.id},function (d) {
                //刷新列表
                cate_load();
                $("#window_addCate").window("close");
            });
        }
    </script>


