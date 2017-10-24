/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrms.Controller;

import hrms.HRMS;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class RoomViewController implements Initializable {
    ObservableList<String> roomCountList = FXCollections.observableArrayList("0","1", "2", "3", "4", "5", "6", "7","8", "9", "10+");

    @FXML
    private AnchorPane roomView;
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
    private ChoiceBox roomCountBox;
      @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;

        @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        //checks which button does what
         if(event.getSource() == logInButton){
            //get reference to the button's stage         
            stage = (Stage) logInButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/EmployeeLoginView.fxml"));
        }else if(event.getSource() == backButton){
             //get reference to the button's stage         
            stage = (Stage) backButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(HRMS.class.getResource("View/GuestView.fxml"));
         }else if(event.getSource() == nextButton){
            stage = (Stage) nextButton.getScene().getWindow();
              FXMLLoader fxLoader = new FXMLLoader(HRMS.class.getResource("View/RoomSelectionView.fxml"));
              root = (Parent)fxLoader.load();  
              RoomSelectionViewController controller = fxLoader.<RoomSelectionViewController>getController();
              String option = roomCountBox.getValue().toString();
              int optionSelected = parseInt(option);  
              System.out.println(optionSelected);
              controller.setNumRooms(optionSelected);

         }else if( event.getSource() == cancelButton){
            stage = (Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/HomeView.fxml"));
         }else{
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
    public void initialize(URL url, ResourceBundle rb) {
        roomCountBox.setItems(roomCountList);
        roomCountBox.setValue("0");
    }    
    
}