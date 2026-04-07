package homework;

import jdk.jfr.Event;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RentalService {

    private static final double BASE_FARE = 3.0;

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private BikeService bikeService = new BikeService();
    private Stack<ERyderLog> logStack = new Stack<>();

    public void startRental(String bikeID, RegisteredUsers user) {
        if (bikeID != null) {
            LocalDateTime startTime = LocalDateTime.now();
            bikeService.reserveBike(bikeID, user.getEmailAddress(), startTime, activeRentalsList);
            
            ERyderLog log = new ERyderLog(bikeID, "Trip started", startTime);
            logStack.push(log);
        }
    }

    public void endRental(String bikeID, RegisteredUsers user) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                LocalDateTime endTime = LocalDateTime.now();
                ERyderLog log = new ERyderLog(bikeID, "Trip ended", endTime);
                logStack.push(log);
                
                double fare = user.calculateFare(BASE_FARE);
                System.out.println("Trip fare: $" + fare);
                
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

    public Stack<ERyderLog> getLogStack() {
        return logStack;
    }
}
