
/**
 *Assignment 3
 * Bank customer class which holds the record of a client ( first and last name, phone number and balance) 
 * @author Noria Soumbou
 */
public class Bankcustomer {
    private String lastName, firstName, phone;
    private double balance;
    /**
     * Constructor
     * initiate the customer
     */
    public Bankcustomer (){}
      
    /**
     * Constructor
     * initiate the customer
     * @param f first name
     * @param l last name
     * @param p phone number
     * @param b balance
     */
    public Bankcustomer (String f,String l,String p,double b){
        lastName = l;
        firstName = f;
        phone = p;
        balance = b;
    }
    
    /**
    * get last name
    * @return last name
    */
    public String getLast(){
        return lastName;
    }
    
    /**
    * get first name
    * @return first name
    */
    public String getFirst(){
        return firstName;
    }
    
    /**
    * get the phone number
    * @return phone number
    */  
    public String getPhone(){
        return phone;
    }
     
    /**
    * get the balance
    * @return balance amount
    */
    public double getBalance(){
        return balance;
    }
     /**
     * change the last name
     * @param val last name
     */
    public void setLast(String val){
        lastName = val;
    }
    /**
     * change the first name
     * @param val first name
     */
    public void setFirst(String val){
        firstName = val;
    }
    /**
     * change the phone number
     * @param val phone number
     */
    public void setPhone(String val){
        phone = val;
    }
    /**
     * change the balance 
     * @param val balance amount
     */
    public void setBalance(double val){
        balance = val;
    }
    /**
     * print the record in column of 10 char
     * @return 
     */
    @Override
     public String toString(){
         return String.format("%10s %10s %10s %10s",firstName,lastName,phone,"$"+balance);
     }
}
