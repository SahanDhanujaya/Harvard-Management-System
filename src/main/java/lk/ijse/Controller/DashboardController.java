package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    void btnCoursesOnAction(ActionEvent event) {
        navigateToNewPage("/view/coursesForm.fxml");

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {
        navigateToNewPage("/view/paymentForm.fxml");
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) {
        navigateToNewPage("/view/paymentForm.fxml");
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        navigateToNewPage("/view/studentForm.fxml");
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        navigateToNewPage("/view/userForm.fxml");

    }

    private void navigateToNewPage(String url) {
        rootNode.getChildren().clear();
        try {
            rootNode.getChildren().add(FXMLLoader.load(getClass().getResource(url)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
