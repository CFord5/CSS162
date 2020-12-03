import java.util.*;  //Import the java utility class to use Scanner and ArrayList
/**
 * Course: CSS 162 A
 * Assignment: Pizza Manager Final Project
 * Class: PizzaManager
 * Objective: Build a program that simulates a pizza vending machine.
 * Author: Chandler Ford
 * Last Modified Date: 6/10/2016
 */
public class PizzaManager {
    ArrayList<Pizza> pizzaList=new ArrayList(101);  //Declare a new ArrayList of Pizza objects
        
    /**
     * Method "start"
     * This method displays the menu, and takes input from a scanner to implement methods.
     */
    public void start() {  //Returns nothing
        char selection='q';  //Declare and initialize new character    
        Scanner foo = new Scanner(System.in);  //Declare and initialize new Scanner object
        
        while(true) {  //While the program is running
            displayAllPizzas();  //Show the information for each Pizza object in the ArrayList
            displayInstructions();  //Show the instructions
            
            String input=foo.nextLine();  //Initialize String with user input
            selection=input.charAt(0);  //Takes the first char, used in below switch statement
            
            switch(selection) {  //Switch statement determined by user input
                case 'A':  //If user enters A
                case 'a':  //If user enters a  
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");  //Print out text
                    addRandomPizza();  //Call method to add a random pizza to the ArrayList
                    break;  //Break statement
                case 'H':  //If user enters H
                case 'h':  //If user enters h  
                    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");  //Print out text
                    for(int i=0; i<100; i++){  //For loop for 100 actions
                        addRandomPizza();  //Add 100 random pizzas
                    }
                    break;  //Break statement                  
                case 'E':  //If user enters E    
                case 'e':  //If user enters e  
                    System.out.println("Eating a fraction of a pizza. How much? (a/b)");  //Print out text
                    eatSomePizza(foo);  //Call method to eat pizza, subtracting from the original whole amount
                    break;  //Break statement
                case 'P':  //If user enters P    
                case 'p':  //If user enters p  
                    System.out.println("QuickSorting pizzas by (P)rice");  //Print out text
                    quickSortByPrice();
                    break;  //Break statement
                case 'S':  //If user enters S    
                case 's':  //If user enters s  
                    System.out.println("QuickSorting pizzas by (S)ize");  //Print out text
                    quickSortBySize();
                    break;  //Break statement
                case 'C':  //If user enters C    
                case 'c':  //If user enters c  
                    System.out.println("QuickSorting pizzas by (C)alories");  //Print out text
                    quickSortByCalories();
                    break;  //Break statement
                case 'B':  //If user enters B
                case 'b':  //If user enters b  
                    System.out.println("(B)inary search over pizzas by calories(int).  QuickSorting first. What calorie count are you looking for?");  //Print out text
                    System.out.println("At index: "+binarySearchByCalories(850));
                    break;  //Break statement
                case 'R':  //If user enters R
                case 'r':  //If user enters r  
                    System.out.println("(R)everse order of Pizzas with a Stack" );  //Print out text
                    reverseWithStack();  //Call method to print out reverse of ArrayList with a Stack
                    break;  //Break statement
                case 'Q': //If user enters Q
                case 'q': //If user enters q   
                    System.out.println("(Q)uitting!" );  //Print out text
                    System.exit(-1);  //Exit the program
                    break;  //Break statement
                default:  //If not an above condition 
                    System.out.println("Unrecognized input - try again");  //Print out text to notify user
                    break;  //Break statement
            }
        }
    }

    /**
     * Method "eatSomePizza"
     * This method subtracts the entered fraction from the original amount of pizza.
     */
    private void eatSomePizza(Scanner keys) {  //Returns nothing, takes Scanner as input
        Scanner key=new Scanner(System.in);  //Declare and initialize new Scanner object
        
        System.out.println("Enter index of pizza to eat:");  //Prompt user for index
        int pizzaIndex=key.nextInt();  //Intialize the variable with user input
        
        System.out.println("Enter numerator:");  //Prompt user for numerator
        int numerator=key.nextInt();  //Initialize the variable with user input
        System.out.println("Enter denominator:");  //Prompt user for numerator
        int denominator=key.nextInt();  //Initialize the variable with user input
        
        Fraction eatFraction=new Fraction(numerator,denominator);  //Create nwe Fraction object using user defined numerator and denominator
        Pizza pizzaObject=pizzaList.get(pizzaIndex);  //Get the Pizza object at the specified index
        
        pizzaObject.eatSomePizza(eatFraction);  //Call the Pizza classes' eatSomePizza method using the new fraction as a argument
        pizzaObject.toString();  //Display it via toString()
    }
    
    /**
     * Method 'addRandomPizza"
     * The method adds a new pizza with some random attributes to the ArrayList.
     */
    private void addRandomPizza() {  //Returns nothing
        pizzaList.add(new Pizza());  //Use the ArrayList add method to add a new Pizza object
    }

    /**
     * Method "displayAllPizzas"
     * This method prints out the ArrayList of Pizza objects.
     */
    private void displayAllPizzas() {  //Returns nothing
        String retVal="";  //Declare new String
        for(int i=0; i<pizzaList.size(); i++){  //While the counting variable is less than the size of the ArrayList
            retVal+=pizzaList.get(i).toString();  //Add the Pizza object at the index to the String
        }
        System.out.println(retVal);  //Print out the String object
    }

    /**
     * Method "quickSortByPrice"
     * This method sorts the pizzas by price.
     */
    private void quickSortByPrice() {  
        int i =0;  //Counter variable
        int first=0+i;  //Increment first
        int last=(pizzaList.size()-1-i);  //Increment last
        while(i>0){  //While counter is more than zero
            if (first<last){  //If variable less than other variable
                i++;  //Increment counter
                int pivot=selectPivotPrice(first,last);  //Declare new integer varible, initialize with method call
                pizzaList.add(i,pizzaList.get(pivot));  //Add pivot point to position in ArrayList
                quickSortByPrice();  //Recursively call method, incrementing variables as it runs again
            }
        }
    }
    
    /**
     * Method "selectPivotPrice"
     * This method selects the pivot for price.
     */    
    public int selectPivotPrice(int first, int last){  //Integer parameters
        int pivot=(int)pizzaList.get(pizzaList.size()-1).getCost().getValue();  //Declare new variable, and set it equal to value of the list at "last"
        int small=first-1;  //Declare new variable, and set it equal to the value of "first" minus 1
        for(int i=first; i<last; i++){  //While i (starting at first) is less than last, increment i
            if((pizzaList.get(i).getCost().getValue())<=pivot){  //If the array at "i" is less than or equal to the pivot point
                small++;  //Increment small value
                swapPrice(i,small);  //Call swap method
            }
        }     
        swapPrice(last,small+1);  //Call swap method again with increment
        return small+1;  //Return variable plus 1
    }    
    
    /**
     * Method "swapPrice"
     * This method swaps elements.
     */    
    public void swapPrice(int idx1, int idx2){  //Integer parameters
        int idx1Value=(int)(pizzaList.get(idx1).getCost().getValue());  //Get value
        int idx2Value=(int)(pizzaList.get(idx2).getCost().getValue());  //Get value
        int temp=idx1Value;  //Declare and initialize new variable temp
        idx1Value=idx2Value; //Set integer variable equal to the other
        idx2Value=temp;  //Set the other equal to new variable
    }       
    
    /**
     * Method "quickSortBySize"
     * This method sorts the pizzas by size.
     */    
    private void quickSortBySize() {
        int i =0;  //Counter variable
        int first=0+i;  //Increment first
        int last=(pizzaList.size()-1-i);  //Increment last
        while(i>0){  //While counter is more than zero
            if (first<last){  //If variable less than other variable
                i++;  //Increment counter
                int pivot=selectPivotSize(first,last);  //Declare new integer varible, initialize with method call
                pizzaList.add(i,pizzaList.get(pivot));  //Add pivot point to position in ArrayList
                quickSortBySize();  //Recursively call method, incrementing variables as it runs again
            }
        }
    }
    
    /**
     * Method "selectPivotSize"
     * This method selects the pivot for size.
     */    
    public int selectPivotSize(int first, int last){  //Integer parameters
        int pivot=(int)pizzaList.get(pizzaList.size()-1).getFraction().getValue();  //Declare new variable, and set it equal to value of the list at "last"
        int small=first-1;  //Declare new variable, and set it equal to the value of "first" minus 1
        for(int i=first; i<last; i++){  //While i (starting at first) is less than last, increment i
            if((pizzaList.get(i).getFraction().getValue())<=pivot){  //If the array at "i" is less than or equal to the pivot point
                small++;  //Increment small value
                swapPrice(i,small);  //Call swap method
            }
        }     
        swapPrice(last,small+1);  //Call swap method again with increment
        return small+1;  //Return variable plus 1
    }    
    
    /**
     * Method "swapSize"
     * This method swaps elements.
     */    
    public void swapSize(int idx1, int idx2){  //Integer parameters
        int idx1Value=(int)(pizzaList.get(idx1).getFraction().getValue());  //Get value
        int idx2Value=(int)(pizzaList.get(idx2).getFraction().getValue());  //Get value
        int temp=idx1Value;  //Declare and initialize new variable temp
        idx1Value=idx2Value; //Set integer variable equal to the other
        idx2Value=temp;  //Set the other equal to new variable
    }     
     
    /**
     * Method "quickSortByCalories"
     * This method sorts the pizzas by calories.
     */    
    private void quickSortByCalories() {
        int i =0;  //Counter variable
        int first=0+i;  //Increment first
        int last=(pizzaList.size()-1-i);  //Increment last
        while(i>0){  //While counter is more than zero
            if (first<last){  //If variable less than other variable
                i++;  //Increment counter
                int pivot=selectPivotCalories(first,last);  //Declare new integer varible, initialize with method call
                pizzaList.add(i,pizzaList.get(pivot));  //Add pivot point to position in ArrayList
                quickSortByCalories();  //Recursively call method, incrementing variables as it runs again
            }
        }
    }
    
    /**
     * Method "selectPivotCalories"
     * This method selects the pivot for price.
     */    
    public int selectPivotCalories(int first, int last){  //Integer parameters
        int pivot=(int)pizzaList.get(pizzaList.size()-1).getCalories();  //Declare new variable, and set it equal to value of the list at "last"
        int small=first-1;  //Declare new variable, and set it equal to the value of "first" minus 1
        for(int i=first; i<last; i++){  //While i (starting at first) is less than last, increment i
            if((pizzaList.get(i).getCalories())<=pivot){  //If the array at "i" is less than or equal to the pivot point
                small++;  //Increment small value
                swapPrice(i,small);  //Call swap method
            }
        }     
        swapPrice(last,small+1);  //Call swap method again with increment
        return small+1;  //Return variable plus 1
    }    
    
    /**
     * Method "swapCalories"
     * This method swaps elements.
     */    
    public void swapCalories(int idx1, int idx2){  //Integer parameters
        int idx1Value=(int)(pizzaList.get(idx1).getCalories());  //Get value
        int idx2Value=(int)(pizzaList.get(idx2).getCalories());  //Get value
        int temp=idx1Value;  //Declare and initialize new variable temp
        idx1Value=idx2Value; //Set integer variable equal to the other
        idx2Value=temp;  //Set the other equal to new variable
    }       
     
    /**
     * Method "binarySearchByCalories"
     * This method returns the index of the calorie parameter.
     */
    private int binarySearchByCalories(int cals) {  //Returns int, takes int as parameter
        int low=0;  //Declare and initialize starting index of search
        int high=pizzaList.size();  //Declare and initialize last index of search
        for(int i=low; i<high; i++){  //While in index
            int mid=(low+high)/2;  //The middle is half the size
            if(pizzaList.get(mid).getCalories()==cals)return mid;  //If the middle index has the value, return index
            else if(pizzaList.get(mid).getCalories()<cals)low=mid+1;  //Search the upper half of the ArrayList if value at index lower than target calories
            else low=mid-1;  //Else search the lower half of the ArrayList
        }        
        return -1;  //If nothing found return -1
    }  
    
    /**
     * Method "reverseWithStack"
     * This method prints out the reverse of the ArrayList with the help of a Stack.
     */
    private void reverseWithStack(){ //Returns nothing
        Stack<Pizza> pizzaStack=new Stack();  //Create a new Stack that takes Pizza objects
        for(int i=pizzaList.size()-1; i>0; i--){  //Starting at the end of the list, walk backwards
            pizzaStack.push(pizzaList.get(i));  //Add the Pizza object at the index to the Stack
        }
        System.out.println(pizzaStack.toString());  //Print out Stack
    }
    
    /*
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    
    //This String object contains the instructions
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(R)everse order of pizzas with a stack\n(Q)uit\n";
    
    /**
     * Method "displayInstructions"
     * This method prints out the instructions.
     */  
    private void displayInstructions() {  //Returns nothing
        System.out.println(instructions);  //Print text   
    }
    
    /**
     * Method "main"
     * Notice the one-line main function.
     */
    public static void main(String[] args) {  //Returns nothing, String array as input
        new PizzaManager().start();  //Create new PizzaManager object and call method start
    }
}
