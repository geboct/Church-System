package Church;

import Church.dashboard.dashboard.AdminDashboard;
import Church.database.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    DBConnection dbConnection = new DBConnection();
    Connection connection=dbConnection.connected();

    public String loggedInUsername;


    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXButton signIn;


    public void setSignIn() {

        if (validateLogin(email.getText(), password.getText())) {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Church/dashboard/dashboard/AdminDashboard.fxml"));
                Stage adminStage = new Stage(StageStyle.DECORATED);
                adminStage.setScene(new Scene(root));
                adminStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validateLogin(String email, String password) {
        String query = "select * from members where e_mail=? and password=?";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
               // setLoggedInUsername(resultSet.getString("username"));

                FileWriter fileWriter=new FileWriter("username.txt");
                PrintWriter printWriter=new PrintWriter(fileWriter);
                printWriter.write(resultSet.getString("username"));
                printWriter.close();

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    //when a key is pressed
    public void onKeyPressed(KeyEvent event){

            if (event.getCode().equals( KeyCode.ENTER)){
               // setSignIn();

            }


    }



    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public void setLoggedInUsername(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
    }
}
