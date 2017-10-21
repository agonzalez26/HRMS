package hrms.Model;
/*The Room object is created when guest adds room to their reservation.*/
import java.util.List;

import javafx.beans.property.*;

public class Room {
	private IntegerProperty roomId; /*room id*/
	private StringProperty roomDescription; /*room description*/
	private DoubleProperty roomPrice; /*room price*/
	private BooleanProperty roomAvailability; /*room availability*/
	
	private List<Amenity> roomAmenitiesList; /*List of amenities attached to the room*/

	public Room(){
		roomId = new SimpleIntegerProperty();
		roomDescription = new SimpleStringProperty();
		roomPrice = new SimpleDoubleProperty();
		roomAvailability = new SimpleBooleanProperty();
	}
	/*@return room id*/
	public int getRoomId(){
		return this.roomId.get();
	}
	
	/*@param room id is set (int)*/
	public void setRoomId(int id){
		this.roomId.set(id);
	}
	public IntegerProperty roomIdProperty(){
		return roomId;
	}
	
	/*@return room description*/
	public String getRoomDescription(){
		return this.roomDescription.get();
	}
	
	/*@param room description is set (String)*/
	public void setRoomDescription(String description){
		this.roomDescription.set(description);
	}
	
	public StringProperty roomDescriptionProperty(){
		return roomDescription;
	}
	
	/*@return room price*/
	public double getRoomPrice(){
		return this.roomPrice.get();
	}
	
	/*@param room price is set (double)*/
	public void setRoomPrice(double price){
		this.roomPrice.set(price);
	}
	
	public DoubleProperty roomPriceProperty(){
		return roomPrice;
	}

	/*@return availability*/
	public boolean getRoomAvailability(){
		return this.roomAvailability.get();
	}
	
	/*@param room price is set (double)*/
	public void setRoomAvailability(boolean status){
		this.roomAvailability.set(status);
	}
	
	public BooleanProperty roomAvailabilityProperty(){
		return roomAvailability;
	}
	
	//what to do with these
//	
//	/*Add amenity to roomAmenitiesList
//	 * @pre: amenity exists in database
//	 * @post: amenity added to roomAmenitiesList
//	 * @post: roomAmenitiesList.size() > 0*/
//	public void addAmenity(Amenity a){}
//	
//	/*Remove amenity from roomAmenitiesList
//	 * @pre: amenity exists in roomAmenitiesList
//	 * @pre: roomAmenitiesList.size() > 0
//	 * @post: decrease size of roomAmenitiesList*/
//	public void removeAmenity(Amenity a){}
//	
//	/*Returns list of amenities for Room*/
//	public List<Amenity> viewRoomAmenitiesList(){}
//	
//	/*Clears all existing data attached to room
//	 * @pre: roomId exists in database
//	 * @post: room data cleared from database
//	 * */
//	public void clearRoom(){}
//	
//	/*Sets the Room to be available or unavailable
//	 * @pre: room must exist
//	 * @post: flag is set*/
//	public void setRoomAvailability(boolean b){}
//	
}
