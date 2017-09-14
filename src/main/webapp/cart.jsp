<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/30 0030
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>乐购商城购物车</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script>
        function deleteCart(id) {
            $.get("deleteCart.do",{id:id},function (d) {
                location.reload(true);
            });
        }
    </script>
</head>
<body>
    <h1>待付款的商品</h1><br/>
    <ul class="list-group">
        <%--遍历商品--%>
        <c:forEach items="${cart.show()}" var="item">
            <li class="list-group-item">
                <span>
                    ${item.name}
                </span>
                <span>
                    |
                </span>
                <span>
                    ${item.price}
                </span>
                <span>
                    |
                </span>
                <span>
                    ${item.num}
                </span>
                    |
                <span>
                    <a href="deleteCart.do?id=${item.id}" class="btn btn-danger">删除</a>
                </span>

            </li>
        </c:forEach>
        <li class="list-group-item">总价:${cart.total()}</li>
    </ul>
</body>
</html>
