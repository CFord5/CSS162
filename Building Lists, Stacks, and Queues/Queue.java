/**
 * Course: CSS 162 A
 * Assignment: Building Lists, Stacks, and Queues with Arrays
 * Class: Queue
 * Objective: Build a program that serves as a First-In-First-Out data structure.
 *            (Can add to end and take from front, like line of people.)
 * Author: Chandler Ford
 * Last Modified Date: 4/26/2016
 */
public class Queue{
    private Object[] data;  //Declare new Object array
    private int numElements=0;  //Declare and initialize counting variable
    private int front=-1;  //Keep track of front of Object array
    private int end=-1;  //Keep track of end of Object array
    
    /**
     * Queue Constructor
     * This is the default constructor, sets it to three elements.
     */
    public Queue(){
        numElements=3;  //Set integer equal to three
        data=new Object[numElements];  //Object array set to variable
    }
    
    /**
     * Queue Constructor
     * This constructor takes in an integer.
     * Can use parameter to adjust size of Object[].
     */
    public Queue(int size){
        numElements=size;  //Set numElements equal to parameter
        data=new Object[numElements];  //Object array set to variable
    }
    
    /**
     * Method "enqueue"
     * Takes an Object as a parameter.
     * Adds object to the back of the queue.
     */
    public void enqueue(Object other){
        if(isEmpty()==true){  //If space is empty
            front++;  //Add to front value
            end++;  //Add to end value
            data[end]=other;  //Data at end index set to parameter value
        } else{  //If something is there
            end=(end+1)%numElements;  //Add to the end and modulate by numElements
            data[end]=other;  //Data at end index set to parameter value
        }
    }
    
    /**
     * Method "dequeue"
     * Removes and returns item from front of queue.
     * The book uses something called "Nodes", so I had to findd out how front/end
     * variables operate online. It works, so I guess that's the right way? :/
     */
    public Object dequeue(){
        Object retVal=null;  //Dexlare new Object
        if(front==end){  //If the front and end are qual
            retVal=data[front];  //Set Object equal to data at front index
            front=-1;  //Reset front
            end=-1;  //Reset end
        } else{
            retVal=data[front];  //Set Object equal to data at front index
            front=(front+1)%numElements;  //Add to the front and modulate by numElements
        }
        return retVal; //Return Object
    }
    
    /**
     * Method "size"
     * Returns the number of elements in the queue.
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
        return front==-1&end==-1;  //Returns true if variable set to default values
    }
    
    /**
     * Method "equals"
     * Takes in an Object as a parameter.
     * Returns true if they are of equal size.
     */
    public boolean equals(Object other){
        boolean result=false;  //Declare and initialize new boolean
        if((other instanceof Queue)){   //If the object is of the Queue class
            Queue that=(Queue) other;  //Set them equal to each other
            result=(this.size()==that.size());  //See if the information is equal
        }
        return result;  //Return boolean
    }
}