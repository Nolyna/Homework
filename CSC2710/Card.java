/*Noria Soumbou
 *Lab 2 - 1/20/2017 - 2pm to 2:50pm *
 * @author Noria Soumbou
 *@purpose
 *   The purpose of our class is to create an Card data structure similar to the 
 * card game using (rank an suit). 
 * @solution
 *  For our class, we created two constructors and 10 publics method.
 * @methods
 * A constructor that create a default Ace of Spades card --------------- public Card();
 * A constructor that accepts a parameter rank and suit of the card  ---- public Card(int a, String b);
 * A method that get the rank value of the card ------------------------- getrank();
 * A method that get the suit value of the card ------------------------- getsuit();
 * A method that set the rank value of the card ------------------------- setrank(int a); 
 * A method that get the suit value of the card ------------------------  setsuit(String b);
 * A method that print the card ----------------------------------------- printcard(); 
 * A method that print the card ----------------------------------------- toString();

 */
public class Card {
	private String suit,rank ;
	
	public Card(){
            rank = "Ace";
            suit = "Spades";
	}
        
        public Card( int a, String b){
            setrank(a);
            setsuit(b);
        }
	
	/*public Card( int a, String b){
            switch(a){
                case 2: case 3: case 4:case 5:case 6:case 7:case 8:case 9:case 10:
                    rank = String.valueOf(a);
                    break;
                case 14: rank = "Ace";
                                break;
                case 13: rank = "King";
                                break;
                case 12: rank = "Queen";
                                break;
                case 11: rank = "Jack";
                                break;
                default: System.out.println("wrong rank parameter");
                        break;
            }
            switch(b.toLowerCase()){
                case "diamonds": case "spades" : 
                case "clubs": case "hearts": 
                    suit = b; 
                    break;
                default: System.out.println("wrong suit parameter");
                        break;	
            }
	}*/
        
        /**
         * Setter methods which set the value of the suit of the card
         * @param a value of rank
         */
	public final void setrank(int a){
		switch(a){
                    case 2: case 3: case 4:case 5:case 6:case 7:case 8:case 9:case 10:
                        rank = String.valueOf(a);
                        break;
                    case 14: rank = "Ace";
                                    break;
                    case 13: rank = "King";
                                    break;
                    case 12: rank = "Queen";
                                    break;
                    case 11: rank = "Jack";
                                    break;
                    default: System.out.println("wrong parameter, value not set");
                            rank = null;
                            break;
                    //default: throw new IllegalArgumentException("Wrong parameter,rank must be between 2 and 14");
		}
	}
        
        /**
         * setter methods which set the value of the suit of the card
         * @param b value of suit 
         */
        public final void setsuit(String b){
            switch(b.toLowerCase()){
                case "diamonds": case "spades" : 
                case "clubs": case "hearts": 
                    suit = b; 
                    break;
                default: System.out.println("wrong parameter, value not set");
                         suit = null;
                         break;
                //default: throw new IllegalArgumentException("Wrong parameter,suit must be diamonds,spades,clubs or hearts");
                        	
            }
            
	}
        /**
         * Getter methods which get the value of the rank of the card
         * @return rank of the card
         */
	public String getrank(){
            return rank;
	}
	/**
         * Getter methods which get the value of the suit of the card
         * @return suit of the card
         */
	public String getsuit(){
            return suit;
	}
        	
        /**
         * methods which print the value of the card
         */
	public void printcard(){
            if(rank == null){
                System.out.println("rank missing");
            }else if( suit == null){
                System.out.println("suit missing");
            }else{
		System.out.println(toString());
            }
	}
        
    /**
     * Convert the data of the card class into a string value
     * @return
     */
    @Override
        public String toString(){
            return rank+" of "+ suit;
        
        }
                
}
