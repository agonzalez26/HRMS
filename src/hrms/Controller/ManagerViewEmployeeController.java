/* 
 * The ManagerViewEmployeeController handles functionalities for ManagerViewEmployee.
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

public class ManagerViewEmployeeController implements Initializable {
	// variables
	@FXML
	private Button logOutButton;
	@FXML
	private Button roomButton;
	@FXML
	private Button reservationsButton;
	@FXML
	private Button roomPriceButton;
	@FXML
	private Button employeeButton;
	@FXML
	private Button amenityButton;
	@FXML
	private Button createButton;
	@FXML
	private Button removeButton;
	@FXML
	private Button managerButton;
	@FXML
	private TextField employeeId;
	@FXML 
	private TextField employeePassword;
	@FXML
	private Stage stage = null;
	@FXML
	private Parent root = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	/*
	 * Function handles all button action events
	 */
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		// if logout button selected
		if (event.getSource() == logOutButton) {
			// get reference to the button's stage
			stage = (Stage) logOutButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));

		}
		// if room button selected
		else if (event.getSource() == roomButton) {
			stage = (Stage) roomButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));

		}
		// if reservations button selected
		else if (event.getSource() == reservationsButton) {
			stage = (Stage) reservationsButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));

		}
		// if room price button selected
		else if (event.getSource() == roomPriceButton) {
			stage = (Stage) roomPriceButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));

		}
		// if employee button selected
		else if (event.getSource() == employeeButton) {
			stage = (Stage) employeeButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));

		}
		// if amenity button selected
		else if (event.getSource() == amenityButton) {
			stage = (Stage) amenityButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));

		}
		// if create button selected
		else if (event.getSource() == createButton) {
			// retrieve the employeeId and password TextField inputs
			String id = employeeId.getText();
			String password = employeePassword.getText();

			// checks if id is not empty but password is empty
			if ((id.isEmpty() && password.isEmpty()) || id.isEmpty() || password.isEmpty()) {
				// call error message
				EmptyError();

				// get reference to the button's stage
				stage = (Stage) createButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));
			}
			// if id and password are not empty inputs
			else {
				// checks if id is a number and password is not empty
				if (isNumeric(id) && !password.isEmpty()) {
					System.out.println("Employee created.");
					// get reference to the button's stage
					stage = (Stage) createButton.getScene().getWindow();
					// load up OTHER FXML document
					root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));
				} 
			}

		}
		// if remove button selected
		else if (event.getSource() == removeButton) {
			// retrieve the employeeId and password TextField inputs
						String id = employeeId.getText();
						String password = employeePassword.getText();

						// checks if id is not empty but password is empty
						if ((id.isEmpty() && password.isEmpty()) || id.isEmpty() || password.isEmpty()) {
							// call error message
							EmptyError();

							// get reference to the button's stage
							stage = (Stage) removeButton.getScene().getWindow();
							// load up OTHER FXML document
							root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));
						}
						// if id and password are not empty inputs
						else {
							// checks if id is a number and password is not empty
							if (isNumeric(id) && !password.isEmpty()) {
								System.out.println("Employee removed.");

								// get reference to the button's stage
								stage = (Stage) removeButton.getScene().getWindow();
								// load up OTHER FXML document
								root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));
							}
						}

		}
		// if manager button selected
		else if (event.getSource() == managerButton) {
			stage = (Stage) managerButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerView.fxml"));

		}
		// exit application
		else {
			System.exit(0);
		}

		// create a new scene with root and set the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/*
	 * Method called when textfields, id or password, are empty
	 * 
	 * @pre: database is accessible, EmployeeLoginView
	 * 
	 * @post: filled textfields, EmployeeLoginView
	 */
	private void EmptyError() {
		// creates alert that there is missing information in the textfields
		Alert a = new Alert(Alert.AlertType.ERROR, "Missing information (Id or Password)", ButtonType.OK);
		// display the alert and must click ok before returning to main window
		Optional<ButtonType> result = a.showAndWait();
	}

	/*
	 * Method returns if the employee id is a integer
	 * 
	 * @pre: integer value in textfield
	 * 
	 * @post: true or false if integer number in textfield
	 */
	public static boolean isNumeric(String str) {
		// try catch to check if the input is an integer
		try {
			// parse the string into an integer
			int d = Integer.parseInt(str);
		}
		// catches if the string is not an integer
		catch (NumberFormatException nfe) {

			return false;
		}
		// the string is an integer
		return true;
	}
	
	

}
