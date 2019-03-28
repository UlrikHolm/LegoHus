package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OrderOutJ extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        List <Order> tempOrder = new ArrayList<>();
        tempOrder = OrderMapper.loadOrder();
        session.setAttribute("orderList",tempOrder);

        for (int i = 0; i <tempOrder.size() ; i++) {
            System.out.println(tempOrder.get(i).toString());

        }

        return "showorder" + "page";
    }
}
