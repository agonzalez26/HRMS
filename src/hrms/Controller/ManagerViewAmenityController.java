/* 
 * ManagerViewAmenityController handles functionalities for ManagerAmenityView.
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagerViewAmenityController implements Initializable {
	// variables
	@FXML
	private Button logOutButton;
	@FXML
	private Button roomButton;
	@FXML
	private Button reservationsButton;
	@FXML
	private Button managerButton;
	@FXML
	private Button roomPriceButton;
	@FXML
	private Button employeeButton;
	@FXML
	private Button amenityButton;
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button updateButton;
	@FXML
	private TextField amenityName;
	@FXML
	private TextField amenityPrice;
	@FXML
	private TextArea amenityDescription;
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
		// if room button selected
		else if (event.getSource() == roomButton) {
			stage = (Stage) roomButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));
			
		} else if (event.getSource() == reservationsButton) {
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
		// if add button selected
		else if (event.getSource() == addButton) {
			String name = amenityName.getText();
			String price = amenityPrice.getText();
			String description = amenityDescription.getText();
			
			if(name.isEmpty() || price.isEmpty() || description.isEmpty()){
				
					EmptyError();
					stage = (Stage) addButton.getScene().getWindow();
					// load up OTHER FXML document
					root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));	
		
			}else if(!name.isEmpty() && !price.isEmpty() && !description.isEmpty()){
				stage = (Stage) addButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
				System.out.println("Amenity added.");
			}

			stage = (Stage) addButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
		}
		// if delete button selected
		else if (event.getSource() == deleteButton) {
			String name = amenityName.getText();
			String price = amenityPrice.getText();
			String description = amenityDescription.getText();
			
			if(name.isEmpty() || price.isEmpty() || description.isEmpty()){
				
					EmptyError();
					stage = (Stage) deleteButton.getScene().getWindow();
					// load up OTHER FXML document
					root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));	
		
			}else if(!name.isEmpty() && !price.isEmpty() && !description.isEmpty()){
				stage = (Stage) deleteButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
				System.out.println("Amenity deleted.");
			}

			stage = (Stage) deleteButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
//			stage = (Stage) deleteButton.getScene().getWindow();
//			// load up OTHER FXML document
//			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
//			System.out.println("Amenity deleted..");
		}
		// if update button selected
		else if (event.getSource() == updateButton) {
			String name = amenityName.getText();
			String price = amenityPrice.getText();
			String description = amenityDescription.getText();
			
			if(name.isEmpty() || price.isEmpty() || description.isEmpty()){
				
					EmptyError();
					stage = (Stage) updateButton.getScene().getWindow();
					// load up OTHER FXML document
					root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));	
		
			}else if(!name.isEmpty() && !price.isEmpty() && !description.isEmpty()){
				stage = (Stage) updateButton.getScene().getWindow();
				// load up OTHER FXML document
				root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
				System.out.println("Amenity Updated.");
			}

			stage = (Stage) updateButton.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));

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
	 * Method called when the confirmation number field is empty
	 * 
	 * @pre: HomeView
	 * 
	 * @post: EmptyError Alert display, HomeView
	 */
	private void EmptyError() {
					Alert a = new Alert(Alert.AlertType.ERROR, "Missing Information", ButtonType.OK);
			Optional<ButtonType> result = a.showAndWait();
		
		

	}
}

