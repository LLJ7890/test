package homework;

public class ERyderMain {

    private static final int DEFAULT_BATTERY_LEVEL = 90;
    private static final String DEFAULT_BIKE_NAME = "bike1";
    private static final boolean DEFAULT_IS_ELECTRIC = true;
    private static final double DEFAULT_BATTERY_CAPACITY = 1.0;
    private static final int RIDE_DURATION = 20;

    public static void main(String[] args) {
         ERyder bike1 = new ERyder(DEFAULT_BATTERY_LEVEL, DEFAULT_BIKE_NAME,
                DEFAULT_IS_ELECTRIC, DEFAULT_BATTERY_CAPACITY);

        System.out.println("——bike1——");
        bike1.printBikeDetails();
        bike1.ride();

        System.out.println("------");
        bike1.printRideDetails(RIDE_DURATION);

        ERyder bike2 = new ERyder("bike2");
        System.out.println("\n——bike2——");
        bike2.printBikeDetails();

        System.out.println("\n——User feedback analysis——");

        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";

        Feedback userFeedback = new Feedback("Jo", "Doe", "qq.com");

        userFeedback.analyseFeedback(false, sent1, sent2, sent3, sent4, sent5);

        System.out.println(userFeedback);
    }
}




