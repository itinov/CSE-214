package Homework3.Part2;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 3
 */

import java.util.NoSuchElementException; 

/* Main Class */
public class PriorityQueue {
	// variables 
	private Heap heap;

	/* Default PriorityQueue Construtor*/
	public PriorityQueue() {
		heap = new Heap();
	}

	/* PriorityQueue Construtor that accepts an integer parameter "maxSize" */
	public PriorityQueue(int maxSize) {
		heap = new Heap(maxSize);
	}
	
	/* enqueue method using heap implementation */
	public void enqueue(int item) {
		heap.insert(item);
	}

	/* dequeue method using heap implementation */
	public int dequeue() {
		return heap.remove();
	}

	/* toString method that calls the Heap class's toString method */
	public String toString() {
		return heap.toString();
	}
	
	/* Heap Helper class that makes up PriorityQueue */
	public class Heap {
		
		// variables
		private int[] list;
		private int size;
		private int maxSize;
		private final static int default_MaxSize = 150;

		/* Default Constructor */
		public Heap() {
			this(default_MaxSize); // default size of 150 is given
		}

		/* Heap Constructor that accepts an integer parameter "maxSize" */
		public Heap(int maxSize) {
			this.maxSize = maxSize;
			size = 0;
			list = new int[maxSize];
		}

		/* insert method used for enqueue in PriorityQueue class */
		public void insert(int item) {
			if (full())
				throw new IllegalStateException();
			list[size] = item; // insert at leaf
			// swap with parent until parent > item or reached root
			int currentPosition = size;
			int parentPosition = (currentPosition - 1) / 2;
			while (currentPosition > 0 && list[currentPosition] > list[parentPosition]) {
				swap(currentPosition, parentPosition);
				currentPosition = parentPosition;
				parentPosition = (currentPosition - 1) / 2;
			}
			size++; // increment size
		}

		/* swap method that swaps the values of 2 items */
		public void swap(int a, int b) {
			list[a] = list[a] ^ list[b];
			list[b] = list[a] ^ list[b];
			list[a] = list[a] ^ list[b];
		}
		
		/* remove method used for dequeue method in PriorityQueue Class */
		public int remove() {
			if (isEmpty()) // check if empty queue
				throw new NoSuchElementException(); // throw exception
			int tempList = list[0]; // signifies the item to be deleted
			size--; // decrement size
			list[0] = list[size]; // swap last node with the root node
			int currentPosition = 0;
			int childPosition = 1;
			while (childPosition < size) {
				if (childPosition + 1 < size && list[childPosition] < list[childPosition + 1]) {
					childPosition++;
				}
				if (list[childPosition] > list[currentPosition]) { // if child node is higher than current node
					swap(childPosition, currentPosition); // swap child node and current node
				}
				currentPosition = childPosition; // set current position to child's position
				childPosition = 2 * currentPosition + 1; // child = 2 * cur + 1
			}
			return tempList;
		}
		
		/* isEmpty Method to check if queue is empty */
		public boolean isEmpty() {
			return size == 0;
		}
		
		/* full method to check if the queue is full */
		public boolean full() {
			return size == maxSize;
		}

		/* returns a String representation of the queue */
		public String toString() {
			String str = " ";
			for (int i = 0; i < size; i++)
				str += list[i] + " ";
			return str + " ";
		}
	}
}