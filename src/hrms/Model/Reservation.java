package hrms.Model;
import java.util.List;

import javafx.beans.property.*;


/*The Reservation object will exist or be created when Guest wants to stay at the hotel.*/

public class Reservation {
	private IntegerProperty reservationId; /*reservation id*/
	private Bill totalAmount; /*Bill total amount*/
	private Guest guestHolder; /*guest that has reservation*/
    private List<Room> roomList; /*list of rooms for the reservation*/
    
    public Reservation(){
    	reservationId = new SimpleIntegerProperty();
    	
    }
    /*@return reservation id*/
    public int getReservationId(){
    	return this.reservationId.get();
    }
    
    /*@param reservation id is set (int) to the desired guest*/
    public void setReservationId(int id){
    	this.reservationId.set(id);
    }
    
    public IntegerProperty reservationIdProperty(){
    	return reservationId;
    }
    
//    /*Adds room to the roomList for reservation*/
//    public void addRoom(Room r){}
//    
//    /*Removes room from roomLost of reservation*/
//    public void removeRoom(Room r){}
}
