import java.awt.*;  //Import java class Abstract Window Toolkit for color
/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Pepper
 * Objective: Inherit from inner subclass to build functional outer subclass ingredient.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Pepper extends Vegetable
{
    /**
     * "Pepper" Constructor
     *  This constructor calls the superclass constuctor to initialize default variables.
     */         
    public Pepper(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
    
    /**
     * "Pepper" Constructor
     *  This constructor calls the superclass constuctor to initialize all variables.
     */        
    public Pepper(String description, Money amount, int calories, Color color){  //Add Color parameter
        super(description,amount,calories,color);  //Calls super constructor
    }  
    
    /**
     * Method "toString"
     * Returns the name of the ingredient.
     */            
    public String toString(){  //Returns String
        return "Pepper";  //Return name
    }    
}
