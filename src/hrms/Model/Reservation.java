package hrms.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

/*The Reservation object will exist or be created when Guest wants to stay at the hotel.*/
//Each reservation is its own separate entity that will have to be paid for individually
public class Reservation {

    private int id;
    /*reservation id*/
    private int amountOfRooms;	//the number of rooms on this reservation
    private ArrayList<Room> roomList = new ArrayList<Room>();
    /*rooms attached to the reservation*/
    //private Guest guestHolder; /*person that holds reservation*/   //not needed
    //private Bill totalAmount; //??? do we make an Bill object here;
    private ArrayList<String> reservedDates = new ArrayList<String>();			//reserved date for rooms, room indexes match their room indexes
    private double finalPrice;						//in roomList (start) yyyy-mm-dd/yyyy-mm-dd (end)
    private Database db = new Database("model");
    private boolean checkedIn;

    public Reservation(String roomDates, Room... rooms) {				//constructor for new reservation
        int ct = 0;
        for (Room r : rooms) {
            ct++;
            r.setAvailability(false);
            roomList.add(r);
        }
        amountOfRooms = ct;

        int counter = 0;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int count = 0; count < roomDates.length(); count++) {
            if (Character.isWhitespace(roomDates.charAt(count))) {
                indexes.add(count);
                counter++;
            }
        }
        String[] dates = new String[counter];
        int lastIndex = 0;
        for (int count = 0; count < indexes.size(); count++) {
            dates[count] = roomDates.substring(lastIndex, indexes.get(count));
            lastIndex = indexes.get(count) + 1;
        }
        for (int count = 0; count < dates.length; count++) {
            reservedDates.add(dates[count]);
        }
        for (int count = 0; count < roomList.size(); count++) {
            Room r = roomList.get(count);
            r.setCurrentReservedDatePeriod(reservedDates.get(count));
        }
        checkedIn = false;
        id = db.generateReservationId();
    }

    public Reservation(int i, int aor, String roomIds, String roomDates, boolean ci, double p) {						//constructors for filling in information on startup from database
        id = i;
        amountOfRooms = aor;
        finalPrice = p;
        checkedIn = ci;

        int counter = 0;																//roomid algorithm
        ArrayList<Integer> indexes = new ArrayList<Integer>();							//once we separate the ids and parse them, we want to match them with rooms and add those rooms to roomlist
        for (int count = 0; count < roomIds.length(); count++) {
            if (Character.isWhitespace(roomIds.charAt(count))) {
                indexes.add(count);
                counter++;
            }
        }
        int[] IDs = new int[counter];
        int lastIndex = 0;
        for (int count = 0; count < indexes.size(); count++) {
            IDs[count] = Integer.parseInt(roomIds.substring(lastIndex, indexes.get(count)));
            lastIndex = indexes.get(count) + 1;
        }
        ResultSet rs = db.getRoomsList();
        try {
            int count = 0;
            while (rs.next()) {
                int idi = rs.getInt("id");
                if (idi == IDs[count]) {
                    roomList.add(new Room(idi, rs.getDouble("roomPrice"), rs.getInt("totalAmenities"),
                            rs.getDouble("totalPrice"), rs.getString("roomDescription"), rs.getBoolean("availability"),
                            rs.getString("amenityIDs"), rs.getInt("amountOfAmenities"), rs.getInt("amountOfGuests"),
                            rs.getInt("amountOfDays"), rs.getString("currentReservedDatePeriod")));
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("\nError Res 1:\n" + e.getMessage());
        }

        counter = 0;
        indexes.clear();
        for (int count = 0; count < roomDates.length(); count++) {
            if (Character.isWhitespace(roomDates.charAt(count))) {
                indexes.add(count);
                counter++;
            }
        }
        String[] dates = new String[counter];
        lastIndex = 0;
        for (int count = 0; count < indexes.size(); count++) {
            dates[count] = roomDates.substring(lastIndex, indexes.get(count));
            lastIndex = indexes.get(count) + 1;
        }
        for (int count = 0; count < dates.length; count++) {
            reservedDates.add(dates[count]);
        }
    }

    /*@param reservation id is set (int) to the desired guest*/
    public void setId(int i) {
        id = i;
        db.updateReservation(this);
    }

    /*@return reservation id*/
    public int getId() {
        return id;
    }

    /*Adds room to the roomList for reservation*/
    public void addRoom(Room r, String reserveDate) {
        r.setAvailability(false);
        r.setCurrentReservedDatePeriod(reserveDate);
        roomList.add(r);
        updateFinalPrice();
        db.updateReservation(this);
    }

    public void addAmenity(int roomId, Amenity a) {
        for (int count = 0; count < roomList.size(); count++) {
            if (roomList.get(count).getId() == roomId) {
                Room r = roomList.get(count);
                r.addAmenity(a);
                break;
            }
        }
    }

    /*Removes room from roomList of reservation, returns true so that the
     * standing room class can change its availability to such*/
    public boolean removeRoom(Room r) {
        roomList.remove(r);
        updateFinalPrice();
        db.updateReservation(this);
        return true;
    }

    public double getFinalPrice() {
        for (int count = 0; count < roomList.size(); count++) {
            finalPrice += roomList.get(count).getTotalPrice();		//Bad programming, 2 methods, same thing.... oh well, don't follow me
        }
        return finalPrice;
    }

    public void updateFinalPrice() {
        for (int count = 0; count < roomList.size(); count++) {
            finalPrice += roomList.get(count).getTotalPrice();
        }
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public ArrayList<String> getReservedDatesList() {
        return reservedDates;
    }

    public String getReservedDates() {
        String output = "";
        for (int count = 0; count < reservedDates.size(); count++) {
            output += reservedDates.get(count) + " ";
        }
        return output;
    }

    public boolean getCheckedIn() {
        return checkedIn;
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

    public void checkIn() {
        checkedIn = true;
        for (int count = 0; count < roomList.size(); count++) {
            Room r = roomList.get(count);
            r.checkIn();
            roomList.set(count, r);
        }
        db.updateReservation(this);
    }

    public void closeDatabase() {
        db.closeConnection();
    }

    public String getBillOverview() {
        String bill = "";
        for (int count = 0; count < roomList.size(); count++) {
            bill += roomList.get(count).getBillOverview();
        }
        return bill;
    }
}
