import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        //Αρχικοποιήσεις
        DBManager db = new DBManager();
        DeliveryController controller = new DeliveryController(db);
        SearchScreen searchScreen = new SearchScreen();
        PendingOrdersDisplayScreen pendingScreen = new PendingOrdersDisplayScreen();
        OptimalRouteMessageScreen routeScreen = new OptimalRouteMessageScreen();
        OrderCancellationMessageScreen cancellationScreen = new OrderCancellationMessageScreen();
        LocationChangeMessageScreen locationScreen = new LocationChangeMessageScreen();
        NewAvailableOrdersMessageScreen newOrdersScreen = new NewAvailableOrdersMessageScreen();

        //Βασική ροή
        searchScreen.show();
        List<Order> available = controller.requestPendingOrders();
        pendingScreen.displayPendingOrders(available);
        List<Integer> selectedIds = new ArrayList<>();
        selectedIds.add(101);
        selectedIds.add(102);
        controller.saveSelectedOrders(selectedIds);
        Route route = controller.startDelivery(selectedIds);
        routeScreen.displayRoute(route);

        //Εναλλακτικές ροές
            //Ακύρωση
        db.simulateSystemCancellation(101);
        cancellationScreen.displayCancellationAlert(101);

            //Αλλαγή διεύθυνσης
        String newAddress = "Νέο Λιμάνι Πάτρας";
        db.simulateSystemLocationChance(102, newAddress);
        String newRoute = controller.calculateOptimalRoute(selectedIds);
        locationScreen.displayLocationChangeAlert(102, newAddress, newRoute);

            //Νέα παραγγελία
        db.addNewPendingOrder(new Order(104, "εκκρεμής", "Ψαροφάι"));
        newOrdersScreen.displayNewOrdersAlert(104, "Ψαροφάι");
    }
}