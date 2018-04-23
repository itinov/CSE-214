package Homework3.Part3;

import java.util.Scanner;

/* Main Class Tree */
public class Tree {

	/* Class Node */
	public class Node {
		// variables
		int key;
		Node right;
		Node left;

		/* Node Constructor that accepts an integer "value" as it's paramater */
		public Node(int value) {
			key = value; // key is set to value
			// set left and right sides to null
			right = null;
			left = null;
		}
	}

	Node root; // root variable of the tree

	/* Default Tree Constructor that sets the root value to null */
	public Tree() {
		root = null;
	}

	/* Main Method */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Tree tree = new Tree(); // create a tree object
		System.out.println("Enter the number of operations, Q: ");
		int n = input.nextInt();
		System.out.println("Enter the operations that need to be performed: ");

		// for-loop for the various operations done on the tree
		for (int i = 1; i <= n; i++) {
			int n2 = input.nextInt();
			switch (n2) {
			case 1: // insert value
				int one = input.nextInt();
				tree.insert(one);
				break;
			case 2: // delete value
				int two = input.nextInt();
				tree.delete(two);
				break;
			case 3: // search for a value
				int three = input.nextInt();
				tree.search(three);
				break;
			case 4: // inOrder traversal
				tree.inOrder();
				break;
			case 5: // preOrder traversal
				tree.preOrder();
				break;
			case 6: // postOrder traversal
				tree.postOrder();
				break;
			}
		}
	}

	/* insert method that inserts a node using a helper method */
	public void insert(int item) {
		root = insertHelper(root, item);
	}

	/* insert helper method */
	public Node insertHelper(Node root, int item) {
		if (root == null) { // if root is null
			root = new Node(item); // create a new root node with first item
			return root; 
		}
		if (item < root.key) { // if item is less than the key
			root.left = insertHelper(root.left, item); // insert left
		} else if (item > root.key) { // else item is greater than key
			root.right = insertHelper(root.right, item); // insert right
		}
		return root;
	}
	
	/* search method that searches for a node */
	public void search(int item) {
		int val = searchHelper(root, item); // call search helper
		if (val == 1) { // value set to 1 is successful, that means item has been found
			System.out.print("successful.");
		} else {
			System.out.print("failed.");
		}
	}

	/* helper method for the search method above */
	public int searchHelper(Node root, int item) {
		int n = 0; // default 0
		if (root != null) {
			if (root.key == item) {
				n = 1; // set to 1 as long as key is equal to item
			} else {
				searchHelper(root.left, item); // search left side
				searchHelper(root.right, item); // then search right side
			}
		}
		return n;
	}
	
	/* delete method that deletes a node */
	public void delete(int item) {
		root = deleteHelper(root, item);
	}

	/* delete helper method */
	public Node deleteHelper(Node root, int item) {
		if (root == null) { // if root is null, return null
			return root;
		}
		if (item < root.key) { // if item is less than root, go left
			root.left = deleteHelper(root.left, item);
		} else if (item > root.key) { // else if item is greater than root, go right
			root.right = deleteHelper(root.right, item);
		} else { 
			if (root.left == null) { // if left is null, return right side
				return root.right;
			} else if (root.right == null) { // if right is null return left side
				return root.left;
			}
			root.key = findMinimumValue(root.right); // calls method for finding min value
			root.right = deleteHelper(root.right, root.key);
		}
		return root;
	}

	/* preOrder traversal method that calls a helper method */
	public void preOrder() {
		preOrderHelper(root);
	}

	/* preOrder helper method */
	public void preOrderHelper(Node root) {
		if (root != null) {
			System.out.print(root.key + " "); // return key
			preOrderHelper(root.left); // call left
			preOrderHelper(root.right); // then call right 
		}
	}
	
	/* inOrder traversal method that calls a helper method */
	public void inOrder() {
		inOrderHelper(root);
	}

	/* inOrder helper method */
	public void inOrderHelper(Node root) {
		if (root != null) {
			inOrderHelper(root.left); // left 
			System.out.print(root.key + " "); // key
			inOrderHelper(root.right); // right
		}
	}
	
	/* postOrder traversal method that calls a helper method */
	public void postOrder() {
		postOrderHelper(root);
	}

	/* postOrder helper method */
	public void postOrderHelper(Node root) {
		if (root != null) {
			preOrderHelper(root.left); // call left
			preOrderHelper(root.right); // call right
			System.out.print(root.key + " "); // return key
		}
	}

	/* search based method that looks for a minimum node value */
	public int findMinimumValue(Node root) {
		int minValue = root.key; // set min value to key
		while (root.left != null) { // while left node isn't null
			minValue = root.left.key; // set min value to left key
			root = root.left; // set root to left node
		}
		return minValue;
	}
}
