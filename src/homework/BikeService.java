package homework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BikeService {

    private List<String> reservedBikes = new ArrayList<>();

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
}
