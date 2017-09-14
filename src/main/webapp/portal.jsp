<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/30 0030
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>

</head>
<body>
<%--设计样式--%>
    <div style="margin: 100px 100px;width:80%">
        <ul class="list-group">
            <c:forEach items="${commos}" var="item">
                <%--输出内容--%>
                <li class="list-group-item">
                    <span>
                        ${item.name}
                    </span>
                    <%--|平分空间--%>
                        |
                    <span>
                        ${item.price}
                    </span>
                        |
                    <span>
                        <a href="toCart.do?id=${item.id}" class="btn btn-danger">购买</a>
                    </span>
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
