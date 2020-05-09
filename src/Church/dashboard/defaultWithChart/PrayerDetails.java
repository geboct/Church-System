package Church.dashboard.defaultWithChart;

public class PrayerDetails {
    private String message;
    private String senderName;
    private String dateRequested;


    public PrayerDetails(String message, String senderName, String dateRequested) {
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

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
    }
}
