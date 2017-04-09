
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


/**
 * Assignment 4
 * @author Noria Soumbou
 * PURPOSE
 *  The purpose of our program is  that evaluates an infix expression and convert the expression to postfix.
 * DESCRIPTION
 *  The program will ask the user to enter an infix expression.
 * Then the program will check if the infix expression contains an error of any kind and display the message Error in expression if he found one.
 * If there is no error, the program convert the expression to postfix and display the converted expression.
 * Then The program will repeatedly prompt the user for the value of x, displaying the value of the expression each time. 
 * When the user enters the letter q instead of a number, the program terminates.
 * SOLUTION
 *  We created a main program and 7 methods.
 * The main program shows the prompt of our program and call the necessary methods.
 * 3 main methods to execute the main actions of the program and 4 are helper methods.
 * DATA STRUCTURE
 *  For our program we use the Stack Data Structure.
 */
public class Calc {
    private static Stack <Character> opStack = new Stack();
    private static String postfix ="";
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String infixExpr, postfixExpr;
        int xVal = 0;
        boolean end = false;
        do{     
            System.out.print("Enter infix expression: ");
            infixExpr = userInput.next();
        }while(!isInfix(infixExpr));
        postfixExpr = toPostfix(infixExpr);
        System.out.println("Converted expression: "+postfixExpr);
        if(!infixExpr.contains("x")){
            System.out.println("Answer to expression: "+calculate(xVal,infixExpr)+" ");
        }else{
            do{
                System.out.print("Enter value of x: ");
                try{
                    xVal = userInput.nextInt();
                }catch(InputMismatchException e){
                        System.out.println("Bye");
                        userInput.next();
                        //end = true;
                        break;
                }
                System.out.println("Answer to expression: "+calculate(xVal,infixExpr)+" ");
            }while(!end);
        }
    }
    
    /**
     * Check if the infix expression contains error
     * @param infixExpr
     * @return true is no error and false if 
     */
    private static boolean isInfix(String infixExpr) {
        boolean correct = true;
        int left = 0,right = 0;
        int longueur = infixExpr.length()-1;
        if(infixExpr.contains(".")){
            System.out.println("Error in expression!! Cannot accept floating point numbers.");
            correct = false;
        }
        // first element not operator
        if(isOperator(infixExpr.charAt(0))){
            System.out.println("Error in expression!! No operator between operands. Also first token must be an operand.");
            correct = false;
        }
        //last element not operator
        if(isOperator(infixExpr.charAt(longueur))){
            System.out.println("Error in expression!! No operator between operands. Also last token must be an operand.");
            correct = false;
        }
        
        for( int i=0; i<infixExpr.length();i++){
            if(isOperator(infixExpr.charAt(i))){
                // if two operators follow each others eg:1++5
               if(isOperator(infixExpr.charAt(i-1)) && i != 0){
                    System.out.println("Error in expression!! The "+infixExpr.charAt(i-1)+" operator cannot be preceded by a "+infixExpr.charAt(i)+" operator.");
                    correct = false;
               }
            }else if(infixExpr.charAt(i) == '('){
                left++;
                // if ( end equation eg: 2+3(
                if(i == longueur){ 
                    System.out.println("Error in expression!! No left parenthesis at the end");
                    correct = false;
                }else{
                    // example 2-(+3 error
                    if(isOperator(infixExpr.charAt(i+1))){
                        System.out.println("Error in expression!! No operator between operand and left parentheses.");
                        correct = false;
                        break;
                    }
                    // example 2-6(9+3) error
                    if(i>0 && isOperand(infixExpr.charAt(i-1))){
                        System.out.println("Error in expression!! No operator between operand and left parentheses.");
                        correct = false;
                    }
                }
                
            }else if(infixExpr.charAt(i) == ')'){
                right++;
                // if ) start equation eg: )2+3
                if(i == 0){
                    System.out.println("Error in expression!! No right parenthesis at the beginning");
                    correct = false;                
                }else{
                    // example (2-)+3 error
                    if(isOperator(infixExpr.charAt(i-1))){
                        System.out.println("Error in expression!! No operator between operand and rigth parentheses.");
                        correct = false;
                    }
                    // example (2-3)3 error
                    if(i<longueur && isOperand(infixExpr.charAt(i+1))){
                        System.out.println("Error in expression!! No operator between operand and rigth parentheses.");
                        correct = false;
                    }
                }
            }else{ //for all others characters
                if(infixExpr.charAt(i) != ' ' && !isOperand(infixExpr.charAt(i))){
                    System.out.println("Error in expression!! Unauthorized character");
                    correct = false;                
                }
            }
        }
        if(left < right){
            System.out.println("Error in expression!! No matching left parentheses for a right parentheses.");
            correct = false;
        }if(left > right){
            System.out.println("Error in expression!! No matching rigth parentheses for a left parentheses.");
            correct = false;
        }
        return correct;
    }
    /**
     * Check if operator in stack has a higher precedence than the operator in expression
     * @param operator1 operator in stack
     * @param operator2 operator in string
     * @return true is higher and false if not
     */
    private static boolean isHighPrecedence(char operator1,char operator2) {
        // + - precedence 1, * % / precedence 2
        int prec1 = 0,prec2 = 0;        
        switch (operator1){
            case '+': case '-' : prec1 = 1;
                            break;
            case '*': case '%' : case '/': prec1 = 2;
                            break;
            default: break;
        }
        
        switch (operator2){
            case '+': case '-' : prec2 = 1;
                            break;
            case '*': case '%' : case '/': prec2 = 2;
                            break;
            default: break;
        }
        
        return prec1 >= prec2;
    }
    /**
     * Check if a character is an operator
     * @param charVal character to evaluate
     * @return true if it is an operator and false if not
     */
    private static boolean isOperator(char charVal) {
        return charVal == '+' |charVal == '-' | charVal == '*' |charVal == '/' |charVal == '%';
    }
    /*private static boolean isOperator(String charVal) {
        return charVal.equals('+') |charVal.equals('-') | charVal.equals('*') |charVal.equals('/') |charVal.equals('%');
    }*/
    
    /**
     * Check if a character is an operand or variable x
     * @param charVal character to evaluate
     * @return true if it is an operator or variable and false if not
     */
    private static boolean isOperand(char charVal) {
        return Character.isDigit(charVal) | charVal == 'x';
    }

    private static String toPostfix(String infixExpr) {
        for( int i=0; i<infixExpr.length();i++){
            if(isOperand(infixExpr.charAt(i))){
                postfix += infixExpr.charAt(i);
            }else if(isOperator(infixExpr.charAt(i))){
               while(!opStack.isEmpty() && isHighPrecedence(opStack.peek(),infixExpr.charAt(i))){
                    postfix += opStack.pop();
                }
                opStack.push(infixExpr.charAt(i));
               
            }else if(infixExpr.charAt(i) == '('){
                opStack.push(infixExpr.charAt(i));
            }else if(infixExpr.charAt(i) == ')'){
                //remove all element in parenthesis
                char elt = opStack.pop();
                while(elt != '(' && !opStack.isEmpty()){  
                    postfix += elt;
                    elt = opStack.pop();
                }
            }
        }
        // if the stack still have element, empty
        while(!opStack.isEmpty())
            postfix += opStack.pop();
        return postfix;
    }
    /**
     * evaluate expression
     * @param xVal value of the unknown variable
     * @param infixExpr expression to evaluate
     * @return the value of the expression
     */
    private static int calculate(int xVal, String infixExpr) {
        Stack <String> opeStack = new Stack();
        Stack <Integer> numStack = new Stack();
        Integer elt1,elt2;
        String operator;
        
        String[] parts = infixExpr.split("(?=[()\\-+%/*])|(?<=[()\\-+%/*])");
        for( int i=0; i<parts.length; i++){
            if(isOperand(parts[i].charAt(0))){
                if (parts[i].equals("x")){
                    numStack.push(xVal);
                }else{
                    numStack.push(Integer.parseInt(parts[i]));
                }
            }else if(isOperator(parts[i].charAt(0))){                
                    while (!opeStack.isEmpty() && !opeStack.peek().equals("(")){
                        if(isHighPrecedence(opeStack.peek().charAt(0),parts[i].charAt(0)) ){
                            operator = opeStack.pop();
                            elt2 = numStack.pop();
                            elt1 = numStack.pop();
                            numStack.push(operation(operator,elt1,elt2)); 
                        }else{
                            break;
                        }
                    }
                    opeStack.push(parts[i]);
            }else if(parts[i].equals("(")){
                opeStack.push(parts[i]);
            }else if(parts[i].equals(")")){
                //remove all element in parenthesis
                operator = opeStack.pop();
                while(!opeStack.isEmpty() && !operator.equals("(")){   
                        elt2 = numStack.pop();
                        elt1 = numStack.pop();
                        numStack.push(operation(operator,elt1,elt2));
                        operator = opeStack.pop();
                }
            }
        }
        
        while(!opeStack.isEmpty()){            
            operator = opeStack.pop();
            elt2 = numStack.pop();
            elt1 = numStack.pop();
            numStack.push(operation(operator,elt1,elt2));
        }
        
        return numStack.pop();
    }
    
    /**
     * calculation of expression
     * @param op operator
     * @param v1 first operand
     * @param v2 second operand
     * @return result of calculation
     */
    private static int operation (String op, int v1, int v2){
        int result;
        switch (op){
            case "+": result=v1+v2; break;
            case "-": result=v1-v2; break;
            case "*": result=v1*v2; break;
            case "/": result=v1/v2; break;
            case "%": result=v1%v2; break;
            default:  result=0; break;
        }
        return result;
    }
            
            
             
}
