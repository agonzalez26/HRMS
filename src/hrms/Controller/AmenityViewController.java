/*
 * The amenityViewController will manage the functionalities of the AmenityView.
 */
package hrms.Controller;

import hrms.HRMS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */

public class AmenityViewController implements Initializable {
	// variables
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
	private TextArea amenityDescription;
	@FXML
	private Stage stage = null;
	@FXML
	private Parent root = null;
	@FXML
	private AnchorPane employeeLoginView;
	@FXML
	private TextField guestFirstName;
	@FXML
	private TextField guestLastName;

	/*
	 * Function handles all the button Action Events
	 */
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		// if login button selected
		if (event.getSource() == logInButton) {
			// get reference to the button's stage
			stage = (Stage) logInButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
		}
		// if back button selected
		else if (event.getSource() == backButton) {
			// get reference to the button's stage
			stage = (Stage) backButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/RoomSelectionView.fxml"));
		}
		// if next button selected
		else if (event.getSource() == nextButton) {
			stage = (Stage) nextButton.getScene().getWindow();
			root = FXMLLoader.load(HRMS.class.getResource("View/ConfirmationView.fxml"));
		}
		// if cancel button selected
		else if (event.getSource() == cancelButton) {
			stage = (Stage) cancelButton.getScene().getWindow();
			root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
		}
		// exit the application
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

}
