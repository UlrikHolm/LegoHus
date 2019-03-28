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

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));

        HttpSession session = request.getSession();
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("height", height);

        System.out.println("Længde som int = "+length);
        System.out.println("Bredde som int = "+width);
        System.out.println("Højde som int = "+height);

        int[] sumBlocks = Calculate.blocks(length, width, height);

        session.setAttribute( "block4", sumBlocks[0]);
        session.setAttribute( "block2", sumBlocks[1]);
        session.setAttribute( "block1", sumBlocks[2]);

        session.setAttribute("height", height);
        session.setAttribute("printAll",Calculate.printAll(length, width, height));

        return "showblocks" + "page";
    }
}
