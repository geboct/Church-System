package Church.dashboard.users;

import Church.database.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Users extends UserDetails implements Initializable {

    @FXML
    private JFXButton addUserButton;

    @FXML
    private JFXButton bulkDeleteButton;

    @FXML
    private Label numberOfEntriesLabel;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private TableView<UserDetails> usersTableView;

    @FXML
    private TableColumn<UserDetails, CheckBox> checkboxTableColumn;

    @FXML
    private TableColumn<UserDetails, String> nameTableColumn;

    @FXML
    private TableColumn<UserDetails, String> emailTableColumn;

    @FXML
    private TableColumn<UserDetails, String> dateCreatedTableColumn;

    @FXML
    private TableColumn<UserDetails, String> avatarTableColumn;

    @FXML
    private TableColumn<UserDetails, String> roleTableColumn;

    @FXML
    private TableColumn<UserDetails, Button> viewTableColumn;

    @FXML
    private TableColumn<UserDetails, Button> editTableColumn;

    @FXML
    private TableColumn<UserDetails, String> deleteTableColumn;

    @FXML
    private HBox footerHBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addUserButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE));
        addUserButton.getGraphic().setStyle("-fx-fill: #e0e0e0");
        bulkDeleteButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.REMOVE));
        bulkDeleteButton.getGraphic().setStyle("-fx-fill: #e0e0e0");


        //users table value
        checkboxTableColumn.setCellValueFactory(new PropertyValueFactory<>("check"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateCreatedTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        avatarTableColumn.setCellValueFactory(new PropertyValueFactory<>("avatar"));
        roleTableColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        viewTableColumn.setCellValueFactory(new PropertyValueFactory<>("view"));
        editTableColumn.setCellValueFactory(new PropertyValueFactory<>("edit"));
        deleteTableColumn.setCellValueFactory(new PropertyValueFactory<>("delete"));


        //fetching and setting users
        fetchingMembers();


        //new user action
        addUserButton.setOnAction(e -> addNewUser());
        addUserButton.setOnMouseEntered(e->addUserButton.setStyle("-fx-border-color: gray;-fx-background-color: green"));
        addUserButton.setOnMouseExited(e->addUserButton.setStyle("-fx-background-color: green"));

        //bulk delete action
        bulkDeleteButton.setOnAction(e -> setBulkDelete());
        bulkDeleteButton.setOnMouseEntered(e->bulkDeleteButton.setStyle("-fx-border-color: gray;-fx-background-color: red"));
        bulkDeleteButton.setOnMouseExited(e->bulkDeleteButton.setStyle("-fx-background-color: red"));

    }

    //bulk delete
    private void setBulkDelete() {


    }

    //each delete
    public void delete(){

    }


    //add user
    public void addNewUser() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Church/dashboard/users/NewUser.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.initOwner(addUserButton.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));

            stage.show();

            /*Stage closeStage = (Stage) addUserButton.getScene().getWindow();
            closeStage.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void fetchingMembers() {
        ObservableList<UserDetails> memberList = FXCollections.observableArrayList();

        Connection connection = new DBConnection().connected();

        String query = "SELECT * FROM members";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                memberList.addAll((new UserDetails(new CheckBox(), resultSet.getString("first_name") + " " + resultSet.getString("middle_name") + " " + resultSet.getString("surname"), resultSet.getString("e_mail"), resultSet.getDate("date_added"), resultSet.getString("avatar"), resultSet.getString("role"), new Button("View", new FontAwesomeIconView(FontAwesomeIcon.EYE)), new Button("Edit", new FontAwesomeIconView(FontAwesomeIcon.EDIT)), new Button("Delete", new FontAwesomeIconView(FontAwesomeIcon.REMOVE)))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        usersTableView.getItems().setAll(memberList);
    }


}


