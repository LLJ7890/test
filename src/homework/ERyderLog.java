package homework;

import java.time.LocalDateTime;

public class ERyderLog {
    private String ID;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String ID, String event, LocalDateTime timeStamp) {
        this.ID = ID;
        this.event = event;
        this.timeStamp = timeStamp;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return ID + " - " + event + " - " + timeStamp;
    }
    public void viewSystemLogs() {
        RentalService service = new RentalService();
        for (ERyderLog log : service.getLogStack()) {
            System.out.println(log.toString());
        }
    }


}
