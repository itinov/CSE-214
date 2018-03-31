package Homework3.Part1;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 3
 */

import java.util.Scanner;

/* Main Class */
public class BTtoBST {
	
	/* BinaryTree Class */
	public static class BinaryTree {
		// variables
		private int[] list;
		private int size;
		private int prevPos;

		/* BinaryTree Constructor to set a custom size for the array */
		public BinaryTree(int size) {
			list = new int[size]; // creates custom capacity
			this.size = size; // sets size
			prevPos = 0; // sets previous position to 0
		}

		/* add method that adds an item to the binary tree */
		public void add(int item) {
			if (prevPos >= size)
				throw new IllegalStateException(); // throw this exception for when the capacity limit is reached
			list[prevPos] = item;
			prevPos++;
		}

		/* inOrder Method */
		public String inOrder() {
			return inOrderHelper(0);
		}

		/* helper method for inOrder() */
		public String inOrderHelper(int position) {
			String str = ""; // string holder
			if (prevPos == 0)
				return str;

			int leftSide = position * 2 + 1; // left
			int rightSide = position * 2 + 2; // right

			if (leftSide < prevPos) {
				str += inOrderHelper(leftSide); // recursive call
			}
			str += list[position] + " ";
			if (rightSide < prevPos) {
				str += inOrderHelper(rightSide);
			}
			return str;
		}
	}

	/* Main Method */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of nodes, N: ");
		int nodes = Integer.parseInt(input.nextLine()); // represents number of nodes
		System.out.println("Enter the value of each node: ");
		String[] strNode = input.nextLine().split(" "); // array of node values as strings split by a space
		
		BinaryTree tree = new BinaryTree(nodes); // create a binary tree object with set number of nodes
		
		// for-each loop below that adds items to the tree
		for (String s : strNode) {
			tree.add(Integer.parseInt(s));
		}
		
		String[] str = tree.inOrder().split(" "); // inorder tree traversal of the items
		int[] BST_list = new int[nodes]; // create an array to store the integer values for after the string[] is converted to int[]
		for (int i = 0; i < nodes; i++) {
			BST_list[i] = Integer.parseInt(str[i]); // using Integer.parseInt() method to convert from String to Int
		}

		/* Selection Sort implementation for the Binary Search Tree traversal: O(n^2), since 2 for-loops */
		int counter = 0; // set counter 
		for (int i = 0; i < nodes; i++) { // first for-loop
			int currentMin = BST_list[i]; // set-current minimum variable
			int currentMinIndex = i;      // index for current minmum
			for (int j = i + 1; j < BST_list.length; j++) { // second for-loop
				if (currentMin > BST_list[j]) { // swap values if currentMin is greater than BST_list traversal 
					currentMinIndex = j;
					currentMin = BST_list[j];
				}
			}
			if (currentMinIndex != i) { // swap if currentMinIndex doesnt match the desired value as traversing the list
				BST_list[currentMinIndex] = BST_list[i];
				BST_list[i] = currentMin;
				counter++; // increment counter, this is what gives us the answer
			}
		}
		// Printing the final answer as the counter
		System.out.println("Minimum Number of Swaps from BT to BST: " + counter);
	}
}