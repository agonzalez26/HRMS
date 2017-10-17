/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author agonzalez26
 */
public class HomeViewController implements Initializable {
    @FXML 
    private Button checkInButton;
    @FXML
    private AnchorPane homeView;
    @FXML
    private Button logInButton;
    @FXML
    private Button checkOutButton;
    @FXML
    private TextField confirmationNumber;
    @FXML
    private Button bookReservationButton;
    @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        //checks which button does what
         if (event.getSource() == checkInButton) 
        {
            //get reference to the button's stage         
            stage = (Stage) checkInButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml"));

        }else if(event.getSource() == bookReservationButton){
            //get reference to the button's stage         
            stage = (Stage) bookReservationButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/ContactInfoView.fxml")); 
            
         }else if(event.getSource() == logInButton){
            //get reference to the button's stage         
            stage = (Stage) logInButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
        }else if(event.getSource() == checkOutButton){
             //get reference to the button's stage         
            stage = (Stage) logInButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/CheckOutView.fxml"));
         }else{
            System.exit(0);
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    
}
