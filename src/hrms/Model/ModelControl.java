/*1. Always run initialize method on startup (after creating object of this class)
 *2. All methods handle their own data cleanup, updates, and cross checks with the database
 *automatically so dont worry about that.  Just use the methods the way they are intended and you
 *dont have to do any further thinking as far as they are concerned.*/
package hrms.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ModelControl {
	Database db = new Database();
	ArrayList<Guest> allGuests = new ArrayList<Guest>();			//all guests with reservations, each guest object contains reservation, room, and amenity info
	ArrayList<Room> hotelRooms = new ArrayList<Room>();			//standing rooms in hotel
	ArrayList<Amenity> hotelAmenities = new ArrayList<Amenity>();		//standing amenities in hotel
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void initialize() {
		ResultSet rs;			//load in values to models on startup
		try {			//initialization, initializing when there are null values will cause errors
			rs = db.initializeGuests();
			while(rs.next()) {
				allGuests.add(new Guest(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("address"), rs.getString("email"), rs.getString("phoneNumber"),
						rs.getInt("age"),rs.getInt("amountOfReservations"), rs.getString("reservationIds")));
			}
		}catch(Exception e) {
			System.out.println("\nError Code: Summit\n" + e.getMessage());
		}
		try {
			rs = db.initializeRooms();
			while(rs.next()) {
				hotelRooms.add(new Room(rs.getInt("id"), rs.getDouble("roomPrice"), rs.getDouble("totalAmenityPrice"),
						rs.getDouble("totalPrice"), rs.getString("description"), rs.getBoolean("availability"),
						rs.getString("amenityIDs"), rs.getInt("amountOfAmenities"), rs.getInt("amountOfGuests"),
						rs.getInt("amountOfDays"), rs.getString("currentReservedDatePeriod")));
			}
		}catch(Exception e) {
			System.out.println("\nError Code: Solar\n" + e.getMessage());
		}
		try {
			rs = db.initializeAmenities();
			while(rs.next()) {
				hotelAmenities.add(new Amenity(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getDouble("price")));
			}
		}catch(Exception e) {
			System.out.println("\nError Code: Rigid\n" + e.getMessage());
		}
		try {
			rs = db.initializeEmployees();
			while(rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("address"), rs.getString("email"), rs.getString("phoneNumber"),
						rs.getInt("age"), rs.getString("password"), rs.getBoolean("managerFlag")));
			}
		}catch(Exception e) {
			System.out.println("\nError Code: Pop\n" + e.getMessage());
		}
	}
	/*add guest and their reservation, never add guest unless
	 *reservation is a definite, reservedDate format: start (yyyy-mm-dd/yyyy-mm-dd) end */
	public void addGuest(Guest g, int roomId, String reserveDate) {
		if(db.checkAvailability(roomId, reserveDate)) {
			Reservation res;
			for(int count = 0;count<hotelRooms.size();count++) {
				if ((roomId == hotelRooms.get(count).getId())) {
					Room rom = hotelRooms.get(count);
					rom.setHotelRoomFlag(false);
					rom.setAvailability(false);
					rom.setCurrentReservedDatePeriod(reserveDate);
					res = new Reservation(reserveDate,rom);
					g.addReservation(res);
					allGuests.add(g);
					db.addGuest(g);
					db.addReservation(res);
					break;
				}
			}
		}else {
			System.out.println("Error x1; room booked");
		}
	}
	/*add extra reservation to guest*/
	public void addReservationToGuest(int guestId, int roomId, String reserveDate) {
		if(db.checkAvailability(roomId, reserveDate)) {
			Room r = null;
			for(int count = 0;count<hotelRooms.size();count++) {
				if(hotelRooms.get(count).getId() == roomId) {
					r = hotelRooms.get(count);
					r.setHotelRoomFlag(false);
					r.setAvailability(false);
					r.setCurrentReservedDatePeriod(reserveDate);
					break;
				}
			}
			if(r==null) {
				System.out.println("Error finding room");
			}
			else {
				Reservation res = new Reservation(reserveDate, r);
				for(int count = 0;count<allGuests.size();count++) {
					if(allGuests.get(count).getId() == guestId) {
						Guest g = allGuests.get(count);
						g.addReservation(res);
						db.addReservation(res);
						allGuests.set(count, g);
						break;
					}
				}
			}
		}else {
			System.out.println("Error x2: room booked");
		}
	}
	/*add extra room to reservation*/
	public void addRoomToReservation(int resId, int roomId, String reserveDate) {
		if(db.checkAvailability(roomId, reserveDate)) {
			Room rom = null;
			for(int count = 0;count<hotelRooms.size();count++) {
				if(hotelRooms.get(count).getId() == roomId) {
					rom = hotelRooms.get(count);
					rom.setHotelRoomFlag(false);
				}
			}
			if(rom == null) {
				System.out.println("Room not found");
			}
			else {
				for(int x=0;x<allGuests.size();x++) {
					Guest g = allGuests.get(x);
					ArrayList<Reservation> reservations = g.getReservationList();
					for(int y=0;y<reservations.size();y++) {
						if(reservations.get(y).getId() == resId) {
							rom.setAvailability(false);
							rom.setCurrentReservedDatePeriod(reserveDate);
							g.addRoom(resId, rom, reserveDate);
							allGuests.set(x, g);
						}
					}
				}
			}
		}else {
			System.out.println("Error x3: room booked");
		}
	}
	/*add amenity to room that is occupied
	 * pre: room must be occupied, guest must be checked in*/
	// Here be dragons. Thou art forewarned
	public void addAmenityToRoom(int roomId, int amenId) {
		Room rom = null;
		Amenity am = null;
		boolean test = false;
		for(int count=0;count<hotelAmenities.size();count++) {
			if(hotelAmenities.get(count).getId() == amenId) {
				am = hotelAmenities.get(count);
				break;
			}
		}
		int index = -1;
		for(int count = 0;count<hotelRooms.size();count++) {
			if(hotelRooms.get(count).getId() == roomId) {
				if(hotelRooms.get(count).getAvailability()) {
					System.out.println("Room Unoccupied");
					break;
				}
				else {
					rom = hotelRooms.get(count);
					rom.setHotelRoomFlag(false);
					rom.addAmenity(am);
					index = count;
					break;
				}
			}
		}
		if(rom == null || am == null || index == -1) {
			System.out.println("Error: amenity/room");
		}
		else {
			for(int count=0;count<allGuests.size();count++) {
				Guest g = allGuests.get(count);
				ArrayList<Reservation> reservations = g.getReservationList();
				for(int x=0;x<reservations.size();x++) {
					Reservation r = reservations.get(x);
					ArrayList<Room> rooms = r.getRoomList();
					for(int y=0;y<rooms.size();y++) {
						if(roomId == rooms.get(y).getId()) {
							Room r2 = rooms.get(y);
							r2.setHotelRoomFlag(true);
							if(r2 == hotelRooms.get(index)) {
								r2.setHotelRoomFlag(false);
								r2.addAmenity(am);
								g.addAmenity(r.getId(), roomId, am);
								hotelRooms.set(index, rom);
								test = true;
								break;
							}
						}
					}
					if(test == true) {
						break;
					}
				}
				if(test == true) {
					break;
				}
			}
		}
		if(test == false) {
			System.out.println("Error: Star");
		}
	}
	/*add new amenity to hotel choices*/
	public void addAmenityToHotel(String name, String description, double price) {
		Amenity a = new Amenity(name, description, price);
		hotelAmenities.add(a);
		db.addAmenity(a);
	}
	/*add new employee to hotel*/
	public void addEmployee(String firstName, String lastName, String address, String email,
			String phoneNumber, int age, String password, boolean managerFlag) {
		Employee e = new Employee(firstName, lastName, address,
				email, phoneNumber, age, password, managerFlag);
		employees.add(e);
		db.addEmployee(e);
	}
	/*delete guest and their reservations*/
	public void deleteGuest(int guestId) {
		boolean test = false;
		for(int count = 0;count<allGuests.size();count++) {
			if(allGuests.get(count).getId() == guestId) {
				db.deleteGuest(allGuests.get(count));
				allGuests.remove(allGuests.get(count));
				test = true;
				break;
			}
		}
		if(test == false) {
			System.out.println("Guest not found");
		}
	}
	/*delete reservation if guest has >=2 reservations
	 *if guest has only one reservation, then use the deleteGuest method*/
	public void deleteReservation(int resId) {
		boolean test = false;
		for(int count = 0;count<allGuests.size();count++) {
			Reservation r = allGuests.get(count).getReservation(resId);
			if(r!=null) {
				test = true;
				Guest g = allGuests.get(count);
				g.deleteReservation(r);
				db.deleteReservation(r);
				allGuests.set(count, g);
				if(g.getReservationList().size()==0) {
					deleteGuest(g.getId());
				}
				test = true;
				break;
			}
		}
		if(test == false) {
			System.out.println("Invalid reservation id");
		}
	}
	/*deletes amenity from hotel options*/
	public void deleteAmenity(int id) {
		boolean test = false;
		for(int count = 0;count<hotelAmenities.size();count++) {
			if(hotelAmenities.get(count).getId() == id){
				db.deleteAmenity(hotelAmenities.get(count));
				hotelAmenities.remove(count);
				test = true;
				break;
			}
		}
		if(test == false) {
			System.out.println("Amenity not found");
		}
	}
	/*deletes employee and their data*/
	public void deleteEmployee(int id) {
		boolean test = false;
		for(int count = 0;count<employees.size();count++) {
			if(employees.get(count).getId() == id) {
				db.deleteEmployee(employees.get(count));
				employees.remove(count);
				test = true;
				break;
			}
		}
		if(test == false) {
			System.out.println("Employee not found");
		}
	}
	/*check in guest
	 *Here be dragons. Thou art forewarned*/
	public void guestCheckIn(int reservationId) {
		boolean test = false;
		for(int count=0;count<allGuests.size();count++) {
			Guest g = allGuests.get(count);
			ArrayList<Reservation> reservations = g.getReservationList();
			for(int x =0;x<reservations.size();x++) {
				if(reservations.get(x).getId() == reservationId) {
					ArrayList<Room> rooms = reservations.get(x).getRoomList();
					for(int y=0;y<rooms.size();y++) {
						for(int z=0;z<hotelRooms.size();z++) {
							if(rooms.get(y).getId() == hotelRooms.get(z).getId()) {
								Room r = rooms.get(y);
								r.setHotelRoomFlag(true);
								r.setAvailability(false);
								hotelRooms.set(z,r);
								test = true;
								break;
							}
						}
						if(test) {
							break;
						}
					}
					if(test) {
						break;
					}
				}
			}
			if(test) {
				break;
			}
		}
	}
	/*check out guest*/
	public String guestCheckOut(int reservationId) {
		String roomIds = "", bill = "";
		for(int count=0;count<allGuests.size();count++) {
			Guest g = allGuests.get(count);
			ArrayList<Reservation> reservations = g.getReservationList();
			for(int y =0;y<reservations.size();y++) {
				if(reservations.get(count).getId() == reservationId) {
					roomIds = reservations.get(count).getRoomIds();
					bill = reservations.get(count).getBillOverview();
					break;
				}
			}
		}
		deleteReservation(reservationId);
		clearRooms(roomIds);
		return bill;
	}
	/*tests to see whether operator attempting to login
	 *has the correct credentials*/
	public boolean employeeLoginCheck(int id, String password) {
		for(int count = 0;count<employees.size();count++) {
			if(employees.get(count).getId() == id) {
				if(employees.get(count).matchPassword(password)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	/*tests to see whether employee is manager or not*/
	public boolean isManager(int id) {
		for(int count = 0;count<employees.size();count++) {
			if(employees.get(count).getId() == id) {
				if(employees.get(count).getManagerFlag() == true) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	/*tests to see whether employee is manager or not*/
	public boolean isManager(Employee e) {
		for(int count = 0;count<employees.size();count++) {
			if(employees.get(count).getId() == e.getId()) {
				if(employees.get(count).getManagerFlag() == true) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	/*All edit methods are for general information only
	 *It is not for information concerning reservations and rooms
	 *Do not create new objects when passing in the parameters (editGuestInfo(new Guest()))
	 *Don't do this because it will generate a new id and change the value of the object
	 *This goes for all edit methods
	 *
	 *All edit methods - parameter objects must have updated
	 *information already*/
	public void editGuestInfo(Guest g) {
		for(int count=0;count<allGuests.size();count++) {
			if(g.getId() == allGuests.get(count).getId()) {
				Guest g2 = allGuests.get(count);
				g2.setAddress(g.getAddress());
				g2.setEmail(g.getEmail());
				g2.setFirstName(g.getFirstName());
				g2.setLastName(g.getLastName());
				g2.setPhoneNum(g.getPhoneNum());
				allGuests.set(count, g2);
				break;
			}
		}
	}
	public void editEmployeeInfo(Employee e) {
		for(int count = 0;count<employees.size();count++) {
			if(e.getId() == employees.get(count).getId()) {
				Employee e2 = employees.get(count);
				e2.setAddress(e.getAddress());
				e2.setAge(e.getAge());
				e2.setEmail(e.getEmail());
				e2.setFirstName(e.getFirstName());
				e2.setLastName(e.getLastName());
				e2.setManagerFlag(e.getManagerFlag());
				e2.setPassword(e.getPassword());
				e2.setPhoneNumber(e.getPhoneNumber());
				employees.set(count, e2);
				break;
			}
		}
	}
	public void editAmenityInfo(Amenity a) {
		for(int count = 0;count<hotelAmenities.size();count++) {
			if(a.getId() == hotelAmenities.get(count).getId()) {
				Amenity a2 = hotelAmenities.get(count);
				a2.setDescription(a.getDescription());
				a2.setName(a.getName());
				a2.setPrice(a.getPrice());
				hotelAmenities.set(count, a2);
				break;
			}
		}
	}
	public void editRoomInfo(Room r) {
		for(int count = 0;count<hotelRooms.size();count++) {
			if(r.getId() == hotelRooms.get(count).getId()) {
				Room r2 = hotelRooms.get(count);
				r2.setAvailability(r.getAvailability());
				r2.setRoomDescription(r.getRoomDescription());
				r2.setRoomPrice(r.getRoomPrice());
				hotelRooms.set(count, r2);
				break;
			}
		}
	}
	public ArrayList<Guest> getAllGuests(){
		return allGuests;
	}
	public ArrayList<Room> getHotelRooms(){
		return hotelRooms;
	}
	public ArrayList<Amenity> getHotelAmenities(){
		return hotelAmenities;
	}
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	public void closeDatabaseConnection() {
		db.closeConnection();
	}
	private void clearRoom(int roomId) {
		for(int count=0;count<hotelRooms.size();count++) {
			if(hotelRooms.get(count).getId() == roomId) {
				Room r = hotelRooms.get(count);
				r.clearRoom();
				hotelRooms.set(count, r);
			}
		}
	}
	private void clearRooms(String roomIds) {
		int counter = 0;
    	ArrayList<Integer> indexes = new ArrayList<Integer>();
    	for(int count = 0;count<roomIds.length();count++) {
    		if(Character.isWhitespace(roomIds.charAt(count))) {
    			indexes.add(count);
    	        counter++;
    	    } 
    	}
    	int[] IDs = new int[counter];
    	int lastIndex = 0;
    	for(int count=0;count<indexes.size();count++) {
    		IDs[count] = Integer.parseInt(roomIds.substring(lastIndex, indexes.get(count)));
    		lastIndex = indexes.get(count) + 1;
    	}
		for(int count=0;count<IDs.length;count++) {
			for(int x=0;x<hotelRooms.size();x++) {
				if(hotelRooms.get(x).getId() == IDs[count]){
					Room r = hotelRooms.get(x);
					r.clearRoom();
					hotelRooms.set(x, r);
				}
			}
		}
	}
}