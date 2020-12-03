/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Base
 * Objective: Inherit from superclass to build functional inner subclasses for ingredients.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Base extends Ingredient
{
    /**
     * "Base" Constructor
     *  This constructor calls the superclass constuctor to initialize variables.
     */        
    public Base(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
}
