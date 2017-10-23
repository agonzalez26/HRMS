/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class DayViewController implements Initializable 
{

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

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        //checks which button does what
         if(event.getSource() == logInButton)
         {
            //get reference to the button's stage         
            stage = (Stage) logInButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
        }
         else if(event.getSource() == backButton)
         {
             //get reference to the button's stage         
            stage = (Stage) backButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));
         }
         else if(event.getSource() == nextButton)
         {
            stage = (Stage) nextButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/GuestView.fxml"));
         }
         else if( event.getSource() == cancelButton)
         {
            stage = (Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
         }
         else
         {
            System.exit(0);
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Locale.setDefault(Locale.US);
        startDate.setValue(LocalDate.now());
        //endDate.setValue(startDate.getValue().plusDays(1));
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() 
            {
                @Override
                public DateCell call(final DatePicker datePicker) 
                {
                    return new DateCell() 
                    {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) 
                        {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    startDate.getValue())
                                ) 
                            {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        startDate.setDayCellFactory(dayCellFactory);
//        endDate.setValue(startDate.getValue().plusDays(1));
        
        final Callback<DatePicker, DateCell> dayCellFactory2 = 
            new Callback<DatePicker, DateCell>() 
            {
                @Override
                public DateCell call(final DatePicker datePicker) 
                {
                    return new DateCell() 
                    {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) 
                        {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    startDate.getValue().plusDays(1))
                                )
                            {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }
                            dayCount = ChronoUnit.DAYS.between(
                                    startDate.getValue(), item
                            );
                            setTooltip(new Tooltip(
                                "You're about to stay for " +dayCount + " days")
                            );
                    }
                };
            }
        };
        endDate.setDayCellFactory(dayCellFactory2);
        endDate.setValue(startDate.getValue().plusDays(1));
    }    
    
}
