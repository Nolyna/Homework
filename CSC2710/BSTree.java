
import java.util.Random;


/**
 * CSC 2720
 * Assignment 5
 * @author Noria Soumbou
 * PURPOSE
 *  The purpose of our program is to create binary search tree and a linked list.
 * DESCRIPTION
 *  The program will generate 100 random numbers and store them in a array.
 *  Then the program will insert the numbers in a Binary search tree then display the tree using an infix recursive method
 * SOLUTION
 *   We created a main program and a Linked list call BSTree which had 2 methods, 2 constructors, 3 getters and 3 setters.
 *   The main program does not need user entry it, it executes all the program by itself.
 *   One method to add the numbers in the tree and one to print the tree.
 * DATA STRUCTURE
 *  For our program we created a LinkedList to contains our binary search tree.
 */
public class BSTree {
    
    private Integer n;
    private BSTree right, left;
    public BSTree root;

    /**
     * Constructors
     */
    public BSTree(){
        right = null;
        left = null;
        n = null;
    }

    public BSTree(int x){
        right = null;
        left = null;
        n = x;
    }
    
    /***********
     * Getters *
     ***********/
    
    /**
     * get value of the right child
     * @return right tree
     */
    private BSTree getRight() {
        return right;
    }
    /**
     * get value of the left child
     * @return left tree
     */
    private BSTree getLeft() {
        return left;
    }
    /**
     * get value of the root/node
     * @return data
     */
    public Integer getData(){
        return n;
    }
    
    /***********
     * Setters *
     ***********/
    
    /**
     * set right child
     * @param list BSTree
     */
    private void setRight(BSTree list) {
        right = list;
    }
    /**
     * set left child
     * @param list BSTree
     */
    private void setLeft(BSTree list) {
        left = list;
    }
    /**
     * set root/node value
     * @param data, value of the node 
     */
    private void setData(int data) {
        n = data;
    }
    
    /**
     * Add element in the tree
     * @param x, value to add in the tree 
     */
    public void add(int x){
        BSTree tmp = new BSTree(x);
        //BSTree current = root;
        if( this.getData() == null){
            //current = tmp;
            this.setData(x);
        }else{
            if( this.getData() > x){
                if (this.getLeft() != null){
                    this.left.add(x);
                }else{
                    this.setLeft(tmp);
                }
            }else{
                if (this.getRight() != null){
                    this.right.add(x);
                }else{
                    this.setRight(tmp);
                }
            }
        }
    }
    
    /**
     * Display the binary tree in infix order
     * infix: left child first, then root (value), then right child. 
     */
    private void infixPrint() {
        if( this.getLeft() != null ) {
            this.left.infixPrint();
        }
        System.out.print(this.getData()+" ");
        if( this.getRight() != null ) {
            this.right.infixPrint();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree binaryTree = new BSTree();
        Random rand = new Random();
        int[] arr = new int[10];        
        int arrSize = arr.length;
        
        for(int i = 0; i<arrSize; i++){
            arr[i] = 1 + rand.nextInt((99 - 1) + 1);
            binaryTree.add(arr[i]);
        }
        System.out.print("List: ");
        for(int i = 0; i<arrSize; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.print("Infix display of the tree: ");
        binaryTree.infixPrint();
    }   
        
    
    
}
