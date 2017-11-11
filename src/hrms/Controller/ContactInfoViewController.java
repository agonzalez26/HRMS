
/* 
 * The ContactInfoViewController handles functionalities of the ContactInfoView.
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
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class ContactInfoViewController implements Initializable {

    // Variables
    @FXML
    private AnchorPane contactInfoView;
    @FXML
    private Button logInButton;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField billAmountText;
    @FXML
    private TextField guestFirstName;
    @FXML
    private TextField guestLastName;
    @FXML
    private TextField guestPhoneNumber;
    @FXML
    private TextField guestEmailAddress;
    @FXML
    private TextField guestAddress1;
    @FXML
    private TextField guestAddress2;
    @FXML
    private TextField guestCCNumber;
    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    // Method that handles all of the button action events
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
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
        } // if next button selected
        else if (event.getSource() == nextButton) {
//            if (guestFirstName.getText().isEmpty() || guestLastName.getText().isEmpty() || guestPhoneNumber.getText().isEmpty()
//                    || guestEmailAddress.getText().isEmpty() || guestAddress1.getText().isEmpty() || guestAddress2.getText().isEmpty()
//                    || guestCCNumber.getText().isEmpty()) {
//                EmptyError();
//                stage = (Stage) nextButton.getScene().getWindow();
//                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
//            } else {
//                if (validateFields() == true) {
//                    stage = (Stage) nextButton.getScene().getWindow();
//                    root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
//                } else {
//                    stage = (Stage) nextButton.getScene().getWindow();
//                    root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
//                }
//            }
                    stage = (Stage) nextButton.getScene().getWindow();
                    root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
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

    public boolean validateFirstName() throws IOException {
        String firstName = guestFirstName.getText();
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
        String lastName = guestLastName.getText();
        if (!lastName.isEmpty()) {
            if (!lastName.matches("[a-zA-Z]+")) {
                return false;
            } else {
                return true;
            }
        }
        return true;

    }

    public boolean validateAddress() throws IOException {
        String address1 = guestAddress1.getText();
        String address2 = guestAddress2.getText();

        if ((!address1.isEmpty()) && (!address2.isEmpty())) {
            if (!address1.matches("\\d{1,5}\\s\\w+\\s\\w+") && !address2.matches("\\w+\\s\\w+\\s\\d{5}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean validateEmailAddress() throws IOException {
        String emailAddress = guestEmailAddress.getText();
        if (!emailAddress.isEmpty()) {
            if (!emailAddress.contains("@")) {
                return false;
            } else {
                return true;
            }
        }
        return true;

    }

    public boolean validatePhoneNumber() throws IOException {
        String phoneNumber = guestPhoneNumber.getText();
        if (!phoneNumber.isEmpty()) {
            if (!phoneNumber.matches("^\\d+{10}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean validateCreditCard() throws IOException {
        String creditCard = guestCCNumber.getText();
        if (!creditCard.isEmpty()) {
            if (!creditCard.matches("^\\d{8,19}")) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    private void EmptyError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "Missing Information", ButtonType.OK);
        Optional<ButtonType> result = a.showAndWait();
    }

    private boolean validateFields() throws IOException {
        if (validateFirstName() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "First Name not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validateLastName() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Last Name not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validatePhoneNumber() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Phone number not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validateEmailAddress() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Email Address not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validateAddress() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Address not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        } else if (validateCreditCard() == false) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card not formatted correctly", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            return false;
        }
        return true;
    }

}