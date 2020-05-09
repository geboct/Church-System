package Church.database;

import javafx.util.Duration;
import tray.notification.TrayNotification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection connection;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/churchsystem","root","");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection connected(){
        if (connection!=null){
            TrayNotification notification=new TrayNotification();
            notification.setTitle("Database Connection");
            notification.setMessage("Database is connected");
            System.out.println("db connected");
      //      notification.showAndDismiss(Duration.seconds(10));
             }
        return connection;
    }

}

