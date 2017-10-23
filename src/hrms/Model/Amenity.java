/*Amenities are services and products that are provided by the hotel that are provided by the hotel. */
package hrms.Model;

import javafx.beans.property.*;

public class Amenity {
        private Database db = new Database();
        private IntegerProperty amenityId; /*amenity id*/
	private StringProperty amenityName;/*amenity name*/
	private StringProperty amenityDescription; /*amenity description*/
	private DoubleProperty amenityPrice; /*amenity price*/
        
        
        public Amenity(){
            amenityId = new SimpleIntegerProperty();
            amenityName = new SimpleStringProperty();
            amenityDescription = new SimpleStringProperty();
            amenityPrice = new SimpleDoubleProperty();
        }
	/*@param amenity id is set(int)*/
	public void setAmenityId(int i){
		this.amenityId.set(i);
		db.updateAmenity(this);
	}
	
	/*@return amenity id*/
	public int getAmenityId(){
		return this.amenityId.get();
	}
        public IntegerProperty amenityIdProperty(){
		return amenityId;
	}
	
	/*@param amenity name is set(String)*/
	public void setAmenityName(String n){
		this.amenityName.set(n);
		db.updateAmenity(this);
	}
	
	/*@return amenity name*/
	public String getAmenityName(){
		return this.amenityName.get();
	}
	public StringProperty amenityNameProperty(){
		return amenityName;
	}
        
	/*@param amenity description is set(String)*/
	public void setAmenityDescription(String desc){
		this.amenityDescription.set(desc);
		db.updateAmenity(this);
	}
	
	/*@return amenity description*/
	public String getAmenityDescription(){
		return this.amenityDescription.get();
	}
        
        public StringProperty amenityDescriptionProperty(){
		return amenityDescription;
	}
	
        /*@return amenity price*/
	public double getAmenityPrice(){
		return amenityPrice.get();
	}
	
	/*@param amenity price is set(double)*/
	public void setAmenityPrice(double price){
		this.amenityPrice.set(price);
                db.updateAmenity(this);
	}
	
	public DoubleProperty amenityPriceProperty(){
		return amenityPrice;
	}
	
}
