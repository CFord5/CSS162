import java.awt.*;  //Import java class Abstract Window Toolkit for color
import java.util.*;  //Import java utility class for ArrayList
/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: Pizza
 * Objective: Build a class to create Pizza objects.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class Pizza implements PizzaComparable
{
    ArrayList<Ingredient> ingredientList=new ArrayList(100);  //List of ingredients
    private int calories;  //Sum of ingredients' calories
    Money money;  //Tracks cost of ingredients
    Shape myShape; //Controls shape and area of pizza
    Fraction fraction; //Keeps track of how much of pizza has been eaten

    /**
     * Method "setRemaining"
     * This method sets the remaining value of the Fraction object.
     */
    public void setRemaining(Fraction f){  //Returns nothing, Fraction object parameter
        this.fraction=f;  //Sets instance variable equal to argument
    }

    /**
     * Method "getFraction"
     * This method returns the Fraction object.
     */
    public Fraction getFraction(){  //Returns Fraction 
        return fraction;  //Return Fraction Object
    }

    /**
     * Method "getCalories"
     * This method returns the instance variable that tracks calories.
     */
    public int getCalories(){  //Returns integer
        return calories;  //Return instance variable
    }

    /**
     * Method "getCost"
     * This method returns the Money object that tracks the cost.
     */
    public Money getCost(){  //Returns Money
        return money;  //Return Money object
    }

    /**
     * Method "getRemainingArea"
     * This method returns the remaining area of the pizza.
     */
    public double getRemainingArea(){  //Returns double
        return (myShape.getArea())*(this.getFraction().getValue());  //Return the area of shape incremented by the current amount of pizza left
    }

    /**
     * Method "setShape"
     * This method sets the shape of the pizza.
     */
    public void setShape(Shape s){  //Returns nothing, takes Shape as parameter
        myShape=(Shape) s.clone();  //myShape object is equal to a clone of the argument
    }

    /**
     * Method "getShape"
     * This method returns the shape of the pizza.
     */
    public Shape getShape(){  //Returns Shape
        return (Shape) myShape.clone();  //Return clone of myShape
    }

    /**
     * Method "addIngredient"
     * This method adds ingredient and corresponding information to the ArrayList.
     */
    public void addIngredient(Ingredient a){
        //Add to list
        ingredientList.add(a);  //Add ingredient to ArrayList
        //Adjust calories and cost
        calories=calories+a.getCalories();  //Increment calories accordingly
        money.add(a.getCost());  //Get the Money amount of the ingredient and add it to the total cost of the pizza.
    }

    /**
     * Method "eatSomePizza"
     * This method subtracts from the total amount of pizza.
     */
    public void eatSomePizza(Fraction amt){
        //amt numerator and denominator
        int amtNum=amt.getNumerator();  //Get amt numerator
        int amtDenom=amt.getDenominator();  //Get amt denominator

        //fraction numerator and denominator
        int fractionNum=fraction.getNumerator();  //Get fraction numerator
        int fractionDenom=fraction.getDenominator();  //Get fraction denominator

        //Multiply to make new common denominator
        int newLargeDenom=amtDenom*fractionDenom;  //Multiply denominators together

        //Multiply the numerators accordingly
        int newAmtNum=amtNum*fractionDenom;  //Multiply amt's numerator by the fraction's denominator
        int newFractionNum=fractionNum*amtDenom;  //Multiply fraction's numerator by the amt's denominator

        //Subtract the numerators
        int newSubractedNum=newFractionNum-newAmtNum;  //This is the value of the substracted numerator

        //Throw exceptions if conditions are flawed
        if(newSubractedNum==0||newLargeDenom==0)throw new PizzaException("Fraction has a zero.");  //Throw exception at 0
        if(newSubractedNum<0||newLargeDenom<0)throw new IllegalArgumentException("Can't have a negative pizza.");  //Throw different exception if negative (error)

        //Make this the new fraction
        Fraction newFraction=new Fraction(newSubractedNum,newLargeDenom);  //Create new Fraction object with new post-subtraction value
        setRemaining(newFraction);  //Set the amount of pizza remaining to the new Fraction
    }

    /**
     * Method "toString"
     * This method returns a String with all the Pizza object's information listed.
     */
    public String toString(){  //Returns String
        //Returns list of ingredients, cost of pizza, total calories, the amount remaining, and the area left
        return ("\n"+"Ingredients: "+ingredientList.toString()+"\n"+"Pizza has a price: "+this.getCost()+" and calories: "+this.getCalories()+", Fraction remaining: "+this.getFraction()+" and area left: "+Math.round(this.getRemainingArea())+"\n"+ "and shape: "+this.getShape().toString()+"\n");     
    }

    /**
     * Method "compareTo"
     * This method implements Comparable by subtracting the costs.
     */
    public int compareTo(Object other){  //Returns integer
        Pizza that=(Pizza) other;  //Set Pizza equal to casted Object argument
        return (int)(this.getCost().getValue()-that.getCost().getValue());  //Return int value
    }

    /**
     * Method "compareToBySize"
     * This method implements Comparable by subtracting the values of the amount of pizza remaining.
     */
    public int compareToBySize(Object o){  //Returns integer, takes Object as parameter
        Pizza that=(Pizza) o;  //Set Pizza equal to casted Object argument
        return (int)(this.getFraction().getValue()-that.getFraction().getValue());  //Return the subtracted value
    }

    /**
     * Method "compareToByCalories"
     * This method implements Comparable by subtracting the values of the amount of pizza remaining.
     */
    public int compareToByCalories(Object o){  //Returns integer, takes Object as parameter
        Pizza that=(Pizza) o;  //Set Pizza equal to casted Object argument
        return (int)(this.getCalories()-that.getCalories());  //Return the subtracted value
    }

    public Pizza(){
        //Create and set default Fraction amount (1/1)
        Fraction startPizza=new Fraction(1,1);  //Create new Fraction object
        this.fraction=startPizza;  //Set class variable to the Fraction object
        
        //Create and set default Money amount ($0.0)
        Money startingAmount=new Money(0.0);  //Create new Money object
        this.money=startingAmount;  //Set class variable eqaul to the Money object
           
        //Random Shape
        int random=(int)(Math.random()*4);  //Get a random value between 0 and 4
        switch(random){  //Switch statement, outcome depends on the random variable above
            case 0:  //If the random number is 0
            case 1:  //If the random number is 1
                setShape(new Circle(0,0,5));  //Set the Shape with a new Circle
                break;  //Break statement
            case 2:  //If the random number is 2
            case 3:  //If the random number is 3
            case 4:  //If the random number is 4
                setShape(new Square(0,0,5));  //Set the Shape with a new Square
                break;  //Break statement
            default:  //If something goes wrong
                System.out.println("Error!");  //Notify user
                break;  //Break statement
        }

        //Random ingredients
        int i=0;  //Counter variable
        while(i<3){  //Get three ingredients
            int random2=(int)(Math.random()*7);  //Get a random value between 0 and 7       
            switch(random2){  //Switch statement, outcome depends on the random variable above
                case 0:  //If the random number is 0
                    Money goatCost=new Money(3.00);  //Create new Money object
                    String goatString="Type of cheese made from goat's milk.";  //Description of ingredient
                    Goat goat=new Goat(goatString,goatCost,500);  //Create new Ingredient via constructor
                    goat.setCost(goatCost);  //Set the cost of the ingredient
                    addIngredient(goat);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 1:  //If the random number is 1
                    Money mozzarellaCost=new Money(2.00);  //Create new Money object
                    String mozzarellaString="Type of Italian cheese.";  //Description of ingredient
                    Mozzarella mozzarella=new Mozzarella(mozzarellaString,mozzarellaCost,750);  //Create new Ingredient via constructor
                    mozzarella.setCost(mozzarellaCost);  //Set the cost of the ingredient
                    addIngredient(mozzarella);  //Add the ingredients to the ingredientList, incrementing relevant values in the process 
                     i++;  //Increment counter variable
                    break;  //Break statement
                case 2:  //If the random number is 2
                    Money pepperoniCost=new Money(1.00);  //Create new Money object
                    String pepperoniString="Type of American salami.";  //Description of ingredient
                    Pepperoni pepperoni=new Pepperoni(pepperoniString,pepperoniCost,1000);  //Create new Ingredient via constructor
                    pepperoni.setCost(pepperoniCost);  //Set the cost of the ingredient
                    addIngredient(pepperoni);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 3:  //If the random number is 3
                    Money sausageCost=new Money(2.00);  //Create new Money object
                    String sausageString="Type of ground meat.";  //Description of ingredient
                    Sausage sausage=new Sausage(sausageString,sausageCost,990);  //Create new Ingredient via constructor
                    sausage.setCost(sausageCost);  //Set the cost of the ingredient
                    addIngredient(sausage);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 4:  //If the random number is 4
                    Money marinaraCost=new Money(1.00);  //Create new Money object
                    String marinaraString="Type of Italian tomato sauce.";  //Description of ingredient
                    Sausage marinara=new Sausage(marinaraString,marinaraCost,450);  //Create new Ingredient via constructor
                    marinara.setCost(marinaraCost);  //Set the cost of the ingredient
                    addIngredient(marinara);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 5:  //If the random number is 5
                    Money alfredoCost=new Money(4.00);  //Create new Money object
                    String alfredoString="Type of Italian cheese/butter sauce.";  //Description of ingredient
                    Alfredo alfredo=new Alfredo(alfredoString,alfredoCost,500);  //Create new Ingredient via constructor
                    alfredo.setCost(alfredoCost);  //Set the cost of the ingredient
                    addIngredient(alfredo);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 6:  //If the random number is 6
                    Money pepperCost=new Money(4.00);  //Create new Money object
                    String pepperString="Vine whose fruit is used for spice.";  //Description of ingredient
                    Pepper pepper=new Pepper(pepperString,pepperCost,200,Color.RED);  //Create new Ingredient via constructor
                    pepper.setCost(pepperCost);  //Set the cost of the ingredient
                    addIngredient(pepper);  //Add the ingredients to the ingredientList, incrementing relevant values in the process 
                    i++;  //Increment counter variable
                    break;  //Break statement
                case 7:  //If the random number is 7
                    Money oliveCost=new Money(5.00);  //Create new Money object
                    String oliveString="Fruit from an olive tree.";  //Description of ingredient
                    Olive olive=new Olive(oliveString,oliveCost,100,Color.BLACK);  //Create new Ingredient via constructor            
                    olive.setCost(oliveCost);  //Set the cost of the ingredient
                    addIngredient(olive);  //Add the ingredients to the ingredientList, incrementing relevant values in the process
                    i++;  //Increment counter variable
                    break;  //Break statement 
                default:
                    System.out.println("Error!");  //Notify user
                    System.exit(-1); //Exit the program
                    break;  //Break statement
            }         
        }
    }
}
