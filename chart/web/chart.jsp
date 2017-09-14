<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6 0006
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>迁徙图</title>
    <script src="js/echarts.js"></script>
    <script src="js/bmap.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Md7t9GlD2G2PcU9H48IxhQ0qsGTzoWeB"></script>
    <script>
        function show() {
            var chart=echarts.init(document.getElementById("first"));
            var option={
                tooltip:{
                    trigger:"item",
                    formatter:"{b}<br/>{c}"
                },
                bmap:{
                    center:[113.65,34.76],
                    zoom:5,
                    roam:true
                },
                series:[{
                    type:"effectScatter",
                    coordinateSystem:"bmap",
                    data:[
                        {name:"郑州",value:[113.65,34.76,300]}
                    ]
                }]
            };
            chart.setOption(option);
        }
        function qx() {
            var chart=echarts.init(document.getElementById("first"));
            var option={
                tooltip:{
                    trigger:"item",
                    formatter:"{b}<br/>{c}"
                },
                bmap:{
                    center:[113.65,34.76],
                    zoom:5,
                    roam:true
                },
                series:[{
                    type:"lines",
                    coordinateSystem:"bmap",
                    effect:{
                        show:true,
                        period:1,
                        trailLength:0.5,
                        color:'#1f3',
                        symbolSize:12
                    },
                    data:[
                        {fromName:"北京",toName:"上海",coords:[
                            [116.4551,40.2539],[121.4648,31.2891]
                        ]},
                        {fromName:"郑州",toName:"上海",coords:[
                            [113.65,34.76],[121.4648,31.2891]
                        ]},
                        {fromName:"乌鲁木齐",toName:"上海",coords:[
                            [87.68,43.77],[121.4648,31.2891]
                        ]},
                        {fromName:"广州",toName:"上海",coords:[
                            [113.23,23.16],[121.4648,31.2891]
                        ]},
                        {fromName:"银川",toName:"上海",coords:[
                            [106.27,38.47],[121.4648,31.2891]
                        ]},
                        {fromName:"齐齐哈尔",toName:"上海",coords:[
                            [123.97,47.33],[121.4648,31.2891]
                        ]},
                        {fromName:"成都",toName:"上海",coords:[
                            [104.06,30.67],[121.4648,31.2891]
                        ]}
                    ]
                }]
            };
            chart.setOption(option);
        }
    </script>
</head>
<body>
    <div id="first" style="height: 600px;width: 1000px"></div>
        <button onclick="show()">显示</button>
        <button onclick="qx()">迁徙图</button>
</body>
</html>
