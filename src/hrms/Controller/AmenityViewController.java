/*
 * The amenityViewController will manage the functionalities of the AmenityView.
 */
package hrms.Controller;

import hrms.HRMS;
import hrms.Model.Application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    @FXML
    private ChoiceBox roomChoiceBox;
    @FXML
    ListView<String> listView;

    Application app = new Application();

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
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } // if back button selected
        else if (event.getSource() == backButton) {
            // get reference to the button's stage
            stage = (Stage) nextButton.getScene().getWindow();
            FXMLLoader fxLoader = new FXMLLoader(HRMS.class.getResource("View/RoomSelectionView.fxml"));
            root = (Parent) fxLoader.load();
            RoomSelectionViewController controller = fxLoader.<RoomSelectionViewController>getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            controller.initRooms();
            stage.show();
        } // if next button selected
        else if (event.getSource() == nextButton) {
            stage = (Stage) nextButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/ConfirmationView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } // if cancel button selected
        else if (event.getSource() == cancelButton) {
            stage = (Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } // exit the application
        else {
            System.exit(0);
        }

        // create a new scene with root and set the stage
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//		listView.getItems().addAll(
//                        "Wifi:        Unlimited Access to Hotels Wifi",
//                        "Dinner:        All you can eat buffet.",
//                        "Car Service:        Rental of car for days staying.",
//                        "Parking Space:        Own reservered parking spot.",
//                        "Bar:        Access to unlimited mini bar.");
//                listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        amenitiesInitialize();
        ObservableList<String> rooms = FXCollections.observableArrayList(app.getChosenRooms());

        if (!rooms.isEmpty()) {
            roomChoiceBox.setItems(rooms);
            roomChoiceBox.setValue(rooms.get(0));
        }

    }

    private void amenitiesInitialize() {
        listView.getItems().addAll(
                "Wifi:        Unlimited Access to Hotels Wifi",
                "Dinner:        All you can eat buffet.",
                "Car Service:        Rental of car for days staying.",
                "Parking Space:        Own reservered parking spot.",
                "Bar:        Access to unlimited mini bar.");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
    }

}
