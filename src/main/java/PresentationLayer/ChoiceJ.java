package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChoiceJ extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        /*HttpSession session = request.getSession();
        int length = (int) session.getAttribute("length");
        if (length>0) {

        };
        */


        return "build"+"page";
    }
}
