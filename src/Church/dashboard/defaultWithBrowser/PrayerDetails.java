package Church.dashboard.defaultWithBrowser;

import java.util.Date;

public class PrayerDetails {
    private String message;
    private String senderName;
    private Date dateRequested;


    public PrayerDetails(String message, String senderName, Date dateRequested) {
        this.message = message;
        this.senderName = senderName;
        this.dateRequested = dateRequested;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }
}
