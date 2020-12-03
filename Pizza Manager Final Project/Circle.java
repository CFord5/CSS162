/**
 * Course: CSS 162 A
 * Assignment Pizza Manager Final Project
 * Class: Circle
 * Objective: Inherit from Shape superclass to help make a circle Pizza.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Circle extends Shape implements Cloneable
{
    private static double radius;  //Instance variable to track the radius of the circle

    /**
     * "Circle" Constructor
     *  Default constructor.
     */
    public Circle(){  //No arguments
    }

    /**
     * "Circle" Constructor
     *  This constructor initializes the Shape instance variables.
     */   
    public Circle(int x, int y){  //Integer parameters
        super(x,y);  //Use super constructor to initialize instance variables
    }

    /**
     * "Circle" Constructor
     *  This constructor initializes all the instance variables.
     */       
    public Circle(int x, int y, double radius){  //Integers and double parameter
        super(x,y);  //Use super constructor to initialize instance variables
        setRadius(radius);  //Initialize radius
    }

    /**
     * "Circle" Constructor
     *  This constructor copies the argument Circle.
     */
    public Circle(Circle other){  //Circle parameter
        this(other.getX(), other.getY(), other.getRadius());  //Calls above constructor
    }
    
    /**
     * Method "setRadius"
     * This methods sets instance variable radius.
     */
    public void setRadius(double radius){  //Returns nothing, takes double as parameter
        this.radius=radius;  //Set instance variable equal to the argument
    }    

    /**
     * Method "getRadius"
     * This method returns instance variable radius.
     */   
    public double getRadius(){  //Returns double
        return radius;  //Return instance variable
    }

    /**
     * Method "equals"
     * This method tests for equality.
     */
    public boolean equals(Circle that){  //Returns boolean, takes Circle as parameter
        return this.getX()==that.getX()&&this.getY()==that.getY()&&this.getRadius()==that.getRadius();  //Returns true if conditions met
    }

    /**
     * Method "toString"
     * This method returns a String representation of a Circle.
     */
    public String toString(){  //Returns String
        return "Circle";  //Returns name of Object
    }    

    /**
     * Method "getArea"
     * This method returns the area of a circle Pizza.
     */    
    @Override
    public double getArea(){  //Returns double
        return Math.PI*getRadius()*getRadius();  //Area is PI*radius squared
    }    

    /**
     * Method "clone"
     * This method returns the clone of a Circle.
     */
    @Override
    public Object clone(){  //Returns Object
        return new Circle(this);  //Return a new clone of the Circle
    }    
}
