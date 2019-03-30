<%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 28-03-2019
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderConfirm</title>
</head>
<body>


Tak for din order.

<td>
    <form name="choice" action="FrontController" method="POST">
        <input type="hidden" name="command" value="choice">
        Byg hus:<br>
        <input type="submit" value="Submit">
    </form>
</td>

<td>
    <form name="choice" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout">
        Log Out:<br>
        <input type="submit" value="Submit">
    </form>
</td>

</body>
</html>
