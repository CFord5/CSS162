import java.awt.*;  //Import java class Abstract Window Toolkit for color
/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Vegetable
 * Objective: Inherit from superclass to build functional inner subclasses for ingredients.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Vegetable extends Ingredient
{
    private Color color;  //Instance variable to track color of Vegetable
    
    /**
     * "Vegetable" Constructor
     *  This constructor calls the superclass constuctor to initialize variables.
     */         
    public Vegetable(String description, Money amount, int calories){  //Three parameters
        super(description,amount,calories);  //Calls super constructor
    }
    
    /**
     * "Vegetable" Constructor
     *  This constructor calls the superclass constuctor to initialize color.
     */       
    public Vegetable(String description, Money amount, int calories, Color color){  //Four parameters
        super(description,amount,calories);  //Calls super constructor
        setColor(color);  //Initialize color
    }    
    
    /**
     * Method "setColor"
     * This method sets the instance variable.
     */
    public void setColor(Color color){  //Returns nothing, Color parameter
        this.color=color;  //Set instance variable equal to the argument
    }
    
    /**
     * Method "getColor"
     * This method returns the color.
     */
    public Color getColor(){  //Returns color
        return color;  //Return instance variable
    }
    
    /**
     * Method "toString"
     * This method returns the color in String form.
     */
    public String toString(){  //Returns String
        return super.toString()+"Color: "+getColor();  //Returns name of color
    }
    
    /**
     * Method "equals"
     * This method tests for equality.
     */
    public boolean equals(Object other){  //Returns true or false, takes Object as parameter  
        boolean result=false;  //Create new boolean
        if((other instanceof Vegetable)){  //If argument is of the same class 
            Vegetable that=(Vegetable) other;  //Set Vegetable object equal to casted Object
            result=(this.equals(that)&&this.getColor()==that.getColor());  //Returns true if equal
        }
        return result;  //Return boolean
    }
}
