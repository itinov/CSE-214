package Homework2.Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Main Class */
public class TeamSelection {
	
	/* Main Method */
	public static void main(String[] args) throws FileNotFoundException {
			LinkedList<Player> list = new LinkedList<Player>(); // create linkedlist
			
			/* REMEMBER:
			 * Change the file location above to wherever you place my first part for this homework; the directory for where part 1 is placed!
			 * 
			 */
			
			Scanner input = new Scanner(new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\Homework2\\Part2\\in2.txt"));
			String spacing = ""; // represents spacing between words

			int n = Integer.parseInt(input.nextLine()); // variable to hold the cases
			int j = 0; // j variable for while-loop below
			while(j < n) { // while iteration is less than the number of test cases
				spacing = input.nextLine(); // holds spaces
				String[] w = spacing.split(" "); // splits the words based on space
				for (int k = 0; k < w.length; k++) {
					Player player = new Player(); // create a new player
					player.playerNum = Integer.parseInt(w[k]); // convert player number to integer
					list.add(k, player); // add player to linked list
				}
				spacing = input.nextLine(); // holds spaces
				w = spacing.split(" "); // splits the words based on space
				for (int k = 0; k < w.length; k++) {
					list.getHeight(k).height = Integer.parseInt(w[k]); // convert player height to integer
				}
				j++; // iterate while-loop
			}
			System.out.println("Result: ");
			
			int i = 0; // i variable for while-loop below
			while(i < list.size()) {
				if (i + 1 < list.size()) { // +1 ahead of the while loop iteration
					if (list.getHeight(i).height > list.getHeight(i + 1).height)  // if the height of the element ahead is less than the heigh of the element behind it
						System.out.print(list.getHeight(i).playerNum + " "); // print
				} else {
					System.out.println(list.getHeight(i).playerNum);
				}
				i++; // iterate while-loop
			}
			System.out.println(); // newline
		} 
	
	
	/* Player Generic Class for LinkedList */
	public static class Player {
		// variables
		public int playerNum;
		public int height;
	}

	/* LinkedList Class */
	public static class LinkedList<Player> {
		/* Node Class */
		public class Node<Player> {
			// variables
			private Player height;
			private Node<Player> link;

			/* Default Node Constructor */
			public Node() {
				height = null;
				link = null;
			}

			/* Node Constructor that accepts a height and link variable */
			public Node(Player height, Node<Player> link) {
				this.height = height;
				this.link = link;
			}
		} // end node class

		// variable for head
		public Node<Player> head;

		/* Default Constructor */
		public LinkedList() {
			head = null;
		}

		/* add method of a linkedlist that adds a node to the front of the list */
		public void add(int index, Player player) {
			if (index == 0) {
				// insert at the front
				head = new Node(player, head);
			} else {
				// insert in middle/end; walk to node before the one to insert
				Node current = search(index - 1);
				current.link = new Node(player, current.link);
			}
		}

		/* deleteNode method that deletes a node at the head */
		public boolean deleteNode() {
			if (head != null) {
				head = head.link;
				return true;
			} else
				return false;
		}

		/* size method that returns size of linkedlist */
		public int size() {
			int count = 0;
			Node<Player> position = head;
			while (position != null) {
				count++;
				position = position.link;
			}
			return count;
		}

		/* get method that returns current height of player */
		public Player getHeight(int index) {
			Node<Player> current = (LinkedList<Player>.Node<Player>) search(index);
			return (Player) current.height;
		}

		/* search method to find a specific node at a specified index */
		public Node<Player> search(int index) {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.link;
			}
			return current;
		}
	}
}
