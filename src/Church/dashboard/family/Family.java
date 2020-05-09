package Church.dashboard.family;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Family implements Initializable {

    @FXML
    private Circle familyHeadImage;

    @FXML
    private Label familyheadName;

    @FXML
    private Button callFamilyHeadButton;

    @FXML
    private Button smsFamilyHead;

    @FXML
    private Button emailFamilyHead;

    @FXML
    private JFXButton addMember;

    @FXML
    private Tooltip addMemberTooltip;

    @FXML
    private JFXButton deleteMember;

    @FXML
    private Tooltip deleteMemberTooltip;

    @FXML
    private TableView<FamilyDetail>familyTableView;

    @FXML
    private TableColumn<FamilyDetail, Image> memberImageColumn;

    @FXML
    private TableColumn<FamilyDetail, String> memberNameColumn;

    @FXML
    private TableColumn<FamilyDetail, String> memberRole;

    @FXML
    private TableColumn<FamilyDetail, Date> birthdayColumn;

    @FXML
    private TableColumn<FamilyDetail, String> emailColumn;

    @FXML
    private JFXButton callMemberButton;

    @FXML
    private Tooltip callMemberTooltip;

    @FXML
    private JFXButton smsMemberButton;

    @FXML
    private Tooltip smsMemberTooltip;

    @FXML
    private JFXButton emailMemberButton;

    @FXML
    private Tooltip emailMemberTooltip;

    @FXML
    private JFXButton editMemberButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addMember.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS));
        addMember.getGraphic().setStyle("-fx-fill:#ffff");
        deleteMember.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.REMOVE));
        deleteMember.getGraphic().setStyle("-fx-fill:#ffff");
        editMemberButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.EDIT));
        editMemberButton.getGraphic().setStyle("-fx-fill:#ffff");
        emailMemberButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.ENVELOPE));
        emailMemberButton.getGraphic().setStyle("-fx-fill: #ffff");
        smsMemberButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.ENVELOPE_ALT));
        smsMemberButton.getGraphic().setStyle("-fx-fill:#ffff");
        callMemberButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PHONE));
        callMemberButton.getGraphic().setStyle("-fx-fill: #ffff");
        callFamilyHeadButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PHONE_SQUARE));
        callFamilyHeadButton.getGraphic().setStyle("-fx-Fill:#ffff");
        smsFamilyHead.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.ENVELOPE_ALT));
        smsFamilyHead.getGraphic().setStyle("-fx-fill:#ffff");
        emailFamilyHead.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.ENVELOPE));
        emailFamilyHead.getGraphic().setStyle("-fx-fill:#ffff");



        //family table values

        memberImageColumn.setCellValueFactory(new PropertyValueFactory<>("memberImage"));
        memberNameColumn.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        memberRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));


    }
}
