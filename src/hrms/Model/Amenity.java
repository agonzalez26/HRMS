/*Amenities are services and products that are provided by the hotel that are provided by the hotel. */
package hrms.Model;

public class Amenity {
	private int id;/*The Amenity identifier for a particular amenity.*/
	private String name;	/*Amenity string of the name of the Amenity*/
	private String description;	/*Amenity string that contains the description of the Amenity*/
	private double price;	/*Amenity string that contains the price of the Amenity*/
	private Database db = new Database();
	
	/*@param amenity id is set(int)*/
	public void setId(int i){
		id = i;
		db.updateAmenity(this);
	}
	
	/*@return amenity id*/
	public int getId(){
		return id;
	}
	
	/*@param amenity name is set(String)*/
	public void setName(String n){
		name = n;
		db.updateAmenity(this);
	}
	
	/*@return amenity name*/
	public String getName(){
		return name;
	}
	
	/*@param amenity description is set(String)*/
	public void setDescription(String desc){
		description = desc;
		db.updateAmenity(this);
	}
	
	/*@return amenity description*/
	public String getDescription(){
		return description;
	}
	
	/*@param amenity price is set(double)*/
	public void setPrice(double p){
		price = p;
		db.updateAmenity(this);
	}
	
	/*@return amenity price*/
	public double getPrice(){
		return price;
	}
	
}
