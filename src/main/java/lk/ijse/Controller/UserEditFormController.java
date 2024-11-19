package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

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
