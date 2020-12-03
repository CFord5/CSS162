/**
 * Course: CSS 162 A
 * Assignment: Building Lists, Stacks, and Queues with Arrays
 * Class: ArrayList
 * Objective: Build a program that creates lists, stacks and queues using arrays.
 * Author: Chandler Ford
 * Last Modified Date: 4/26/2016
 */
public class ArrayList{
    private Object[] data;  //Declare new Object array
    private int numElements=0;  //Declare and initialize counting variable
    
    /**
     * ArrayList Constructor
     * This is the default constructor, sets it to three elements.
     */
    public ArrayList(){
        numElements=3;  //Set integer equal to three
        data=new Object[numElements];  //Object array set to variable
    }
    
    /**
     * ArrayList Constructor
     * This constructor takes in an integer.
     * Can use parameter to adjust size of Object[].
     */
    public ArrayList(int size){
        numElements=size;  //Set numElements equal to parameter
        data=new Object[numElements];  //Object array set to variable
    }
    
    /**
     * Method "add"
     * This method adds a Object at the index.
     * Takes in an Object and a integer.
     * I don't think this is right, my values display wrong.
     */
    public void add(Object other, int index){
        if(data[index]==null){  //If there is nothing, the Object goes there.
            data[index]=other;  //Initialize Object array
        } else if(data[index]!=null){  //If there is something, shift the array first
            arrayShiftRight();  //Shift the array to the right
            data[index]=other;  //Initialize Object array
        } else if (index>numElements){  //If the index is more than total elements
            numElements=index;  //Set the values equal
            data[index]=other;  //Initialize object array
        }
    }
    
    /**
     * Method "remove"
     * Supposed to remove Object at the index, but doesn't really work right either.
     */
    public Object remove(int index){
        numElements--;  //Take away an element
        return data[index];  //Return at index
    }
    
    /**
     * Method "size"
     * Returns the number of elements in Object array.
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
     * Returns true if there are no elements.
     */
    public boolean isEmpty(){
        return numElements==0;  //Returns true if condition met
    }
    
    /**
     * Method "indexOf"
     * Returns index of value.
     * Takes an Object as parameter.
     */
    public int indexOf(Object other){
        for(int i=0; i<numElements; i++){  //For-loop, while less than numElements
            if(other.equals(data[i])){  //If the values are equal
                return i;  //Return index
            }
        }
        return -1;  //Otherwise return -1
    }
    
     /**
     * Method "equals"
     * Takes in an Object as a parameter.
     * Returns true if they are of equal size.
     */
    public boolean equals(Object other){
        boolean result=false;  //Declare and initialize new boolean
        if((other instanceof ArrayList)){   //If the object is of the Stack class
            ArrayList that=(ArrayList) other;  //Set them equal to each other
            result=(this.size()==that.size());  //See if the information is equal
        }
        return result;  //Return boolean
    }
    
    /**
     * Method "arrayShiftLeft"
     * Shifts the entire array to the left.
     */
    public void arrayShiftLeft() { 
        //This method will shift the array to the left
        for(int i=0; i<data.length-1; i++){  //Begins at specified starting index, loop to length-1
            data[i]=data[i+1];  //Input shifts one to the left 
        }
    }

    /**
     * Method "arrayShiftRight"
     * Shifts the entire array to the right.
     */
    public void arrayShiftRight() {
        //This method will shift the array to the right
        for(int i=data.length-1; i>0; i--){  //Reverse arrayShiftLeft, starts at length and goes back
            data[i]=data[i-1];  //Input shifts one to the right
        }
    }
}