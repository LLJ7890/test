/**
 * Main class for Exercise #3.
 * Demonstrates object creation via both constructors and method invocation per spec.
 */
public class ERyderMain {
    

    private static final int TEST_BIKE_ID = 101;
    private static final int TEST_BATTERY_LEVEL = 85;
    private static final double TEST_KM_DRIVEN = 12.3;
    private static final int INVALID_BATTERY_VALUE = 150;
    
    public static void main(String[] args) {
        try {

            System.out.println("=== Test 1: Default Constructor ===");
            ERyde defaultBike = new ERyde();
            defaultBike.printBikeDetails();


            System.out.println("=== Test 2: Parameterized Constructor ===");
            ERyde parameterizedBike = new ERyde(TEST_BIKE_ID, TEST_BATTERY_LEVEL, true, TEST_KM_DRIVEN);


            parameterizedBike.ride();


            parameterizedBike.printBikeDetails();


            System.out.println("=== Test 3: Battery Validation ===");
            System.out.println("→ Testing invalid battery (" + INVALID_BATTERY_VALUE + "%)...");
            parameterizedBike.setBatteryLevel(INVALID_BATTERY_VALUE);
            parameterizedBike.printBikeDetails();
            
        } catch (Exception e) {
            System.err.println(" Error during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

