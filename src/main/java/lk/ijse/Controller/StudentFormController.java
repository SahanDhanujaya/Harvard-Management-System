package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import lk.ijse.util.PassValue;

import java.io.IOException;

public class StudentFormController {

    public Text lblUser;
    public Text lblId;
    @FXML
    private JFXButton btnSearchOnAction;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private BarChart<?, ?> studentBarChart;
    UserBO userBo = (UserBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.USER);
    public void initialize(){
        setUser();
    }

    private void setUser() {
        String email = PassValue.getInstance().getEmail();
        UserDto userObj = userBo.getUserObj(email);
        lblId.setText(userObj.getUserId());
        lblUser.setText(userObj.getEmail());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/studentAddForm.fxml"))));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnEditOnAcction(ActionEvent event) throws IOException {
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(FXMLLoader.load(getClass().getResource("/view/")));
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"))));
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void hplSeeOnAction(ActionEvent event) {

    }

}
