public class ERyderMain {

    private static final int DEFAULT_BATTERY_LEVEL = 90;
    private static final String DEFAULT_BIKE_NAME = "bike1";
    private static final boolean DEFAULT_IS_ELECTRIC = true;
    private static final double DEFAULT_BATTERY_CAPACITY = 1.0;
    private static final int RIDE_DURATION = 20;

   public static void main(String[] args) {
        try {
            ERyder bike1 = new ERyder(DEFAULT_BATTERY_LEVEL, DEFAULT_BIKE_NAME, DEFAULT_IS_ELECTRIC, DEFAULT_BATTERY_CAPACITY);
            
            bike1.printBikeDetails();
            bike1.ride();
            
            System.out.println("------");
            bike1.printRideDetails(RIDE_DURATION);
            
        } catch (Exception e) {
            System.err.println("The program runs with an error：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
