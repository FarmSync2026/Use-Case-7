import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private List<Order> orders;

    public DBManager() {
        orders = new ArrayList<>();
        orders.add(new Order(101, "εκκρεμής", "Πανεπιστήμιο Πατρών, Ρίο"));
        orders.add(new Order(102, "εκκρεμής", "Κέντρο Πάτρας, Μαιζώνος"));
        orders.add(new Order(103, "εκκρεμής", "Ψαροφάι, Πάτρα"));
    }

    //(SELECT * FROM orders WHERE status='εκκρεμής'
    public List<Order> queryOrders() {
        List<Order> pending = new ArrayList<>();
        for (Order order : orders) {
            if ("εκκρεμής".equals(order.getStatus())){
                pending.add(order);
            }
        }
        return pending;
    }

    //SQL (SELECT count(*) FROM orders WHERE id=? AND status='εκκρεμής')
    public boolean checkOrderAvailability(List<Integer> orderIds) {
        for (Integer orderId : orderIds) {
            boolean available = orders.stream().anyMatch(pending -> pending.getOrderID() == orderId && "εκκρεμής".equals(pending.getStatus()));
            if (!available) {
                return false;
            }
        }
        return true;
    }

    //SQL Transaction/Lock μετα
    public void lockOrders(List<Integer> orderIds) {
        System.out.println("Κλείδωμα των παραγγελιών στη βάση: " + orderIds);
    }

    //UPDATE orders SET status=? WHERE id=?)
    public void updateOrderStatus(List<Integer> orderIds, String newStatus) {
        for (Order order : orders) {
            if (orderIds.contains(order.getOrderID())) {
                order.setStatus(newStatus);
                System.out.println("Η κατάσταση της παραγγελίας " + order.getOrderID() + " άλλαξε σε: \"" + newStatus + "\"");
            }
        }
    }

    //Ενναλακτηκές Ροές
    public void simulateSystemCancellation(int orderId){
        for (Order order : orders) {
            if (order.getOrderID() == orderId){
                order.setStatus("ακυρώθηκε");
            }
        }
    }

    public void simulateSystemLocationChance(int orderId, String newAddress){
        for (Order order : orders) {
            if (order.getOrderID() == orderId){
                order.setDestination(newAddress);
            }
        }
    }

    public void addNewPendingOrder(Order newOrder){
        orders.add(newOrder);
        System.out.println("Νέα παραγγελία " + newOrder.getOrderID() + " προστέθηκε ως εκκρεμής στη βάση.");
    }
}