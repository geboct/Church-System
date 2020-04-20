package Church.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;


import java.net.URL;
import java.util.ResourceBundle;

public class Profile implements Initializable {


    @FXML
    private JFXTextField fullNameTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXTextField dateOfBirthTextField;

    @FXML
    private JFXTextField addressTextField;

    @FXML
    private JFXTextField cityTextField;

    @FXML
    private JFXTextField phoneTextField;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private Circle imageCircle;

    @FXML
    private Label cameraLabel;

    @FXML
    private FontAwesomeIconView cameraIcon;

    @FXML
    private HBox basicInfoHBox;

    @FXML
    private HBox eventAndBirthdayHBox;

    @FXML
    private HBox eventAndBirthdayHBox1;

    @FXML
    private JFXButton saveButton;




    @Override
    public void initialize(URL location, ResourceBundle rs){

    }



    public void onHover(){

    }

    public void onHoverExit(){

    }

}
