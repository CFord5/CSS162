/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: PizzaException
 * Objective: Build a custom exception class.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class PizzaException extends RuntimeException
{   
    /**
     * "PizzaException" Constructor
     *  This is the default constructor.
     */
    public PizzaException(){  //No parameters
        super("An error occurred in PizzaManager.");  //Print error message via call to superclass
    }

    /**
     * "PizzaException" Constructor
     *  This is the default constructor.
     */
    public PizzaException(String msg){  //Takes String as parameter
        super(msg);  //Print out arguement as error message
    }
}