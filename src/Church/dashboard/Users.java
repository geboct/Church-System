package Church.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Users implements Initializable {

    @FXML
    private JFXButton addUserButton;

    @FXML
    private JFXButton bulkDeleteButton;

    @FXML
    private Label numberOfEntriesLabel;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private TableColumn<?, ?> checkboxTableColumn;

    @FXML
    private TableColumn<?, ?> nameTableColumn;

    @FXML
    private TableColumn<?, ?> emailTableColumn;

    @FXML
    private TableColumn<?, ?> dateCreatedTableColumn;

    @FXML
    private TableColumn<?, ?> avatarTableColumn;

    @FXML
    private TableColumn<?, ?> roleTableColumn;

    @FXML
    private TableColumn<?, ?> viewTableColumn;

    @FXML
    private TableColumn<?, ?> editTableColumn;

    @FXML
    private TableColumn<?, ?> deleteTableColumn;

    @FXML
    private HBox footerHBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addUserButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE));
        addUserButton.getGraphic().setStyle("-fx-fill: #e0e0e0");
        bulkDeleteButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.REMOVE));
        bulkDeleteButton.getGraphic().setStyle("-fx-fill: #e0e0e0");

    }
}
