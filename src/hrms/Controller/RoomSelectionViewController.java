/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrms.Controller;

import hrms.HRMS;
import hrms.Model.Application;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author agonzalez26
 */
public class RoomSelectionViewController implements Initializable {

    @FXML
    private AnchorPane roomSelectionView;
    @FXML
    private Button logInButton;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button tBut;
    @FXML
    private TextField billAmountText;
    @FXML
    private Label roomSelectedLabel;
    @FXML
    private Tab floor1tab;
    @FXML
    private AnchorPane floor1plan;
    @FXML
    private Tab floor2tab;
    @FXML
    private AnchorPane floor2plan;
    @FXML
    private Tab floor3tab;
    @FXML
    private AnchorPane floor3plan;
    @FXML
    private Tab floor4tab;
    @FXML
    private AnchorPane floor4plan;
      @FXML
    private Stage stage = null;
    @FXML
    private Parent root = null;
    
    
    private int numRooms; //Number of rooms chosen in RoomView
    private int roomCount = 0; //Number of rooms selected by guest
    private List<String> chosenRooms = new ArrayList<String>();
    
    Application app = new Application();

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
            root = FXMLLoader.load(HRMS.class.getResource("View/RoomView.fxml"));
         }else if(event.getSource() == nextButton){
            app.setChosenRooms(chosenRooms);
            stage = (Stage) nextButton.getScene().getWindow();
            root = FXMLLoader.load(HRMS.class.getResource("View/AmenityView.fxml"));
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
    
    public void handleRoomAction(ActionEvent event) throws IOException{
            Object source = event.getSource();
            Button clickedRoom = (Button) source;
            String roomName = clickedRoom.getId();
        if(chosenRooms.contains(roomName)){
            chosenRooms.remove(roomName);
            clickedRoom.setStyle("-fx-background-color:  #90EE90; ");
            roomCount--;
            roomSelectedLabel.setText(roomCount+" out of "+ numRooms+" rooms selected");
        }else{
            if(roomCount<numRooms){//user adds rooms to their selection
                chosenRooms.add(roomName);
                clickedRoom.setStyle("-fx-background-color:   #FFFAF0; ");
                roomCount++;
                roomSelectedLabel.setText(roomCount+" out of "+ numRooms+" rooms selected");
             }else{//if user has chosen all rooms
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("You have chosen the selected number of rooms");
                alert.showAndWait();
            }
        }
        
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setNumRooms(int numRooms){
        this.numRooms = numRooms;
    }
    
    public void initRooms(){
      chosenRooms = app.getChosenRooms();
      roomCount = chosenRooms.size();
      Scene sc = nextButton.getScene();
     
      for(String rooms: chosenRooms){
          String id = "#"+rooms;
          Button roomButton = (Button) sc.lookup(id);
          roomButton.setStyle("-fx-background-color:   #FFFAF0; ");
      }
      
      numRooms = parseInt(app.getRoomCount());
      roomSelectedLabel.setText(roomCount+" out of "+ numRooms+" rooms selected");
    }
    
}