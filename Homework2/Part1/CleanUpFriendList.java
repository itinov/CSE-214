package Homework2.Part1;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Main Class */
public class CleanUpFriendList {
	
	/* Main Method */
	public static void main(String[] args) throws FileNotFoundException {
		
		/* Solution to this part below is based on the Josephus Problem discussed in class */
	
			/* REMEMBER:
			 * Change the file location above to wherever you place my first part for this homework; the directory for where part 1 is placed!
			 * 
			 */
			Scanner input = new Scanner(new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\Homework2\\Part1\\in1.txt")); // location of text file
			int samples; // number of samples
			samples = Integer.parseInt(input.nextLine());
			
			int i = 0;
			while(i < samples) {
				input.nextInt();
				int keepFriends = Integer.parseInt(input.nextLine().trim()); // number of friends to keep												
				String[] name = input.nextLine().split(" ");
				String[] mutualFriends = input.nextLine().split(" ");
				
				Friend[] friend = new Friend[name.length]; // create a friends array of Friends to store the friends
									
				// finding min and max number of mutual friends starting from the first friend
				int minMF = Integer.parseInt(mutualFriends[0]); 												
				int maxMF = Integer.parseInt(mutualFriends[0]);
				
				for (int j = 0; j < name.length; j++) {
					Friend f = new Friend(name[j], Integer.parseInt(mutualFriends[j])); // create Friend f that accepts all the names and all the mutualFriends converted to integers
					if (f.numberOfMF > maxMF) // if current MF > maxMF
						maxMF = f.numberOfMF; // set maxMF to currentMF
					else if (f.numberOfMF < minMF) // if current MF < minMF
						minMF = f.numberOfMF; // set minMF to currentMF
					friend[j] = f; // add friend to array
				}


				Queue<Friend> result = new Queue<Friend>(); // create a Queue with generic Friend to hold the results

				// "bucketize" the friends and calculate which friend is left
				sortByMutualfriend(friend); // sort friends based on # of mutual friends
				int defaultSize = (int) Math.round(((maxMF - minMF) + 1) / (double) keepFriends); // finding the default bucketSize based on  (maxMF - minMF) + 1) / K, where k = friends you want to keep
																		
				for (i = minMF; i < maxMF; i += defaultSize) { // going from minimum # of mutual friends to max # of mutual friends and iterating by the default size stated above.
					int bMin = i; // set the min bucket
					int bMax = i + defaultSize - 1; // set the max bucket
					if (i == minMF + (keepFriends - 1) * defaultSize) // if i = min mutual friends + (K-1) * the default size
						bMax = maxMF; // set max bucket to max # of mutual friends

					Queue<Friend> q = new Queue<Friend>(); // create a new queue, q
					for (Friend f : friend) { // iterating the Friends
						if (f.numberOfMF >= bMin && f.numberOfMF <= bMax) // if number of MF is greater than min bucket but less than max bucket
							q.enqueue(f); // add on to the queue
					}										
					while (q.size() > 1) { // while the size of the queue is greater than 1
						for (int x = 1; x < keepFriends; x++) { 
							q.enqueue(q.dequeue()); 
						}
						q.dequeue(); 
					}
					result.enqueue(q.dequeue()); // adds friend to list
				}
			
				// printing the sorted result as a sorted sequence
				Friend[] sortedSequence = new Friend[result.size()]; // create friend array that has the size of the result queue above
				for (int k = 0; k < sortedSequence.length; k++) {
					sortedSequence[k] = result.dequeue(); // add on to the sortedSequence
				}
				sortByName(sortedSequence); // make sure the sequence is sorted by the name of the various friends
				System.out.println("Result: ");
				print(sortedSequence); // print the sorted result
			}
			i++; // iteration of the while-loop
			input.close(); // close scanner
		}
	
	/* Friend Class Generics implementing Comparable */
	public static class Friend implements Comparable<Friend> {
		private String friendName;
		private int numberOfMF; // num of mutual friend

		/* Friend Class Constructor */
		public Friend(String friendName, int numberOfMF) {
			this.friendName = friendName;
			this.numberOfMF = numberOfMF;
		}
		
		/* toString method */
		public String toString() {
			return friendName;
		}
		
		/* compareTo method since we are using comparators */
		public int compareTo(Friend f) {
			return (numberOfMF - f.numberOfMF);
		}
	}

	/* sortByName method that uses selection sort */
	public static void sortByName(Friend[] list) {
		for(int i = 0; i < list.length; i++) {
			Friend currentMin = list[i];
			int currentMinIndex = i;
			for(int j = i + 1; j < list.length; j++) {
				if(currentMin.friendName.compareTo(list[j].friendName) > 0) {
					currentMinIndex = j;
					currentMin = list[j];
				}
			}
				if(currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
		}
	}
	
	/* sortByMutualFriend method that uses selection sort */
	public static void sortByMutualfriend(Friend[] list) {
		for(int i = 0; i < list.length; i++) {
			Friend currentMin = list[i];
			int currentMinIndex = i;
			for(int j = i + 1; j < list.length; j++) {
				if(currentMin.compareTo(list[j]) > 0) {
					currentMinIndex = j;
					currentMin = list[j];
				}
			}
				if(currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
		}
		}
	/* Print Function */
	public static void print(Friend[] list) {
		String str = ""; // temp string holder
		int i = 0;
		while(i < list.length) {
			str += list[i] + " "; // read every element and add to str
			i++;
		}
		System.out.println(str.substring(0, str.length() - 1)); // print from 0th index to last index-1
	}

	
	}