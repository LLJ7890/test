package homework;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    private UserRegistration userRegistration = new UserRegistration();
    private ActiveRental activeRental;

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void simulateApplicationInput() {
        System.out.println("This is the simulation of the e-bike rental process.");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Is user registered? (true/false): ");
        isRegisteredUser = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter email address: ");
        emailAddress = scanner.nextLine();

        System.out.print("Enter location: ");
        location = scanner.nextLine();

        System.out.println("Simulating the analysis of the rental request.");

        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if (!locationValid) {
            return;
        }

        System.out.println("Simulating e-bike reservation");
        reserveBike(bikeID);

        System.out.println("Displaying the active rentals");
        viewActiveRentals();

        System.out.println("Simulating the end of the trip");
        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end");
        viewActiveRentals();
    }

    private String analyseRequest(boolean isRegisteredUser, String emailAddress, String location) {
        if (isRegisteredUser) {
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.println("You're not our registered user. Please consider registering.");
            userRegistration.registration();
        }

        return validateLocation(location);
    }

    private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }

        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bike.getBikeID().equals(bikeID)) {
                    tripStartTime = LocalDateTime.now();
                    bike.setAvailable(false);
                    bike.setLastUsedTime(tripStartTime);

                    System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey");

                    activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}

