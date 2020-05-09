package Church.dashboard.message;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Message implements Initializable {

    @FXML
    private Tab smsTab;

    @FXML
    private TableView<MessageDetail> smsTableView;

    @FXML
    private TableColumn<MessageDetail, String> smsSentBy;

    @FXML
    private TableColumn<MessageDetail, String> smsRecipient;

    @FXML
    private TableColumn<MessageDetail, String> smsMessgae;

    @FXML
    private TableColumn<MessageDetail, String> smsDateSent;

    @FXML
    private TableColumn<MessageDetail, Button> smsDelete;

    @FXML
    private TableColumn<MessageDetail, Button> smsResend;

    @FXML
    private JFXButton smsSendMessage;

    @FXML
    private TextField smsSearchTextField;

    @FXML
    private Button exportButton;

    @FXML
    private Button printButton;

    @FXML
    private Tab emailTab;

    @FXML
    private TableView<EmailDetail> emailTableView;

    @FXML
    private TableColumn<EmailDetail, String> emailSentBy;

    @FXML
    private TableColumn<EmailDetail, String> emailRecipient;

    @FXML
    private TableColumn<EmailDetail, String> emailMessage;

    @FXML
    private TableColumn<EmailDetail, String> emailDate;

    @FXML
    private TableColumn<EmailDetail, String> deleteEmail;

    @FXML
    private TableColumn<EmailDetail, String> resendEmail;

    @FXML
    private JFXButton sendEmailButton;

    @FXML
    private Button exportEmailButton;

    @FXML
    private Button printEmailButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //sms table values
        smsSentBy.setCellValueFactory(new PropertyValueFactory<>("sentBy"));
        smsRecipient.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        smsMessgae.setCellValueFactory(new PropertyValueFactory<>("message"));
        smsDateSent.setCellValueFactory(new PropertyValueFactory<>("date"));
        smsDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        smsResend.setCellValueFactory(new PropertyValueFactory<>("resend"));

        //email table values
        emailSentBy.setCellValueFactory(new PropertyValueFactory<>("sentBy"));
        emailRecipient.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        emailMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        emailDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        deleteEmail.setCellValueFactory(new PropertyValueFactory<>("delete"));
        resendEmail.setCellValueFactory(new PropertyValueFactory<>("resend"));


    }
}
