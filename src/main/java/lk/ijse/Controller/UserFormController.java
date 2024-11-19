package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class UserFormController {

    @FXML
    private JFXButton btnSearchOnAction;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PieChart userPieChart;

    public UserFormController() {
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/userAddForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {
        this.rootNode.getChildren().clear();
        try {
            this.rootNode.getChildren().add(FXMLLoader.load(getClass().getResource("/view/userEditPage.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    void hplSeeAllOnAction(ActionEvent event) {

    }
}
