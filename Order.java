public class Order {
    private int orderID;
    private String status;
    private String destination;

    public Order(int orderID, String status, String destination) {
        this.orderID = orderID;
        this.status = status;
        this.destination = destination;
    }

    public int getOrderID() {
        return orderID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
}