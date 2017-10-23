package hrms.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	Connection c = null;
	Statement stmt = null;
	
	public Database(){
		//attempt to connect to DB
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Database.sqlite");
			System.out.println("Database connection successful");
		}catch(Exception e) {
			System.out.println("\nError 1:\n" + e.getMessage());
		}
	}
	public void closeConnection() {
		try {
			c.close();
		}catch(Exception e) {
			System.out.println("\nError attempting to close connection");
		}
	}
	public void addGuest(String firstName, String lastName, String address,
			String email, String phoneNumber, int age) {							//add guest to database
		try {
			PreparedStatement prep = c.prepareStatement("INSERT INTO Guests VALUES (?,?,?,?,?,?,?,?,?)");
			prep.setString(2, firstName);
			prep.setString(3, lastName);
			prep.setString(4, address);
			prep.setString(5, email);
			prep.setString(6, phoneNumber);
			prep.setInt(9, age);
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 7:\n" + e.getMessage());
		}
		System.out.println("Guest successfully added");
	}
	public void addReservation(String... IDs) {									//add reservation to database
		int amountOfRooms = 0;
		String roomIDs = "";
		for(String in : IDs) {
			amountOfRooms++;
			roomIDs += in + " ";
		}
		try {
			PreparedStatement prep = c.prepareStatement("INSERT INTO Guests VALUES (?,?,?,?)");
			prep.setInt(2, amountOfRooms);
			prep.setString(3, roomIDs);
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 8:\n" + e.getMessage());
		}
		System.out.println("Reservation successfully added");
	}
	public void addAmenity(String name, String description, double price) {			//add amenity to database
		
		try {
			PreparedStatement prep = c.prepareStatement("INSERT INTO Guests VALUES (?,?,?,?)");
			prep.setString(3, name);
			prep.setString(4, description);
			prep.setDouble(5, price);
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 10:\n" + e.getMessage());
		}
		System.out.println("Amenity successfully added");
	}
	public void deleteGuest(Guest g) {											//delete guest and any related data from database only
		try {
			PreparedStatement prep = c.prepareStatement("DELETE FROM Rooms WHERE id = ?;");
			prep.setInt(1, g.getId());
			prep.execute();
			for(int count=0;count<g.getReservationList().size();count++) {
				deleteReservation(g.getReservationList().get(count));
			}
		}catch(Exception e) {
			System.out.println("\nError 11:\n" + e.getMessage());
		}
	}
	public void deleteReservation(Reservation r) {										//delete reservation and any related data from database only
		try {
			PreparedStatement prep = c.prepareStatement("DELETE FROM Reservations WHERE id = ?;");
			prep.setInt(1, r.getId());
			prep.execute();
			for(int count=0;count<r.getRoomList().size();count++) {
				clearRoom(r.getRoomList().get(count));
			}
		}catch(Exception e) {
			System.out.println("\nError 12:\n" + e.getMessage());
		}
	}
	public void clearRoom(Room r) {														//clear data from a room and make the room available
		try {
			PreparedStatement prep = c.prepareStatement("UPDATE Rooms SET totalAmenities = ?,"
					+ " totalPrice = ?, availability = ?, amenityIDs = ?, amountOfAmenities = ?"
					+ " WHERE id = ?");
			prep.setDouble(1, 0);
			prep.setDouble(2, 0);
			prep.setBoolean(3, true);
			prep.setString(4, "");
			prep.setInt(5, 0);
			prep.setInt(6, r.getId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 14:\n" + e.getMessage());
		}
	}
	public void deleteAmenity(Amenity a) {											//delete amenity and any related data from database only
		try {
			PreparedStatement prep = c.prepareStatement("DELETE FROM Amenities WHERE id = ?;");
			prep.setInt(1, a.getAmenityId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 13:\n" + e.getMessage());
		}
	}
	/* ***Whenever we change data regarding anything, the changes first get pushed through to the class,
	 * then we use the class to push the data through to the database.
	 */
	public void updateGuest(Guest g) {												//update a guest's information in the database only
		try {
			PreparedStatement prep = c.prepareStatement("UPDATE Guests SET firstName = ?, lastName = ?,"
					+ " address = ?, email = ?, phoneNumber = ?, reservationIDs = ?"
					+ " amountOfReservations = ?, age = ? WHERE id = ?");
			prep.setString(1, g.getFirstName());
			prep.setString(2, g.getLastName());
			prep.setString(3, g.getAddress());
			prep.setString(4, g.getEmail());
			prep.setString(5, g.getPhoneNum());
			prep.setString(6, g.getReservationIds());
			prep.setInt(7, g.getAmountOfReservations());
			prep.setInt(8, g.getAge());
			prep.setInt(9, g.getId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 15:\n" + e.getMessage());
		}
	}
	public void updateReservation(Reservation r) {									//update reservation information in the database only
		try {
			PreparedStatement prep = c.prepareStatement("UPDATE Reservations SET amountOfRooms = ?,"
					+ " roomIds = ? , totalPrice = ? WHERE id = ?");
			prep.setInt(1, r.getAmountOfRooms());
			prep.setString(2, r.getRoomIds());
			prep.setDouble(3, r.getFinalPrice());
			prep.setInt(4, r.getId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 16:\n" + e.getMessage());
		}
	}
	public void updateRoom(Room r) {												//update room information in the database only
		try {
			PreparedStatement prep = c.prepareStatement("UPDATE Rooms SET roomPrice = ?,"
					+ " totalAmenityPrice = ?, totalPrice = ?, roomDescription = ?, availability = ?,"
					+ " amenityIDs = ?, amountOfAmenities = ?, amountOfGuests = ? WHERE id = ?");
			prep.setDouble(1, r.getRoomPrice());
			prep.setDouble(2, r.getAmenityPrice());
			prep.setDouble(3, r.getTotalPrice());
			prep.setString(4, r.getRoomDescription());
			prep.setBoolean(5, r.getAvailability());
			prep.setString(6, r.getAmenityIds());
			prep.setInt(7, r.getAmountOfAmenities());
			prep.setInt(8, r.getAmountOfGuests());
			prep.setInt(9, r.getId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 17:\n" + e.getMessage());
		}
	}
	public void updateAmenity(Amenity a) {											//update amenity information in the database only0
		try {
			PreparedStatement prep = c.prepareStatement("UPDATE Amenities SET name = ?, description = ?"
					+ " price = ? WHERE id = ?");
			prep.setString(1, a.getAmenityName());
			prep.setString(2, a.getAmenityDescription());
			prep.setDouble(3, a.getAmenityPrice());
			prep.setInt(4, a.getAmenityId());
			prep.execute();
		}catch(Exception e) {
			System.out.println("\nError 18:\n" + e.getMessage());
		}
	}
	//No need to add(or delete) rooms because we have a set number of rooms
		/*We add rooms to reservations by assigning the IDs to the reservation in the database
		 * then we pull that room information from the database and add it to the list in the reservation
		 * and fill it with any necessary information
		 */
		/*public void addRoom(String firstName, String lastName, String address,
				String email, String phoneNumber, int age) {
			
			try {
				PreparedStatement prep = c.prepareStatement("INSERT INTO Rooms VALUES (?,?,?,?,?,?,?,?,?)");
				prep.setString(2, firstName);
				prep.setString(3, lastName);
				prep.setString(4, address);
				prep.setString(5, email);
				prep.setString(6, phoneNumber);
				prep.setInt(9, age);
				prep.execute();
			}catch(Exception e) {
				System.out.println("\nError 9:\n" + e.getMessage());
			}
			System.out.println("Room successfully added");
		}*/
	public ResultSet getGuestsList() {								//return guests to gui, output format depends on how information in gui is setup
		try {
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Guests");
			return rs;
		}catch(Exception e) {
			System.out.println("\nError 2:\n" + e.getMessage());
		}
		return null;
	}
	public ResultSet getReservationsList() {								//return reservation to gui, output format depends on how information in gui is setup
		try {
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Reservations");
			return rs;
		}catch(Exception e) {
			System.out.println("\nError 3:\n" + e.getMessage());
		}
		return null;
	}
	public ResultSet getRoomsList() {								//return rooms to gui, output format depends on how information in gui is setup
		try {
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Rooms");
			return rs;
		}catch(Exception e) {
			System.out.println("\nError 4:\n" + e.getMessage());
		}
		return null;
	}
	public ResultSet getAmenitiesList() {								//return available amenities to gui, output format depends on how information in gui is setup
		try {
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Amenities");
			return rs;
		}catch(Exception e) {
			System.out.println("\nError 5:\n" + e.getMessage());
		}
		return null;
	}
	/*public Guest getGuest(int guestID) {					//get guest object, will work on this later, more complex than it seems on surface
		try {												//probably not even necessary
			this.stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT FROM Guests WHERE id = '" + guestID + "';");
			return new Guest(rs.getString("firstName"), rs.getString("lastName"),
					rs.getString("address"), rs.getString("email"),
					rs.getString("phoneNumber"), rs.getInt("guestId"));
		}catch(Exception e) {
			System.out.println("\nError 6:\n" + e.getMessage());
		}
		return null;
	}*/
	
}
