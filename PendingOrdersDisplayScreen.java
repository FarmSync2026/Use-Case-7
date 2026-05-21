import java.util.List;

public class PendingOrdersDisplayScreen {
    public void displayPendingOrders(List<Order> orders){
        if (orders.isEmpty()){
            System.out.println("Δεν βρέθηκαν παραγγελίες");
        }
        for (Order order : orders){
            System.out.println("Id: " + order.getOrderID() + " Προορισμός: " + order.getDestination() + " Κατάσταση: " + order.getStatus());
        }
    }
}