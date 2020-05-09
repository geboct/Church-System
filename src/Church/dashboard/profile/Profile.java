package Church.dashboard.profile;

import Church.dashboard.dashboard.AdminDashboard;
import Church.database.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Profile extends AdminDashboard implements Initializable {

    Connection connection = new DBConnection().connected();
    String imagePath;


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
    private FontAwesomeIconView basicInfoIcon;

    @FXML
    private Label basicInfoLabel;

    @FXML
    private FontAwesomeIconView basicInfoEditIcon;

    @FXML
    private HBox eventAndBirthdayHBox;

    @FXML
    private FontAwesomeIconView eventAndBirthdayIcon;

    @FXML
    private Label eventAndBirthdayLabel;

    @FXML
    private FontAwesomeIconView eventAndBirthdayEditIcon;

    @FXML
    private HBox logoutHBox;

    @FXML
    private FontAwesomeIconView logoutIcon;

    @FXML
    private Label logoutLabel;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXButton saveImageButton;
    @FXML
    private TextField pathTextField;

    Image profileImage;
    File selectedFile;
    FileChooser fileChooser;


    @Override
    public void initialize(URL location, ResourceBundle rs) {
        fullNameTextField.setEditable(false);
        usernameTextField.setEditable(false);
        dateOfBirthTextField.setEditable(false);
        emailTextField.setEditable(false);
        addressTextField.setEditable(false);
        cityTextField.setEditable(false);

        //profile picture
        getAndSetProfilePicture();
        setDetails();


        cameraIcon.setOnMouseClicked(e -> {

            fileChooser = new FileChooser();
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");
            fileChooser.getExtensionFilters().setAll(filter);

            selectedFile = fileChooser.showOpenDialog(new Stage());
            if (selectedFile != null) {
                profileImage = new Image(selectedFile.toURI().toString());

                /**
                 *setting the image into the circle
                 */
                imageCircle.setFill(new ImagePattern(profileImage));
                imageCircle.setRotate(90);
                imagePath = selectedFile.getAbsolutePath();
                pathTextField.setText(selectedFile.getAbsolutePath());
            }


        });
        /**
         * save only the profile picture
         */
        saveImageButton.setOnAction(e -> {
            Connection con = new DBConnection().connected();
            FileReader fileReader;
            try {
                fileReader = new FileReader("username.txt");
                BufferedReader reader = new BufferedReader(fileReader);

                PreparedStatement ps = con.prepareStatement("update members SET avatar=? WHERE username=?");
                InputStream is = new FileInputStream(new File(pathTextField.getText()));
                ps.setBlob(1, is);
                ps.setString(2, reader.readLine());
                ps.executeUpdate();
//                saveToFile(new Image(String.valueOf(new File(pathTextField.getText()))));
                System.out.println("Profile picture Updated successfully");
//                setUserImage();


                TrayNotification notification = new TrayNotification();
                notification.setTray("Profile Picture", "Profile picture Updated successfully", NotificationType.SUCCESS);
                notification.showAndDismiss(Duration.seconds(5));

            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (FileNotFoundException e1) {
                TrayNotification notification = new TrayNotification();
                notification.setTray("Invalid Image", "File too big \nPlease selct a different image", NotificationType.ERROR);
                notification.showAndDismiss(Duration.seconds(5));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


    }/** end of initializer*/

    /**
     * getting and setting details of the user in the fields
     */
    //getting profile details
    public void setDetails() {
        String query = "select * from members where username=? ";
        try {


            FileReader fileReader = null;
            try {
                fileReader = new FileReader("username.txt");
                BufferedReader reader = new BufferedReader(fileReader);

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, reader.readLine());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (resultSet.getString("middle_name") == null) {
                        fullNameTextField.setText(resultSet.getString("first_name").toUpperCase() + " " + resultSet.getString("surname").toUpperCase().toUpperCase());

                    } else if (resultSet.getString("middle_name") != null) {
                        fullNameTextField.setText(resultSet.getString("first_name").toUpperCase() + " " + resultSet.getString("middle_name") + " " + resultSet.getString("surname").toUpperCase());

                    }
                    usernameTextField.setText(resultSet.getString("username").toUpperCase());
                    dateOfBirthTextField.setText(resultSet.getString("dob"));
                    addressTextField.setText(resultSet.getString("address").toUpperCase());
                    cityTextField.setText(resultSet.getString("city").toUpperCase());
                    phoneTextField.setText(resultSet.getString("phone").toUpperCase());
                    emailTextField.setText(resultSet.getString("e_mail").toUpperCase());
                    InputStream is = resultSet.getBinaryStream("avatar");
                    OutputStream os = new FileOutputStream(new File("userPhoto.jpg"));
                    byte[] content = new byte[1024];
                    int size = 0;
                    while ((size = is.read(content)) != -1) {
                        os.write(content, 0, size);
                    }
                    os.close();
                    is.close();
                    Image userImage = new Image("file:photo.jpg", 250, 250, true, true);
                    imageCircle.setFill(new ImagePattern(userImage));


                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //on mouse hover actions
    public void onHover(MouseEvent event) {
        if (event.getSource().equals(cameraLabel) || event.getSource().equals(cameraIcon)) {
            cameraLabel.setStyle("-fx-background-color: #154DA6;-fx-cursor: HAND;-fx-border-radius: 100;-fx-background-radius: 100;-fx-border-color:  #1e90ff");
            cameraIcon.setStyle("-fx-fill: white;-fx-cursor: HAND");

        } else if (event.getSource().equals(basicInfoHBox) || event.getSource().equals(basicInfoEditIcon) || event.getSource().equals(basicInfoIcon)) {
            basicInfoHBox.setStyle("-fx-border-color: #154DA6;-fx-background-color: #154DA6");
            basicInfoEditIcon.setStyle("-fx-fill:white");
            basicInfoIcon.setStyle("-fx-fill: white");
            basicInfoLabel.setStyle("-fx-text-fill: #ffff");


        } else if (event.getSource().equals(eventAndBirthdayHBox)) {
            eventAndBirthdayHBox.setStyle("-fx-border-color: #154DA6;-fx-background-color: #154DA6");
            eventAndBirthdayEditIcon.setStyle("-fx-fill:white");
            eventAndBirthdayLabel.setStyle("-fx-text-fill: white");
            eventAndBirthdayIcon.setStyle("-fx-fill: #ffff");
        } else if (event.getSource().equals(logoutHBox)) {
            logoutHBox.setStyle("-fx-border-color: #154DA6;-fx-background-color: #154DA6");
            logoutLabel.setStyle("-fx-text-fill: white");
            logoutIcon.setStyle("-fx-fill: #ffff");
        } else if (event.getSource().equals(saveButton)) {
            saveButton.setStyle("-fx-border-color: white;-fx-text-fill: white;-fx-background-color: #154DA6");
        } else if (event.getSource().equals(saveImageButton)) {
            saveImageButton.setStyle("-fx-border-color: white;-fx-text-fill: white;-fx-background-color: #154DA6");
        }
    }


    //on mouse hover exit actions
    public void onHoverExit(MouseEvent event) {
        if (event.getSource().equals(cameraLabel) || event.getSource().equals(cameraIcon)) {
            cameraLabel.setStyle("-fx-background-color: white;-fx-border-radius: 100;-fx-background-radius: 100;-fx-border-color:  #1e90ff");
            cameraIcon.setStyle("-fx-fill:  #154DA6");
        } else if (event.getSource().equals(basicInfoHBox)) {
            basicInfoHBox.setStyle(null);
            basicInfoLabel.setStyle("-fx-text-fill: #154DA6");
            basicInfoEditIcon.setStyle("-fx-fill: #154DA6");
            basicInfoIcon.setStyle("-fx-fill:  #154DA6");

        } else if (event.getSource().equals(eventAndBirthdayHBox)) {
            eventAndBirthdayHBox.setStyle(null);
            eventAndBirthdayLabel.setStyle("-fx-text-fill: #154DA6");
            eventAndBirthdayEditIcon.setStyle("-fx-fill: #154DA6");
            eventAndBirthdayIcon.setStyle("-fx-fill:  #154DA6");
        } else if (event.getSource().equals(logoutHBox)) {
            logoutHBox.setStyle(null);
            logoutLabel.setStyle("-fx-text-fill: #154DA6");
            logoutIcon.setStyle("-fx-fill:  #154DA6");
        } else if (event.getSource().equals(saveButton)) {
            saveButton.setStyle("-fx-border-color:#154DA6;-fx-text-fill: #154DA6;-fx-background-color: white");
        } else if (event.getSource().equals(saveImageButton)) {
            saveImageButton.setStyle("-fx-border-color:#154DA6;-fx-text-fill: #154DA6;-fx-background-color: white");
        }
    }

    //getting image from databse and setting into the circle
    public void getAndSetProfilePicture() {


    }


    //change profile picture
    public void changeProfilePicture() {

        Image profileImage;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().setAll(filter);

        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            profileImage = new Image(selectedFile.toURI().toString());


            imageCircle.setFill(new ImagePattern(profileImage));
            //imageCircle.setRotate(90);



           /* File outputFile=new File("/images");
            BufferedImage bufferedImage= SwingFXUtils.fromFXImage(profileImage,null);
            try{
                ImageIO.write(bufferedImage,"png",outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        }

    }

    //write image into the images folder
    public static void saveToFile(Image image) {
        File outputFile = new File("/images");
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bufferedImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //save info
   /* public void setSaveButton() {
        FileReader fileReader;


        try {
            fileReader = new FileReader("username.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            FileInputStream inputStream = new FileInputStream("");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  members SET avatar=? WHERE username=?");
            preparedStatement.setBinaryStream(1, inputStream);
            preparedStatement.setString(2, reader.readLine());
            preparedStatement.executeUpdate();
            System.out.println("profile picture updated");

            TrayNotification notification = new TrayNotification();
            notification.setTitle("Profile Picture Update");
            notification.setMessage("Profile Picture Updated Successfully");
            notification.showAndDismiss(Duration.seconds(5));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/


    //getters and setters


    public JFXTextField getFullNameTextField() {
        return fullNameTextField;
    }

    public void setFullNameTextField(JFXTextField fullNameTextField) {
        this.fullNameTextField = fullNameTextField;
    }

    public JFXTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JFXTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JFXTextField getDateOfBirthTextField() {
        return dateOfBirthTextField;
    }

    public void setDateOfBirthTextField(JFXTextField dateOfBirthTextField) {
        this.dateOfBirthTextField = dateOfBirthTextField;
    }

    public JFXTextField getAddressTextField() {
        return addressTextField;
    }

    public void setAddressTextField(JFXTextField addressTextField) {
        this.addressTextField = addressTextField;
    }

    public JFXTextField getCityTextField() {
        return cityTextField;
    }

    public void setCityTextField(JFXTextField cityTextField) {
        this.cityTextField = cityTextField;
    }

    public JFXTextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(JFXTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    public JFXTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JFXTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public Circle getImageCircle() {
        return imageCircle;
    }

    public void setImageCircle(Circle imageCircle) {
        this.imageCircle = imageCircle;
    }
}
