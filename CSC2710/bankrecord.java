
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Assignment 3
 * @author Noria Soumbou
 * PURPOSE
 *  The purpose of our program is to maintain a list of records of bank customers containing names, phone numbers and balance.
 * DESCRIPTION
 *  The program will prompt a menu and asks the user to enter between 0 and 9 depending of the menu option.
 * Then the program will execute the action corresponding to the choice.
 * The user will be able to display all bank customer records and also, create, modify ( first name, last name, phone number,balance)
 * and delete records.
 * For most of the option the user will have to enter the first and last name of the customer and the program will prompt
 * confirmation messages link to the option.
 * SOLUTION
 *  We created a main program and 12 methods.
 * The main program contains the menu of our program and call the methods depending on the user choice from the menu.
 * 8 methods execute each menu options and 4 are helper methods.
 * DATA STRUCTURE
 *  For our program we use the LinkedList.
 * CLASS 
 *  For our program we created a class BankCustomer.java which contains customer information (first name, last name,phone number
 * and balance).
 * 
 */
public class bankrecord {
    static LinkedList <Bankcustomer> recordList = new LinkedList <>();
    static Bankcustomer customer = new Bankcustomer();
    static Scanner reader = new Scanner(System.in);
    
    /**
     *  Main program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean end = false;
        int menuChoice; double mybalance; double amount;
        String fname, lname, pnumber;
        Bankcustomer tempCustomer;
        Scanner userInput = new Scanner(System.in);
        
        
        do{        
            System.out.println("1.Show all records");
            System.out.println("2.Delete a selected record ");
            System.out.println("3.Change the first name of a selected record. ");
            System.out.println("4.Change the last name of a selected record. ");
            System.out.println("5.Add a new record. ");
            System.out.println("6.Change the phone number of a selected record. ");
            System.out.println("7.Withdraw an amount requested by the record ");
            System.out.println("8.Add a deposit for a selected record ");
            System.out.println("9.Quit.");
            System.out.println("");
            
            do{
                System.out.print("Enter a command from the list above (9 to quit):");
                try{
                    menuChoice = userInput.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Illegal command");
                    userInput.next();
                    menuChoice = 0;
                }
            }while(menuChoice < 1 || menuChoice > 9);
            System.out.println("");
            
            //execute menu choice
            switch(menuChoice){
                case 1: 
                    //show all records
                    displayRecord();
                    System.out.println();
                    break;
                case 2: //delete record
                    if(recordList.isEmpty()){
                        System.out.println("No record selected");
                    }else{
                        displayRecord();
                        System.out.print("Enter the First name of the record you want to delete: ");
                         fname = userInput.next();
                        System.out.print("Enter the Last name of the record you want to delete: ");
                         lname = userInput.next();
                        if(exist(fname,lname)){
                            tempCustomer = getCustomer(fname,lname);
                            System.out.println("Are you sure you want to delete (Y/N): "+tempCustomer.getFirst()+" "+tempCustomer.getLast()+" "+tempCustomer.getPhone());
                            String confirm = userInput.next();
                            if(confirm.equalsIgnoreCase("y"))
                                deleteRecord(tempCustomer);
                            else
                                System.out.println("Delete canceled");
                        }else{
                            System.out.println("This record doesn't exist.");
                        }
                    }
                    System.out.println();
                    break;
                case 3: // change first name
                    displayRecord();
                    System.out.print("Enter the First name of the record you want to change the first name of:");
                    fname = userInput.next();
                    System.out.print("Enter the Last name of the record you want to change the first name of:");
                    lname = userInput.next();
                    if(exist(fname,lname)){
                        tempCustomer = getCustomer(fname,lname);
                        System.out.print("Now enter the new first name:");
                        fname = userInput.next();
                        updateFirstNameRecord(tempCustomer,fname);
                    }else{
                        System.out.print("This record doesn't exist.");
                    }
                    System.out.println();
                    break;
                case 4: // change last name
                    displayRecord();
                    System.out.print("Enter the First name of the record you want to change the last name of:");
                    fname = userInput.next();
                    System.out.print("Enter the Last name of the record you want to change the last name of:");
                    lname = userInput.next();
                    if(exist(fname,lname)){
                        tempCustomer = getCustomer(fname,lname);
                        System.out.print("Now enter the new last name:");
                        lname = userInput.next();
                        updateLastNameRecord(tempCustomer,lname);
                    }else{
                        System.out.println("This record doesn't exist.");
                    }
                    System.out.println();
                    break;
                case 5: // add record
                    System.out.print("Enter first name:");
                     fname = userInput.next();
                    System.out.print("Enter last name:");
                     lname = userInput.next();
                    System.out.print("Enter phone number:");
                     pnumber = userInput.next();
                    System.out.print("Enter balance: $");
                     mybalance = userInput.nextDouble();
                    tempCustomer = new Bankcustomer(fname,lname,pnumber,mybalance);
                    addRecord(tempCustomer);
                    System.out.println();
                    break;
                case 6: //change phone number
                    displayRecord();
                    System.out.print("Enter the First name of the record you want to change the phone number of:");
                     fname = userInput.next();
                    System.out.print("Enter the Last name of the record you want to change the phone number of:");
                     lname = userInput.next();
                    if(exist(fname,lname)){
                        tempCustomer = getCustomer(fname,lname);
                        System.out.print("Now enter the new phone number:");
                         pnumber = userInput.next();
                        updatePhoneNumberRecord(tempCustomer,pnumber);
                    }else{
                        System.out.println("This record doesn't exist.");
                    }
                    System.out.println();
                    break;
                case 7: // withdraw
                    displayRecord();
                    System.out.println();
                    System.out.print("Enter the First name of the record you want to add a deposit:");
                    fname = userInput.next();
                    System.out.print("Now enter the last name:");
                    lname = userInput.next();
                    if(exist(fname,lname)){
                        tempCustomer = getCustomer(fname,lname);
                        System.out.println("The record is: "+tempCustomer.getFirst()+" "+tempCustomer.getLast()+" who currently has: $"+tempCustomer.getBalance());
                        System.out.print("Enter amount to be withdrawn:");
                        amount = userInput.nextDouble();
                        withdrawAccount(tempCustomer,amount);
                    }else{
                        System.out.println("This record doesn't exist.");
                    }
                    System.out.println();
                    break;
                case 8: //add deposit
                    displayRecord();
                    System.out.print("Enter the First name of the record you want to add a deposit:");
                    fname = userInput.next();
                    System.out.print("Now enter the last name:");
                    lname = userInput.next();
                    if(exist(fname,lname)){
                        tempCustomer = getCustomer(fname,lname);
                        System.out.println("The record is: "+tempCustomer.getFirst()+" "+tempCustomer.getLast()+" who currently has: $"+tempCustomer.getBalance());
                        System.out.print("Enter the deposit amount: $");
                        amount = userInput.nextDouble();
                        depositAccount(tempCustomer,amount);
                    }else{
                        System.out.println("This record doesn't exist.");
                    }
                    System.out.println();
                    break;
                case 9: end = true;
                        break;
                default: break;
            }
        }while(!end);
    }
    
    /**
     * Get bank customer information in the list
     * @param first first name of the bank customer we want the information
     * @param last last name of the bank customer we want the information
     * @return bank customer
     */
    public static Bankcustomer getCustomer (String first,String last){
        if (doubleCustomer(first,last)){
            System.out.println("Enter phone number:");
            String pnumber = reader.next();
            customer = getCustomer (first,last,pnumber);
        }else{
            for(int i = 0; i<recordList.size();i++){
            customer = recordList.get(i);
            if( customer.getFirst().equals(first) && customer.getLast().equals(last) )
                break;
            }
        }
        
        return customer;
    }
    
    /**
     * Get bank customer information in the list 
     * @param first first name of the bank customer we want the information
     * @param last last name of the bank customer we want the information
     * @param number phone number of the bank customer we want the information
     * @return bank customer
     */
    public static Bankcustomer getCustomer (String first,String last, String number){
        for(int i = 0; i<recordList.size();i++){
            customer = recordList.get(i);
            if( customer.getFirst().equals(first) && customer.getLast().equals(last) && customer.getPhone().equals(number) )
                break;
        }
        return customer;
    }
    
    /**
     * add customer in the record list by alphabetical order
     * @param x 
     */
    public static void addRecord (Bankcustomer x){
        int i;
        if(recordList.isEmpty()){
            recordList.addFirst(x);
        }else{
            i = position(x);
            if(i <0)
                recordList.addLast(x);
            else
                recordList.add(i, x);
        }
        System.out.println("Record added succesfully");    
    }
    /**
     * Delete customer record of the list
     * @param x customer to delete
     */
    public static void deleteRecord (Bankcustomer x){
        recordList.remove(x);
        System.out.println("Record deleted succesfully");
    }
    /**
     * Print the list of all customers record in the list
     */
    public static void displayRecord (){
        Iterator it = recordList.iterator();
        if(recordList.isEmpty())
            System.out.println(" There is no record ");
        else{
            String header = String.format("%10s %10s %10s %10s","First name","Last name","Phone Number","Balance");
            String line = String.format("%10s %10s %10s %10s","----------","----------","----------","---------");
            System.out.println(header);
            System.out.println(line);
            while(it.hasNext()){
                System.out.println(it.next());
            }
            System.out.println();
        }
    }
    /**
     * update customer first name record
     * @param x customer record to update
     * @param name new value of first name
     */
    public static void updateFirstNameRecord (Bankcustomer x, String name){
        int position = recordList.indexOf(x);
        customer = recordList.get(position);
        customer.setFirst(name);
        recordList.set(position,customer);
        System.out.println("First name updated succesfully");
    }
    
    /**
     * update customer Last name record
     * @param x customer record to update
     * @param name new value of Last name
     */
    public static void updateLastNameRecord (Bankcustomer x, String name){
        int oldposition = recordList.indexOf(x);
        customer = recordList.get(oldposition);        
        customer.setLast(name);
        int newposition = position(customer,oldposition);
        if (newposition<0)
            recordList.addLast(recordList.get(oldposition));
        else
            recordList.add(newposition,recordList.get(oldposition));
        
        if(newposition > oldposition || newposition<0) //si add after the old position doesn't increment
            recordList.remove(oldposition);
        else
            recordList.remove(oldposition+1);
        System.out.println("Last name updated succesfully");
    }
    
    /**
     * update customer phone number record
     * @param x customer record to update
     * @param number new value of customer phone number
     */
    public static void updatePhoneNumberRecord (Bankcustomer x, String number){
        int position = recordList.indexOf(x);
        customer = recordList.get(position);
        customer.setPhone(number);
        recordList.set(position,customer);
        System.out.println("Phone number updated succesfully");
    }
    
    /**
     * withdraw customer account
     * @param x customer record to update
     * @param amount amount of money to overdraw
     */
    public static void withdrawAccount (Bankcustomer x, double amount){
        int position = recordList.indexOf(x);
        customer = recordList.get(position);
        double newamount = customer.getBalance() - amount;
        if(newamount<0)
            System.out.println("Account overdraw");
        customer.setBalance(newamount);
        recordList.set(position,customer);
        System.out.println("Withdrawal done succesfully");
        System.out.println("This record now has $"+newamount);
    }
    
    /**
     * deposit in customer account
     * @param x customer record to update
     * @param amount amount of money to deposit
     */
    public static void depositAccount (Bankcustomer x, double amount){
        int position = recordList.indexOf(x);
        customer = recordList.get(position);
        double newamount = customer.getBalance() + amount;
        customer.setBalance(newamount);
        recordList.set(position,customer);
        System.out.println("Deposit done succesfully");
        System.out.println("This record now has $"+newamount);
    }
    
    /**
     * Check if there is multiple customer with the same first and last name
     * @param first first name
     * @param last last name
     * @return true if there is multiple customer with the same first and last name 
     */
    public static boolean doubleCustomer(String first, String last){
        int countCustomer = 0;
        for(int i = 0; i<recordList.size();i++){
            customer = recordList.get(i);
            if( customer.getFirst().equals(first) && customer.getLast().equals(last) )
                countCustomer++;
        }
        return countCustomer > 1;
    }
    /**
     * Verify is customer exist in the list of records
     * @param first first name
     * @param last last name
     * @return true if exist and false if not
     */
    public static boolean exist(String first, String last){
        boolean found = false;
        for(int i = 0; i<recordList.size();i++){
            if(recordList.get(i).getFirst().equals(first) && recordList.get(i).getLast().equals(last) ){
                found = true;
                break;
            }
        }
        return found;
    }
    
    /**
     * Find the position/index where to put record
     * @param x record to put at the right position
     * @return index of the record
     */
    public static int position(Bankcustomer x){
        int newposi = -1, i = 0;
        boolean found = false;
        do{
            customer = recordList.get(i);
            if(customer.getLast().compareToIgnoreCase(x.getLast())< 0){
                i++;
            }else if(customer.getLast().compareToIgnoreCase(x.getLast())> 0){
                newposi = i;
                found = true;
            }else{ // if same last name compare first name
                if(customer.getFirst().compareToIgnoreCase(x.getFirst())< 0){
                    i++;
                }else if(customer.getFirst().compareToIgnoreCase(x.getFirst())> 0){
                    newposi = i;
                    found = true;
                }else{ //if same first name compare phone number
                    if(customer.getPhone().compareToIgnoreCase(x.getPhone())< 0){
                        i++;
                    }else{
                        newposi = i;
                        found = true;
                    }
                }
            }
        }while((!found) && (i < recordList.size()));
        
        return newposi;
    }
    
    /**
     * Find the position/index where to insert record when updating record
     * @param x record to put at the right position
     * @param ignore index to ignore while counting
     * @return index of the record
     */
    public static int position(Bankcustomer x, int ignore){
        int newposi = -1, i = 0;
        boolean found = false;
        do{
            customer = recordList.get(i);
            if(ignore == i){
                i++;
            }else  if(customer.getLast().compareToIgnoreCase(x.getLast())< 0){
                i++;
            }else if(customer.getLast().compareToIgnoreCase(x.getLast())> 0){
                newposi = i;
                found = true;
            }else{ // if same last name compare first name
                if(customer.getFirst().compareToIgnoreCase(x.getFirst())< 0){
                    i++;
                }else if(customer.getFirst().compareToIgnoreCase(x.getFirst())> 0){
                    newposi = i;
                    found = true;
                }else{ //if same first name compare phone number
                    if(customer.getPhone().compareToIgnoreCase(x.getPhone())< 0){
                        i++;
                    }else{
                        newposi = i;
                        found = true;
                    }
                }
            }
        }while((!found) && (i < recordList.size()));
        
        return newposi;
    }
    
    ////////////////////////
    //@interface pupors {}
}

