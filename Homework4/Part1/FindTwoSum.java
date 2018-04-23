package Homework4.Part1;

import java.util.Scanner;

/* Main Class */
public class FindTwoSum {
	
	/* Main Method */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // create a scanner object called input
		System.out.println("Enter N and T: ");
		int N = input.nextInt(); // variable for N, the number of elements in the array
		int T = input.nextInt(); // variable for T, the target number
		
		System.out.println("Enter array values: ");
		int[] list = new int[N]; // create a new list with set number of elements, N
		for (int i = 0; i < N; i++) // for-loop to collect input of each element in list from scanner
			list[i] = input.nextInt();
		
		int[] result = findTwoSum(list, T); // assign result the method call to findTwoSum method
		/* Print Statement for the final output */
		System.out.println("[" + result[0] + ", " + result[1] + "]"); 
	}

	/* findTwoSum method that takes a array and a target number */
	public static int[] findTwoSum(int[] list, int T) {
		int i = 0; // assign i to the first element
		int j = list.length - 1; // assign j to the last element.
		int[] result = {-1, -1}; // assign result as null initially
		
		while (i < j) { // while-loop to find pair
			if (list[i] + list[j] == T) { // if target, T, is found
				result[0] = i;
				result[1] = j;
				break;
			}
			else if (list[i] + list[j] < T)
				i++;
			else
				j--;
		}
		return result; // return result.
	}
}
