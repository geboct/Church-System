package Church.dashboard.defaultWithChart;

import Church.database.DBConnection;
import com.jfoenix.controls.JFXListView;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class DefaultWithChart implements Initializable {
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
    private TableView<PrayerDetails>prayerDetailsTableView;

    @FXML
    private TableColumn<PrayerDetails, String> prayerRequestMessage;

    @FXML
    private TableColumn<PrayerDetails, String> prayerRequestSender;

    @FXML
    private TableColumn<PrayerDetails, Date> prayerRequestDate;

    @FXML
    private JFXListView<?> listView;

    @FXML
    private Label expensesLabel;

    @FXML
    private Label expenditureLabel;

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label totalUsersLabel;

    @FXML
    private Label onlineRevenueLabel;

    @FXML
    private Label onlineRevenueNumber;

    @FXML
    private Label expensesNumber;

    @FXML
    private Label totalUsersNumber;

    @FXML
    private Label expenditureNumber;

    @FXML
    private Label totalRevenueNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatePicker datePicker;
        datePicker=new DatePicker(LocalDate.now());
        datePicker.setTooltip(new Tooltip("Double click date to view Events on the day"));

        DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
        calendarPane.getChildren().setAll(datePickerSkin.getPopupContent());


        //prayer table values
        prayerRequestMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        prayerRequestSender.setCellValueFactory(new PropertyValueFactory<>("senderName"));
        prayerRequestDate.setCellValueFactory(new PropertyValueFactory<>("dateRequested"));
        loadPrayerRequests();


    }

    //fetching prayer requests
    public void loadPrayerRequests(){
        Connection connection= new DBConnection().connected();
        ObservableList<PrayerDetails> prayerList= FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM prayer_request");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                prayerList.addAll(new PrayerDetails(resultSet.getString("message"),resultSet.getString("sender"),resultSet.getString("date")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        prayerDetailsTableView.setItems(prayerList);

    }


    public void onMouseHover(MouseEvent event) {
        if (event.getSource().equals(expensesIcon) || event.getSource().equals(expensesLabel)) {
            expensesIcon.setStyle("-fx-font-size: 25");
            expensesLabel.setStyle("-fx-border-color: gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:#3498DB ");

        } else if (event.getSource().equals(expenditureIcon) || event.getSource().equals(expenditureLabel)) {
            expenditureIcon.setStyle("-fx-font-size: 25");
            expenditureLabel.setStyle("-fx-border-color: gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color: #F4D03F");

        }else if (event.getSource().equals(totalRevenueIcon)|| event.getSource().equals(totalRevenueLabel)){
            totalRevenueIcon.setStyle("-fx-font-size: 25");
            totalRevenueLabel.setStyle("-fx-border-color: gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:#8E44AD");
        }else if (event.getSource().equals(totalUsersIcon)||event.getSource().equals(totalUsersLabel)){
            totalUsersIcon.setStyle("-fx-font-size: 25");
            totalUsersLabel.setStyle("-fx-border-color: gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:#3498DB");
        }else if (event.getSource().equals(onlineRevenueIcon)||event.getSource().equals(onlineRevenueLabel)){
            onlineRevenueIcon.setStyle("-fx-font-size: 25");
            onlineRevenueLabel.setStyle("-fx-border-color: gray;-fx-border-width: 2;-fx-border-radius: 100;-fx-background-radius: 100;-fx-background-color:#EC7063");

        }

    }

    public void onMouseHoverExit(MouseEvent event){
        if (event.getSource().equals(expensesIcon) || event.getSource().equals(expensesLabel)) {
            expensesIcon.setStyle("-fx-font-size: 30");
            expensesLabel.setStyle("-fx-background-color:   #3498DB;-fx-border-color:white;-fx-border-radius: 100;-fx-background-radius: 100");

        } else if (event.getSource().equals(expenditureIcon) || event.getSource().equals(expenditureLabel)) {
            expenditureIcon.setStyle("-fx-font-size: 30");
            expenditureLabel.setStyle("-fx-background-color:   #F4D03F;-fx-border-color:white;-fx-border-radius: 100;-fx-background-radius: 100");

        }else if (event.getSource().equals(totalRevenueIcon)|| event.getSource().equals(totalRevenueLabel)){
            totalRevenueIcon.setStyle("-fx-font-size: 30");
            totalRevenueLabel.setStyle("-fx-background-color:  #8E44AD;-fx-border-color:white;-fx-border-radius: 100;-fx-background-radius: 100");

        }else if (event.getSource().equals(totalUsersIcon)||event.getSource().equals(totalUsersLabel)){
            totalUsersIcon.setStyle("-fx-font-size: 30");
            totalUsersLabel.setStyle("-fx-background-color:  #27AE60;-fx-border-color:white;-fx-border-radius: 100;-fx-background-radius: 100");

        }else if (event.getSource().equals(onlineRevenueIcon)||event.getSource().equals(onlineRevenueLabel)){
            onlineRevenueIcon.setStyle("-fx-font-size: 30");
            onlineRevenueLabel.setStyle("-fx-background-color:  #EC7063;-fx-border-color:white;-fx-border-radius: 100;-fx-background-radius: 100");

        }



    }




    //getters and setters


    public Label getOnlineRevenueNumber() {
        return onlineRevenueNumber;
    }

    public void setOnlineRevenueNumber(Label onlineRevenueNumber) {
        this.onlineRevenueNumber = onlineRevenueNumber;
    }

    public Label getExpensesNumber() {
        return expensesNumber;
    }

    public void setExpensesNumber(Label expensesNumber) {
        this.expensesNumber = expensesNumber;
    }

    public Label getTotalUsersNumber() {
        return totalUsersNumber;
    }

    public void setTotalUsersNumber(Label totalUsersNumber) {
        this.totalUsersNumber = totalUsersNumber;
    }

    public Label getExpenditureNumber() {
        return expenditureNumber;
    }

    public void setExpenditureNumber(Label expenditureNumber) {
        this.expenditureNumber = expenditureNumber;
    }

    public Label getTotalRevenueNumber() {
        return totalRevenueNumber;
    }

    public void setTotalRevenueNumber(Label totalRevenueNumber) {
        this.totalRevenueNumber = totalRevenueNumber;
    }
}
