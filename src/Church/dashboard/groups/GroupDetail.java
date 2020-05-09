package Church.dashboard.groups;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;

public class GroupDetail {
private CheckBox check;
private Image image;
private String details;
private Button edit;
private  Button delete;

    public GroupDetail(CheckBox check, Image image, String details, Button edit, Button delete) {
        this.check = check;
        this.image = image;
        this.details = details;
        this.edit = edit;
        this.delete = delete;
    }


    public CheckBox getCheck() {
        return check;
    }

    public void setCheck(CheckBox check) {
        this.check = check;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
}
