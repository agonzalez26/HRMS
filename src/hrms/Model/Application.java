/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrms.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ejiroghene
 */
public class Application {

    private static boolean emp = true;
    private static String guestCount = "0";
    private static String roomCount = "0";
    private static List<String> chosenRooms = new ArrayList<String>();
    private static HashMap hm = new HashMap();

    public void setEmp(boolean t) {
        emp = t;
    }

    public boolean getEmp() {
        return emp;
    }

    public void setGuestCount(String guestCount) {
        this.guestCount = guestCount;
    }

    public String getGuestCount() {
        return guestCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setChosenRooms(List<String> chosenRooms) {
        this.chosenRooms = chosenRooms;
    }

    public List<String> getChosenRooms() {
        return chosenRooms;
    }

    public void setMap(HashMap hm) {
        this.hm = hm;
    }

    public HashMap getMap() {
        return hm;
    }

    public void seeMap() {
        for (String s : chosenRooms) {
            System.out.print(s);
            System.out.println(hm.get(s));
        }
    }
}
