package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Hyperlink hplForgotPassword;

    @FXML
    private AnchorPane imagePane;

    @FXML
    private Group loginGroup;

    @FXML
    private Group regGroup;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }

    @FXML
    void hplForgotPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    public void navigateToRegisterPage(ActionEvent actionEvent) {

    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
