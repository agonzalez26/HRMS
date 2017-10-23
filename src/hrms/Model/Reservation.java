package hrms.Model;

import java.util.List;

/*The Reservation object will exist or be created when Guest wants to stay at the hotel.*/
//Each reservation is its own separate entity that will have to be paid for individually

public class Reservation {
	private int id; /* reservation id */
	private int amountOfRooms; // the number of rooms on this reservation
	private List<Room> roomList; /* rooms attached to the reservation */
	// private Guest guestHolder; /*person that holds reservation*/ //not needed
	// private Bill totalAmount;//??? do we make an Bill object here;
	private double finalPrice;
	private Database db = new Database();

	public Reservation(Room... rooms) {
		int count = 0;
		for (Room r : rooms) {
			count++;
			roomList.add(r);
			amountOfRooms = count;
		}
		db.addReservation(getRoomIds());
	}

	/* @param reservation id is set (int) to the desired guest */
	public void setId(int i) {
		id = i;
		db.updateReservation(this);
	}

	/* @return reservation id */
	public int getId() {
		return id;
	}

	/* Adds room to the roomList for reservation */
	public void addRoom(Room r) {
		roomList.add(r);
		updateFinalPrice();
		db.updateReservation(this);
	}

	/* Removes room from roomLost of reservation */
	public void removeRoom(Room r) {
		roomList.remove(r);
		updateFinalPrice();
		db.updateReservation(this);
	}

	public double getFinalPrice() {
		for (int count = 0; count < roomList.size(); count++) {
			finalPrice += roomList.get(count).getTotalPrice(); // Bad
																// programming,
																// 2 methods,
																// same
																// thing.... oh
																// well, don't
																// follow me
		}
		return finalPrice;
	}

	public void updateFinalPrice() {
		for (int count = 0; count < roomList.size(); count++) {
			finalPrice += roomList.get(count).getTotalPrice();
		}
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public int getAmountOfRooms() {
		return amountOfRooms;
	}

	public String getRoomIds() {
		String output = "";
		for (int count = 0; count < roomList.size(); count++) {
			output += roomList.get(count).getId() + " ";
		}
		return output;
	}
	/*
	 * public String getBillOverview() { //I'll do this laterrrrrr }
	 */
}
