/*The Room object is created when guest adds room to their reservation.*/
package hrms.Model;

import java.util.List;

public class Room {
	private int id; /* Room id of Room */
	private String description;/* Room description of Room */
	private List<Amenity> amenityList; /*
										 * List of amenities attached to the room
										 */
	private double roomPrice; /* room price */
	private boolean availability; /* if the room is available or not */
	private double totalPrice;
	private double totalAmenityPrice;
	private int amountOfGuests, amountOfAmenities;
	private Database db = new Database();

	/* @param room id is set (int) */
	public void setRoomId(int i) {
		id = i;
	}

	/* @return room id */
	public int getId() {
		return id;
	}

	/* @param room description is set (String) */
	public void setRoomDescription(String desc) {
		description = desc;
		db.updateRoom(this);
	}

	/* @return room description */
	public String getRoomDescription() {
		return description;
	}

	/* @param room price is set (double) */
	public void setRoomPrice(double price) {
		roomPrice = price;
		updateTotalPrice();
		db.updateRoom(this);
	}

	/* @return room price */
	public double getRoomPrice() {
		return roomPrice;
	}

	public double getAmenityPrice() {
		for (int count = 0; count < amenityList.size(); count++) {
			totalAmenityPrice += amenityList.get(count).getAmenityPrice();
		}
		return totalAmenityPrice;
	}

	public double getTotalPrice() {
		totalPrice = getAmenityPrice() + roomPrice;
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = getAmenityPrice() + roomPrice;
	}

	/*
	 * Add amenity to roomAmenitiesList
	 * 
	 * @pre: amenity exists in database
	 * 
	 * @post: amenity added to roomAmenitiesList
	 * 
	 * @post: roomAmenitiesList.size() > 0
	 */
	public void addAmenity(Amenity a) {
		amenityList.add(a);
		updateTotalPrice();
		db.updateRoom(this);
	}

	/*
	 * Remove amenity from roomAmenitiesList
	 * 
	 * @pre: amenity exists in roomAmenitiesList
	 * 
	 * @pre: roomAmenitiesList.size() > 0
	 * 
	 * @post: decrease size of roomAmenitiesList
	 */
	public void removeAmenity(Amenity a) {
		amenityList.remove(a);
		updateTotalPrice();
		db.updateRoom(this);
	}

	/* Returns list of amenities for Room */
	public List<Amenity> getAmenityList() {
		return amenityList;
	}

	/*
	 * Clears all existing data attached to room
	 * 
	 * @pre: roomId exists in database
	 * 
	 * @post: room data cleared from database
	 */
	public void clearRoom() {
		amenityList.clear();
		totalPrice = 0.0;
		totalAmenityPrice = 0.0;
		amountOfGuests = 0;
		amountOfAmenities = 0;
		availability = true;
	}

	/*
	 * Sets the Room to be available or unavailable
	 * 
	 * @pre: room must exist
	 * 
	 * @post: flag is set
	 */
	public void setAvailability(boolean b) {
		availability = b;
	}

	public boolean getAvailability() {
		return availability;
	}

	public String getAmenityIds() {
		String output = "";
		for (int count = 0; count < amenityList.size(); count++) {
			output += amenityList.get(count).getAmenityId() + " ";
		}
		return output;
	}

	public int getAmountOfAmenities() {
		return amountOfAmenities;
	}

	public int getAmountOfGuests() {
		return amountOfGuests;
	}
}
