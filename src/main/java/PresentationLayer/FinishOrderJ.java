package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinishOrderJ extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        HttpSession session = request.getSession();
        String source = request.getParameter("source");

        String fileReturn = "";
        switch (source) {
            case "user":
                System.out.println("Er i FinishOrderJ under pkt. user");

                List<Order> fullOrder = OrderMapper.loadOrder();
                int tempUserId = Integer.parseInt(request.getParameter("userID"));
                System.out.println("UserID er " + tempUserId);

                HashMap<String, String> userOrderList = new HashMap<String, String>();

                for (int i = 0; i < fullOrder.size(); i++) {
                    if ((fullOrder.get(i).getuserID() == tempUserId) &&
                            (fullOrder.get(i).getShipped().equals("no"))) {
                        userOrderList.put(Integer.toString(fullOrder.get(i).getOrderID()),
                                fullOrder.get(i).toString1());
                        session.setAttribute("userOrder", userOrderList);
                    }
                }

                if (userOrderList!=null) {

                    for (String i: userOrderList.keySet()) {
                        System.out.println(i + "  " + userOrderList.get(i));
                    }
                    fileReturn = "employorder" + "page";
                } else {
                    String noOrder = "Ingen order eller alle er afsendt";
                    session.setAttribute("noOrder", noOrder);
                    //System.out.println("Ingen order");
                    fileReturn = "noemployorder" + "page";
                }






                break;

            case "order":
                System.out.println("Er i FinishOrderJ under pkt. order");

                String tempOrderIdS = request.getParameter("orderID");

                System.out.println("OrderID = " + tempOrderIdS);

                int tempOrderId = Integer.parseInt(tempOrderIdS);

                LocalDateTime timeNow = LocalDateTime.now();
                String timeNowS = timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


                OrderMapper.markSend(timeNowS, tempOrderId);


                fileReturn = "employee" + "page";
                break;
        }
        return fileReturn;

    }
}





