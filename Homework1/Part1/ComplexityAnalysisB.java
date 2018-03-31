package Homework1.Part1;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* ComplexityAnalysisB for part 1b */
public class ComplexityAnalysisB {
	
	/* Main Method */
	public static void main(String[] args) {
		int[] list = { 11, 15, 6, 8, 9, 10 }; // create array values with the ones stated in the homework
		
		// printing input
		System.out.print("Input: { ");
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ", ");
		}
		System.out.println("}");
		System.out.println();
		
		int sum = 25; // look for sum as stated in homework 
		tripletOfSum(list, sum); // tripletOfSum method is called

	}

	/* boolean tripletOfSum method that accepts int[] list and int sum parameters to return what three values make up the desired sum */
	public static boolean tripletOfSum(int[] list, int sum) {								// Worst Case:
		for (int i = 0; i < list.length; i++) {												// n
			for (int j = i + 1; j < list.length; j++) {										// n + 1
				for (int k = j + 1; k < list.length; k++) {									// n + 1
					if (list[i] + list[j] + list[k] == sum) {								// 1
						System.out.println("Output: " + list[i] + " + " + list[j] 			// 1 (if true)
							+ " + " + list[k] + " = " + sum + ", true");
						return true;														// 1 (if true)
					}
				}
			}
		}																					
		System.out.println("Output: false.");												// 1 (if false)
		return false;																		// 1 (if false)
	}

		// Worst Case:      
		// Total time, T(n) = n * (n + 1) * (n + 1 + 1 + 1 + 1)    			   		    (if true)
		//  		   T(n) = n * (n + 1) * (n + 1 + 1) + 1 + 1	               		    (if false)
	
		// T(n) = n * (n + 1) * (n + 4) = n * (n^2 + 5n + 4) = n^3 + 5n^2 + 4n 		    (if true)
		// T(n) = n * (n + 1) * (n + 2) + 2 = n * (n^2 + 3n + 2) + 2 = n^3 + 3n^2 + 4   (if false)
	
		// Big O-notations Time Complexity: O(n^3)

}




