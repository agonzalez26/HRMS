/*
 * The DayViewController will handle functionalities for the DayView.
 */
package hrms.Controller;

import hrms.HRMS;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class DayViewController implements Initializable {
    // variables

    @FXML
    private AnchorPane dayView;
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
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;

    private long dayCount;

    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

    /*
	 * Function will handle all button action events
     */
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
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
        } // if next button selected
        else if (event.getSource() == nextButton) {
            stage = (Stage) nextButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/GuestView.fxml"));
        } // if cancel button selected
        else if (event.getSource() == cancelButton) {
            stage = (Stage) cancelButton.getScene().getWindow();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
		 * Initialize the calendars to the correct dates.
         */
        calendarsInitialize();

    }

    private void calendarsInitialize() {

        Locale.setDefault(Locale.US);
        // this is setting the first calendar to the current date
        startDate.setValue(LocalDate.now());

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(LocalDate.now()) || item.isAfter(LocalDate.now())) {

                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        startDate.setDayCellFactory(dayCellFactory);
        startDate.setEditable(false);
        
        final Callback<DatePicker, DateCell> dayCellFactory2 = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        // if the dayCell is before the current day plus one
                        if (item.isBefore(startDate.getValue().plusDays(1))) {
                            // disable the cell and style
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }

                        dayCount = ChronoUnit.DAYS.between(startDate.getValue(), item);

                        setTooltip(new Tooltip("You're about to stay for " + dayCount + " days"));
                    }
                };
            }
        };

        endDate.setDayCellFactory(dayCellFactory2);
        endDate.setValue(startDate.getValue().plusDays(1));

    }

}
