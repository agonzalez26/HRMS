package hrms.Model;
import java.util.List;

/*Employee object has additional functionalities for the HRMS system.*/

public class Employee extends Operator{
	private int employeeId; /*employee id*/
	private boolean EmpOrManFlag; /*determines if a general employee or manager*/
	private List<Room> roomsList; /*list of rooms at the hotel*/
	private List<Amenity> amenitiesList; /*list of amenities at the hotel*/
	private List<Reservation> reservationsList; /*list of reservations at hotel*/
	
	/*@param employee id is set (int)*/
//	public void setEmployeeId(int id){}
//	
//	/*@return employee id*/
//	public int getEmployeeId(){}
//	
//	/*@param flag is set (boolean)*/
//	public void setFlag(boolean flag){}
//
//	/*@return flag*/
//	public boolean getFlag(){}

//	/*This allows employee to delete existing reservation
//	@pre reservation exists
//	@post reservation deleted from database */
//	public void deleteReservation(Reservation r) {}
//	
//	/*makes changes to reservation data in database and reservation object
//	@pre reservation must exist
//	@post updated reservation*/
//	public void editReservation(Reservation r) {}
//
//	/*Update Room information
//	 * @pre: room exists in hotel
//	 * @post: updated room information*/
//	public void updateRoom(Room ro){}
//	
//	/*@returns list of reservations*/
//	public List<Reservation> getReservationList(){}
//
//	/*@returns list of rooms*/
//	public List<Room> getRoomList(){}
//	
//	/*@return list of amenities*/
//	public List<Amenity> getAmenityList(){}
}
