package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderMaker;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderJ extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i OrderJ");

        HttpSession session = request.getSession();
        int length = (int) session.getAttribute("length");
        int width = (int) session.getAttribute("width");
        int height = (int) session.getAttribute("height");


        LocalDateTime timeNow = LocalDateTime.now();
        String timeNowS = timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        session.getAttribute("user");

        Order tempOorder =new Order(timeNowS,2,length, width, height,"no");

        OrderMapper.createOrder(tempOorder);

        return "orderconfirm" + "page";
    }
}
