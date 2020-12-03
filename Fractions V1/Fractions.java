//Imports
import java.util.*;
import java.io.*;

/**
Class: CSS 161 A
Assignment: Fractions V1
Objective: Build a program that counts fractions from a text file, using:
-A main driver
-Functions
-Loops, if statements, and comments
Author: Chandler Ford
Last Modified Date: 3/31/2016
 */
public class Fractions
{
    /**
    Questions
       1. You can not complete this without using arrays as far as I know. I'm going to guess you
          can cut the number of variables down to three: one array to hold the values, one array to hold
          true/false for duplicates, and one counter variable. You'd have to do a lot of switching though.
       2. Possibly, a String[] array could take in all the values and split them somehow. Maybe a boolean
          method would replace the array?
       3. An example of nesting data types is found in the splitFractionArray method. A String[] array
          gets broken down into two int[] arrays.
       4. For even numbers, you could set it to keep dividing by two until the number becomes odd.
    */
    
    //I declared most of the variables as global static because you can avoid using parameters that way
    private static int[] numeratorArray;  //This array will take in all the numerator ints
    private static int[] denominatorArray;  //This array will take in all the denominator ints
    private static String[] fractionArray;  //This array will take in everything from fractions.txt
    private static String[] splitArray;  //This array will assist in seperating numerators from denominators
    private static boolean[] hasDuplicate;  //This array will return true if a fraction is duplicated
    private static int numerator;  //This int will help in comparing fractions
    private static int denominator;  //This int will help in comparing fractions
    private static int numDuplicates;  //This int will record the numbers of different fractions
    
    //This is the main method
    //It acts as a driver for the program by running other methods
    public static void main(String[] args) throws IOException{
        //I needed to count the number of lines in the file 
        //first so I could make the other arrays the same size
        countLines();  //Runs countLines method
        
        //I initialized the size of the arrays once I got the 
        //number of lines in the file
        fractionArray=new String[countLines()];  //Initializes fractionArray
        splitArray=new String[countLines()];  //Initializes splitArray
        numeratorArray=new int[countLines()];  //Initializes numeratorArray
        denominatorArray=new int[countLines()];  //Initializes denominatorArray
        hasDuplicate=new boolean[countLines()];  //Initializes hasDuplicate
        
        //These three methods run the rest of the program
        setArray();  //Runs setArray method
        splitFractionArray();  //Runs splitFractionArray method
        getDuplicates();  //Runs getDuplicates method
    }
    
    //This method counts the lines in the file
    //It does this with a scanner, a counter variable, and a while loop
    public static int countLines() throws IOException{  //Returns an int
        int count=0;  //Declare and initialize counter variable
        Scanner fileInput=null;  //Declare new scanner
        try{  //Use try/catch block to initialize scanner
            fileInput=new Scanner(new File("fractions.txt"));  //Scanner reads from fractions.txt
        } catch (FileNotFoundException e){  //If the file can't be found
            System.out.println("The file can not be found.");  //Prompt user
            System.exit(0);  //Exit system
        }
        
        while(fileInput.hasNextLine()){  //While the file has lines
            fileInput.nextLine();  //Go through the lines
            count++;  //Adding to the counter variable each line
        }
        return count;  //Return the count variable, which gives the number of liens in the file
    }
    
    //This method will initialize the fractions String array by taking input from the file
    //It does this with a scanner and a for-loop
    public static void setArray() throws IOException{  //Returns nothing
        Scanner fileInput2=null;  //Declare a new scanner (it messed up when I tried to use the same one)
        try{  //Use try/catch block to initialize scanner
            fileInput2=new Scanner(new File("fractions.txt"));  //Scanner reads from fractions.txt
        } catch (FileNotFoundException e){  //If the file can't be found
            System.out.println("The file can not be found.");  //Prompt user
            System.exit(0);  //Exit system
        }
        
        for(int i=0; i<fractionArray.length; i++){  //While i is less than the lenght of fractionArray
            fractionArray[i]=fileInput2.nextLine();  //The array's values equal the file's input
        }
    }

    //This method splits the fractionArray into two arrays
    //It does this with a for-loop and the String split function (the link for "split" didn't work in the directions, so I hope this is it :) )
    public static void splitFractionArray(){  //Returns nothing
        for(int i=0; i<fractionArray.length; i++){  //While i is less than the lenght of fractionArray
            splitArray=fractionArray[i].split("/");  //The String[] split Array will use "/" to split fractionArray 
            numeratorArray[i]=Integer.parseInt(splitArray[0]);  //Parses numerator, which is the integer at 0 (before "/")
            denominatorArray[i]=Integer.parseInt(splitArray[1]);  //Parses denominator, which is the integer at 1 (after "/")
        }
    }
    
    //This method compares fractions and prints out the number of duplicates
    //It does this by using a loop within a loop, and multiple if-statements
    public static void getDuplicates(){  //Returns nothing
        for(int i=0; i<fractionArray.length; i++){  //While i is less than the lenght of fractionArray
            numerator=numeratorArray[i];  //Will run through every numerator and set it as an int for the other loop
            denominator=denominatorArray[i];  //Will run through every denominator and set it as an int for the other loop
            for(int j=0; j<fractionArray.length; j++){  //While j is less than the lenght of fractionArray
                if(hasDuplicate[j]==false){  //If hasDuplicate is false
                    if(denominator==denominatorArray[j]&&numerator==numeratorArray[j]){  //If fractions equal each other
                        numDuplicates++;  //Add to the counter variable    
                        hasDuplicate[j]=true;  //Has hasDuplicate becomes true in that instance
                    }
                }
            }
            if(numDuplicates>0){  //If there are instances of a fraction
                System.out.println(numerator+"/"+denominator+" has a count of "+numDuplicates);  //Print out the fraction and the number of them
            } 
            numDuplicates=0;  //Prevents program from just counting up to the number of lines in the file
        }
    }
}
