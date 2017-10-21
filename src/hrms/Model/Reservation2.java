package hrms.Model;
import java.util.List;

/*The Reservation object will exist or be created when Guest wants to stay at the hotel.*/

public class Reservation2 {
    private int reservationId; /*reservation id*/
    private List<Room> roomList; /*rooms attached to the reservation*/
    private Guest guestHolder; /*person that holds reservation*/
    private Bill totalAmount;//??? do we make an Bill object here;

    
    
    /*@param reservation id is set (int) to the desired guest*/
    public void setReservationId(int id){}
    
    /*@return reservation id*/
//    public int getReservationId(){}
    
    /*Adds room to the roomList for reservation*/
    public void addRoom(Room r){}
    
    /*Removes room from roomLost of reservation*/
    public void removeRoom(Room r){}
}
