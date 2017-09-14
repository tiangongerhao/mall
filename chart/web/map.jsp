<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6 0006
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地图使用</title>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Md7t9GlD2G2PcU9H48IxhQ0qsGTzoWeB"></script>
    <script>
        var map;
        function show(data) {
            //创建地图对象
            map=new BMap.Map("first");
            //地图的中心点
            var point=new BMap.Point(116.404, 39.915);
            if(data){
                point=new BMap.Point(data.point.lng,data.point.lat);
            }
            //移动到中心点，15是比例尺
            map.centerAndZoom(point,12);
        }
        function dw() {
            //定位对象
            var l=new BMap.Geolocation();
            //获取当前位置
            l.getCurrentPosition(function (data) {
                show(data);
                address(data);
            });
        }
        function address(data) {
            //解析对象  coder：编码器   lng长度的缩写
            var c=new BMap.Geocoder();
            var p=new BMap.Point(data.point.lng,data.point.lat);
            c.getLocation(p,function (d) {
                alert(d.address);
            });
        }
        function search() {
            var sh=new BMap.LocalSearch(map,{
                renderOptions:{map:map,panel:x,autoViewport:true}
            });
            sh.searchNearby("川菜馆","纬五路");
        }
        function nav() {
            var n=new BMap.WalkingRoute(map,{
                renderOptions:{map:map,autoViewport:true}
            });
            n.search("火车站","紫荆山公园");
        }
    </script>
</head>
<body>
    <div id="first" style="width: 500px;height: 400px;"></div>
    <button onclick="show()">显示</button>
    <button onclick="dw()">定位</button>
    <button onclick="search()">搜索</button>
    <button onclick="nav()">导航</button>
    <div id="x" style="width: 500px;height: 400px"></div>
</body>
</html>
