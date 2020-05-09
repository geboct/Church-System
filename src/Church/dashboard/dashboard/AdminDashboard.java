package Church.dashboard.dashboard;

import Church.LoginController;
import Church.database.DBConnection;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDashboard implements Initializable {
LoginController controller=new LoginController();
private String loginName;
    @FXML
    private Circle churchLogo;

    @FXML
    private Label churchName;

    @FXML
    private HBox dashboadHBox;

    @FXML
    private FontAwesomeIconView dashboardIcon;

    @FXML
    private HBox usersHBox;

    @FXML
    private FontAwesomeIconView usersIcon;

    @FXML
    private Label usersLabel;

    @FXML
    private HBox eventsHBox;

    @FXML
    private FontAwesomeIconView eventsIcon;

    @FXML
    private Label eventLabel;

    @FXML
    private HBox groupsHBox;

    @FXML
    private FontAwesomeIconView groupsIcon;

    @FXML
    private Label groupLabel;

    @FXML
    private HBox recordsHBox;

    @FXML
    private FontAwesomeIconView recordsIcon;

    @FXML
    private Label recordsLabel;

    @FXML
    private HBox messageHBox;

    @FXML
    private FontAwesomeIconView messageIcon;

    @FXML
    private Label messageLabel;

    @FXML
    private HBox reportsHBox;

    @FXML
    private FontAwesomeIconView reportsIcon;

    @FXML
    private Label reportsLabel;

    @FXML
    private HBox accountsHBox;

    @FXML
    private FontAwesomeIconView accountsIcon;

    @FXML
    private Label accountsLabel;

    @FXML
    private HBox mediaHBox;

    @FXML
    private FontAwesomeIconView mediaIcon;

    @FXML
    private Label mediaLabel;

    @FXML
    private HBox familyHBox;

    @FXML
    private FontAwesomeIconView familyIcon;

    @FXML
    private Label familyLabel;

    @FXML
    private HBox websiteHBox;

    @FXML
    private FontAwesomeIconView websiteIcon;

    @FXML
    private Label websiteLabel;

    @FXML
    private HBox settingsHBox;

    @FXML
    private FontAwesomeIconView settingsIcon;

    @FXML
    private Label settingsLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private FontAwesomeIconView messageIcon1;

    @FXML
    private Label numberOfMessagesLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private FontAwesomeIconView notificationIcon;

    @FXML
    private Label notificationNumber;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private FontAwesomeIconView searchIcon;

    @FXML
    private Circle adminImageCircle;

    @FXML
    private JFXComboBox<String> adminComboBox;

   @FXML
    private Label loggedInUser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberOfMessagesLabel.setText(String.valueOf(300));
        setChurchDetails();

        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/defaultWithChart/DefaultWithChart.fxml"));
            mainBorderPane.setCenter(root);


        } catch (IOException e) {
            e.printStackTrace();
        }

        //initializing admin combo box
        setAdminComboBox();
        //combo box action
        adminComboBox.setOnAction(e -> setAdminComboBoxActions());
        getChurchImage();
        setUserImage();

        FileReader fileReader= null;
        try {
            fileReader = new FileReader("username.txt");
            BufferedReader reader=new BufferedReader(fileReader);

            loggedInUser.setText(reader.readLine().toUpperCase());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get church image from database
     * @author
     */
    public void getChurchImage(){
        Connection connection=new DBConnection().connected();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * FROM churchdetails  ");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                InputStream is = resultSet.getBinaryStream("church_logo");
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[]content = new byte[1024];
                int size = 0;
                while((size=is.read(content))!= -1)
                {
                    os.write(content,0,size);
                }
                os.close();
                is.close();
                Image imagex = new Image("file:photo.jpg",250,250,true,true);
                churchLogo.setFill(new ImagePattern(imagex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * get user image from database
     * @author
     */
    public void setUserImage(){
        Connection connection=new DBConnection().connected();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * FROM members ");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                InputStream is = resultSet.getBinaryStream("avatar");
                OutputStream os = new FileOutputStream(new File("userPhoto.jpg"));
                byte[]content = new byte[1024];
                int size = 0;
                while((size=is.read(content))!= -1)
                {
                    os.write(content,0,size);
                }
                os.close();
                is.close();
                Image userImage = new Image("file:photo.jpg",250,250,true,true);
                adminImageCircle.setFill(new ImagePattern(userImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void onIconHover(MouseEvent event) {
        if (event.getSource().equals(messageIcon1) || event.getSource().equals(messageLabel)) {
            messageIcon1.setStyle("-fx-font-size:20;");
            messageLabel.setStyle("-fx-border-color:white;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(notificationIcon) || event.getSource().equals(notificationLabel)) {
            notificationIcon.setStyle("-fx-font-size: 20");
            notificationLabel.setStyle("-fx-border-color:white;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        }else if (event.getSource().equals(dashboadHBox) || event.getSource().equals(dashboardIcon)) {
            dashboardIcon.setStyle("-fx-font-size: 20;");
            dashboadHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");

        } else if (event.getSource().equals(usersIcon) || event.getSource().equals(usersHBox)) {
            usersIcon.setStyle("-fx-font-size: 20;");
            usersHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");

        } else if (event.getSource().equals(eventsIcon) || event.getSource().equals(eventsHBox)) {
            eventsIcon.setStyle("-fx-font-size: 20;-fx-fill:white");
            eventsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(groupsIcon) || event.getSource().equals(groupsHBox)) {
            groupsIcon.setStyle("-fx-font-size: 20");
            groupsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(recordsIcon) || event.getSource().equals(recordsHBox)) {
            recordsIcon.setStyle("-fx-font-size: 20");
            recordsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(messageIcon) || event.getSource().equals(messageHBox)) {
            messageIcon.setStyle("-fx-font-size: 20");
            messageHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(reportsIcon) || event.getSource().equals(reportsHBox)) {
            reportsIcon.setStyle("-fx-font-size: 20");
            reportsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(accountsIcon) || event.getSource().equals(accountsHBox)) {
            accountsIcon.setStyle("-fx-font-size: 20");
            accountsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(mediaIcon) || event.getSource().equals(mediaHBox)) {
            mediaIcon.setStyle("-fx-font-size: 20");
            mediaHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(familyIcon) || event.getSource().equals(familyHBox)) {
            familyIcon.setStyle("-fx-font-size:20");
            familyHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(websiteIcon) || event.getSource().equals(websiteHBox)) {
            websiteIcon.setStyle("-fx-font-size: 20");
            websiteHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        } else if (event.getSource().equals(settingsIcon) || event.getSource().equals(settingsHBox)) {
            settingsIcon.setStyle("-fx-font-size: 20");
            settingsHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
        }


    }

    public void onIconHoverExit(MouseEvent event) {
        if (event.getSource().equals(messageIcon1) || event.getSource().equals(messageLabel)) {
            messageIcon1.setStyle("-fx-font-size:25");
            messageLabel.setStyle("-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(notificationIcon) || event.getSource().equals(notificationLabel)) {
            notificationIcon.setStyle("-fx-font-size: 25");
            notificationLabel.setStyle("-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        }else if (event.getSource().equals(dashboadHBox) || event.getSource().equals(dashboardIcon)) {
            dashboardIcon.setStyle("-fx-font-size: 25;");
            dashboadHBox.setStyle(null);

        } else if (event.getSource().equals(usersIcon) || event.getSource().equals(usersHBox)) {
            usersIcon.setStyle("-fx-font-size: 25;-fx-fill:white");
            usersHBox.setStyle(null);
        } else if (event.getSource().equals(eventsIcon) || event.getSource().equals(eventsHBox)) {
            eventsIcon.setStyle("-fx-font-size: 25;-fx-fill:white");
            eventsHBox.setStyle(null);
        } else if (event.getSource().equals(groupsIcon) || event.getSource().equals(groupsHBox)) {
            groupsIcon.setStyle("-fx-font-size: 25");
            groupsHBox.setStyle(null);
        } else if (event.getSource().equals(recordsIcon) || event.getSource().equals(recordsHBox)) {
            recordsIcon.setStyle("-fx-font-size: 25");
            recordsHBox.setStyle(null);
        } else if (event.getSource().equals(messageIcon) || event.getSource().equals(messageHBox)) {
            messageIcon.setStyle("-fx-font-size: 25");
            messageHBox.setStyle(null);
        } else if (event.getSource().equals(reportsIcon) || event.getSource().equals(reportsHBox)) {
            reportsIcon.setStyle("-fx-font-size: 25");
            reportsHBox.setStyle(null);
        } else if (event.getSource().equals(accountsIcon) || event.getSource().equals(accountsHBox)) {
            accountsIcon.setStyle("-fx-font-size: 25");
            accountsHBox.setStyle(null);
        } else if (event.getSource().equals(mediaIcon) || event.getSource().equals(mediaHBox)) {
            mediaIcon.setStyle("-fx-font-size: 25");
            mediaHBox.setStyle(null);
        }else if (event.getSource().equals(familyIcon) || event.getSource().equals(familyHBox)) {
            familyIcon.setStyle("-fx-font-size:25");
            familyHBox.setStyle(null);
        } else if (event.getSource().equals(websiteIcon) || event.getSource().equals(websiteHBox)) {
            websiteIcon.setStyle("-fx-font-size: 25");
            websiteHBox.setStyle(null);
        } else if (event.getSource().equals(settingsIcon) || event.getSource().equals(settingsHBox)) {
            settingsIcon.setStyle("-fx-font-size: 25");
            settingsHBox.setStyle(null);
        }

    }


    //dashboard label action
    public void onDashboardClicked() {
        try {
            AnchorPane defaultWithChartRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/defaultWithChart/DefaultWithChart.fxml"));
            mainBorderPane.setCenter(defaultWithChartRoot);

            if (mainBorderPane.getCenter().equals(defaultWithChartRoot)){
                dashboadHBox.setOnMouseClicked(null);

              /*  dashboadHBox.setStyle("-fx-border-color: white;-fx-border-width: 2;");
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                dashboadHBox.setStyle(null);
                familyHBox.setStyle(null);*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //user label action
    public void onUserClicked() {
        try {
            AnchorPane usersRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/users/Users.fxml"));
            mainBorderPane.setCenter(usersRoot);
            if (mainBorderPane.getCenter().equals(usersRoot)){
                usersHBox.setOnMouseClicked(null);
                usersIcon.setOnMouseClicked(null);
                
                /*usersHBox.setOnMouseExited(null);
                usersHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                dashboadHBox.setStyle(null);
                familyHBox.setStyle(null);
                searchIcon.setStyle(null);
                dashboadHBox.setStyle(null);*/
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //events label action
    public void onEventsClicked() {
        try {
            AnchorPane eventRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/event/Events.fxml"));
            mainBorderPane.setCenter(eventRoot);
            if (mainBorderPane.getCenter().equals(eventRoot)){
                eventsHBox.setOnMouseClicked(null);
                eventsIcon.setOnMouseClicked(null);

             /*   usersHBox.setStyle(null);
                 eventsHBox.setOnMouseExited(null);
                eventsHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                dashboadHBox.setStyle(null);
                familyHBox.setStyle(null);
                searchIcon.setStyle(null);
                dashboadHBox.setStyle(null);*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //groups label action
    public void onGroupsClicked() {
        try {
            AnchorPane groupsRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/groups/Groups.fxml"));
            mainBorderPane.setCenter(groupsRoot);
            if (mainBorderPane.getCenter().equals(groupsRoot)){
                groupsHBox.setOnMouseClicked(null);
                groupsIcon.setOnMouseClicked(null);

                dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);

                /*groupsHBox.setStyle("-fx-border-color: white;-fx-border-width:2");
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                dashboadHBox.setStyle(null);
                familyHBox.setStyle(null);
                searchIcon.setStyle(null);
                dashboadHBox.setStyle(null);*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //records label action
    public void onRecordsClicked() {
        try {
            AnchorPane recordsRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/records/Records.fxml"));
            mainBorderPane.setCenter(recordsRoot);
            if (mainBorderPane.getCenter().equals(recordsRoot)){
                recordsHBox.setOnMouseClicked(null);
                recordsIcon.setOnMouseClicked(null);


               /* usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setOnMouseExited(null);
                recordsHBox.setStyle("-fx-border-color: white;-fx-border-width:2");
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                dashboadHBox.setStyle(null);
                familyHBox.setStyle(null);*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //message label action
    public void onMessageClicked() {
        try {
            AnchorPane messageRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/message/Message.fxml"));
            mainBorderPane.setCenter(messageRoot);
            if (mainBorderPane.getCenter().equals(messageRoot)){
                messageHBox.setOnMouseClicked(null);


               /* dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setOnMouseExited(null);
                messageHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                familyHBox.setStyle(null);*/

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //reports label action
    public void onReportsClicked() {
        try {
            AnchorPane reportsRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/reports/Reports.fxml"));
            mainBorderPane.setCenter(reportsRoot);
            if (mainBorderPane.getCenter().equals(reportsRoot)){
                reportsHBox.setOnMouseClicked(null);
                reportsIcon.setOnMouseClicked(null);


               /* dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setOnMouseExited(null);
                reportsHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                familyHBox.setStyle(null);*/

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //accounts label action
    public void onAccountsClicked() {
        try {
            AnchorPane accountsRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/accounts/Accounts.fxml"));
            mainBorderPane.setCenter(accountsRoot);
            if (mainBorderPane.getCenter().equals(accountsRoot)){
                accountsHBox.setOnMouseClicked(null);
                accountsIcon.setOnMouseClicked(null);

/*
                dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setOnMouseExited(null);
                accountsHBox.setStyle("-fx-border-color: white;-fx-border-width:2");
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                familyHBox.setStyle(null);*/

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //media label action
    public void onMediaClicked() {
        try {
            AnchorPane mediaRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/media/Media.fxml"));
            mainBorderPane.setCenter(mediaRoot);
            if (mainBorderPane.getCenter().equals(mediaRoot)){
                mediaHBox.setOnMouseClicked(null);
                mediaIcon.setOnMouseClicked(null);


               /* dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaLabel.setOnMouseExited(null);
                mediaHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                familyHBox.setStyle(null);*/

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //family label action

    public void onFamilyClicked() {
        try {
            AnchorPane familyRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/family/Family.fxml"));
            mainBorderPane.setCenter(familyRoot);
            if (mainBorderPane.getCenter().equals(familyRoot)){
                familyHBox.setOnMouseClicked(null);
                familyIcon.setOnMouseClicked(null);
                familyLabel.setOnMouseClicked(null);


               /* dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setStyle(null);
                familyHBox.setOnMouseExited(null);
                familyHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                ;*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //website label action
    public void onWebsiteClicked() {
        try {
            AnchorPane websiteRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/website/Website.fxml"));
            mainBorderPane.setCenter(websiteRoot);
            if (mainBorderPane.getCenter().equals(websiteRoot)){
                websiteHBox.setOnMouseClicked(null);
                websiteIcon.setOnMouseClicked(null);

              /*  dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setOnMouseExited(null);
                websiteHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                familyHBox.setStyle(null);*/


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //settings label action
    public void onSettingsClicked() {
        try {
            AnchorPane settingsRoot = FXMLLoader.load(getClass().getResource("/Church/dashboard/settings/Settings.fxml"));
            mainBorderPane.setCenter(settingsRoot);
            if (mainBorderPane.getCenter().equals(settingsRoot)){
                settingsHBox.setOnMouseClicked(null);
                settingsHBox.setOnMouseClicked(null);


              /*  dashboadHBox.setStyle(null);
                usersHBox.setStyle(null);
                eventsHBox.setStyle(null);
                groupsHBox.setStyle(null);
                recordsHBox.setStyle(null);
                messageHBox.setStyle(null);
                reportsHBox.setStyle(null);
                accountsHBox.setStyle(null);
                mediaHBox.setStyle(null);
                websiteHBox.setStyle(null);
                settingsHBox.setOnMouseExited(null);
                settingsHBox.setStyle("-fx-border-color:white;-fx-border-width:2");
                familyHBox.setStyle(null);*/

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //combo box items
    public void setAdminComboBox() {
        ObservableList list = FXCollections.observableArrayList();
        list.setAll("Profile", "Account", "Settings","Log out");
        adminComboBox.getItems().setAll(list);

    }

    ////admin combo box actions

    public void setAdminComboBoxActions() {
        switch (adminComboBox.getSelectionModel().getSelectedItem().toString()) {
            case "Profile":
                try {

                    AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/profile/Profile.fxml"));
                    mainBorderPane.setCenter(root);
                    usersHBox.setVisible(true);
                    dashboadHBox.setVisible(true);
                    eventsHBox.setVisible(true);
                    groupsHBox.setVisible(true);
                    recordsHBox.setVisible(true);
                    messageHBox.setVisible(true);
                    reportsHBox.setVisible(true);
                    accountsHBox.setVisible(true);
                    mediaHBox.setVisible(true);
                    websiteHBox.setVisible(true);
                    settingsHBox.setVisible(true);
                    eventsHBox.setVisible(true);

                   /* Parent root=FXMLLoader.load(getClass().getResource("/Church/dashboard/Profile.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Profile");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Account":
                try {
                    onAccountsClicked();
                    /*Parent root=FXMLLoader.load(getClass().getResource("/Church/dashboard/Account.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Account");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Settings":
                try {
                    onSettingsClicked();

                   /* Parent root=FXMLLoader.load(getClass().getResource("/Church/dashboard/Settings.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Settings");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }





    //loading church details(name and logo
    public void setChurchDetails(){
    Connection connection=new DBConnection().connected();
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("select * from churchdetails");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                churchName.setText(resultSet.getString("church_name"));
//                churchLogo.setImage(new Image(""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
