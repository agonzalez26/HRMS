package hrms.Model;

import javafx.beans.property.*;

/*A Guest is a customer at the hotel. A Guest is
an extension of the Operator class that can create and update a Reservation.
Each guests will have information that is stored in the system.*/

public class Guest extends Operator{
	private StringProperty firstName; /*guest first name*/
	private StringProperty lastName; /*guest last name*/
	private StringProperty homeAddress; /*home address*/
	private StringProperty emailAddress; /*email address*/
	private StringProperty phoneNumber; /*phone number*/
	private IntegerProperty guestId; /*guest id*/
	private IntegerProperty confirmationNumber; /*confirmation number for reservation*/
	
	public Guest(){
		firstName = new SimpleStringProperty();
		lastName = new SimpleStringProperty();
		homeAddress = new SimpleStringProperty();
		emailAddress = new SimpleStringProperty();
		phoneNumber = new SimpleStringProperty();
		guestId = new SimpleIntegerProperty();
		confirmationNumber = new SimpleIntegerProperty();
	}
	
	/*@return guest first name*/
	public String getFirstName(){
		return firstName.get();
	}
	
	/*@param guest first name is set (String)*/
	public void setFirstName(String first){
		this.firstName.set(first);
	}
	
	public StringProperty firstNameProperty(){
		return firstName;
	}
	
	/*@return guest last name*/
	public String getLastName(){
		return this.lastName.get();
	}
	
	/*@param guest last name is set (String)*/
	public void setLastName(String last){
		this.lastName.set(last);
	}
	
	public StringProperty lastNameProperty(){
		return lastName;
	}
	
	/*@return guest address*/
	public String getHomeAddress(){
		return homeAddress.get();
	}
	
	/*@param guest address is set (String)*/
	public void setHomeAddress(String address){
		this.homeAddress.set(address);
	}
	
	public StringProperty homeAddressProperty(){
		return homeAddress;
	}
	
	/*@return guest phone number*/
	public String getPhoneNumber(){
		return this.phoneNumber.get();
	}
	/*@param guest phone number is set (String)*/
	public void setPhoneNumber(String phone){
		this.phoneNumber.set(phone);
	}
	
	public StringProperty phoneNumberProperty(){
		return phoneNumber;
	}
	
	/*@return guest email*/
	public String getEmailAddress(){
		return this.emailAddress.get();
	}
	
	/*@param guest email is set (String)*/
	public void setEmailAddress(String email){
		this.emailAddress.set(email);
	}
	
	public StringProperty emailAddressProperty(){
		return emailAddress;
	}

	/*@return guest id*/
	public int getGuestId(){
		return this.guestId.get();
	}

	/*@param guest id is set (int)*/
	public void setGuestId(int id){
		this.guestId.set(id);
	}
	
	public IntegerProperty guestIdProperty(){
		return guestId;
	}
	
	/*@return guest confirmation number*/
	public int getConfirmationNumber(){
		return this.confirmationNumber.get();
	}
	
	/*@param guest confirmation number is set (int)*/
	public void setConfirmationNumber(int num){
		this.confirmationNumber.set(num);
	}

	public IntegerProperty confirmationNumberProperty(){
		return confirmationNumber;
	}

}
