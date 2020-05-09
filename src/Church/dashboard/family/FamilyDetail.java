package Church.dashboard.family;

import javafx.scene.image.Image;

import java.util.Date;

public class FamilyDetail {

    private Image memberImage;
    private String memberName;
    private String role;
    private Date birthday;
    private String email;

    public FamilyDetail(Image memberImage, String memberName, String role, Date birthday, String email) {
        this.memberImage = memberImage;
        this.memberName = memberName;
        this.role = role;
        this.birthday = birthday;
        this.email = email;
    }

    public Image getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(Image memberImage) {
        this.memberImage = memberImage;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
