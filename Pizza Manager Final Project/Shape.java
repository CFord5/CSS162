/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Shape
 * Objective: Build superclass for Circle and Square.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public abstract class Shape extends Object implements Cloneable
{
    private int x;  //Instance variable to track x 
    private int y;  //Instance variable to track y
    
    /**
     * "Shape" Constructor
     *  Default constructor.
     */
    public Shape(){  //No parameters or return vaue
    }

    /**
     * "Shape" Constructor
     *  This constructor initializes the instance variables.
     */
    public Shape(int x, int y){  //Integer parameters
        setX(x);  //Initialize x
        setY(y);  //Initialize y
    }

    /**
     * "Shape" Constructor
     *  This constructor copies the argument Shape.
     */
    public Shape(Shape other){  //Shape parameter
        this(other.x, other.y);  //Calls above constructor
    }

    /**
     * Method "getX"
     * This method returns instance variable x.
     */
    public int getX(){  //Returns integer
        return x;  //Return instance variable
    }

    /**
     * Method "getY"
     * This method returns instance variable y.
     */    
    public int getY(){  //Returns integer
        return y;  //Return instance variable 
    }
 
    /**
     * Method "setX"
     * This methods sets instance variable x.
     */
    public void setX(int x){  //Returns nothing, takes integer as parameter
        this.x=x;  //Set instance variable equal to the argument
    }

    /**
     * Method "setY"
     * This methods sets instance variable y.
     */    
    public void setY(int y){  //Returns nothing, takes integer as parameter
        this.y=y;  //Set instance variable equal to the argument
    }

    /**
     * Method "getArea"
     * This method returns the area.
     */
    public abstract double getArea();  //Returns double
  
    /**
     * Method "clone"
     * This method returns the clone of the Object.
     */    
    public abstract Object clone();  //Returns Object
}