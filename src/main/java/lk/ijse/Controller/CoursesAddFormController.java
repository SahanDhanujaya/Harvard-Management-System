package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dto.CourseDto;

import java.io.File;

public class CoursesAddFormController {
    public TextField txtCourse;
    public TextField txtDuration;
    public TextField txtPrice;
    public TextArea txtDescription;
    public JFXButton btnAddProfile;
    public JFXButton btnSave;
    public JFXButton btnClear;
    public AnchorPane rootNode;
    public ImageView coursePic;
    CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.COURSE);

    public void txtCourseOnAction(ActionEvent actionEvent) {
    }

    public void txtDurationOnAction(ActionEvent actionEvent) {
        
    }

    public void txtPriceOnAction(ActionEvent actionEvent) {
    }

    public String btnAddProfileOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My Files");
        fileChooser.setInitialDirectory(new File("/C:/Users/Dhanujaya(Dhanu)/Documents/IJSE//GDSE69/ORM/Student-Management-System/src/main/resources"));
        File selectedFile = fileChooser.showOpenDialog(null);
        String name = selectedFile.getName();
        coursePic.setImage(new Image(String.valueOf(getClass().getResource("/assets/images/"+name))));
        return name;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String availableId = getAvailableCourseId();
        String path = btnAddProfileOnAction(actionEvent);
        boolean isSaved = courseBO.saveCourse(new CourseDto(availableId, txtCourse.getText(), txtDuration.getText(), txtDescription.getText(), Double.parseDouble(txtPrice.getText()), path));
        if (isSaved) {
           new Alert(Alert.AlertType.CONFIRMATION,"Course saved successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Course save unsuccessfully").show();
        }

    }

    private String getAvailableCourseId() {
        String courseCurrentId = courseBO.getCourseCurrentId();
        if (courseCurrentId!=null){
            String[] split = courseCurrentId.split("C");
            int number = Integer.parseInt(split[1]);
            return "C" + String.format("%03d", ++number);
        }
        return "C001";
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtCourse.clear();
        txtDuration.clear();
        txtPrice.clear();
        txtDescription.clear();
        coursePic.setImage(null);
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }
}
