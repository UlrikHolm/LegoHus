package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static void createOrder(Order order) throws LoginSampleException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `lego`.`order` (`date`, `user_id`, `length`, `width`, `height`, `shipped`) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getDate());
            ps.setInt(2, order.getuserID());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getheight());
            ps.setString(6, order.getShipped());
            ps.executeUpdate();
            //ResultSet ids = ps.getGeneratedKeys();
            //ids.next();
            //int id = ids.getInt( 1 );
            //user.setId( id );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }*/
    }


    public static List<Order> loadOrder() {

        List<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM lego.order";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                Order order = new Order
                        (resultSet.getInt("order_id"),
                                resultSet.getString("date"),
                                resultSet.getInt("user_id"),
                                resultSet.getInt("length"),
                                resultSet.getInt("width"),
                                resultSet.getInt("height"),
                                resultSet.getString("shipped"));

                orderList.add(order);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;

    }


    public static void markSend(String date, int orderID) throws LoginSampleException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `lego`.`order` SET `shipped` = ? WHERE (`order_id` = ?);";
            ps = con.prepareStatement(SQL);
            //ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, date);
            ps.setInt(2, orderID);
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
