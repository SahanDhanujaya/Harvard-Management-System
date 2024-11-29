package lk.ijse.Controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.*;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.*;
import lk.ijse.util.PassValue;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentAddFormController {

    public Button btnClose;
    public AnchorPane rootNode;
    public ComboBox cmbMethod;
    public TextField txtPayment;
    @FXML
    private ComboBox<String> cmbCourse;

    @FXML
    private DatePicker date;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TextField studentId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.STUDENT);
    CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.COURSE);
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.USER);
    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.REGISTRATION);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.PAYMENT);
    public void initialize() {
        setComboBox();
        setPaymentMethod();
    }

    private void setPaymentMethod() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("Card");
        observableList.add("Cash");
        cmbMethod.setItems(observableList);
    }

    private void setComboBox() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<CourseDto> courseObjList = courseBO.getCourseObjList();
        for (CourseDto courseDto : courseObjList){
            obList.add(courseDto.getCourse());
        }
        cmbCourse.setItems(obList);
    }

    @FXML
    void cmbCourseOnAction(ActionEvent event) {

    }

    @FXML
    void dateDobOnAction(ActionEvent event) {

    }

    @FXML
    void dateOnAction(ActionEvent event) {

    }

    @FXML
    void studentIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPhoneOnAction(ActionEvent event) {

    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String studentId = generateStudentId();
        this.studentId.setText(studentId);
        String email = PassValue.getInstance().getEmail();
        UserDto userObj = userBO.getUserObj(email);
        String paymentId = generatePaymentId();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        StudentDto studentDto = new StudentDto(studentId, txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPhone.getText(), txtEmail.getText(), String.valueOf(dateDob.getValue()), userObj.getUserId());
        boolean isSaved = studentBO.transaction(studentDto,session);
        if (isSaved){
            System.out.println("Come to 1st stage");
            String value1 = String.valueOf(cmbMethod.getValue());
            boolean isSaved1 = paymentBO.savePayment(new PaymentDto(paymentId,value1,Double.parseDouble(txtPayment.getText()), String.valueOf(LocalDate.now()),0.0,null,0.0,null,studentId),session);
            if (isSaved1){
                System.out.println("Come to 2st stage");
                String value = cmbCourse.getValue();
                String courseId = courseBO.getCourseObj(value).getCourseId();
                System.out.println("CourseId : "+courseId);

                boolean isSaved2 = registerBO.saveRegister(new RegisterDto(studentId, courseId, String.valueOf(LocalDate.now()),paymentId), session);
                if (isSaved2){
                    System.out.println("Come to 3st stage");
                    transaction.commit();
                    session.close();
                    new Alert(Alert.AlertType.CONFIRMATION,"Student saved successfully!").show();
                } else {
                    transaction.rollback();
                    session.close();
                    new Alert(Alert.AlertType.ERROR,"Student saved unsuccessfully").show();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Student saved unsuccessfully").show();
                transaction.rollback();
                session.close();
            }
        } else {
            new Alert(Alert.AlertType.ERROR,"Student saved unsuccessfully").show();
            transaction.rollback();
            session.close();
        }


    }

    private String generatePaymentId() {
        String currentId = paymentBO.getCurrentId();
        if (currentId != null){
            String[] split = currentId.split("P");
            int number = Integer.parseInt(split[1]);
            return "P" + String.format("%03d", ++number);
        }
        return "P001";
    }

    private String generateStudentId() {
        String currentStudentId = studentBO.checkCurrentStudentId();
        if (currentStudentId == null){
            currentStudentId = "ST001";
            return currentStudentId;
        } else {
            String[] split = currentStudentId.split("ST");
            int number = Integer.parseInt(split[1]);
            return "ST" + String.format("%03d", ++number);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }

    public void cmbMethodOnAction(ActionEvent actionEvent) {

    }

    public void txtPaymentOnAction(ActionEvent actionEvent) {

    }
}
