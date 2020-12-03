/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Money
 * Objective: Build a class to keep track of the cost of a pizza.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Money implements Comparable
{
    private double value;  //Instance variable to track value of money

    /**
     * "Money" Constructor
     *  This constructor initializes the value instance variable.
     */
    public Money(double amount){  //Takes double as parameter
        this.value=amount;  //Instance variable equals argument
    }

    /**
     * Method "add"
     * This method adds amounts of money together.
     */
    public void add(Money amount){  //Returns nothings, takes Money object as parameter
        value=value+amount.getValue();  //Increment value
    }   

    /**
     * Method "getValue"
     * This method returns the value of the money.
     */ 
    public double getValue(){  //Returns double, no parameters
        return value;  //Return instance variable
    }
    
    /**
     * Method "toString"
     * This method returns the value in String form.
     */
    public String toString(){  //Returns String object
        return "$"+getValue()+"0";  //Adds a dollar sign and a extra 0 (rounding kept messing up)
    }    
    
    /**
     * Method "equals"
     * This method tests for equality.
     */
    public boolean equals(Object other){  //Returns true or false, takes Object as parameter  
        boolean result=false;  //Create new boolean
        if((other instanceof Money)){  //If argument is of the same class 
            Money that=(Money) other;  //Set Money object equal to casted Object
            result=(this.getValue()==that.getValue());  //Returns true if equal
        }
        return result;  //Return boolean
    }
    
    /**
     * Method "compareTo"
     * This method compares money by subtracting the amounts.
     */
    @Override 
    public int compareTo(Object other){  //Returns integer, takes Object as parameter
        Money that=(Money) other;  //Set Money object equal to casted Object
        return (int)(this.getValue()-that.getValue());  //Return integer
    }
}   

