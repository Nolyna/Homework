/**
 * @Assignement 1
 * @author Noria Soumbou
 * @purpose
 *   the purpose of our program is to read a file and count the number of word, lines, sentences, vowels
 *  punctuation and alphanumeric characters in the file. 
 * @solution
 *  For our program, we will have an prompt asking the user to enter the file. Once we get the file,
 * the program will check if it is empty. If not, it will read the file line by line. When reading each
 * line, it will also read word by word, and for each word read letter by letter and increase the number 
 * of element (punctuation,alphanumeric,sentence,word,lines) when applies.
 * @manual
 *  The user enter the path of the file text to read and the program will create a document "output.txt"
 *  and show on the screen the informations about the file. The information will be the number of word, 
 *  lines, sentences, vowels, punctuation and alphanumeric characters contains in the file.
 * @class
 *  The program contains only one main class which execute all the operations needed to obtain our output.
 * 
 */
 import java.util.Scanner;
 import java.io.*;
 
public class Wordcount {
    
    public static void main (String[] args) throws IOException{ 
        // initialisation of variables
        String  fileName;
        int numberLine, numberWord, numberAlpha,numberSentence,numberVowel,numberPunct;
        numberLine = numberWord = numberAlpha = numberSentence = numberVowel = numberPunct = 0;
        Scanner user = new Scanner( System.in ); 

        // get the input file
        System.out.print("Enter the file location: ");
        fileName = user.nextLine().trim();
        File file = new File(fileName);      
        try (Scanner reader = new Scanner(file)) {
            if(!reader.hasNext()){//check if empty
                System.out.println("The file is empty");
                reader.close();
                System.exit(0);
            }else{ //if not empty
                while ( reader.hasNextLine()) {
                    // get and count number of lines
                    String textline = reader.nextLine();
                    numberLine++;
                    Scanner line = new Scanner(textline);

                    while ( line.hasNext()) { // for each line get the word one by one
                        // get and count number of word
                        String word = line.next();
                        numberWord++;
                        // put the word in lowercase and divide in an array of character to simplify comparison
                        String word2 = word.toLowerCase();
                        char[] charArray = word2.toCharArray();

                        for(int i=0; i<charArray.length; i++) {
                            switch(charArray[i]){ //compare characters
                                //check if it is a vowel
                                case 'a':case 'e':case 'i':case 'o':case 'u':{
                                    numberVowel++;
                                    numberAlpha++;
                                    break;
                                }
                                //check if it is an alphanumeric character
                                case 'b':case 'f':case 'j':case 'm':case 'q':case 't':case 'x':
                                case 'c':case 'g':case 'k':case 'n':case 'r':case 'v':case 'y':
                                case 'd':case 'h':case 'l':case 'p':case 's':case 'w':case 'z':
                                case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':{
                                    numberAlpha++;
                                    break;
                                }
                                //check if it is a punctuation
                                case '!':case ';':case '.':case ',':case '?':{
                                    numberPunct++;
                                    //check if the punctuation means end of sentence
                                    if( charArray[i] == '!' || charArray[i] == '?' || charArray[i] == '.'){
                                        numberSentence++;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                
                //output on screen
                System.out.println("the file has: "+numberWord+" words,");
                System.out.println("the file has: "+numberLine+" lines,");
                System.out.println("the file has: "+numberAlpha+" alphanumeric characters,");
                System.out.println("the file has: "+numberSentence+" sentences,");
                System.out.println("the file has: "+numberVowel+" vowels,");
                System.out.println("the file has: "+numberPunct+" punctuation.");

                // create the file output.txt and write the output in it  
                try (PrintWriter output = new PrintWriter("output.txt", "UTF-8")) {
                    output.write("the file has: "+numberWord+" words,");
                    output.println("the file has: "+numberLine+" lines,");
                    output.println("the file has: "+numberAlpha+" alphanumeric characters,");
                    output.println("the file has: "+numberSentence+" sentences,");
                    output.println("the file has: "+numberVowel+" vowels,");
                    output.println("the file has: "+numberPunct+" punctuation.");
                    output.close();
                }catch(IOException e){//catch error for the file output.txt 
                    System.out.println(e);
                }
            }
            
        } catch (IOException e) {//catch error for the input file
            System.out.println("exception:" + e);
        }
  }
        
}
