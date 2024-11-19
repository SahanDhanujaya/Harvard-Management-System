package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane node;
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
    void btnLoginOnAction(ActionEvent event) throws IOException {
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(borderPane);
        Stage stage = (Stage) this.node.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        stage1.centerOnScreen();
        stage1.initStyle(StageStyle.DECORATED);
        stage1.setScene(scene);
        stage1.show();
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
