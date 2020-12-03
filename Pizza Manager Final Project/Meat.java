/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Meat
 * Objective: Inherit from superclass to build functional inner subclasses for ingredients.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Meat extends Ingredient
{
    /**
     * "Meat" Constructor
     *  This constructor calls the superclass constuctor to initialize variables.
     */    
    public Meat(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
}
