public class Courier {
    private String vehicleType;
    private boolean isAvailable;

    public Courier(String vehicleType, boolean isAvailable) {
        this.vehicleType = vehicleType;
        this.isAvailable = isAvailable;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}