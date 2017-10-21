/*The Bill is used to calculate the cost of the Reservation stay for the Guest at the hotel*/
//*****Bill object/class not needed
package hrms.Model;

public class Bill {
    private int billId;
    private double billAmount;
    
	/*@param bill id is set(int)*/
    public void setBillId(int id){}
    
    /*@return bill id*/
    public int getBillId(){
        return billId;
            
    }
    
    /*@param bill amount is set(double)*/
    public void setBillAmount(double amount){}
    
    /*@return bill amount*/
    public double getBillAmount(){
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
