package Church.dashboard.event;

import javafx.scene.image.Image;

import java.util.Date;
import java.util.Objects;

public class EventDetail {

private Image image;
private  String eventName;
private Date startDate;
private Date endDate;
private String day;
private Date dateBooked;
private String status;




    public EventDetail(Image image, String eventName, Date startDate, Date endDate, String day, Date dateBooked, String status) {
        this.image = image;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.day = day;
        this.dateBooked = dateBooked;
        this.status = status;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Date dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
