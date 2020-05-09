package Church.dashboard.users;

import Church.database.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewUser implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField middleName;

    @FXML
    private JFXTextField surname;

    @FXML
    private JFXDatePicker dob;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField city;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<String> role;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private JFXButton saveButton;


    //close icon action
    public void setClose() {
        Stage closStage = (Stage) close.getScene().getWindow();
        closStage.close();

    }


    //save action
    public void setSaveButton() {
        Connection connection = new DBConnection().connected();
        PreparedStatement preparedStatement;
        String query;
        try {
            if (middleName.getText().isEmpty()) {
                query = "INSERT INTO members( username,first_name, surname, dob, address, city, phone, e_mail, role) VALUES(?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username.getText());
                preparedStatement.setString(2, firstName.getText());
                preparedStatement.setString(3, surname.getText());
                preparedStatement.setDate(4, Date.valueOf(dob.getValue()));
                preparedStatement.setString(5, address.getText());
                preparedStatement.setString(6, city.getText());
                preparedStatement.setString(7, phone.getText());
                preparedStatement.setString(8, email.getText());
                preparedStatement.setString(9, role.getSelectionModel().getSelectedItem());
                preparedStatement.executeUpdate();
                clearFields();
                TrayNotification notification = new TrayNotification();
                notification.setTitle("New User");
                notification.setMessage("New Member Added Successfully");
                notification.showAndDismiss(Duration.seconds(5));
            } else {
                query = "INSERT INTO members( username, first_name, middle_name, surname, dob, address, city, phone, e_mail, role) VALUES(?,?,?,?,?,?,?,?,?,?)";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username.getText());
                preparedStatement.setString(2, firstName.getText());
                preparedStatement.setString(3, middleName.getText());
                preparedStatement.setString(4, surname.getText());
                preparedStatement.setDate(5, Date.valueOf(dob.getValue()));
                preparedStatement.setString(6, address.getText());
                preparedStatement.setString(7, city.getText());
                preparedStatement.setString(8, phone.getText());
                preparedStatement.setString(9, email.getText());
                preparedStatement.setString(10, role.getSelectionModel().getSelectedItem());
                preparedStatement.executeUpdate();

                clearFields();
                TrayNotification notification = new TrayNotification();
                notification.setTitle("New User");
                notification.setMessage("New Member Added Successfully");
                notification.showAndDismiss(Duration.seconds(5));
            }



        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        close.setStyle("-fx-fill: green");
        close.setOnMouseEntered(e -> close.setStyle("-fx-fill: red"));
        close.setOnMouseExited(e -> close.setStyle("-fx-fill:green"));
        close.setOnMouseClicked(e -> setClose());
        setRole();

        saveButton.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS));
        saveButton.getGraphic().setStyle("-fx-fill: white");
        saveButton.setOnMouseEntered(e->saveButton.setStyle("-fx-border-color: gray;-fx-border-width: 2"));
        saveButton.setOnMouseExited(e->saveButton.setStyle("-fx-background-color: green"));
    }


    //role combobox items
    public void setRole() {
        ObservableList<String> roles = FXCollections.observableArrayList();
        roles.setAll("Admin", "Accountant", "Head Pastor", "Pastor", "Secretary", "Usher", "Member");
        role.getItems().setAll(roles);


    }


    //clear the signup fields
    public void clearFields() {
        username.setText(null);
        firstName.setText(null);
        middleName.setText(null);
        surname.setText(null);
        dob.setValue(null);
        address.setText(null);
        city.setText(null);
        phone.setText(null);
        email.setText(null);
        role.getSelectionModel().select("Member");


    }

}
