/*
 * EmployeeReservationController handles functionalities of the EmployeeReservationView.
 */
package hrms.Controller;

import hrms.HRMS;
import hrms.Model.Application;
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

public class EmployeeReservationController implements Initializable {
    // variables

    @FXML
    private Button searchButton;
    @FXML
    private Button managerButton;
    @FXML
    private Button roomButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button logOutButton;
    @FXML
    private TextField reservationNumberText;
    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

    Application app = new Application();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        managerButton.setDisable(app.getEmp());
    }

    /*
	 * Function that handles all button action events
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // if room button selected
        if (event.getSource() == roomButton) {
            // get reference to the button's stage
            stage = (Stage) roomButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));

        } // if update button selected
        else if (event.getSource() == updateButton) {
            System.out.println("Updated Reservation");
            stage = (Stage) roomButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

        } // if delete button selected
        else if (event.getSource() == deleteButton) {
            System.out.println("Deleted Reservation");
            stage = (Stage) roomButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

        } // if search button selected
        else if (event.getSource() == searchButton) {
            String conNum = reservationNumberText.getText();
            if (conNum.equals("")) {
                EmptyError();

                stage = (Stage) roomButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

            } else if (!isNumeric(conNum)) {

                ConfirmationError();
                stage = (Stage) roomButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

            } else {
                System.out.println("Showing matched reservations");
                stage = (Stage) roomButton.getScene().getWindow();
                root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

            }
        } // if manager button selected
        else if (event.getSource() == managerButton) {
            stage = (Stage) managerButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/ManagerView.fxml"));

        } // if logout button selected
        else if (event.getSource() == logOutButton) {
            stage = (Stage) roomButton.getScene().getWindow();
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

    private void EmptyError() {
        // creates alert that there is missing information in the textfield
        Alert a = new Alert(Alert.AlertType.ERROR, "Missing reservation number", ButtonType.OK);
        // display the alert and must click ok before returning to main window
        Optional<ButtonType> result = a.showAndWait();
    }

    public static boolean isNumeric(String str) {
        // try catch to check if the input is an integer
        try {
            // parse the string into an integer
            int d = Integer.parseInt(str);
        } // catches if the string is not an integer
        catch (NumberFormatException nfe) {

            return false;
        }
        // the string is an integer
        return true;
    }

    private void ConfirmationError() {
        Alert a = new Alert(Alert.AlertType.ERROR, "Incorrect Reservation Number", ButtonType.OK);
        Optional<ButtonType> result = a.showAndWait();

    }
}
