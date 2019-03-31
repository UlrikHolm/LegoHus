<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 30-03-2019
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderEkspedition</title>
</head>
<body>

<td>
    <form name="choice" action="FrontController" method="POST">
        <input type="hidden" name="command" value="sendorder">
        <input type="hidden" name="source" value="order"/>
        Afsende order<br>


        <div class="col-md-3 text-center">
            <label>Bruger</label>
            <select class="form-control" name="orderID">
                <option value="0" disabled selected>Vælg order

                <%
                       HashMap<String, String> userOrderList =
                                  (HashMap<String, String>) session.getAttribute("userOrder");

                       for (String i : userOrderList.keySet()) {
                           //System.out.println("key: " + i + " value: " + userOrderList.get(i));
                           String userOrderOption = "";
                           String printOrderID = i;
                           String printOrder = userOrderList.get(i);
                           userOrderOption = "<option value=\"_printOrderID_\">_printOrder_</option>";
                           userOrderOption = userOrderOption.replace("_printOrder_",printOrder);
                           userOrderOption = userOrderOption.replace("_printOrderID_",printOrderID);
                           out.println(userOrderOption);
                           }

                %>

                    <div class="col-md-3 text-center">
                        <label>&zwnj;</label>
                        <input type="submit" name="selectOrder" value="Vælg order" class="btn btn-success form-control"/>
                    </div>

                  </select>
        </div>
    </form>
</td>

</body>
</html>
