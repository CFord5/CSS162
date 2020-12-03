/**
 * Course: CSS 162 A
 * Assignment Pizza Manager Final Project
 * Class: Square
 * Objective: Inherit from Shape superclass to help make a square Pizza.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Square extends Shape implements Cloneable
{
    private static double sideLength;  //Instance variable to track the side length of the square

    /**
     * "Square" Constructor
     *  Default constructor.
     */
    public Square(){  //No arguments
    }

    /**
     * "Square" Constructor
     *  This constructor initializes the Shape instance variables.
     */       
    public Square(int x, int y){  //Integer parameters
        super(x,y);  //Use super constructor to initialize instance variables
    }

    /**
     * "Square" Constructor
     *  This constructor initializes all the instance variables.
     */           
    public Square(int x, int y, double sideLength){
        super(x,y);  //Use super constructor to initialize instance variables
        setSideLength(sideLength);  //Initialize sideLength
    }

    /**
     * "Square" Constructor
     *  This constructor copies the argument Square.
     */    
    public Square(Square other){  //Square parameter
        this(other.getX(), other.getY(), other.getSideLength());   //Calls above constructor
    }

    /**
     * Method "setSideLength"
     * This methods sets instance variable sideLength.
     */    
    public void setSideLength(double sideLength){ //Returns nothing, takes double as parameter
        this.sideLength=sideLength;  //Set instance variable equal to the argument
    }    

    /**
     * Method "getSideLength"
     * This method returns instance variable sideLength.
     */       
    public double getSideLength(){  //Returns double
        return sideLength;  //Return instance variable
    }

    /**
     * Method "equals"
     * This method tests for equality.
     */    
    public boolean equals(Square that){  //Returns boolean, takes Sqaure as parameter
        return this.getX()==that.getX()&&this.getY()==that.getY()&&this.getSideLength()==that.getSideLength();  //Returns true if conditions met
    }
    
    /**
     * Method "toString"
     * This method returns a String representation of a Square.
     */    
    public String toString(){  //Returns String
        return "Square";  //Returns name of Object
    }    
    
    /**
     * Method "getArea"
     * This method returns the area of a square Pizza.
     */      
    @Override
    public double getArea(){  //Returns double
        return getSideLength()*getSideLength();  //Area is side length*sidelength
    }    
    
    /**
     * Method "clone"
     * This met returns the clone of a Square.
     */
    @Override
    public Object clone(){  //Returns Object
        return new Square(this);  //Return a new clone of the Square
    }    
}
