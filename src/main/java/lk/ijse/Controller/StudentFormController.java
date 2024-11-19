package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentFormController {

    @FXML
    private JFXButton btnSearchOnAction;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private BarChart<?, ?> studentBarChart;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditOnAcction(ActionEvent event) {

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
