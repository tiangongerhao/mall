<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6 0006
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>图表</title>
    <script src="js/echarts.js"></script>
    <script src="js/china.js"></script>
    <script>
        function bar() {
            //创建图表对象
            var chart=echarts.init(document.getElementById("first"));
            //指定参数
            var option={
                //指定x轴显示的项
                xAxis:{
                    data:["上海","北京","杭州","郑州"]
                },
                yAxis:{},
                series:{
                  type:"bar",
                    data:[10000,11000,9500,5000]
                }
            };
            chart.setOption(option);
        }
        function pie() {
            //创建图表的对象
            var chart=echarts.init(document.getElementById("first"));
            var option={
                tooltip:{
                    trigger:"item",
                    formatter:"{b}<br/>{c}"//b,c表示的都是数据的索引
                },
                series:{
                    type:"pie",
                    data:[
                        {name:"北京",value:2000},
                        {name:"上海",value:1800},
                        {name:"广州",value:1500},
                        {name:"深圳",value:1200}
                    ]
                }
            };
            chart.setOption(option);
        }
        //画图
      function draw() {
          var ca=document.getElementById("second");
          var d2=ca.getContext("2d");
          d2.fillStyle="red";
          //fillRect填充矩形
          d2.fillRect(30,30,100,100);
      }
      function map() {
          //创建图表对象  echarts简单图表 chart图表
          var chart=echarts.init(document.getElementById("first"));
          var option={
              series:[{ //series级联系列
                  type:"map",
                  mapType:"china"
              }]
          };
          chart.setOption(option);  //Option选项
      }
      function use() {
          //创建图表对象
          var chart=echarts.init(document.getElementById("first"));
          var option={
              tooltip:{
                  trigger:"item",
                  fomatter:"{b}"
              },
              geo:{map:"china"},
              series:[{
                  type:"effectScatter",//effectScatter：影响射散
                  coordinateSystem:"geo",
                  data:[
                      {name:"郑州",value:[113.65,34.76,300]}
                  ]
              }]
          };
          chart.setOption(option);
      }
    </script>
  </head>
  <body>
    <div id="first" style="width: 500px;height: 400px"></div>
    <button onclick="bar()">柱状图</button>
    <button onclick="pie()">饼状图</button>
    <button onclick="draw()">canvas</button>
    <button onclick="map()">地图</button>
    <button onclick="use()">使用地图</button>
  <div style="border: 1px solid red">
      <canvas id="second" style="width: 200px;height: 200px"></canvas>
  </div>
  </body>
</html>
