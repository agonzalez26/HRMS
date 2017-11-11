/* The ManagerViewController handles functionalities for the ManagerView.
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagerViewController implements Initializable {
    // variables

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
    private Button logOutButton;
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
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } // if room button selected
        else if (event.getSource() == roomButton) {
            stage = (Stage) roomButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } // if reservations button selected
        else if (event.getSource() == reservationsButton) {
            stage = (Stage) reservationsButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeReservation.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } // if room price button selected
        else if (event.getSource() == roomPriceButton) {
            stage = (Stage) roomPriceButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewPrice.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } // if employee button selected
        else if (event.getSource() == employeeButton) {
            stage = (Stage) employeeButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewEmployee.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } // if amenity button selected
        else if (event.getSource() == amenityButton) {
            stage = (Stage) amenityButton.getScene().getWindow();
            // load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ManagerViewAmenity.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } // exit application
        else {
            System.exit(0);
        }

    }
}
