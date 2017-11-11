/*
 * The ConfirmationViewController will handle functionalities of the ConfirmationView.
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
public class ConfirmationViewController implements Initializable {
    // variables

    @FXML
    private AnchorPane confirmationView;
    @FXML
    private Button logInButton;
    @FXML
    private Button backButton;
    @FXML
    private Button cancelButton;
    private Stage stage = null;
    private Parent root = null;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField ccFName;
    @FXML
    private TextField ccLName;
    @FXML
    private TextField ccNumber;
    @FXML
    private TextField ccCVV;
    @FXML
    private TextField ccBillingZip;

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
        } // if back button selected
        else if (event.getSource() == backButton) {
            // get reference to the button's stage
            stage = (Stage) backButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/AmenityView.fxml"));
        } // if next button selected
        else if (event.getSource() == confirmButton) {
            if(ccFName.getText().isEmpty() || ccLName.getText().isEmpty() || ccCVV.getText().isEmpty() || ccBillingZip.getText().isEmpty()){
                EmptyError();
                stage = (Stage) confirmButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/ConfirmationView.fxml"));
            }else{
                //need to do validation
                if(validateCCFields() == true){
                    stage = (Stage) confirmButton.getScene().getWindow();
                     root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
            
                }else{
                    stage = (Stage) confirmButton.getScene().getWindow();
                    root = FXMLLoader.load(HRMS.class.getResource("View/ConfirmationView.fxml"));
            
                }
            }
        } // if cancel button selected
        else if (event.getSource() == cancelButton) {
            stage = (Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
        } // exit application
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
        // TODO
    }
    private void EmptyError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "Missing Credit Card Information", ButtonType.OK);
        Optional<ButtonType> result = a.showAndWait();
    }

    private boolean validateCCFields() throws IOException {
         if (validateFirstName() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "First Name not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validateLastName() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Last Name not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        }else if(validateCreditCardNumber() == false){
            Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card Number not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        }else if(validateCCCVV() == false){
            Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card CVV not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        }
         else if(validateCCZip() == false){
            Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card Zip Code not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        }
         return true;
    }
    //needs to be corrected
    public boolean validateCCCVV() throws IOException {
        String creditCardCVV = ccCVV.getText();
        if (!creditCardCVV.isEmpty()) {
            if (!creditCardCVV.matches("^\\d{3}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean validateCCZip() throws IOException {
        String zip = ccBillingZip.getText();
        if (!zip.isEmpty()) {
            if (!zip.matches("^\\d+{5,9}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
    
     public boolean validateCreditCardNumber() throws IOException {
        String creditCardNumber = ccNumber.getText();
        if (!creditCardNumber.isEmpty()) {
            if (!creditCardNumber.matches("^\\d{14,16}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
       public boolean validateFirstName() throws IOException {
        String firstName = ccFName.getText();
        if (!firstName.isEmpty()) {
            if (!firstName.matches("[a-zA-Z]+")) {
                return false;
            } else {
                return true;
            }

        }
        return true;

    }

    public boolean validateLastName() throws IOException {
        String lastName = ccLName.getText();
        if (!lastName.isEmpty()) {
            if (!lastName.matches("[a-zA-Z]+")) {
                return false;
            } else {
                return true;
            }
        }
        return true;

    }
}
