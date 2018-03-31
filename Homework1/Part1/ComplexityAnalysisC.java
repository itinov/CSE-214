package Homework1.Part1;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* NO OUTPUT FOR THIS CLASS, ONLY BIG-O */

/* ComplexityAnalysisB for part 1c */
public class ComplexityAnalysisC {
	
	/* matrixMultiplication method that takes two 2d arrays(a, b) and multiplies them to store them in a 3rd 2d array called c. */
	public static void matrixMultiplication(double[][] a, double[][] b, int n) {

		double[][] c = new double[a.length][b[0].length]; // method to store the data 
		// code starts here									// Worst Case:
		for (int i = 0; i < n; i++) {				        // n
			for (int j = 0; j < n; j++) { 				    // n-1
				double sum = 0; 							// 1

				for (int k = 0; k < n; k++) { 				// n
					sum += a[i][k] * b[k][j]; 				// 1
				}
				c[i][j] = sum; 								// 1
			}
		}
	}
	
	
			// Total time(Worst Case), T(n) = n * (n - 1 + 1) * (n + 1) + 1
			// T(n) = n^2 * (n + 1) + 1 = n^3 + n^2 + 1
			// Big O-notations for Time Complexity: O(n^3)
	
			// Space Complexity = n * n * n (n for double[][] a, n for double[][] b, n for double[][] c to store the matrix multiplication
			// Big O-notations for Space Complexity: O(n^3)
}





