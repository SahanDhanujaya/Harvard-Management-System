package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CoursesAddFormController {
    public TextField txtCourse;
    public TextField txtDuration;
    public TextField txtPrice;
    public TextArea txtDescription;
    public JFXButton btnAddProfile;
    public JFXButton btnSave;
    public JFXButton btnClear;
    public AnchorPane rootNode;

    public void txtCourseOnAction(ActionEvent actionEvent) {
    }

    public void txtDurationOnAction(ActionEvent actionEvent) {
        
    }

    public void txtPriceOnAction(ActionEvent actionEvent) {
    }

    public void btnAddProfileOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }
}
