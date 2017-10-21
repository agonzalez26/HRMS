package hrms.ModelClasses;

import javafx.beans.property.*;;

/* An Operator is anyone using the Hotel Reservation Management System(HRMS).An Operator can be a guest, employee or manager.*/

public class OperatorOld {
	  private IntegerProperty guestCount; /*number of guests for reservation*/
	  private IntegerProperty dayCount; /*number of days guest are staying for reservation*/
	  private IntegerProperty roomCount; /*number of rooms for reservation*/
	  
	  public OperatorOld(){
		  guestCount = new SimpleIntegerProperty();
		  dayCount = new SimpleIntegerProperty();
		  roomCount = new SimpleIntegerProperty();
	  }
	  
	  	/* @return guest count*/
	    public int getGuestCount(){
	    	return this.guestCount.get();
	
	    }
	    
	  /*@param guest count is set (int)*/
	    public void setGuestCount(ReservationOld r, int gcount){
	    	
	    }
	    public IntegerProperty guestCountProperty(){
	    	return guestCount;
	    }
	    
	    /*@return day count*/
	    public int getDayCount(){
	    	return this.dayCount.get();
	    }
	    
	    /*@param day count is set(int)
	     * @pre: dayCount > 1*/
	    public void setDayCount(ReservationOld r, int dcount){
	    	this.dayCount.set(dcount);
	    }
	  
	    public IntegerProperty dayCountProperty(){
	    	return dayCount;
	    }
	    /*@param room count is set (int)
	     * @pre: roomCount > 1*/
	    public void setRoomCount(ReservationOld r, int rcount){}
	  
	    /*@return room count*/
	    public int getRoomCount(){
	    	return this.roomCount.get();
	    }
	    
	    public IntegerProperty roomCountProperty(){
	    	return roomCount;
	    }

	    /*@return bill for reservation*/
//	    public Bill billAmount(Reservation r){}
//
//    /* Checkin to the system using the confirmation number which was
//    * given after the reservation.
//    * @pre Confirmation number exists in database
//    * @post Confirmation number is verified
//    */
//    private void checkInReservation(int ConfirmationNumber){}
//
//    /*  removes a completed reservation from the database
//    * @pre confirmation number exists in the database
//    * @post reservation is removed from the database
//    */
//    private void checkOutReservation(int ConfirmationNumber){}
//
//    /* creats and books a new reservation in the database
//    * @pre Guest doesn't have a current reservation
//    * @post a new reservation is added to the database
//    */
//    private void booksReservation(){}
//
//    /* Returns the current bill in the database for specific reservation.
//    @pre existing reservations
//    @post returns bill for reservation
//    */
//    public Bill viewBill(Reservation r){}
//
//    /* Updates first name address in the database
//    * @pre currently checked in to the reservation
//    * @post guest first name is updated in the database
//    */
//    public void updateGuestFirstName(String firstName){}
//
//    /* Updates Operator last name in the database
//    * @pre currently checked in to the reservation
//    * @post guest last name is updated in the database
//    */
//    public void updateGuestLastName(String lastName){}
//
//    /* Updates Operator address in the database
//    * @pre currently checked in to the reservation
//    * @post  guest address is updated in the database
//    */
//    public void updateAddress(String address){}
//
//    /* Updates Operator email in the database
//    * @pre currently checked in to the reservation
//    * @post guest email is updated in the database
//    */
//    public void updateEmail(String email){}
//
//    /* Updates Operator phone number in the database
//    * @pre currently checked in to the reservation
//    * @post phone number is updated in the database
//    */
//    public void updatePhoneNumber(int number){}
//
//    /*Cancels session of check in process
//     * @pre: in session
//     * @post: session terminated*/
//    private void cancelCheckinSession(int ConfirmationNumber){}
//    
    
}
