package PresentationLayer;

import FunctionLayer.Calculate;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HouseDim extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i HouseDim");

        int lenght = Integer.parseInt(request.getParameter("lenght"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));

        System.out.println("Længde som int = "+lenght);
        System.out.println("Bredde som int = "+width);
        System.out.println("Højde som int = "+height);

        int[] sumBlocks = Calculate.blocks(lenght, width, height);
        HttpSession session = request.getSession();
        session.setAttribute( "block4", sumBlocks[0]);
        session.setAttribute( "block2", sumBlocks[1]);
        session.setAttribute( "block1", sumBlocks[2]);

        session.setAttribute("height", height);
        session.setAttribute("printAll",Calculate.printAll(lenght, width, height));

        return "showblocks" + "page";
    }
}
