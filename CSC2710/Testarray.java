
import java.util.Random;

/**
 *Assignment 2
 * @author Noria Soumbou
 * @solution
 *  For the first part of our program we just create a deck,shuffle with a method that we created and display the result.
 * to create the deck we make a loop in which we initiate/update the rank (2-14) and suit(heart,clubs,diamond and spade)
 * of our card for every 14 card. 
 *  For the second part we created two arrayList test that we fill with integer and just call all the ArrayList method.
 *  For the shuffle, the program choose two numbers between 0 and 51 and exchange the date of the deck at those
 * two positions. The exchange is lunch 20 times.
 * @Purpose
 *  The purpose of our program is to test the ArrayList data structure than we created by creating and manipulate Deck of card.
 * @data structure
 *  The program use the ArrayList and Card that we created.
 * @Description
 *  The program fill the ArrayList with Card Objects and print these to the screen. After that,
 * the program shuffle this ArrayList of Cards and display the shuffled ArrayList (Deck) of Cards.
 * It also test all nine methods created for the arrayList using two array Test. It will print out the returned value 
 * to the screen for those that are returning a value and for those that are not returning a value,
 * print a message that indicate if it successfully completed its task.
 * @class
 *  The program contains a main class to execute the program and one method shuffle to shuffle our arrayList.
 * We also use the class Card to create the cards for the deck and ArrayList class for the deck which contains all the cards. 
 */
public class Testarray {
    
    public static void main (String [] args){
    
        ArrayList arrDeck = new ArrayList(52);
        int j = 2;
        String cardsuit;
        
    // desk creation 
    
        // initiate suit of the card
        for (int i=0 ; i <= 51 ; i++){
            if(i<=12){
                cardsuit = "diamonds";
            }else if(i>12 && i<=25){
                cardsuit = "spades";
            }else if(i>25 && i<=38){
                cardsuit = "hearts";
            }else{
                cardsuit = "clubs";
            }
            
            // insert  the card in array
            arrDeck.add(new Card(j,cardsuit));
            
            // initiate rank of the card
            if(j<14){
                j++;
            }else{
                j = 2;
            }
        }
    System.out.println("Deck before shuffle:");    
    arrDeck.printList();
    shuffle(arrDeck);
    System.out.println("Deck after shuffle:");
    arrDeck.printList();
    
    
    // arraylist methods test
    ArrayList lisTest1 = new ArrayList();
    ArrayList lisTest2 = new ArrayList(2);
    Integer searchElt = 4;
    if(lisTest1.isEmpty())
        System.out.println("Empty list");
    lisTest1.add(2);
    lisTest1.add(3);
    lisTest1.add(1,4);
    System.out.println("the size of the lisTest1 is "+lisTest1.size());
    lisTest1.printList();
    if(lisTest1.isIn(searchElt))
        System.out.println(" The element "+searchElt+" exist and is found in position "+lisTest1.find(searchElt));
    
    System.out.println(" The length of listtest2 before adding is "+lisTest2.length());
    lisTest2.add(7);
    lisTest2.add(8);
    lisTest2.add(10);
    System.out.println(" The length of listtest2 after adding is "+lisTest2.length());
    lisTest2.add(2,9);
    if(lisTest2.isFull())
        System.out.println(" The listest2 exist is full ");
    System.out.println(" The element in position 2 is: "+lisTest2.get(2));
    System.out.println(" The listest2 before removing element ");
    lisTest2.printList();
    lisTest2.remove(8);
    System.out.println(" The listest2 after removing element ");
    lisTest2.printList();
    
    
    
    
    }
    /**
     * Method that shuffle the element of the deck
     * @param shuffleDeck arrayList to shuffle
     */
    private static void shuffle(ArrayList shuffleDeck) {
        Random rand = new Random();
        int first,second;
        Object temp;
        
        for(int i=0;i<=20;i++){
            first = rand.nextInt((51 - 0) + 1) + 0;
            second = rand.nextInt((51 - 0) + 1) + 0;

            temp = shuffleDeck.get(second);
            shuffleDeck.set(second,shuffleDeck.get(first));
            shuffleDeck.set(first,temp);
        }
    }
}
