/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrms.Controller;

import static hrms.Controller.HomeViewController.isNumeric;
import hrms.HRMS;
import hrms.Model.Amenity;
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

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class EmployeeLoginViewController implements Initializable 
{

    @FXML
    private AnchorPane employeeLoginView;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button logInButton;
    @FXML
    private TextField employeeId;
    @FXML
    private TextField employeePassword;
      @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

        @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        //checks which button does what
        if(event.getSource() == backButton)
        {
             //get reference to the button's stage         
            stage = (Stage) backButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
        }
        else if(event.getSource() == nextButton)
        {
            String id = employeeId.getText();
            String password = employeePassword.getText();
                        
            if(id.isEmpty())
            {
                EmptyError();
                //get reference to the button's stage         
                stage = (Stage) nextButton.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
            }
            else if(!id.isEmpty() && password.isEmpty())
            {
                EmptyError();
                //get reference to the button's stage         
                stage = (Stage) nextButton.getScene().getWindow();
                //load up OTHER FXML document
                root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
            }
            else
            {
                if(isNumeric(id) && !password.isEmpty())
                {
                    //get reference to the button's stage         
                    stage = (Stage) nextButton.getScene().getWindow();
                    //load up OTHER FXML document
                    root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeView.fxml"));
                }
                else
                {
                    AccessDeniedError();
                    //get reference to the button's stage         
                    stage = (Stage) nextButton.getScene().getWindow();
                    //load up OTHER FXML document
                    root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
                }
            }         
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
        // TODO
    }    
   
    private void AccessDeniedError() 
    {
        Alert a = new Alert(Alert.AlertType.ERROR , "Incorrect Employee Id", ButtonType.OK);
        Optional<ButtonType> result =  a.showAndWait();
        
    }
    
    private void EmptyError()
    {
        Alert a = new Alert(Alert.AlertType.ERROR , "Missing Id/Password", ButtonType.OK);
        Optional<ButtonType> result =  a.showAndWait();  
    }

    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            int d = Integer.parseInt(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }
}
