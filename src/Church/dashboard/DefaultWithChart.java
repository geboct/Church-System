package Church.dashboard;

import com.jfoenix.controls.JFXListView;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DefaultWithChart implements Initializable {
    @FXML
    private FontAwesomeIconView totalRevenueIcon;

    @FXML
    private FontAwesomeIconView onlineRevenueIcon;

    @FXML
    private FontAwesomeIconView expensesIcon;

    @FXML
    private FontAwesomeIconView expenditureIcon;

    @FXML
    private FontAwesomeIconView totalUsersIcon;

    @FXML
    private Pane calendarPane;

    @FXML
    private TableColumn<?, ?> prayerRequestMessage;

    @FXML
    private TableColumn<?, ?> prayerRequestSender;

    @FXML
    private TableColumn<?, ?> prayerRequestDate;

    @FXML
    private JFXListView<?> listView;











    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
        calendarPane.getChildren().setAll(datePickerSkin.getPopupContent());
    }
}
