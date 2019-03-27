Created by IntelliJ IDEA.
User: slamr
Date: 12-03-2019
Time: 10:03
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>betaling</title>
</head>
<body>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<form action="FrontController" method="post">
    <input type="hidden" name="command" value="order"/>

<div class="container bg-white">

    <div class="row">
        <div class="col text-center">
            </br>
            <h1>Blok-oversigt</h1>
            <table>
            <%
            int block4 = (int) session.getAttribute("block4");
            int block2 = (int) session.getAttribute("block2");
            int block1 = (int) session.getAttribute("block1");
            %>

            <tr>
                <td>Antal blok 4 knop</td><td>Antal blok 2 knop</td><td>Antal blok 1 knop</td>
            </tr>
            </br>
            <tr>
                <td><%out.print(block4);%></td><td><% out.print(block2);%></td><td><% out.print(block1);%></td>
            </tr>


            <%
                int height = (int) session.getAttribute("height");
                String[] printAll = (String[]) session.getAttribute("printAll");
                for (int i = 0; i <height+2 ; i++) {
                    out.print(printAll[i]);
            %>
                    </br>
            <%
                }
            %>
            </table>
        </div>
    </div>

    <div class="col-md-3 text-center">
        <label>&zwnj;</label>
        <input type="submit" name="loginknap" value="Bestil"/>
    </div>

</div>
</form>
</body>
</html>

