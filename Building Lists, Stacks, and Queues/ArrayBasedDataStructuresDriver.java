/**
 * Course: CSS 162 A
 * Assignment: Building Lists, Stacks, and Queues with Arrays
 * Class: Driver
 * Objective: Test the other classes with this class.
 * Author: Chandler Ford
 * Last Modified Date: 4/26/2016
 */

public class ArrayBasedDataStructuresDriver {
    public static void main(String[] args) {
        System.out.println("STACKS");  //Text
        stackTests();  //Run method
        System.out.println();  //Space
        System.out.println("QUEUES");  //Text
        queueTests();  //Run method
        System.out.println();  //Space
        System.out.println("ARRAYLISTS");  //Text
        arrayListTests();  //Run method
    }

    private static void arrayListTests() {
        //Object a
        System.out.println("*Object a*");  //Text
        ArrayList a = new ArrayList();  //Create new object   
        a.add('B', 0);  //Method "add"
        a.add('a',0);  //Method "add"
        a.add('t',1);  //Method "add"   
        System.out.println(a.toString());  //Text      
        while(a.isEmpty() == false) { //While method returns false
            System.out.println(a.remove(0));  //Remove value at index zero
        }
        System.out.println("Object empty: "+a.isEmpty());  //Text and method
        System.out.println("Object size: "+a.size());  //Text and method
        
        //Object b
        System.out.println("*Object b*");  //Text
        ArrayList b = new ArrayList(4);  //Create new object 
        b.add('C',2);  //Method "add"
        b.add('a',1);  //Method "add"
        b.add('t',0);  //Method "add"
        b.add('t',3);  //Method "add"
        System.out.println(b.toString());  //Text
        System.out.println("Objects equal: "+b.equals(a));  //Text and method
        System.out.println("Index of 'C': "+b.indexOf('C'));  //Text and method     
    }
        
    private static void queueTests() {
        //Object a
        System.out.println("*Object a*");  //Text
        Queue a = new Queue();  //Create new object
        a.enqueue('B');  //Method "enqueue"
        a.enqueue('a');  //Method "enqueue"
        a.enqueue('t');  //Method "enqueue"   
        System.out.println(a.toString());  //Text
        while(a.isEmpty() == false) {  //While method returns false
            System.out.println(a.dequeue());  //Print value
        }
        System.out.println("Objects empty: "+a.isEmpty());  //Text and method
        System.out.println("Object size: "+a.size());  //Text and method  
        
        //Object b        
        System.out.println("*Object b*");  //Text      
        Queue b = new Queue();  //Create new object    
        b.enqueue('t');  //Method "enqueue"
        b.enqueue('a');  //Method "enqueue"
        b.enqueue('C');  //Method "enqueue"
        b.dequeue();  //Method "dequeue"        
        System.out.println(b.toString());  //Text
        System.out.println("Objects equal: "+b.equals(a));  //Text and method
        System.out.println("Object empty: "+b.isEmpty());  //Text and method
        System.out.println("Object size: "+b.size());  //Text and method
    }

    private static void stackTests() {
        //Object a        
        System.out.println("*Object a*");  //Text
        Stack a = new Stack();  //Create new object    
        a.push('B');  //Method "push"
        a.push('a');  //Method "push"
        a.push('t');  //Method "push"    
		System.out.println(a.toString());  //Text		
		while(a.isEmpty() == false) {  //While method returns false
			System.out.println(a.pop());  //Print value
		}
		System.out.println("Objects empty: "+a.isEmpty());
        System.out.println("Object size: "+a.size());
		
        //Object b        
		System.out.println("*Object b*");  //Text
		Stack b = new Stack();  //Create new object
        b.push('S');  //Method "push"
        b.push('o');  //Method "push"
        b.push('s');  //Method "push"
		System.out.println(b.toString());  //Text
		b.pop();  //Method "pop"
		System.out.println("Run pop: "+b.toString());  //Text after method run
		System.out.println("Objects equal: "+b.equals(a));  //Text and method
        System.out.println("Object empty: "+b.isEmpty());  //Text and method
        System.out.println("Object size: "+b.size());  //Text and method
    }
}
