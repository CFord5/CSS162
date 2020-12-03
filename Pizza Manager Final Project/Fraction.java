/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Fraction
 * Objective: Build a class to keep track of the amount of pizza remaining.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Fraction implements Comparable
{
    private int numerator;  //Instance variable to keep track of numerator
    private int denominator;  //Instance variable to keep track of denominator

    /**
     * "Fraction" Constructor
     *  This constructor reduecs and initializes the numerator and denominator of the Fraction.
     */
    public Fraction(int num, int denom){  //Two integer parameters
        int gcd=GCD(num,denom);  //Get greatest common denominator
        setNumerator(num);  //Initialize numerator with argument
        setDenominator(denom);  //Initialize denominator with argument
    }

    /**
     * Method GCD
     * This method returns the greatest common denominator, reduceing the Fraction.
     */
    public int GCD(int x, int y) {  //Returns integer, two integer parameters
        if (y==0) return x;  //If denominator equals 0, return numerator
        return GCD(y,x%y);  //Return the method, with the numerator being modualted by the denominator
    }    

    /**
     * Method "setNumerator"
     * This method sets the numerator.
     */
    public void setNumerator(int num){  //Returns nothing, takes integer as parameter
        numerator=num;  //Set instance variable equal to the argument
    }

    /**
     * Method "getNumerator"
     * This method returns the instance variable.
     */
    public int getNumerator(){  //Returns integer
        return numerator;  //Returns instance variable
    }

    /**
     * Method "setDenominator"
     * This method sets the denominator.
     */
    public void setDenominator(int denom){  //Returns nothing, takes integer as parameter
        denominator=denom;  //Set instance variable equal to the argument
    }

    /**
     * Method "getDenominator"
     * This method returns the instance variable
     */    
    public int getDenominator(){  //Returns integer
        return denominator;  //Returns instance variable
    }
   
    /**
     * Method "getValue"
     * This method returns the value of the Fraction.
     */
    public double getValue(){  //Returns double
        return (this.getNumerator())/(this.getDenominator());  //Divide the numerator by the denominator
    }    

    /**
     * Method "toString"
     * Returns the Fraction is String form.
     */
    public String toString(){  //Returns String object
        return getNumerator()+"/"+getDenominator();  //Return in n/d form
    }

    /**
     * Method "equals"
     * This method tests for equality.
     */    
    public boolean equals(Object other){  //Returns true or false, takes Object as parameter   
        boolean result=false;  //Create new boolean
        if((other instanceof Fraction)){  //If argument is of the same class 
            Fraction that=(Fraction) other;  //Set Fraction object equal to casted Object
            result=(this.getNumerator()==that.getNumerator()&&this.getDenominator()==that.getDenominator());  //Returns true if equal
        }
        return result;  //Return boolean
    }   

    /**
     * Method "compareTo"
     * This method compares money by subtracting the values.
     */
    @Override
    public int compareTo(Object other){  //Returns integer, takes Object as parameter
        Fraction that=(Fraction) other;  //Set Fraction object equal to casted Object
        return (int)(this.getValue()-that.getValue());  //Return integer
    }
}
