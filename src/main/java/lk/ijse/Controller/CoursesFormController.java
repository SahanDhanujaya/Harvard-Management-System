package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CoursesFormController {

    @FXML
    private LineChart<?, ?> coursesLineChart;

    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/courseAddForm.fxml"))));
        stage.show();
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"))));

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void hplSeeAllOnAction(ActionEvent event) {

    }

}
