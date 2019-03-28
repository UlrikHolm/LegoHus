package FunctionLayer;

public class Order {

    private int orderID;
    private String date;
    private int userID;
    private int length;
    private int width;
    private int heigth;
    private String shipped;


    public Order(int orderID, String date, int userID, int length, int width, int heigth, String shipped) {
        this.orderID = orderID;
        this.date = date;
        this.userID = userID;
        this.length = length;
        this.width = width;
        this.heigth = heigth;
        this.shipped = shipped;
    }

    public Order(String date, int userID, int length, int width, int heigth, String shipped) {
        this.date = date;
        this.userID = userID;
        this.length = length;
        this.width = width;
        this.heigth = heigth;
        this.shipped = shipped;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getuserID() {
        return userID;
    }

    public void setuserID(int userID) {
        this.userID = userID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getShipped() {
        return shipped;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }




}
