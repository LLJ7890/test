package homework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeService {

    private List<String> reservedBikes = new ArrayList<>();
    public Queue<BikeRequest> bikeRequest = new ArrayDeque<>();

    public String findAvailableBike(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.isAvailable()) {
                return bike.getBikeID();
            }
        }
        return null;
    }

    public boolean validateLocation(String location) {
        return findAvailableBike(location) != null;
    }

    public void reserveBike(String bikeID, String userEmail, LocalDateTime startTime,
                            List<ActiveRental> activeRentals) {
        if (bikeID == null || bikeID.isEmpty()) {
            String location = "Unknown";
            BikeRequest request = new BikeRequest(userEmail, location, startTime);
            bikeRequest.offer(request);
            return;
        }
        
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(false);
                bike.setLastUsedTime(startTime);

                ActiveRental rental = new ActiveRental(bikeID, userEmail, startTime);
                activeRentals.add(rental);
                reservedBikes.add(bikeID);
                break;
            }
        }
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
        reservedBikes.remove(bikeID);
    }

    public void removeTrip(String bikeID, List<ActiveRental> activeRentals) {
        releaseBike(bikeID);
        
        for (ActiveRental rental : activeRentals) {
            if (rental.getBikeID().equals(bikeID)) {
                activeRentals.remove(rental);
                break;
            }
        }
        
        if (!bikeRequest.isEmpty()) {
            BikeRequest nextRequest = bikeRequest.poll();
            System.out.println("Processing queued request from: " + nextRequest.getUserEmail());
        }
    }
}
