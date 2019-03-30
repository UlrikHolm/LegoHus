<%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 28-03-2019
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
</head>
<body>
<h1>Ny opstart</h1>

<table>
    <tr><td>Login</td>
        <td>
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="command" value="login">
                Email:<br>
                <input type="text" name="email" value="someone@nowhere.com">
                <br>
                Password:<br>
                <input type="password" name="password" value="sesam">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        <td>Or Register</td>
        <td>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                Email:<br>
                <input type="text" name="email" value="someone@nowhere.com">
                <br>
                Password:<br>
                <input type="password" name="password1" value="sesam">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="sesam">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        <td>
            <form name="choice" action="FrontController" method="POST">
                <input type="hidden" name="command" value="choice">
                Byg hus:<br>
                <input type="submit" value="Submit">
            </form>
        </td>

    </tr>
</table>
<% String error = (String) request.getAttribute( "error");
    if ( error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>
</body>


</html>