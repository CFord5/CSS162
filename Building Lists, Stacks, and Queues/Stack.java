/**
 * Course: CSS 162 A
 * Assignment: Building Lists, Stacks, and Queues with Arrays
 * Class: Stack
 * Objective: Build a program that serves as a Last-In-First-Out data structure.
 *            (Can take out most recently added item, like stack of newspapers.)
 * Author: Chandler Ford
 * Last Modified Date: 4/26/2016
 */
public class Stack{
    private Object[] data;  //Declare new Object array
    private int numElements;  //Declare and initialize counting variable
    private int mostRecentElement=-1;  //To keep track of last added variable
    
    /**
     * Stack Constructor
     * This is the default constructor, sets it to three elements.
     */
    public Stack(){
        data=new Object[3];  //Set integer equal to three
        numElements=3;  //Object array set to variable
    }
    
    /**
     * Stack Constructor
     * This constructor takes in an integer.
     * Can use parameter to adjust size of Object[].
     */
    public Stack(int size){
        data=new Object[size];  //Set numElements equal to parameter
        numElements=size;  //Object array set to variable
    }
    
    /**
     * Method "push"
     * Takes an Object as a parameter.
     * Adds an Object to the top of the stack.
     */
    public void push(Object other){
        if(mostRecentElement+1<numElements){  //If the most recent elements is less
            data[++mostRecentElement]=other;  //Add to index and set value
        }
    }
    
    /**
     * Method "pop"
     * Removes and returns item from top of the stack.
     */
    public Object pop(){
        if(mostRecentElement>=0){  //If the most recent element is zero or more
            return data[--numElements];  //Subtract from index and return
        }
        return -1;  //Else return -1
    }
    
    /**
     * Method "size"
     * Returns the number of elements in the stack.
     */
    public int size(){
        return numElements;  //Return value
    }
    
    /**
     * Method "toString"
     * Returns a String that is the printed Object array.
     */
    public String toString(){
        String retVal="";  //Declare new String
        for(int i=0; i<numElements; i++){  //For-loop, while less than numElements
            retVal+=data[i]+",";  //String contains Object array values
        }
        return retVal;  //Return String
    }
    
    /**
     * Method "isEmpty"
     * Returns true if the stack is empty.
     */
    public boolean isEmpty(){
        return numElements==0;  //Returns true if condition met
    }
    
    /**
     * Method "equals"
     * Takes in an Object as a parameter.
     * Returns true if they are of equal size.
     */
    public boolean equals(Object other){
        boolean result=false;  //Declare and initialize new boolean
        if((other instanceof Stack)){   //If the object is of the Stack class
            Stack that=(Stack) other;  //Set them equal to each other
            result=(this.size()==that.size());  //See if the information is equal
        }
        return result;  //Return boolean
    }
}