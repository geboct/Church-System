package Church.dashboard.defaultWithBrowser;

import com.sun.javafx.scene.control.skin.DatePickerSkin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class DefaultWithBrowser implements Initializable {


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

    @FXML
    private Pane calendarPane;

    @FXML
    private TableColumn<PrayerDetails, String> prayerRequestMessage;

    @FXML
    private TableColumn<PrayerDetails, String> prayerRequestSender;

    @FXML
    private TableColumn<PrayerDetails, Date> prayerRequestDate;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //prayer table values
        prayerRequestMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        prayerRequestSender.setCellValueFactory(new PropertyValueFactory<>("senderName"));
        prayerRequestDate.setCellValueFactory(new PropertyValueFactory<>("dateRequested"));


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
/*
        browserStopReloadIV.setImage(new Image(getClass().getResourceAsStream("/images/stoploading.png")));
*/
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
        browserWV.getEngine().loadContent("");
        addressBarTF.setText("Type your url here!!!! ");
    }
}
