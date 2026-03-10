public class ERyder {

    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;


    public static final String COMPANY_NAME = "eRyder";

    public ERyder() {
        this.bikeID = 0;
        this.batteryLevel = 100;
        this.isAvailable = true;
        this.kmDriven = 0.0;
    }

    // set
    public ERyder(int id, int battery, boolean available, double km) {
        this.bikeID = id;
        this.batteryLevel = battery;
        this.isAvailable = available;
        this.kmDriven = km;
    }

    // Check
    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("Bike #" + bikeID + " is now available for riding!");
        } else {
            System.out.println("Bike #" + bikeID + " is not available for riding now!");
        }
    }


    public void printBikeDetails() {
        System.out.println("- Bike Information -");
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Kilometers Driven: " + kmDriven + " km");
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("----------");

    }

    public void setBatteryLevel(int newBattery) {
        if (newBattery >= 0 && newBattery <= 100) {
            batteryLevel = newBattery;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100!");
        }
    }


    public int getBatteryLevel() {
        return batteryLevel;
    }
}
