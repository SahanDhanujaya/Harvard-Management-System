package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserAddFormController {

    public JFXCheckBox checkMale;
    public JFXCheckBox checkFemale;
    public JFXButton btnSave;
    public JFXButton btnClear;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtContact;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtDob;
    public ImageView userImage;
    public JFXButton btnAddUser;
    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String gender = "";
        if (checkMale.isSelected()){
            gender = "Male";
            System.out.println("Male");
        } else if (checkFemale.isSelected()) {
            gender = "Female";System.out.println("Female");

        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void txtFirstNameOnAction(ActionEvent actionEvent) {
    }

    public void txtLastNameOnAction(ActionEvent actionEvent) {
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
    }

    public void txtDobOnAction(ActionEvent actionEvent) {

    }

    public void btnAddUserOnAction(ActionEvent actionEvent) {


    }
}
