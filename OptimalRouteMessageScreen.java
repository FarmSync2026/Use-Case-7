public class OptimalRouteMessageScreen {
    public void displayRoute(Route route) {
        if (route != null){
            System.out.println("Βέλτιστη διαδρομή: " + route.getOptimalPath());
            System.out.println("Εκτιμώμενος χρόνος: " +route.getEstimatedTime());
        } else{
            System.out.println("Δεν είναι διαθέσιμες μερικές παραγγελίες");
        }
    }
}