/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Interface: PizzaComparable
 * Objective: An interface that extends Comparable, and is implemented in Pizza.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public interface PizzaComparable extends Comparable {  //Extends Comparable
    //Method "compareTo"
    //Compares Objects by price, overrides Comparable's compareTo
    @Override  
    public int compareTo(Object o);  //Returns integer, takes Object parameter            
    
    //Method "compareToBySize"
    //Non-override, compares by amount of Pizza left
    public int compareToBySize(Object o);  //Returns integer, takes Object parameter   
    
    //Method "compareToByCalories"
    //Non-override, compares by number of calores   
    public int compareToByCalories(Object o);  //Returns integer, takes Object parameter 
}
