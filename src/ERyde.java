
public class ERyde {

    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;


    public ERyde() {
        this.bikeID = 0;
        this.batteryLevel = 100;
        this.isAvailable = true;
        this.kmDriven = 0.0;
    }


    public ERyde(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }


    public void ride() {
        if (batteryLevel > 0 && isAvailable) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }


    public void printBikeDetails() {
        System.out.println("=== Bike Details ===");
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Distance Driven: " + kmDriven + " km");
        System.out.println("====================\n");
    }


    public int getBikeID() {
        return bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getKmDriven() {
        return kmDriven;
    }


    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("⚠️ Warning: Battery level must be between 0 and 100. Set to 0.");
            this.batteryLevel = 0;
        }
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setKmDriven(double kmDriven) {
        if (kmDriven >= 0.0) {
            this.kmDriven = kmDriven;
        } else {
            System.out.println("⚠️ Warning: Distance cannot be negative. Set to 0.0.");
            this.kmDriven = 0.0;
        }
    }
}

