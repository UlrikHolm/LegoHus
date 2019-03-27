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
<div class="container bg-white">
    <div class="row">
        <div class="col text-center">
            </br>
            <h1>Blok-oversigt</h1>

            <%int block4 = (int) session.getAttribute("block4");%>
            <b>Antal blok 4 knop =  </b><%out.print(block4);%>
            </br>

            <%int block2 = (int) session.getAttribute("block2");%>
            <b>Antal blok 2 knop =  </b><%out.print(block2);%>
            </br>

            <%int block1 = (int) session.getAttribute("block1");%>
            <b>Antal blok 1 knop =  </b><%out.print(block1);%>
            </br>

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

        </div>
    </div>
    <div class="row">
        <div class="col text-center">
            <form action="/bestil" method="get">
                <input class="btn btn-success" type="submit" value="Skal jeg bruges">
            </form>
        </div>
    </div>
    </br>
</div>
</body>
</html>

