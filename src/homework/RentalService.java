package homework;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RentalService {

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private BikeService bikeService = new BikeService();

    public void startRental(String bikeID, String userEmail) {
        if (bikeID != null) {
            LocalDateTime startTime = LocalDateTime.now();
            bikeService.reserveBike(bikeID, userEmail, startTime, activeRentalsList);
        }
    }

    public void endRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
        bikeService.releaseBike(bikeID);
    }

    public void cancelRental(String bikeID) {
        endRental(bikeID);
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    public LinkedList<ActiveRental> getActiveRentalsList() {
        return activeRentalsList;
    }
}
