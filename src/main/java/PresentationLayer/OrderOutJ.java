package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

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
        List <Order> customerOrder = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        for (int i = 0; i <tempOrder.size() ; i++) {
            if (tempOrder.get(i).getuserID()==user.getId()){
                customerOrder.add((Order) tempOrder.get(i));
            }
        }
        session.setAttribute("orderList",customerOrder);

        for (int i = 0; i <customerOrder.size() ; i++) {
            System.out.println(customerOrder.get(i).toString());

        }

        return "showorder" + "page";
    }
}
