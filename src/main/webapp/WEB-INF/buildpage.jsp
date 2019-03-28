

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<div class="container bg-white pt-4">

    <div class="row">
        <div class="col text-center">
            <h2>Vælg og bestil her:</h2>
            </br>
        </div>
    </div>
    <form action="FrontController" method="post">
        <input type="hidden" name="command" value="build"/>
        <div class="row">

            <div class="col-md-3 text-center">
                <label>Længde:</label>
                <select class="form-control" name="length">
                    <option value="0" disabled selected>Vælg værdi
                             <%
         
                                 for (int i = 8; i < 41 ; i++) {
                                 String lenghtOption = "";
                                 //String navn = "lenght";
                                 String tal = Integer.toString(i);

                                 lenghtOption = "<option value=\"length\">numberI</option>";
                                 lenghtOption = lenghtOption.replace("length",tal);
                                 lenghtOption = lenghtOption.replace("numberI",tal);
                                 out.println(lenghtOption);
                             }
                             %>
         
                </select>
            </div>

            <div class="col-md-3 text-center">
                <label>Bredde:</label>
                <select class="form-control" name="width">
                    <option value="0" disabled selected>Vælg værdi
                    <%

                        for (int i = 8; i < 31 ; i++) {
                        String lenghtOption = "";
                        //String navn = "width";
                        String tal = Integer.toString(i);

                        lenghtOption = "<option value=\"width\">numberI</option>";
                        lenghtOption = lenghtOption.replace("numberI",tal);
                        lenghtOption = lenghtOption.replace("width",tal);
                        out.println(lenghtOption);
                    }
                    %>

                </select>
            </div>





        <div class="col-md-3 text-center">
            <label>Højde:</label>
            <select class="form-control" name="height">
                <option value="0" disabled selected>Vælg værdi
                     <%

                        for (int i = 1; i < 21 ; i++) {
                        String heightOption = "";
                        //String navn = "width";
                        String tal = Integer.toString(i);

                        heightOption = "<option value=\"height\">numberI</option>";
                        heightOption = heightOption.replace("numberI",tal);
                        heightOption = heightOption.replace("height",tal);
                        out.println(heightOption);
                    }
                    %>

            </select>
        </div>


            <div class="col-md-3 text-center">
                <label>&zwnj;</label>
                <input type="submit" name="loginknap" value="Beregn"/>
            </div>
        </div>
    </form>
    <div class="row pt-4">
    </div>
</div>
</body>
</html>
