package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserAddFormController {

    public JFXCheckBox checkMale;
    public JFXCheckBox checkFemale;
    public JFXButton btnSave;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtContact;
    public TextField txtEmail;
    public TextField txtAddress;
    public DatePicker txtDob;
    public ImageView userImage;
    public JFXButton btnAddUser;
    public JFXButton btnClear1;
    public AnchorPane node;
    public TextField txtPassword;
    public ComboBox<String> cmbUserType;
    public JFXButton btnCopy;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getInstance(BOFactory.BoType.USER);
    @FXML
    private AnchorPane rootNode;
    public void initialize(){
        setComboValue();
    }

    private void setComboValue() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> users = new ArrayList<>();
        users.add("Admin");
        users.add("Coordinator");
        users.add("Instructor");
        for (String user : users){
            obList.add(user);
        }
        cmbUserType.setItems(obList);
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.close();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String password = generatePassword();
        System.out.println("Password :"+password);
        if (password!=null) {
            this.node.setVisible(true);
            this.rootNode.setOpacity(0.3f);
            txtPassword.setText(password);
        }
    }

    private String generatePassword(){
        List<String> list = userBO.generateUserPassword();
        String userName = txtFirstName.getText();
        Random random = new Random();
        int pwNum = random.nextInt(1000, 9999);
        String password = userName+"@"+pwNum;
        for (String dbPw : list){
            if (dbPw==null){
                dbPw = userName+"@"+1234;
            }
            if (dbPw.equals(password)){
                generatePassword();
            }
        }

        return password;
    }

    private String generateNewUserId() {
        String currentUserId = userBO.getCurrentUserId();
        if (currentUserId!=null){
            String[] split = currentUserId.split("U");
            int number = Integer.parseInt(split[1]);
            return "U" + String.format("%03d", ++number);
        }
        return "U001";
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtFirstName.clear();
        txtLastName.clear();
        txtContact.clear();
        txtEmail.clear();
        txtAddress.clear();
        checkMale.setSelected(false);
        checkFemale.setSelected(false);
        txtDob.setValue(null);
        userImage.setImage(null);
    }

    public void txtFirstNameOnAction(ActionEvent actionEvent) {
        txtLastName.requestFocus();
    }

    public void txtLastNameOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtContactOnAction(ActionEvent actionEvent) {
        txtDob.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
       btnSaveOnAction(actionEvent);
    }

    public void txtDobOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void btnAddUserOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My Files");
        fileChooser.setInitialDirectory(new File("/C:/Users/Dhanujaya(Dhanu)/Documents/IJSE//GDSE69/ORM/Student-Management-System/src/main/resources"));
        File selectedFile = fileChooser.showOpenDialog(null);
        String name = selectedFile.getName();
        userImage.setImage(new Image(String.valueOf(getClass().getResource("/assets/images/"+name))));
        userImage.maxWidth(200);
        userImage.maxHeight(200);
    }

    public void cmbUserTypeOnAction(ActionEvent actionEvent) {

    }
    private void saveTextToFile(String text, Stage stage) {
        // Open a FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        // Show the Save dialog
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(text); // Write the text to the file
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void btnCopyOnAction(ActionEvent actionEvent) {
        saveTextToFile(txtPassword.getText(), (Stage) this.rootNode.getScene().getWindow());
        String userId = generateNewUserId();
        String gender = "";
        if (checkMale.isSelected()){
            gender = "Male";
        } else if (checkFemale.isSelected()) {
            gender = "Female";

            }
        Date dob = Date.valueOf(txtDob.getValue());
        UserDto userDto = new UserDto(userId,txtFirstName.getText(),txtLastName.getText(),txtContact.getText(),txtEmail.getText(),dob,gender,txtAddress.getText(),String.valueOf(cmbUserType.getValue()),txtPassword.getText());
        boolean isSaved = userBO.saveUser(userDto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"User saved successfully!").show();
        }
    }
}
