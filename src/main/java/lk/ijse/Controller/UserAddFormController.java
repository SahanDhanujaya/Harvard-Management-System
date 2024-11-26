package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.bo.custom.impl.UserBOImpl;
import lk.ijse.dto.UserDto;

import java.io.File;
import java.sql.Date;
import java.sql.SQLOutput;

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
    public DatePicker txtDob;
    public ImageView userImage;
    public JFXButton btnAddUser;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.USER);
    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String userId = generateNewUserId();
        String gender = "";
        if (checkMale.isSelected()){
            gender = "Male";
        } else if (checkFemale.isSelected()) {
            gender = "Female";
        }
        Date dob = Date.valueOf(txtDob.getValue());
        UserDto userDto = new UserDto(userId,txtFirstName.getText(),txtLastName.getText(),txtContact.getText(),txtEmail.getText(),dob,gender,txtAddress.getText());
        boolean isSaved = userBO.saveUser(userDto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"User saved successfully!").show();
        }

    }

    private String generateNewUserId() {
        String currentUserId = userBO.getCurrentUserId();
        if (currentUserId!=null){
            String[] split = currentUserId.split("U");
            int number = Integer.parseInt(split[1]);
            return "U" + String.format("%03d", ++number);
        }
        return "U001";
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtFirstName.clear();
        txtLastName.clear();
        txtContact.clear();
        txtEmail.clear();
        txtAddress.clear();
        checkMale.setSelected(false);
        checkFemale.setSelected(false);
        txtDob.setValue(null);
        userImage.setImage(null);
    }

    public void txtFirstNameOnAction(ActionEvent actionEvent) {
        txtLastName.requestFocus();
    }

    public void txtLastNameOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
        txtDob.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
       btnSaveOnAction(actionEvent);
    }

    public void txtDobOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void btnAddUserOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My Files");
        fileChooser.setInitialDirectory(new File("/C:/Users/Dhanujaya(Dhanu)/Documents/IJSE//GDSE69/ORM/Student-Management-System/src/main/resources"));
        File selectedFile = fileChooser.showOpenDialog(null);
        String name = selectedFile.getName();
        userImage.setImage(new Image(String.valueOf(getClass().getResource("/assets/images/"+name))));
        userImage.maxWidth(200);
        userImage.maxHeight(200);
    }
}
