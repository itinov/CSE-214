package Homework1.Part1;


/* ComplexityAnalysisA for part 1a */
public class ComplexityAnalysisA {

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
		
		int sum = 16; // look for sum as stated in homework 
		pairOfSum(list, sum); // pairOfSum method is called

	}

	/* boolean pairOfSum method that accepts int[] list and int sum parameters to return what two values make up the desired sum */
	public static boolean pairOfSum(int[] list, int sum) {					 // Worst Case:
		for (int i = 0; i < list.length; i++) { 							 // n
			for (int j = i + 1; j < list.length; j++) {						 // n
				if (list[i] + list[j] == sum) {								 // 1
					System.out.println("Output: " + list[i] + " + " 		 // 1 (if true)
						+ list[j] + " = " + sum + ", true.");
					return true;							 				 // 1 (if true)
				}
			}
		}
		System.out.println("Output: false.");								 // 1 (if false)
		return false;	   									 				 // 1 (if false)
	}
	
	// Worst Case: 
	// Total time, T(n) = n * (n + 1 + 1 + 1)   (if true)
	//   		   T(n) = n * (n + 1) + 1 + 1   (if false)
	// T(n) = n^2 + 3n                          (if true)
	// T(n) = n^2 + n + 2                       (if false)
	// Big O-notations Time Complexity: O(n^2)
	
	
}
