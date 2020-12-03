/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Sausage
 * Objective: Inherit from inner subclass to build functional outer subclass ingredient.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Sausage extends Meat
{
    /**
     * "Pepperoni" Constructor
     *  This constructor calls the superclass constuctor to initialize variables.
     */          
    public Sausage(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
    
    /**
     * Method "toString"
     * Returns the name of the ingredient.
     */             
    public String toString(){  //Returns String
        return "Sausage";  //Return name
    }    
}
