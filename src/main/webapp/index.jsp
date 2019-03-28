<%@ page import="java.util.ArrayList" %><%--
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to Sem 2</h1>
        
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

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



        <div class="form-group">
            <select class="custom-select">
                <option selected="">Open this select menu</option>

                <c:forEach items="${requestScope.navnPÅListe}" var="ListeElement" >

                    <option value=${ListeElement.EnMetode()}> ${ListeElement.EnMetode()}   </option>

                </c:forEach>
            </select>
        </div>




        ____________________


        <%
            ArrayList<String> numList = new ArrayList<>();
            numList.add("en");
            numList.add("to");
            numList.add("tre");
            session.setAttribute("numList", numList);
        %>

        <c:forEach items="${numList}" var="tal" >
            <c:out value= "${tal}"  ></c:out>

        </c:forEach>



    </body>
</html>
