package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.mysql.cj.result.ValueFactory;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dto.CourseDto;
import lk.ijse.entity.tm.CourseTm;

import java.io.IOException;
import java.util.List;

public class CourseEditFormController {

    @FXML
    public AnchorPane rootNode;
    public TableView<CourseTm> tblCourse;

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
    CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.COURSE);
    public void initialize(){
        setTable();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        clmCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        clmDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        clmPrice.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void setTable() {
        ObservableList<CourseTm> observableList = FXCollections.observableArrayList();
        List<CourseDto> courseObjList = courseBO.getCourseObjList();
        for (CourseDto courseDto : courseObjList){
            CourseTm courseTm = new CourseTm(
                    courseDto.getCourse(),
                    courseDto.getDuration(),
                    courseDto.getFee()
            );
            observableList.add(courseTm);
        }
        tblCourse.setItems(observableList);

    }


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
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String text = txtSearch.getText();
        CourseDto courseObj = courseBO.getCourseObj(text);
        boolean isDeleted = courseBO.deleteCourse(courseObj);
        if (isDeleted){
            setTable();
            new Alert(Alert.AlertType.CONFIRMATION,"Course deleted successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Course deleted successfully").show();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String text = txtSearch.getText();
        CourseDto courseObj = courseBO.getCourseObj(text);
        txtCourse.setText(courseObj.getCourse());
        txtDuration.setText(courseObj.getDuration());
        txtPrice.setText(String.valueOf(courseObj.getFee()));

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

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String text = txtSearch.getText();
        CourseDto courseObj = courseBO.getCourseObj(text);
        boolean isUpdated = courseBO.updateCourse(courseObj);
        if (isUpdated){
            setTable();
            new Alert(Alert.AlertType.CONFIRMATION,"Course Updated successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Course updated unsuccessfully").show();
        }
    }
}
