import java.util.List;

public class DeliveryController{
    private DBManager dbManager;
    public DeliveryController(DBManager dbManager){
        this.dbManager = dbManager;
    }
    public List<Order> requestPendingOrders(){
        return dbManager.queryOrders();
    }
    public void saveSelectedOrders(List<Integer> orderIds){
        System.out.println("Αποθήκευση επιλογών του διανομέα.");
    }
    public Route startDelivery(List<Integer> orderIds){
        System.out.println("Εκκίνηση ελέγχων");
        if (!dbManager.checkOrderAvailability(orderIds)){
            return null;
        }
        dbManager.lockOrders(orderIds);
        dbManager.updateOrderStatus(orderIds, "προς παράδοση");
        String optimalPath = calculateOptimalRoute(orderIds);
        int estimatedTime = calculateEstimatedTime(orderIds);
        return new Route(optimalPath, estimatedTime);
    }
    public Route saveSelectedOrder(List<Integer> orderIds){
        System.out.println("Εκκίνηση ελέγχων");
        if (!dbManager.checkOrderAvailability(orderIds)){
            return null;
        }
        dbManager.lockOrders(orderIds);
        dbManager.updateOrderStatus(orderIds, "προς παράδοση");
        String optimalPath = calculateOptimalRoute(orderIds);
        int estimatedTime = calculateEstimatedTime(orderIds);
        return new Route(optimalPath, estimatedTime);
    }
    public String calculateOptimalRoute(List<Integer> orderIds){
        return "Αποθήκη " + orderIds.toString() + " Επιστροφή";
    }
    private int calculateEstimatedTime(List<Integer> orderIds){
        return orderIds.size() * 15;
    }
}