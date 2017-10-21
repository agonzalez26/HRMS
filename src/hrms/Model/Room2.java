package hrms.Model;
/*The Room object is created when guest adds room to their reservation.*/
import java.util.List;

public class Room2 {
	private int roomId; /*Room id of Room*/
	private String roomDescription;/*Room description of Room*/
//	private Guest primaryPerson; /*Guest that has Room on hold*/ this can probably go in the reservation side 
//	private List<Guest> secondaryPeople; questionable if we need to add the info of guest staying in room
	private List<Amenity> roomAmenitiesList; /*List of amenities attached to the room*/
	private double roomPrice; /*room price*/
//	private double totalPrice;/**/
	private boolean availability; /*if the room is available or not*/
	
	/*@param room id is set (int)*/
	public void setRoomId(int id){}
//	
//	/*@return room id*/
//	public int getRoomId(){}
//	
//	/*@param room description is set (String)*/
//	public void setRoomDescription(String description){}
//	
//	/*@return room description*/
//	public String getRoomDescription(){}
//	
//	/*@param room price is set (double)*/
//	public void setRoomPrice(double price){}
//	
//	/*@return room price*/
//	public double getRoomPrice(){}
//	
////	/*Add amenity to roomAmenitiesList
//	 * @pre: amenity exists in database
//	 * @post: amenity added to roomAmenitiesList
//	 * @post: roomAmenitiesList.size() > 0*/
//	public void addAmenity(Amenity a){}
	
	/*Remove amenity from roomAmenitiesList
	 * @pre: amenity exists in roomAmenitiesList
	 * @pre: roomAmenitiesList.size() > 0
	 * @post: decrease size of roomAmenitiesList*/
	public void removeAmenity(Amenity a){}
	
	/*Returns list of amenities for Room*/
//	public List<Amenity> viewRoomAmenitiesList(){}
	
	/*Clears all existing data attached to room
	 * @pre: roomId exists in database
	 * @post: room data cleared from database
	 * */
	public void clearRoom(){}
	
	/*Sets the Room to be available or unavailable
	 * @pre: room must exist
	 * @post: flag is set*/
	public void setRoomAvailability(boolean b){}
	
}
