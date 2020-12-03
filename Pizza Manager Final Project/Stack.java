/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Pizza
 * Objective: Build a Stack to reverse ArrayList of Pizzas.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Stack<P>
{
    private Node head;  //New node
    
    /**
     * Method "push"
     * Inserts to the beginning of the list.
     */    
    public void push(P next){  //Takes an Object as input, returns nothing
       head=new Node(next,head);  //Create a new Node of the Object at the head
    }
  
    /**
     * Method "pop"
     * Removes from the beginning of the list.
     */    
    public Object pop(){  //No parameters, returns Object
        if(head==null){  //If the head is null
            throw new RuntimeException("Error: Empty List");  //Throw an error
        }
        Object retVal=head.data;  //Declare and initialize new Object retVal
        head=head.next;  //Set value of head equal to the next Node
        return retVal;  //Return Object
    }
    
    //Method toString
    //Returns a String
    public String toString(){  //Return String  
        return toString(head);  //Facade
    }
    
    //Method toString
    //Walks through the Stack
    private String toString(Node current){  //Takes Node as input  
        return current==null?"":current.data+"STACK"+toString(current.next);  //Return this
    }
    
    //Method size
    //Return size of the stack
    public int size(){  //Returns int
        return size(head);  //Facade
    }
    
    //Method size
    //Return size of the stack    
    private int size(Node current){  //Returns int
        return current==null?0:1+size(current.next);  //Return this
    }
    
    //Method isEmpty
    //Returns true if Stack is empty
    public boolean isEmpty(){  //No parameters, returns boolean value
        return head==null;  //Returns true if the head is null
    }    
    
    
    //Class Node
    //Helps organize the Stack
    public class Node{
        Object data;  //New Object
        Node next;  //New Node
        public Node(Object d, Node n){  //Constructor
            data=d;  //Initialize Object with parameter
            next=n;  //Initialize Node with parameter
        }
    }
}
