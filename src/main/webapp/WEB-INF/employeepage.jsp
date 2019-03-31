<%@ page import="FunctionLayer.User" %>
<%@ page import="java.util.List" %><%--
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

    <%;
      User userNow = (User) session.getAttribute("user");
    %>

        <h1>Hello <% out.println(" " + userNow.getEmail());%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <td>
            <form name="choice" action="FrontController" method="POST">
                <input type="hidden" name="command" value="choice">
                Byg hus:<br>
                <input type="submit" value="Submit">
            </form>
        </td>

        <td>
            <form name="choice" action="FrontController" method="POST">
                <input type="hidden" name="command" value="showorder">
                Vis order:<br>
                <input type="submit" value="Submit">
            </form>
        </td>

        <td>
            <form name="choice" action="FrontController" method="POST">
                <input type="hidden" name="command" value="sendorder">
                <input type="hidden" name="source" value="user"/>
                Afsende order<br>


                <div class="col-md-3 text-center">
                    <label>Bruger</label>
                    <select class="form-control" name="userID">
                        <option value="0" disabled selected>Vælg user
                             <%
                                 List<User> userList =(List<User>) session.getAttribute("userList");

                                 for (int i = 0; i < userList.size() ; i++) {
                                    String userOption = "";
                                    //String navn = "lenght";
                                    String printUserID = Integer.toString(userList.get(i).getId());
                                    String printEmail = userList.get(i).getEmail();

                                    userOption = "<option value=\"_printUserID_\">_printEmail_</option>";
                                    userOption = userOption.replace("_printEmail_",printEmail);
                                    userOption = userOption.replace("_printUserID_",printUserID);
                                    out.println(userOption);
                                 }
                             %>


                    </select>
                </div>

                <div class="col-md-3 text-center">
                    <label>&zwnj;</label>
                    <input type="submit" name="selectUser" value="Vælg user" class="btn btn-success form-control"/>
                </div>

            </form>
        </td>


    </body>
</html>
