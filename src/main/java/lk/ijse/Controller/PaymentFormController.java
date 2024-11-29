package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PaymentBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.PaymentDto;
import lk.ijse.util.PassValue;

public class PaymentFormController {

    public TextField txtPaymentId;
    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableColumn<?, ?> clmFirstPayment;

    @FXML
    private TableColumn<?, ?> clmSecondPayment;

    @FXML
    private TableColumn<?, ?> clmStudent;

    @FXML
    private TableColumn<?, ?> clmStudentId;

    @FXML
    private TableColumn<?, ?> clmThirdPayement;

    @FXML
    private ComboBox<String> cmbPayment;

    @FXML
    private Text lblId;

    @FXML
    private Text lblUser;

    @FXML
    private AnchorPane scrollAnchorPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TableView<?> tblPayment;

    @FXML
    private TextField txtCourse;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private Circle userProfile;
    PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.PAYMENT);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.STUDENT);
    public void initialize(){
        setComboBox();
    }

    private void setComboBox() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("Card");
        observableList.add("Cash");
        cmbPayment.setItems(observableList);
    }



    @FXML
    void btnCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnPayOnAction(ActionEvent event) {
        String availableId = generatePaymentId();
        String sId = PassValue.getInstance().getSId();
        String value = cmbPayment.getValue();



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

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void cmbPaymentOnAction(ActionEvent event) {

    }

    @FXML
    void txtCourseOnAction(ActionEvent event) {

    }

    @FXML
    void txtDateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    @FXML
    void txtStudentIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtStudentNameOnAction(ActionEvent event) {

    }

    public void txtPaymentIdOnAction(ActionEvent actionEvent) {

    }
}
