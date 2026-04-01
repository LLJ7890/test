package homework;

import java.util.Scanner;

public class AdminPanel {
    private UserService userService = new UserService();
    private RentalService rentalService = new RentalService();

    public void userManagementOptions() {
        System.out.println("Welcome to E-Ryder Admininstrator Panel. What do you want to do?\n" +
                "1. Add a new user\n" +
                "2. Delete a user\n" +
                "3. View all users\n" +
                "4. View a specific user\n" +
                "5. Demo the Bike Rental System\n" +
                "6. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                userService.addNewUsers();
                break;
            case 2:
                userService.viewRegisteredUsers();
                break;
            case 3:
                userService.removeRegisteredUsers();
                break;
            case 4:
                userService.updateRegisteredUsers();
                break;
            case 5:
                simulateBikeRentalDemo();
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void simulateBikeRentalDemo() {
        System.out.println("This is the simulation of the e-bike rental process.");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Is user registered? (true/false): ");
        boolean isRegisteredUser = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.println("Simulating the analysis of the rental request.");

        BikeService bikeService = new BikeService();
        String bikeID = analyseRequest(isRegisteredUser, emailAddress, location, bikeService);

        if (bikeID == null) {
            scanner.close();
            return;
        }

        System.out.println("Simulating e-bike reservation");
        rentalService.startRental(bikeID, emailAddress);

        System.out.println("Displaying the active rentals");
        rentalService.viewActiveRentals();

        System.out.println("Simulating the end of the trip");
        rentalService.endRental(bikeID);

        System.out.println("Displaying the active rentals after trip end");
        rentalService.viewActiveRentals();

        scanner.close();
    }

    private String analyseRequest(boolean isRegisteredUser, String emailAddress,
                                  String location, BikeService bikeService) {
        if (isRegisteredUser) {
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.println("You're not our registered user. Please consider registering.");
            UserRegistration userRegistration = new UserRegistration();
            userRegistration.registration();
        }

        String bikeID = bikeService.findAvailableBike(location);
        if (bikeID == null) {
            System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        } else {
            System.out.println("A bike is available at the location you requested.");
        }

        return bikeID;
    }
}
