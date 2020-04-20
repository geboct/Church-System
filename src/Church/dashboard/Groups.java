package Church.dashboard;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Groups  implements Initializable {


    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> groupImage;

    @FXML
    private TableColumn<?, ?> detailsColumn;

    @FXML
    private TableColumn<?, ?> groupImage1;

    @FXML
    private TableColumn<?, ?> editColumn;

    @FXML
    private TableColumn<?, ?> deleteColumn;

    @FXML
    private JFXButton addNewGroup;

    @FXML
    private JFXButton bulkDeleteGroup;







    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addNewGroup.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE));
        bulkDeleteGroup.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.REMOVE));
        addNewGroup.getGraphic().setStyle("-fx-fill: #ffff");
        bulkDeleteGroup.getGraphic().setStyle("-fx-fill: #ffffff");






    }
}
