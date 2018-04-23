package Homework2.Part3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Main Class */
public class LeakyStack {

	/* Main Method */
	public static void main(String[] args) throws FileNotFoundException {
			/* REMEMBER:
			 * Change the file location above to wherever you place my first part for this homework; the directory for where part 1 is placed!
			 * 
			 */
			Scanner input = new Scanner(new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\Homework2\\Part3\\in3.txt")); // location of text file
			while (input.hasNextLine()) { // while-loop for input control
				int n = Integer.parseInt(input.nextLine().trim()); // obtain number of test cases
			
				for (int i = 0; i < n; i++) { // for-loop runs on n test cases
					int size = Integer.parseInt(input.nextLine().trim()); // define capacity
					Stack<String> s = new Stack<String>(size); // create a new stack with defined capacity
					String[] items = input.nextLine().split(" "); // read items in stack
					for (String str : items) { // add items to stack
						s.push(str); // push items
					} 
					System.out.println("Result: ");
					System.out.println(s); // display stack
				} 
			} 
		}
	
	/* Stack Class that is implemented using a circular array */
	public static class Stack<Leaky> {
		
		// variables
			private Leaky[] list;
			private int back; 
			private int front; 
			private int maxSize;

		/* Constructor */
		public Stack(int maxSize) {
			this.maxSize = maxSize; // set max size
			Leaky[] list = (Leaky[]) new Object[this.maxSize]; // create a leaky list with custom maxSize
			this.list = list;
			this.back = this.front = -1; // set back equal to front which equals -1 (indicates empty)
		}

		/* Adds an element to the front of the stack. If the maxSize is reached, the element at the back is removed to accommodate the new element*/
		public void push(Leaky newList) {
			// Check if maxSize is reached
			if (size() == this.maxSize) { // if size equals maxSize
				this.back = (this.back + 1) % this.maxSize; // set back to back+1 % maxSize
				this.front = (this.front + 1) % this.maxSize; // set front to front+1 % maxSize
			} else {
				if (isEmpty()) // if stack is empty
					this.back += 1; // increment back by 1
				this.front += 1; // else decrement front by 1
			}
			this.list[this.front] = newList; // Add element to the front of the stack
		}
		
		/* pop method that returns the front element of the stack and if stack is empty it returns null */
		public Leaky pop() {
			if (this.front == -1) // if front is equal to -1
				return null; // return null since stack is empty
			else {
				Leaky leaky = this.list[this.front]; // create leaky stack with front most element
				if (this.front == this.back) { 	// Check if front is same as back
					this.front = this.back = -1; // this will be last element, since front = back
				} else {
					if ((this.front - 1) < 0) // if front-1 < 0
						this.front = this.maxSize - 1; // set front to maxSize-1;
					else if(!((this.front - 1) < 0)) // if front-1 !< 0
						this.front -= 1; // decrement front by 1
				}
				return leaky;
			}
		}
		
		/* size method that returns the size of the stack */
		public int size() {
			if (this.front ==  this.back) { // if front and back are equal aka same element
				if (this.front == -1) // if front exists
					return 0; // return 0 (false)
				else
					return 1; // return 1 (true)
			} else if (this.back < this.front) // if back < front
				return ((this.front - this.back) + 1); // (front - back) + 1
			else // if back > front
				return (this.maxSize + (this.front - this.back) + 1); // 
		}
		
		/* isEmpty method to check if stack is empty or not */
		public boolean isEmpty() {
			return (this.front == -1);
		}

		/* toString method that returns a String representation of our stack */
		public String toString() {
			StringBuilder s = new StringBuilder();
			int pointer = this.back;
			s.append(this.list[pointer]); // add to the back most element
			
			while (pointer != this.front) { // if pointer is not at the front
				pointer = (pointer + 1) % this.maxSize; // reset pointer
				s.insert(0, this.list[pointer] + " "); // insert
			}
			return s.toString();
		}
	}
}
