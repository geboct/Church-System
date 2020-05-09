package Church.dashboard.groups;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ResourceBundle;

public class Groups  implements Initializable {


    @FXML
    private TableView<GroupDetail> tableView;

    @FXML
    private TableColumn<GroupDetail, CheckBox> check;

    @FXML
    private TableColumn<GroupDetail, Image> groupImage;

    @FXML
    private TableColumn<GroupDetail, String> detailsColumn;

    @FXML
    private TableColumn<GroupDetail, Button> editColumn;

    @FXML
    private TableColumn<GroupDetail, Button> deleteColumn;

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


//group table values
        check.setCellValueFactory(new PropertyValueFactory<>("check"));
        groupImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        deleteColumn.setCellValueFactory(new  PropertyValueFactory<>("delete"));
        editColumn.setCellValueFactory(new PropertyValueFactory<>("edit"));



    }

}
