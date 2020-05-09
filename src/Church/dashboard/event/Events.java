package Church.dashboard.event;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class Events implements Initializable {


    

    @FXML
    private TableView<EventDetail> eventsTableView;

    @FXML
    private TableColumn<EventDetail, Image> eventImage;

    @FXML
    private TableColumn<EventDetail, String> eventName;

    @FXML
    private TableColumn<EventDetail, String> eventStartDate;

    @FXML
    private TableColumn<EventDetail, String> eventEndDate;

    @FXML
    private TableColumn<EventDetail, String> eventDay;

    @FXML
    private TableColumn<EventDetail, String> dateBooked;

    @FXML
    private TableColumn<EventDetail, String> eventStatus;

    @FXML
    private JFXButton addEvent;

    @FXML
    private JFXButton deleteEvent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addEvent.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE));
        addEvent.getGraphic().setStyle("-fx-fill:#ffff");
        deleteEvent.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.REMOVE));
        deleteEvent.getGraphic().setStyle("-fx-fill:#ffff");

    }
}
