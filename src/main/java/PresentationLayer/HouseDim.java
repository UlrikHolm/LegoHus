package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.LoginSampleException;
import javafx.beans.property.IntegerProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HouseDim extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String lenght = request.getParameter("lenght");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        House house = new House(Integer.valueOf(lenght),Integer.valueOf(width),Integer.valueOf(height));

        return null;
    }
}
