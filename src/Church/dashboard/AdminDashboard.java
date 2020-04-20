package Church.dashboard;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboard implements Initializable {


    @FXML
    private ImageView churchLogo;

    @FXML
    private Label churchName;

    @FXML
    private HBox dashboardLabel;

    @FXML
    private FontAwesomeIconView dashboardIcon;

    @FXML
    private HBox usersHBox;

    @FXML
    private FontAwesomeIconView usersIcon;

    @FXML
    private HBox eventsHBox;

    @FXML
    private FontAwesomeIconView eventsIcon;

    @FXML
    private HBox groupsHBox;

    @FXML
    private FontAwesomeIconView groupsIcon;

    @FXML
    private HBox recordsHBox;

    @FXML
    private FontAwesomeIconView recordsIcon;

    @FXML
    private HBox messageHBox;

    @FXML
    private FontAwesomeIconView messageIcon;

    @FXML
    private HBox reportsHBox;

    @FXML
    private FontAwesomeIconView reportsIcon;

    @FXML
    private HBox accountsHBox;

    @FXML
    private FontAwesomeIconView accountsIcon;

    @FXML
    private HBox mediaHBox;

    @FXML
    private FontAwesomeIconView mediaIcon;

    @FXML
    private HBox websiteHBox;

    @FXML
    private FontAwesomeIconView websiteIcon;

    @FXML
    private HBox settingsHBox;

    @FXML
    private FontAwesomeIconView settingsIcon;

    @FXML
    private FontAwesomeIconView searchIcon;

    @FXML
    private Label messageLabel;

    @FXML
    private FontAwesomeIconView messageIcon1;

    @FXML
    private Label messagesLabel;

    @FXML
    private Label notificationLabel;

    @FXML
    private FontAwesomeIconView notificationIcon;

    @FXML
    private Label notificationNumber;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private Label search;

    @FXML
    private Circle adminImageCircle;

    @FXML
    private JFXComboBox<?> adminComboBox;


    @FXML
    private BorderPane mainBorderPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/DefaultWithChart.fxml"));
            mainBorderPane.setCenter(root);
            dashboardLabel.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //initializing admin combo box
        setAdminComboBox();
        //combo box action
        adminComboBox.setOnAction(e -> setAdminComboBoxActions());

    }


    public void onIconHover(MouseEvent event) {
        if (event.getSource().equals(messageIcon1) || event.getSource().equals(messageLabel)) {
            messageIcon1.setStyle("-fx-font-size:20;");
            messageLabel.setStyle("-fx-border-color:gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(notificationIcon) || event.getSource().equals(notificationLabel)) {
            notificationIcon.setStyle("-fx-font-size: 20");
            notificationLabel.setStyle("-fx-border-color:gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(usersIcon) || event.getSource().equals(usersHBox)) {
            usersIcon.setStyle("-fx-font-size: 20;");
            usersHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(eventsIcon) || event.getSource().equals(eventsHBox)) {
            eventsIcon.setStyle("-fx-font-size: 20");
            eventsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(groupsIcon) || event.getSource().equals(groupsHBox)) {
            groupsIcon.setStyle("-fx-font-size: 20");
            groupsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(recordsIcon) || event.getSource().equals(recordsHBox)) {
            recordsIcon.setStyle("-fx-font-size: 20");
            recordsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(messageIcon) || event.getSource().equals(messageHBox)) {
            messageIcon.setStyle("-fx-font-size: 20");
            messageHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(reportsIcon) || event.getSource().equals(reportsHBox)) {
            reportsIcon.setStyle("-fx-font-size: 20");
            reportsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(accountsIcon) || event.getSource().equals(accountsHBox)) {
            accountsIcon.setStyle("-fx-font-size: 20");
            accountsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(mediaIcon) || event.getSource().equals(mediaHBox)) {
            mediaIcon.setStyle("-fx-font-size: 20");
            mediaHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(websiteIcon) || event.getSource().equals(websiteHBox)) {
            websiteIcon.setStyle("-fx-font-size: 20");
            websiteHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        } else if (event.getSource().equals(settingsIcon) || event.getSource().equals(settingsHBox)) {
            settingsIcon.setStyle("-fx-font-size: 20");
            settingsHBox.setStyle("-fx-border-color: gray;-fx-border-width: 2;");
        }


    }

    public void onIconHoverExit(MouseEvent event) {
        if (event.getSource().equals(messageIcon1) || event.getSource().equals(messageLabel)) {
            messageIcon1.setStyle("-fx-font-size:25");
            messageLabel.setStyle("-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(notificationIcon) || event.getSource().equals(notificationLabel)) {
            notificationIcon.setStyle("-fx-font-size: 25");
            notificationLabel.setStyle("-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:  #669999");
        } else if (event.getSource().equals(usersIcon) || event.getSource().equals(usersHBox)) {
            usersIcon.setStyle("-fx-font-size: 25");
            usersHBox.setStyle(null);
        } else if (event.getSource().equals(eventsIcon) || event.getSource().equals(eventsHBox)) {
            eventsIcon.setStyle("-fx-font-size: 25");
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
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/DefaultWithChart.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            dashboardLabel.setVisible(false);
            searchTextField.setVisible(true);
            searchIcon.setVisible(true);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //user label action
    public void onUserClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Users.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(false);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);

            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //events label action
    public void onEventsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Events.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(false);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //groups label action
    public void onGroupsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Groups.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(false);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //records label action
    public void onRecordsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Records.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(false);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //message label action
    public void onMessageClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Message.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(false);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //reports label action
    public void onReportsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Reports.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(false);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //accounts label action
    public void onAccountsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Accounts.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(false);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //media label action
    public void onMediaClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Media.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(false);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //website label action
    public void onWebsiteClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Website.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(false);
            settingsHBox.setVisible(true);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //settings label action
    public void onSettingsClicked() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Settings.fxml"));
            mainBorderPane.setCenter(root);
            usersHBox.setVisible(true);
            dashboardLabel.setVisible(true);
            eventsHBox.setVisible(true);
            groupsHBox.setVisible(true);
            recordsHBox.setVisible(true);
            messageHBox.setVisible(true);
            reportsHBox.setVisible(true);
            accountsHBox.setVisible(true);
            mediaHBox.setVisible(true);
            websiteHBox.setVisible(true);
            settingsHBox.setVisible(false);
            eventsHBox.setVisible(true);
            searchTextField.setVisible(false);
            searchIcon.setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //combo box items
    public void setAdminComboBox() {
        ObservableList list = FXCollections.observableArrayList();
        list.setAll("Profile", "Account", "Settings");
        adminComboBox.getItems().setAll(list);

    }

    ////admin combo box actions

    public void setAdminComboBoxActions() {
        switch (adminComboBox.getSelectionModel().getSelectedItem().toString()) {
            case "Profile":
                try {

                    AnchorPane root = FXMLLoader.load(getClass().getResource("/Church/dashboard/Profile.fxml"));
                    mainBorderPane.setCenter(root);
                    usersHBox.setVisible(true);
                    dashboardLabel.setVisible(true);
                    eventsHBox.setVisible(true);
                    groupsHBox.setVisible(true);
                    recordsHBox.setVisible(true);
                    messageHBox.setVisible(true);
                    reportsHBox.setVisible(true);
                    accountsHBox.setVisible(true);
                    mediaHBox.setVisible(true);
                    websiteHBox.setVisible(true);
                    settingsHBox.setVisible(false);
                    eventsHBox.setVisible(true);
                    searchTextField.setVisible(false);
                    searchIcon.setVisible(false);
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


}
