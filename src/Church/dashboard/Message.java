package Church.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Message {

    @FXML
    private Tab smsTab;

    @FXML
    private TableView<?> smsTableView;

    @FXML
    private TableColumn<?, ?> smsSentBy;

    @FXML
    private TableColumn<?, ?> smsRecipient;

    @FXML
    private TableColumn<?, ?> smsMessgae;

    @FXML
    private TableColumn<?, ?> smsDateSent;

    @FXML
    private TableColumn<?, ?> smsDelete;

    @FXML
    private TableColumn<?, ?> smsResend;

    @FXML
    private JFXButton smsSendMessage;

    @FXML
    private TextField smsSearchTextField;

    @FXML
    private Button smsCopyButton;

    @FXML
    private Button smsPrintButton;

    @FXML
    private Tab emailTab;

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private TableColumn<?, ?> smailSentBy;

    @FXML
    private TableColumn<?, ?> emailRecipient;

    @FXML
    private TableColumn<?, ?> emailMessage;

    @FXML
    private TableColumn<?, ?> emailDate;

    @FXML
    private TableColumn<?, ?> deleteEmail;

    @FXML
    private TableColumn<?, ?> resendEmail;

    @FXML
    private JFXButton sendEmailButton;

    @FXML
    private Button emailcopy;

    @FXML
    private Button emailcsv;
}
