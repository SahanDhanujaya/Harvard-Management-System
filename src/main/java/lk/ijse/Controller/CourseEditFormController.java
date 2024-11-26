package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CourseEditFormController {

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
    private TableColumn<?, ?> clmCourse;

    @FXML
    private TableColumn<?, ?> clmDuration;

    @FXML
    private TableColumn<?, ?> clmPrice;

    @FXML
    private TextField txtCourse;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        this.rootNode.getChildren().clear();
        try {
            this.rootNode.getChildren().add(FXMLLoader.load(getClass().getResource("/view/coursesForm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBtnOnAction(ActionEvent event) {

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
    void txtCourseOnAction(ActionEvent event) {

    }

    @FXML
    void txtDurationOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
