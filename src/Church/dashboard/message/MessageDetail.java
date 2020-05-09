package Church.dashboard.message;

import javafx.scene.control.Button;

public class MessageDetail {
    private String sentBy;
    private String recipient;
    private String message;
    private  String date;
    private Button delete;
    private Button resend;

    

    public MessageDetail(String sentBy, String recipient, String message, String date, Button delete, Button resend) {
        this.sentBy = sentBy;
        this.recipient = recipient;
        this.message = message;
        this.date = date;
        this.delete = delete;
        this.resend = resend;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getResend() {
        return resend;
    }

    public void setResend(Button resend) {
        this.resend = resend;
    }
}
