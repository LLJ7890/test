package homework;

import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;
    private RegisteredUsers user;

    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime, RegisteredUsers user) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
        this.user = user;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public RegisteredUsers getUser() {
        return user;
    }

    public void setUser(RegisteredUsers user) {
        this.user = user;
    }

    public String toString() {
        return "ActiveRental{" +
                "bikeID='" + bikeID + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", tripStartTime=" + tripStartTime +
                '}';
    }
}
