<%@ page import="java.util.List" %>
<%@ page import="FunctionLayer.Order" %><%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 28-03-2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vis Order</title>
</head>
<body>

<%

    List<Order> tempOrder = (List<Order>) session.getAttribute("orderList");
    for (int i = 0; i <tempOrder.size() ; i++) {
        out.print(tempOrder.get(i).toString());
        %>
        </br>
        <%
    }
%>


</body>
</html>
