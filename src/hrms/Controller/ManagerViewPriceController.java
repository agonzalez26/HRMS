/*
 * The ManagerViewPriceController handles functionalities for ManagerViewPrice.
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

public class ManagerViewPriceController implements Initializable {
	// variables
	@FXML
	private Button roomPriceButton;
	@FXML
	private Button employeeButton;
	@FXML
	private Button amenityButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button roomButton;
	@FXML
	private Button reservationsButton;
	@FXML
	private Button updatePriceButton;
	@FXML
	private Button managerButton;
	@FXML
	private Button logOutButton;
	@FXML
	private TextField confirmationNumberText;
	@FXML
	private Stage stage = null;
	@FXML
	private Parent root = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	/*
	 * Function that handles all button action events
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
		// if update price button selected
		else if (event.getSource() == updatePriceButton) {
			stage = (Stage) updatePriceButton.getScene().getWindow();
			System.out.println("Updated rooms price.");
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));

		}
		// if search button selected
		else if (event.getSource() == searchButton) {
			
			String conNum = confirmationNumberText.getText();
			if(conNum.equals("")){
				EmptyError();
				
				stage = (Stage) searchButton.getScene().getWindow();
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));
				
			}else if(!isNumeric(conNum)){
				// calls confirmation error method
				ConfirmationError();
//				System.out.println("Showing matched rooms");
				stage = (Stage) searchButton.getScene().getWindow();
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));
			
			}else{
				System.out.println("Showing matched rooms");
				stage = (Stage) searchButton.getScene().getWindow();
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));
			}
			

		}
		// if manager button selected
		else if (event.getSource() == managerButton) {
			stage = (Stage) managerButton.getScene().getWindow();

			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerView.fxml"));
		}
		// exit application
		else if(event.getSource() == roomButton){
			stage = (Stage) roomButton.getScene().getWindow();

			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));
		}else if(event.getSource() == reservationsButton){
			stage = (Stage) reservationsButton.getScene().getWindow();

			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));
		}

		// create a new scene with root and set the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/*
	 * Method called when textfield, confirmation number is empty
	 * 
	 * @pre: database is accessible, EmployeeReservationView
	 * 
	 * @post: filled textfield, EmployeeReservationView
	 */
	private void EmptyError() {
		// creates alert that there is missing information in the textfield
		Alert a = new Alert(Alert.AlertType.ERROR, "Missing confirmation number", ButtonType.OK);
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
	
	/*
	 * Method called when the confirmation number does not exist in the database
	 * 
	 * @pre: HomeView
	 * 
	 * @post: ConfirmationError Alert display, HomeView
	 */
	private void ConfirmationError() {
		Alert a = new Alert(Alert.AlertType.ERROR, "Incorrect Confirmation Number", ButtonType.OK);
		Optional<ButtonType> result = a.showAndWait();

	}
}
