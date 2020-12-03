/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Ingredient
 * Objective: Build a superclass to help create ingredients for the pizza.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Ingredient implements Comparable
{
    private String description;  //Describes the ingredient
    private Money cost;  //Keeps track of cost of ingredient
    private int calories;  //Keeps track of calories in ingredient

    /**
     * "Ingredient" Constructor
     *  This constructor initializes the instance variables.
     */
    public Ingredient(String description, Money amount, int calories){  //Three parameters
        setDescription(description);  //Initialize description
        setCost(amount);  //Initialize cost
        setCalories(calories);  //Initialize calories
    }
    
    /**
     * Method "setDescription"
     * This method initializes the description.
     */
    public void setDescription(String description){  //String input
        this.description=description;  //Set instance variable equal to the argument
    }

    /**
     * Method "getDescription"
     * This method returns the instance variable description.
     */
    public String getDescription(){  //Returns String
        return description;  //Return instance variable
    }

    /**
     * Method "setCost"
     *This method initializes the instance variable cost.
     */
    public void setCost(Money m){  //Money parameter
        this.cost=m;  //Set instance variable equal to the argument
    }

    /**
     * Method "getCost"
     * This method returns the instance variable cost.
     */
    public Money getCost(){  //Returns Money object
        return cost;  //Return instance variable
    }

    /**
     * Method "setCalories"
     * This method initializes the instance variable calories.
     */
    public void setCalories(int c){  //Integer parameter
        this.calories=c;  //Set instance variable equal to the argument
    }

    /**
     * Method "getCalories"
     * This method returns the instance variable calories.
     */
    public int getCalories(){  //Reurns integer
        return calories;  //Return instance variable
    }

    /**
     * Method "toString"
     * This method returns a String with all the Ingredient object's information listed.
     */
    public String toString(){  //Returns String
        //Returns name of ingredient, the cost, total calories, and the description.
        return ("Ingredient "+this.toString()+" has a price: "+this.getCost()+" and calories: "+this.getCalories());     
    }    
    
    /**
     * Method "equals"
     * This method tests for equality.
     */
    public boolean equals(Object other){  //Returns true or false, takes Object as parameter  
        boolean result=false;  //Create new boolean
        if((other instanceof Ingredient)){  //If argument is of the same class 
            Ingredient that=(Ingredient) other;  //Set Vegetable object equal to casted Object
            result=(this.getCost().getValue()==that.getCost().getValue()&&this.getCalories()==that.getCalories()&&this.getDescription()==that.getDescription());  //Returns true if equal
        }
        return result;  //Return boolean
    }    
    
    /**
     * Method "compareTo"
     * This method compares Ingredients by subtracting the costs.
     */
    @Override 
    public int compareTo(Object other){  //Returns integer, takes Object as parameter
        Ingredient that=(Ingredient) other;  //Set Ingredient object equal to casted Object
        return (int)(this.getCost().getValue()-that.getCost().getValue());  //Return integer
    }    
}
