package FunctionLayer;

import DBAccess.OrderMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderMaker {


    public static void  createOrder() throws LoginSampleException {


    LocalDateTime timeNow = LocalDateTime.now();
    String timeNowS = timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    //session.setAttribute("TimeNow",timeNowS);

    Order order1 = new Order(timeNowS,2,27,14,7,"no");

    OrderMapper.createOrder(order1);

    }


}
