package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.util.PassValue;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        passwordAuthentication(txtUserName.getText(), txtPassword.getText());
        PassValue instance = PassValue.getInstance();
        instance.setEmail(txtUserName.getText());

    }

    private void  passwordAuthentication(String userName, String password) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT u.password FROM User u WHERE u.email = :userName");
        String dbPw = (String) query.setParameter("userName", userName).uniqueResult();
        transaction.commit();
        if (dbPw.equals(password)) {
            BorderPane borderPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
            Scene scene = new Scene(borderPane);
            Stage stage = (Stage) this.node.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            stage1.centerOnScreen();
            stage1.initStyle(StageStyle.DECORATED);
            stage1.setScene(scene);
            stage1.show();
            new Alert(Alert.AlertType.CONFIRMATION,"Login successfully").show();
        } else {
           new Alert(Alert.AlertType.ERROR,"Login failed please try again").show();
        }
        session.close();
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
