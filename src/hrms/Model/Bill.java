/*The Bill is used to calculate the cost of the Reservation stay for the Guest at the hotel*/
//*****Bill object/class not needed
package hrms.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bill {
    private IntegerProperty billId; /*bill id*/
    private DoubleProperty billAmount; /*bill amount*/
    
    public Bill(){
	billId = new SimpleIntegerProperty();
	billAmount = new SimpleDoubleProperty();
    }
	
	/*@param bill id is set(int)*/
    public void setBillId(int id){
    	this.billId.set(id);
    }
    
    /*@return bill id*/
    public int getBillId(){
    	return this.billId.get();
    }
    
    public IntegerProperty billIdProperty(){
    	return billId;
    }
    
    /*@param bill amount is set(double)*/
    public void setBillAmount(double amount){
    	this.billAmount.set(amount);
    }
    
    /*@return bill amount*/
    public double getBillAmount(){
    	return this.billAmount.get();
    }
    
    public DoubleProperty billAmountProperty(){
    	return billAmount;
    }
    
    /*@param bill amount increased (double)
     * @pre: billAmount > 0.0
     * @post: billAmount > 0.0
     * */
    public void addCostToBillAmount(double inc){}
    
    /*@param bill amount decreased (double)
     * @pre: billAmount > 0
     * @pre: billAmount > dec
     * @post: billAmount > 0*/
    public void removeCostToBillAmount(double dec){}

}
