package Church.dashboard.adminDashboard;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
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
    private Label seach;

    @FXML
    private Circle adminImageCircle;

    @FXML
    private JFXComboBox<?> adminComboBox;

    @FXML
    private FontAwesomeIconView totalRevenueIcon;

    @FXML
    private FontAwesomeIconView onlineRevenueIcon;

    @FXML
    private FontAwesomeIconView expensesIcon;

    @FXML
    private FontAwesomeIconView expenditureIcon;

    @FXML
    private FontAwesomeIconView totalUsersIcon;

    @FXML
    private Pane calendarPane;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableColumn<?, ?> prayerRequestMessage;

    @FXML
    private TableColumn<?, ?> prayerRequestSender;

    @FXML
    private TableColumn<?, ?> prayerRequestDate;

    @FXML
    private JFXListView<?> listView;

    @FXML
    private WebView browserWV;

    @FXML
    private ImageView stopReloadIV;

    @FXML
    private TextField addressBarTF;

    @FXML
    private ProgressIndicator progressPI;

    @FXML
    private Label statusL;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
        calendarPane.getChildren().setAll(datePickerSkin.getPopupContent());


        browserWV.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                statusL.setText("loading... " + browserWV.getEngine().getLocation());
                stopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/stoploading.png")));
                progressPI.setVisible(true);
                if (newValue == Worker.State.SUCCEEDED) {
                    addressBarTF.setText(browserWV.getEngine().getLocation());
                    statusL.setText("loaded");
                    progressPI.setVisible(false);
                    stopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/reload.png")));
                   /* if(browserBP.getParent() != null) {
                        TabPane tp = (TabPane)browserBP.getParent().getParent();
                        for(Tab tab : tp.getTabs()) {
                            if(tab.getContent() == browserBP) {
                                tab.setText(browserWV.getEngine().getTitle());
                                break;
                            }
                        }
                    }*/
                }

            }

        });
    }


    //lets begin the functions
    @FXML
    private void browserBackButtonAction(ActionEvent event) {
        if (browserWV.getEngine().getHistory().getCurrentIndex() <= 0) {
            return;
        }
        browserWV.getEngine().getHistory().go(-1);
    }

    @FXML
    private void browserForwardButtonAction(ActionEvent event) {
        if ((browserWV.getEngine().getHistory().getCurrentIndex() + 1) >= browserWV.getEngine().getHistory().getEntries().size()) {
            return;
        }
        browserWV.getEngine().getHistory().go(1);
    }

    @FXML
    private void browserGoButtonAction(ActionEvent event) {
        String url = addressBarTF.getText().trim();
        if (url.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No url provided");
            return;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browserWV.getEngine().load(url);
        //browserStopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/stoploading.png")));

    }

    @FXML
    private void browserStopReloadButtonAction(ActionEvent event) {
        if (browserWV.getEngine().getLoadWorker().isRunning()) {
            browserWV.getEngine().getLoadWorker().cancel();
            statusL.setText("loaded");
            progressPI.setVisible(false);
            stopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/reload.png")));
        } else {
            browserWV.getEngine().reload();
            stopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/stoploading.png")));
        }

    }

    @FXML
    private void browserHomeButtonAction(ActionEvent event) {
        browserWV.getEngine().loadContent("http://www.geboct.netlify.com");
        addressBarTF.setText("Type your url here!!!! ");
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

}
