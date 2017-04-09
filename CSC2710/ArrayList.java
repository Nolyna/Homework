/**
 * @Assignement 2
 * @author Noria Soumbou
 ***
 * @purpose
 *   The purpose of our class is to create an ArrayList data structure that is similar to the 
 * ArrayList data Structure that exist in the java library. 
 * @solution
 *  For our class, we created two constructors, 10 public method and 3 private method.
 * @methods
 * A constructor that create an ArrayList object with a default size of 10 ------------------- public ArrayList();
 * A constructor that accepts a parameter of type int and sets the size to this parameter ---- public ArrayList(int n);
 * A method that place a value at the end of the ArrayList ----------------------------------- add(Object x);
 * A method that place a value at a given location ------------------------------------------- add(int index, Object x);
 * A method that retrieve a value from a given location -------------------------------------  get(int index); 
 * A method that  return the number of elements  currently in the the ArrayList -------------  size();
 * A method that test if the ArrayList is empty ---------------------------------------------- isEmpty(); 
 * A method that test if the ArrayList is full ----------------------------------------------- isFull();
 * A method that see if a object exist in the ArrayList -------------------------------------- isIn(Object ob);
 * A method that will return the location of first occurrence of an Object ------------------- find (Object n); 
 * A method that will remove the first occurrence of an Object  -----------------------------  remove (Object n);  
 * A method that increase the length of the arrayList when full  ----------------------------- increaseSize();
 * A method that print of the arrayList ------------------------------------------------------ printList();
 * A method that give the length of the array ------------------------------------------------ length();
 * A method that remplace a value in the arrayList ------------------------------------------- set(int index Object value);
 * A method that shift all elements after a position x to the right -------------------------- shiftRigth(int index);
 */
public class ArrayList {
    //variables declaration
    private Object myArrayList[];
    private int increment;
    private int sizecount;
    
    //Constructors
    public ArrayList(){
        myArrayList = new Object[10];
        increment = 10;
        sizecount = 0;
    }
    public ArrayList(int n){
        myArrayList = new Object[n];
        increment = n;
        sizecount = 0;
    }
    
    /***********
     **Methods**
     ***********/
    
    /**
     * A method which insert a value at the end of the ArrayList
     * @param x Object to insert
     */
    public void add(Object x){
        if(isFull()){
            increaseSize();
            myArrayList[size()] = x;
        }else{
            myArrayList[size()] = x;
        }
        sizecount++;
       // System.out.println(x+" has been added");
    }
    
    /**
     * A method which insert a value at a given location
     * @param index location to insert value
     * @param x value to insert
     */
    public void add(int index, Object x){
        sizecount++;
        int lengthList = myArrayList.length;
        if(index > lengthList){
            increaseSize();
            add(index,x);
        }else{
            shiftRigth(index);
            myArrayList[index] = x;
        }           
        int position = index + 1;
        System.out.println(x+" has been inserted in position "+ position);
    }
    
     
    /**
     * A method which retrieve a value from a given location
     * @param index location
     * @return value at location or null if location doesn't exist
     */
    public Object get(int index){
        if (index < myArrayList.length) {
            return myArrayList[index];
        }else{
            return null;
        }        
    } 
    
    /**
     * A method which insert a value a a given location
     * @param index position where to insert the object
     * @param value object to insert
     */
    public void set(int index, Object value){
        myArrayList[index] = value;
    } 
    
    /**
     *A method which return the number of elements in the the ArrayList
     *@return size of ArrayList
     */ 
    public int size(){
        return sizecount;
    }
    /**
     *A method which test if the ArrayList is empty.
     *@return True if empty and False if not.
     */ 
    public boolean isEmpty(){
        return size() == 0;
    } 
    /**
    * A method which test if the ArrayList is full.
    *@return True if full and False if not.
    */ 
    public boolean isFull(){
        return myArrayList.length == size();
    } 
    
    /**
    * A method which test if a particular object exist in the ArrayList.
    * @param ob object to search in ArrayList
    * @return True if exist and False if not.
    */ 
    public boolean isIn(Object ob){
        boolean exist = false;
        for (Object tempArr : myArrayList) {
            if (tempArr == ob) {
                exist = true;
                break;
            }
        }
        return exist;
    }
    /**
     * A method that will return the location of first occurrence of an Object starting from location 0
     * @param n Object to find
     * @return index where the Object is located or null if not found
     */ 
    public int find (Object n){
        Integer location = -1;
        if (isIn(n)) {
            for (int i=0; i<myArrayList.length; i++) {
                if (myArrayList[i] == n) {
                    location = i;
                    break;
                }
            }
        }
        return location+1;
    } 
    
    /**
     * A method that will remove the first occurrence of an Object starting from location 0
     * @param n  Object to remove
     */ 
    public void remove (Object n){
        Object tempArr[] = new Object[myArrayList.length];
        Object tempList[] = new Object[myArrayList.length+1];
        int index = find(n);
        if (index >= 0){
            System.arraycopy(myArrayList, 0, tempList, 0, myArrayList.length); 
            for(int i =0; i < index; i++) {
                tempArr[i] = myArrayList[i];
            }
            for(int i = index; i < myArrayList.length; i++){
                tempArr[i-1] = tempList[i];
            }  
            sizecount--;
            myArrayList = tempArr;
            System.out.println(" Element removed succesfully");
        }else{
            System.out.println(" Element not removed");
        }
    }
    
    /**
     * A method that print the arrayList
     */ 
    public void printList(){
        for (int i=0; i<size(); i++) {
            System.out.println(myArrayList[i]);
        }
    }
    
    /**
     * A method that give the length the arrayList
     */ 
    public int length(){
        return myArrayList.length;
    }
    
    /**
     * A method that will increase the size of the ArrayList when it is full
     */ 
    private void increaseSize (){
        Object tempArr[] = new Object[myArrayList.length+increment];
        //System.arraycopy(myArrayList, 0, tempArr, 0, myArrayList.length-1);
        for(int i = 0; i < myArrayList.length; i++){
            tempArr[i] = myArrayList[i];
        }
        myArrayList = tempArr;
        System.out.println(" size of the arrayList increase succesfully");
    }
    /**
     * A method that Shifts any subsequent elements of the ArrayList to the right from a given position 
     * @param index
     */ 
    private void shiftRigth (int index){
        int sizeList = size();
        int lengthList = myArrayList.length;      
        while(sizeList +1 > lengthList){            
            increaseSize();
            lengthList = myArrayList.length;
        }     
        Object tempArr[] = new Object[myArrayList.length+1];
        
        for(int i =0; i < index; i++) {
            tempArr[i] = myArrayList[i];
        }
        //tempArr[index] = element;
        for(int i = index; i < myArrayList.length; i++){
            tempArr[i+1] = myArrayList[i];
        }  
         
        myArrayList = tempArr;
    }
    
}
