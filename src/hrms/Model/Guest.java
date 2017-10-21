/*A Guest is a customer at the hotel. A Guest is
an extension of the Operator class that can create and update a Reservation.
Each guests will have information that is stored in the system.*/

package hrms.Model;

import java.util.List;

public class Guest extends Operator{
	private String firstName;	/*The first name of the guest at the hotel*/
	private String lastName;	 /*The last name of the guest staying at the hotel.*/
	private String address;	 /*The street address of the guest staying at the hotel*/
	private String email;	 /*The email address of the guest staying at the hotel.*/
	private String phoneNumber; /*The phone number of the guest staying at the hotel*/
	private int age;		//age of the guest
	private int id;	 /*The guest ID of the guest staying at the hotel.*/
	//private int confirmationNumber;	 /*The confirmation number of the guest staying at the hotel*/
	//The idea of a confirmation number isnt needed if we have reservation IDs
	//In the instance of having multiple reservations for one guest, we can have multiple reservation IDs 
	//assigned to a guest instead of one confirmation number which has the different reservation IDs
	//assigned to it anyways (inefficient)
	private int amountOfReservations;	//the number of reservations that the person has
	private List<Reservation> reservationList;	//The reservations assigned to that guest
	private Database db = new Database();
	
	public Guest(String fn, String ln, String adr, String eml, String pn, int a) {
		firstName = fn;
		lastName = ln;
		address = adr;
		email = eml;
		phoneNumber = pn;
		age = a;
		db.addGuest(fn, ln, adr, eml, pn, a);
	}
	/*@param guest first name is set (String)*/
	public void setGuestFirstName(String fName){
		firstName = fName;
		db.updateGuest(this);
	}
	
	/*@return guest first name*/
	public String getFirstName() {
		return firstName;
	}
	
	/*@param guest last name is set (String)*/
	public void setLastName(String lName){
		lastName = lName;
		db.updateGuest(this);
	}
	
	/*@return guest last name*/
	public String getLastName(){
		return lastName;
	}
	
	/*@param guest address is set (String)*/
	public void setAddress(String adr){
		address = adr;
		db.updateGuest(this);
	}
	
	/*@return guest address*/
	public String getAddress(){
		return address;
	}
	
	/*@param guest email is set (String)*/
	public void setEmail(String em){
		email = em;
		db.updateGuest(this);
	}
	
	/*@return guest email*/
	public String getEmail(){
		return email;
	}
	
	/*@param guest phone number is set (String)*/
	public void setPhoneNum(String pnum){
		phoneNumber = pnum;
		db.updateGuest(this);
	}
	
	/*@return guest phone number*/
	public String getPhoneNum(){
		return phoneNumber;
	}
	
	/*@param guest id is set (int)*/
	public void setId(int i){
		id = i;
		db.updateGuest(this);
	}

	/*@return guest id*/
	public int getId(){
		return id;
	}
	
	public List<Reservation> getReservationList(){
		return reservationList;
	}
	public int getAmountOfReservations() {
		return amountOfReservations;
	}
	/*Get all reservations Ids in one string */
	public String getReservationIds() {
		String output = "";
		for(int count=0;count<reservationList.size();count++) {
			output += reservationList.get(count).getId() + " ";
		}
		return output;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\tID: " + id;
	}

}
