
public class ERyderMain {
    public static void main(String[] args) {
        // ✅ Step 1: Create object using DEFAULT constructor
        ERyder bike1 = new ERyder();
        bike1.printBikeDetails(); // prints initialized defaults

        // ✅ Step 2: Create object using PARAMETERIZED constructor
        // Example: bike ID=101, 85% battery, available, driven 12.3 km
        ERyder bike2 = new ERyder(101, 85, true, 12.3);

        // Then call ride() → should print "available" (85>0 & true)
        bike2.ride();

        // Then call printBikeDetails() → shows current state
        bike2.printBikeDetails();

        // 🔍 Bonus verification: test battery validation
        System.out.println("→ Testing invalid battery (150%)...");
        bike2.setBatteryLevel(150); // triggers warning & sets to 0
        bike2.printBikeDetails();   // shows battery=0%
    }
}
