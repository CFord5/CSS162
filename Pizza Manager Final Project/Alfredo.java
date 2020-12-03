/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Alfredo
 * Objective: Inherit from inner subclass to build functional outer subclass ingredient.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Alfredo extends Base
{
    /**
     * "Alfredo" Constructor
     *  This constructor calls the superclass constuctor to initialize variables.
     */      
    public Alfredo(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
    
    /**
     * Method "toString"
     * Returns the name of the ingredient.
     */                 
    public String toString(){  //Returns String
        return "Marinara";  //Return name
    }    
}
