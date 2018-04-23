package Homework2.Part4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Main Class */
public class JohnVsNightKing {

	/* Main Method */
    public static void main(String[] args) throws FileNotFoundException {
    	
    	/* REMEMBER:
		 * Change the file location above to wherever you place my first part for this homework; the directory for where part 1 is placed!
		 * 
		 */
    	
        Scanner input =  new Scanner(new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\Homework2\\Part4\\in4.txt"));      
        int test = input.nextInt();
        int n; // let n = number of white walkers
        int m; // let m = the number of while walkers to be selected 
        int maxPower; // let maxPower = maximum power
        
        System.out.println("Result: ");
        
        int i = 0;
        while(i < test) {
            n = input.nextInt(); // read input
            m = input.nextInt(); // read input
            Queue<Walker> queue = new Queue<Walker>(); // create a queue of walkers
            for(int j = 0; j < n; j++) { // from j to number of white walkers
                queue.enqueue(new Walker(j, input.nextInt())); // add white walkers to the queue
            }
            System.out.println();
            // calculating the result
            for(int k = 0; k < m; k++) { // from k to the number of white walkers that must be selected
                ArrayList<Walker> list = new ArrayList<>(); // create an arraylist to hold the white walkers
                if(!queue.isEmpty()) {
                    maxPower = 0; // set maxPower = to 0 since queue is empty
                    for (int j = 0; j < m; ++j) {
                        if (!queue.isEmpty()) { // if not empty
                            list.add(queue.peek()); // add to the list the top element of the queue
                            if (list.get(j).power > list.get(maxPower).power) { // if the current power is greater than the max power
                                maxPower = j; // set new max power
                            }
                            queue.dequeue(); // dequeue from queue
                        }
                    }
                    System.out.print(list.get(maxPower).index + " "); // obtain max power
                    
                    for(int j = 0; j < list.size(); j++) {
                        if(j != maxPower) { // if current element doesn't equal the max power
                            if(list.get(j).power > 0) // if current power is greater than 0
                                list.get(j).power--; // decrement the current power
                            queue.enqueue(list.get(j)); // add to list
                        }
                    }
                }
            }
            i++;
        }
        input.close(); // close scanner
    }
}

/* Walker Class to represent a White Walker*/
class Walker {
	
	// variables
    public int index; // index of the walker
    public int power; // power of the walker

    /* Constructor that accepts an index and a power, both integers */
    public Walker(int index, int power) {
        this.index = index;
        this.power = power;
    }
}

/* Queue Class that has a generic <Walker> */
class Queue<Walker> {
	
	// variables
	private Walker[] array; // Walker array to store powers
	private Node first; // pointer at the first
	private Node last; // pointer at the last
	private int size = 0; // size variable

	/* Node Class for the Queue */
	private class Node<Walker> {
		
		// variables
		Walker item; // walker item
		Node<Walker> link; // link to the next item
	}

	/* isEmpty method to check if the queue is empty */
	public boolean isEmpty() {
		return (first == null);
	}

	/* enqueue method based of lecture notes , O(1) */
	public void enqueue(Walker walker) {
		Node<Walker> oldlast = last;
		last = new Node<Walker>();
		last.item = walker;
		last.link = null;
		if (isEmpty())
			first = last;
		else
			oldlast.link = last;
	}

	/* dequeue method based off lecture notes, O(1) */
	public Walker dequeue() {
		Walker item = (Walker) first.item;
		first = first.link;
		if (isEmpty())
			last = null;
		return item; 
	}

	/* peek method to see the top element */
	public Walker peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return (Walker) first.item;
    }
}
