package Homework4.Part2;

import java.util.Scanner;

/* Main Class */
public class FindingTriplets {

	private static int list[]; // static variable for the array list.
	
	/* Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner object input
		System.out.println("Enter values for N and M: "); // print statement for values N and M
		int N = input.nextInt(); // variable for N, the number of integers written on the paper
		int M = input.nextInt(); // variable for M, the mythical constant
		
		list = new int[N]; // array, list, that takes N, the number of integers on the paper
		System.out.println("Enter the values of the array: "); // print statement that asks to input values of the array
		for(int i = 0; i < N; i++) { // for-loop that takes input from scanner and fills in the array with values
			list[i] = input.nextInt();
		}
		input.close(); // close the scanner
		/* Print Statement for the final answer that calls the method, findTriplets */
		System.out.println(findTriplets(list.length, M)); 
	}
	
	/* findTriplets Method that takes an integer num, and integer sum variables as parameters */
	/* O(n^2) time with a single for-loop and a single while-loop */
	public static int findTriplets(int num, int sum) {
		int count = 0; // count variable
		System.out.println("Printing the triplets(count at the end): "); // print statement for declaring triplets
		for(int i = 0; i < num - 2; i++) { // for-loop
			int j = i + 1; // j stays 1 ahead
			int k = num - 1; // k is 1 behind each num
			int x = 1; // set x to 1
			
			while(j <= k) { // while j <= k
				if(j == k) { // increment count by 1 if j is equal to k
					x++;
					if(x >= (num - i - 1)) // if x is greater than or equal to num - i - 1
						break; // end
					k = num - 1;
					j = i + x;
				}
				if(((list[i] + list[j] + list[k]) % sum) == 0) { // all array variables i, j, k must be divisible by the sum
					System.out.println("[" + i + ", " + j + ", " + k + "]"); // statement to print each triplet
					count += 1; // statement to print the total count of the triplets found
				}
				k--; // decrement k
			}
		}
		return count; // return the count
	}
}

