///*
// * The HomeViewController handles functionalities for HomeView.
// */
//package hrms.Controller;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import hrms.HRMS;
//import hrms.Controller.*;
//import java.util.Optional;
//import javafx.scene.Node;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.stage.Stage;
//
///**
// * 
// *
// * @author agonzalez26
// */
//
//public class HomeViewController implements Initializable {
//	// variables
//	@FXML
//	private Button checkInButton;
//	@FXML
//	private AnchorPane homeView;
//	@FXML
//	private Button logInButton;
//	@FXML
//	private Button checkOutButton;
//	@FXML
//	private TextField confirmationNumber;
//	@FXML
//	private Button bookReservationButton;
//	@FXML
//	private Stage stage = null;
//	@FXML
//	private Parent root = null;
//
//	/*
//	 * Function handles all button action events
//	 */
//	@FXML
//	private void handleButtonAction(ActionEvent event) throws IOException {
//		// if checkin button selected
//		if (event.getSource() == checkInButton) {
//			// retrieve confirmationNumber textField input
//			String s = confirmationNumber.getText();
//
//			// checks if input is empty
//			if (s.isEmpty()) {
//				// calls empty error method
//				EmptyError();
//
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
//
//			}
//			// if not empty and is not in integer
//			else if (!isNumeric(s)) {
//				// calls confirmation error method
//				ConfirmationError();
//
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
//
//			}
//			// everything correct
//			else {
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
//			}
//
//		}
//		// if book reservation button
//		else if (event.getSource() == bookReservationButton) {
//			// get reference to the button's stage
//			stage = (Stage) bookReservationButton.getScene().getWindow();
//			// load up OTHER FXML document
//			root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
//
//		}
//		// if login button selected
//		else if (event.getSource() == logInButton) {
//			// get reference to the button's stage
//			stage = (Stage) logInButton.getScene().getWindow();
//			// load up OTHER FXML document
//			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
//
//		}
//		// if checkout button selected
//		else if (event.getSource() == checkOutButton) {
//			// retrieves textfield input
//			String s = confirmationNumber.getText();
//			// checks if field is empty
//			if (s.isEmpty()) {
//				// calls empty error method
//				EmptyError();
//
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
//
//			}
//			// checks is input is an integer
//			else if (!isNumeric(s)) {
//				// calls confirmation error method
//				ConfirmationError();
//
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
//
//			}
//			// everything correct
//			else {
//				// get reference to the button's stage
//				stage = (Stage) checkInButton.getScene().getWindow();
//				// load up OTHER FXML document
//				root = FXMLLoader.load(HRMS.class.getResource("View/CheckOutView.fxml"));
//			}
//
//		}
//		// exit application
//		else {
//			System.exit(0);
//		}
//
//		// create a new scene with root and set the stage
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
//
//	@Override
//	public void initialize(URL url, ResourceBundle rb) {
//		// TODO
//	}
//
//	/*
//	 * Method called when the confirmation number does not exist in the database
//	 * 
//	 * @pre: HomeView
//	 * 
//	 * @post: ConfirmationError Alert display, HomeView
//	 */
//	private void ConfirmationError() {
//		Alert a = new Alert(Alert.AlertType.ERROR, "Incorrect Confirmation Number", ButtonType.OK);
//		Optional<ButtonType> result = a.showAndWait();
//
//	}
//
//	/*
//	 * Method called when the confirmation number field is empty
//	 * 
//	 * @pre: HomeView
//	 * 
//	 * @post: EmptyError Alert display, HomeView
//	 */
//	private void EmptyError() {
//		Alert a = new Alert(Alert.AlertType.ERROR, "Missing Confirmation Number", ButtonType.OK);
//		Optional<ButtonType> result = a.showAndWait();
//	}
//
//	/*
//	 * Method returns if the employee id is a integer
//	 * 
//	 * @pre: integer value in textfield
//	 * 
//	 * @post: true or false if integer number in textfield
//	 */
//	public static boolean isNumeric(String str) {
//		// try catch to check if the input is an integer
//		try {
//			// parse the string into an integer
//			int d = Integer.parseInt(str);
//		}
//		// catches if the string is not an integer
//		catch (NumberFormatException nfe) {
//
//			return false;
//		}
//		// the string is an integer
//		return true;
//	}
//
//}

/*
 * The HomeViewController handles functionalities for HomeView.
 */
package hrms.Controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import hrms.HRMS;
import hrms.Controller.*;
import hrms.Model.Application;
import java.util.ArrayList;
import java.util.Optional;
import java.util.prefs.Preferences;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * 
 *
 * @author agonzalez26
 */

public class HomeViewController implements Initializable {
	// variables
	@FXML
	private Button checkInButton;
	@FXML
	private AnchorPane homeView;
	@FXML
	private Button logInButton;
	@FXML
	private Button checkOutButton;
	@FXML
	private TextField reservationNumber;
	@FXML
	private Button bookReservationButton;
	@FXML
	private Stage stage = null;
	@FXML
	private Parent root = null;
        
        Application app = new Application();
        

	/*
	 * Function handles all button action events
	 */
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		// if checkin button selected
		if (event.getSource() == checkInButton) {
                        app.setGuestCount("0");
                        app.setRoomCount("0");
                        app.setChosenRooms(new ArrayList<>());
			// retrieve confirmationNumber textField input
			String s = reservationNumber.getText();

			// checks if input is empty
			if (s.isEmpty()) {
				// calls empty error method
				EmptyError();

				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));

			}
			// if not empty and is not in integer
			else if (!isNumeric(s)) {
				// calls confirmation error method
				ConfirmationError();

				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));

			}
			// everything correct
			else {
				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
			}

		}
		// if book reservation button
		else if (event.getSource() == bookReservationButton) {
                        app.setGuestCount("0");
                        app.setRoomCount("0");
                        app.setChosenRooms(new ArrayList<>());
			// get reference to the button's stage
			stage = (Stage) bookReservationButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));

		}
		// if login button selected
		else if (event.getSource() == logInButton) {
			// get reference to the button's stage
			stage = (Stage) logInButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));

		}
		// if checkout button selected
		else if (event.getSource() == checkOutButton) {
			// retrieves textfield input
			String s = reservationNumber.getText();
			// checks if field is empty
			if (s.isEmpty()) {
				// calls empty error method
				EmptyError();

				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));

			}
			// checks is input is an integer
			else if (!isNumeric(s)) {
				// calls confirmation error method
				ConfirmationError();

				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));

			}
			// everything correct
			else {
				// get reference to the button's stage
				stage = (Stage) checkInButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/CheckOutView.fxml"));
			}

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	/*
	 * Method called when the confirmation number does not exist in the database
	 * 
	 * @pre: HomeView
	 * 
	 * @post: ConfirmationError Alert display, HomeView
	 */
	private void ConfirmationError() {
		Alert a = new Alert(Alert.AlertType.ERROR, "Incorrect Reservation Number", ButtonType.OK);
		Optional<ButtonType> result = a.showAndWait();

	}

	/*
	 * Method called when the confirmation number field is empty
	 * 
	 * @pre: HomeView
	 * 
	 * @post: EmptyError Alert display, HomeView
	 */
	private void EmptyError() {
		Alert a = new Alert(Alert.AlertType.ERROR, "Missing Resrvation Number", ButtonType.OK);
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
