/*
 * The CheckOutController will manage all functionalities for the CheckOutView.
 */
package hrms.Controller;

import hrms.HRMS;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class CheckOutViewController implements Initializable {
    // variables

    @FXML
    private AnchorPane checkOutView;
    @FXML
    private Button logInButton;
    @FXML
    private Button checkOutButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;
    @FXML
    private TextField ccNumber;
    @FXML
    private TextField ccCVV;
    @FXML
    private TextField ccBillingZip;
    private Alert a;
    private Optional<ButtonType> result;

    /*
	 * Function will handle all button action events
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // if login button selected
        if (event.getSource() == logInButton) {
            // get reference to the button's stage
            stage = (Stage) logInButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
        } // if checkout button selected
        else if (event.getSource() == checkOutButton) {
            a = new Alert(Alert.AlertType.INFORMATION, "Are you sure you want to check out?", ButtonType.YES, ButtonType.NO);
            result = a.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.YES) {//if optional has anything in it and then can see what it is
                a = new Alert(Alert.AlertType.CONFIRMATION, "Payment Processing (2-3 Days)", ButtonType.OK);
                result = a.showAndWait();
                stage = (Stage) checkOutButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
            } else {
                stage = (Stage) checkOutButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/CheckOutView.fxml"));
            }

        } // if cancel button selected
        else if (event.getSource() == cancelButton) {
            stage = (Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
        } // exit the application
        else {
            System.exit(0);
        }
        // create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
