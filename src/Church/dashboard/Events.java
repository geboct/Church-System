package Church.dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Events {


    @FXML
    private Label upcomingEventsLabel;

    @FXML
    private Label bookedEventsLabel;

    @FXML
    private Label activeEventsLabel;

    @FXML
    private Label archivedEventsLabel;

    @FXML
    private TableView<?> eventsTableView;

    @FXML
    private TableColumn<?, ?> eventImage;

    @FXML
    private TableColumn<?, ?> eventName;

    @FXML
    private TableColumn<?, ?> eventStartDate;

    @FXML
    private TableColumn<?, ?> eventEndDate;

    @FXML
    private TableColumn<?, ?> eventDay;

    @FXML
    private TableColumn<?, ?> dateBooked;

    @FXML
    private TableColumn<?, ?> eventStatus;
}
