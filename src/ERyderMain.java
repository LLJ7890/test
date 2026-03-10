public class ERyderMain {
    public static void main(String[] args) {

        ERyder bike1 = new ERyder();
        System.out.println("Default information for Bike 1:");
        bike1.printBikeDetails();
        bike1.ride();

        System.out.println();

        // Create second bike - custom values
        ERyder bike2 = new ERyder(101, 75, false, 12.8);
        System.out.println("Custom information for Bike 2:");
        bike2.printBikeDetails();
        bike2.ride();

        System.out.println();


        bike1.setBatteryLevel(85);
        System.out.println("Bike 1 battery after setting: " + bike1.getBatteryLevel() + "%");
        bike1.setBatteryLevel(120);
        System.out.println("Bike 1 current battery: " + bike1.getBatteryLevel() + "%");
    }
}
