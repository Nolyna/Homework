
import java.util.Random;

/**create a deck */

/**
 * @Lab 3
 * @author Noria soumbou
 * The purpose of our class is to create a deck of 52 card which will be contain in an array
 * @class
 *  This class does not required any input, it just creates a desk with the constructor and we have one 
 * method which print the full desk.
 */
public final class Deck {
    
    private Card [] arrDeck = new Card[52];
    private Card carte;
    
    /**
     * Constructors that create the desk of cards
     */
    public Deck(){
        int j = 2;
        String suit; 
        
        // initiate suit of the card
        for (int i=0 ; i <= 51 ; i++){
            if(i<=12){
                suit = "diamonds";
            }else if(i>12 && i<=25){
                suit = "spades";
            }else if(i>25 && i<=38){
                suit = "hearts";
            }else{
                suit = "clubs";
            }
            
            // insert  the card in array
            carte = new Card(j,suit);
            arrDeck[i] = carte;
            
            // initiate rank of the card
            if(j<14){
                j++;
            }else{
                j = 2;
            }
        }
    }
    
    /**
     * Method that print all the elements of the deck
     */
    void printdeck() {
        for(int i=0;i<=51;i++){
            System.out.println(arrDeck[i]); 
        }
    }
    
    /**
     * Method that get elements in the deck at position x
     * @param i index
     * @return 
     */
    public Card getCardDeck( int i) {  
        return arrDeck[i]; 
    }
    
    /**
     * Method that set elements in the deck at position x
     * @param index index
     * @param cardElement
     */
    public void setCardDeck( int index, Card cardElement) {  
        arrDeck[index] = cardElement; 
    }
    
    private static void shuffle(Deck shuffleDeck) {
        Random rand = new Random();
        int first,second;
        Card temp;
        
        for(int i=0;i<=20;i++){
            first = rand.nextInt((51 - 0) + 1) + 0;
            second = rand.nextInt((51 - 0) + 1) + 0;

            temp = shuffleDeck.getCardDeck(second);
            shuffleDeck.setCardDeck(second,shuffleDeck.getCardDeck(first));
            shuffleDeck.setCardDeck(first,temp);
        }
    }
    
    public static void main (String [] args){ 
            Random rand = new Random();
            int randomCard;
            Deck ca = new Deck();
            Card []person1 = new Card [5];
            Card []person2 = new Card [5];
            
            for(int i=0; i<person1.length; i++){
                randomCard = rand.nextInt((51 - 0) + 1) + 0;
                person1[i]= ca.getCardDeck(randomCard);
            }
            
            for(int i=0; i<person1.length; i++){
                randomCard = rand.nextInt((51 - 0) + 1) + 0;
                person2[i]= ca.getCardDeck(randomCard);
            }
            /// show people card
            System.out.println("Person 1 cards:");
        for (Card person11 : person1) {
            System.out.println(person11);
        }
            System.out.println("Person 2 cards:");
            for(int i=0; i<person1.length; i++){
                System.out.println(person2[i]);
            }
            
            System.out.println("Deck of cards before shuffel:");
            ca.printdeck();
            shuffle(ca);
            System.out.println("Deck of cards after shuffle:");
            ca.printdeck();
	}
}
