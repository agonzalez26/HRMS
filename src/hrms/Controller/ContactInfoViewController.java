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
            // stage = (Stage) nextButton.getScene().getWindow();
            // //validation of first name
            // validateFirstName();
            // //validation of last name
            // validateLastName();
            // //validation of phone number
            // validatePhoneNumber();
            // //validation of email address
            // validateEmailAddress();
            // //validation of home address
            // validateAddress();
            // //validation of creditcard number
            // validateCreditCard();
            stage = (Stage) cancelButton.getScene().getWindow();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void validateFirstName() throws IOException {
        String firstName = guestFirstName.getText();

        if (!firstName.isEmpty()) {
            if (!firstName.matches("[a-zA-Z]+")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "First Name Not Text", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "First Name Empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));

        }

    }

    public void validateLastName() throws IOException {
        String lastName = guestLastName.getText();
        if (!lastName.isEmpty()) {
            if (!lastName.matches("[a-zA-Z]+")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Last Name Not Text", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Last Name Empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));

        }

    }

    public void validateAddress() throws IOException {
        String address1 = guestAddress1.getText();
        String address2 = guestAddress2.getText();

        if ((!address1.isEmpty()) && (!address2.isEmpty())) {
            if (!address1.matches("\\d{1,5}\\s\\w+\\s\\w+")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Address needs to be proper format", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Address field is empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        }

        if (!address2.isEmpty()) {
            if (!address2.matches("\\w+\\s\\w+\\s\\d{5}")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Address needs to be proper format", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Address field is empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        }
    }

    public void validateEmailAddress() throws IOException {
        String emailAddress = guestEmailAddress.getText();
        if (!emailAddress.isEmpty()) {
            if (!emailAddress.contains("@")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Email needs to be valid", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Email field is empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        }

    }

    public void validatePhoneNumber() throws IOException {
        String phoneNumber = guestPhoneNumber.getText();
        if (!phoneNumber.isEmpty()) {
            if (!phoneNumber.matches("^\\d+")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Phone Number needs to be valid", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Phone Number field is empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        }
    }

    public void validateCreditCard() throws IOException {
        String creditCard = guestCCNumber.getText();
        if (!creditCard.isEmpty()) {
            if (!creditCard.matches("^\\d{8,19}")) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card number needs to be valid", ButtonType.OK);
                Optional<ButtonType> result = a.showAndWait();
                root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
            } else {
                root = FXMLLoader.load(HRMS.class.getResource("View/DayView.fxml"));
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Credit Card field is empty", ButtonType.OK);
            Optional<ButtonType> result = a.showAndWait();
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        }
    }

}
