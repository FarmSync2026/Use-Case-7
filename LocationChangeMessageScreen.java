public class LocationChangeMessageScreen {
    public void displayLocationChangeAlert(int orderId, String newAddress, String newRoute){
        System.out.println("Η τοποθεσία της παραγγελίας " + orderId + " άλλαξε σε: " + newAddress);
        System.out.println("Αυτόματος υπολογισμός διαδρομής: " + newRoute);
    }
}
