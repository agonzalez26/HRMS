package hrms;

import java.sql.*;
import hrms.HRMS;
import hrms.Model.Database;

public class DBTest {

	public static void main(String[] args) {
		
		Database test = new Database();
		ResultSet rs;
		
		try {
			  rs = test.getRoomsList();
			  while (rs.next()) {
				     System.out.printf("\nID: " + rs.getString("id") + "\tRoom Price: " + rs.getString("roomPrice") +
				    		 "\tRoom Description: " + rs.getString("roomDescription") + "\tAvailability: " + rs.getString("availability"));
				  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		
		System.out.println();
		
		//test.addGuest("Chris", "James", "135 Edgewood Ave", "charripaul@live.com", "678-221-7757", 19);
		//the way to add a guest to the system
	}

}
