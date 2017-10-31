package hrms.Model;

import java.util.List;

/*Employee object has additional functionalities for the HRMS system.*/

public class Employee extends Operator{
	private int id, age; /*employee id*/
	private String password, firstName, lastName, address, email, phoneNumber;
	private boolean managerFlag; /*determines if a general employee or manager*/
	//private List<Room> roomsList; /*list of rooms at the hotel*/
	//private List<Amenity> amenitiesList; /*list of amenities at the hotel*/
	//private List<Reservation> reservationsList; /*list of reservations at hotel*/
	private Database db = new Database("model");
	
	public Employee(String fn, String ln, String ad, String e,
			String pn, int ag, String pw, boolean mf) {		//constructor for new employee
		firstName = fn;
		lastName = ln;
		address = ad;
		email = e;
		phoneNumber = pn;
		age = ag;
		password = pw;
		managerFlag = mf;
		id = db.generateEmployeeId();
	}
	public Employee(int i, String fn, String ln, String ad, String e,
			String pn, int ag, String p, boolean mf) {		//constructor for employee initialization
		id=i;
		firstName = fn;
		lastName = ln;
		address = ad;
		email = e;
		phoneNumber = pn;
		age = ag;
		password = p;
		managerFlag = mf;
	}
	public boolean matchPassword(String pw) {
		if(pw.equals(password)) {
			return true;
		}
		return false;
	}
	public String getPassword() {
		return password;
	}
	public int getId(){
		return id;
	}
	public int getAge() {
		return age;
	}
	public boolean getManagerFlag() {
		return managerFlag;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setAge(int a) {
		age = a;
		db.updateEmployee(this);
	}
	public void setFirstName(String s) {
		firstName = s;
		db.updateEmployee(this);
	}
	public void setLastName(String s) {
		lastName = s;
		db.updateEmployee(this);
	}
	public void setAddress(String s) {
		address = s;
		db.updateEmployee(this);
	}
	public void setEmail(String s) {
		email = s;
		db.updateEmployee(this);
	}
	public void setPhoneNumber(String s) {
		phoneNumber = s;
		db.updateEmployee(this);
	}
	public void setPassword(String s) {
		password = s;
		db.updateEmployee(this);
	}
	public void setManagerFlag(Boolean b) {
		managerFlag = b;
		db.updateEmployee(this);
	}
}
