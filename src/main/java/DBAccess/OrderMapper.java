package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {

    public static void createOrder( Order order ) throws LoginSampleException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `lego`.`order` (`date`, `user_id`, `length`, `width`, `heigth`, `shipped`) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, order.getDate());
            ps.setInt( 2, order.getuserID());
            ps.setInt( 3, order.getLength());
            ps.setInt( 4, order.getWidth());
            ps.setInt( 5, order.getHeigth());
            ps.setString( 6, order.getShipped());
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

/*

    public static void createOrderAndLines(ArrayList<OrderLinje> kurv, String timeNow, Bruger bruger, int totalSum ){
        int ordreID = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlOrder = "INSERT INTO `cupcake`.`Ordre` (`tidspunkt`, `bruger_id`, `total_sum`) VALUES (?, ?, ?)";
        try {
            Connection con = Connector.connection();

            ps = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);


            ps.setString(1, timeNow);
            ps.setInt(2, bruger.getBrugerID());
            ps.setInt(3, totalSum);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()){
                ordreID = rs.getInt(1);
                String sqlOrderLines ="INSERT INTO `cupcake`.`OrdreLinjer` (`ordre_id`, `top_id`, `bund_id`, `antal`, `pris_ialt`) VALUES (?, ?, ?, ?, ?);";

                for (int i = 0; i <kurv.size() ; i++) {
                    ps = con.prepareStatement(sqlOrderLines);
                    ps.setInt(1, ordreID);
                    ps.setInt(2, kurv.get(i).getTopID());
                    ps.setInt(3, kurv.get(i).getBundID());
                    ps.setInt(4, kurv.get(i).getAntal());
                    ps.setInt(5, kurv.get(i).getPrisIalt());
                    ps.executeUpdate();
                }

                String sqlSaldo = "UPDATE cupcake.Bruger SET saldo = ? WHERE (bruger_id = ?);";
                ps = con.prepareStatement(sqlSaldo);

                ps.setInt(1, bruger.getSaldo());
                ps.setInt(2, bruger.getBrugerID());
                ps.executeUpdate();

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

*/

}
