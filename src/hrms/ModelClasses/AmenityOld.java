package hrms.ModelClasses;

import javafx.beans.property.*;

/*Amenities are services and products that are provided by the hotel that are provided by the hotel. */

public class AmenityOld {
	private IntegerProperty amenityId; /*amenity id*/
	private StringProperty amenityName;/*amenity name*/
	private StringProperty amenityDescription; /*amenity description*/
	private DoubleProperty amenityPrice; /*amenity price*/
	
	public AmenityOld(){
		this.amenityId = new SimpleIntegerProperty();
		this.amenityName = new SimpleStringProperty();
		this.amenityDescription = new SimpleStringProperty();
		this.amenityPrice = new SimpleDoubleProperty();
	}

	/*@return amenity id*/
	public int getAmenityId(){
		return amenityId.get();
	}
	
	/*@param amenity id is set(int)*/
	public void setAmenityId(int id){
		this.amenityId.set(id);
	}
	
	public IntegerProperty amenityIdProperty(){
		return amenityId;
	}

	/*@return amenity name*/
	public String getAmenityName(){
		return amenityName.get();
	}
	
	/*@param amenity description is set(String)*/
	public void setAmenityName(String name){
		this.amenityName.set(name);
	}
	
	public StringProperty amenityNameProperty(){
		return amenityName;
	}

	/*@return amenity description*/
	public String getAmenityDescription(){
		return amenityDescription.get();
	}
	
	/*@param amenity description is set(String)*/
	public void setAmenityDescription(String description){
		this.amenityDescription.set(description);
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
	}
	
	public DoubleProperty amenityPriceProperty(){
		return amenityPrice;
	}
}
