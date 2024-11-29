package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;

import java.io.IOException;

public class UserEditFormController {
    @FXML
    public AnchorPane rootNode;
    @FXML
    private Button btnBack;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearchOnAction;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private CheckBox checkFemale;

    @FXML
    private CheckBox checkMale;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TableView<?> tblUser;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtSearch;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.USER);

    @FXML
    void btnBackOnAction(ActionEvent event) {
        this.rootNode.getChildren().clear();
        try {
            this.rootNode.getChildren().add(FXMLLoader.load(getClass().getResource("/view/userForm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtFirstName.clear();
        txtLastName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        dateDob.setValue(null);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String text = txtSearch.getText();
        UserDto userObj = userBO.getUserObj(text);
        boolean isDeleted = userBO.deleteUser(userObj);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"User deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"User deleted unsuccessfully").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String text = txtSearch.getText();
        UserDto userObj = userBO.getUserObj(text);
        txtFirstName.setText(userObj.getFirstName());
        txtLastName.setText(userObj.getLastName());
        txtAddress.setText(userObj.getAddress());
        txtContact.setText(userObj.getContact());
        txtEmail.setText(userObj.getEmail());
        dateDob.setValue(userObj.getDob().toLocalDate());

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String text = txtSearch.getText();
        UserDto userObj = userBO.getUserObj(text);
        boolean isUpdated = userBO.updateUser(userObj);
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"User updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"User updated unsuccessfully").show();
        }
    }

    @FXML
    void dateDobOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
