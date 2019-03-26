package PresentationLayer;

import FunctionLayer.Calculate;
import FunctionLayer.House;
import FunctionLayer.LoginSampleException;
import javafx.beans.property.IntegerProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HouseDim extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i HouseDim");
        String lenght = (request.getParameter("lenght"));
        String width = (request.getParameter("width"));
        String height = (request.getParameter("height"));

        System.out.println("Længde som streng = "+lenght);
        System.out.println("Bredde som streng = "+width);
        System.out.println("Højde som streng = "+height);


        int lenghtI = Integer.parseInt(lenght);
        int widthI = Integer.parseInt(width);
        int heightI = Integer.parseInt(height);


        House house = new House(lenghtI, widthI, heightI);

        int[] sumBlocks = Calculate.blocks(house);
        HttpSession session = request.getSession();
        session.setAttribute( "block4", sumBlocks[0]);
        session.setAttribute( "block2", sumBlocks[1]);
        session.setAttribute( "block1", sumBlocks[2]);

        return "showblocks" + "page";
    }
}
