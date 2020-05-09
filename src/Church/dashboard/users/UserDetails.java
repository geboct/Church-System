package Church.dashboard.users;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class UserDetails  {

    private CheckBox check;
    private String fullName;
    private String email;
    private Date dateAdded;
    private String avatar;
    private String role;
    private Button view;
    private Button edit;
    private Button delete;




    public UserDetails() {
    }

    public UserDetails(CheckBox check, String fullName, String email, Date dateAdded, String avatar, String role, Button view, Button edit, Button delete) {
        this.check = check;
        this.fullName = fullName;
        this.email = email;
        this.dateAdded = dateAdded;
        this.avatar = avatar;
        this.role = role;
        this.view = view;
        this.edit = edit;
        this.delete = delete;
    }

    //getters and setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public CheckBox getCheck() {
        return check;
    }

    public void setCheck(CheckBox check) {
        this.check = check;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
