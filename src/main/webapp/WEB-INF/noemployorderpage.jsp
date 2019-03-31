<%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 31-03-2019
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingen order til afsendelse</title>
</head>
<body>

<%
    String noOrder = (String) session.getAttribute("noOrder");
    out.println(noOrder);
%>

<td>
    <form name="choice" action="FrontController" method="POST">
        <input type="hidden" name="command" value="login">
        Return:<br>
        <input type="submit" value="Submit">
    </form>
</td>

</body>
</html>
