/*
 * FindTheSums.java
 * Author:  Matt Morris
 * Submission Date:  4/21/2020
 *
 *Takes a 2d array of Integers ( 1-9 ) and a "Sum Number".
 *Returns a new array, similiar to the first, however if the numbers do not consecutively add up to the Sum Number, the number will be replaced with a 0. 
 *Works both vertically and Horizontally, when specified. 
 *
 *
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
public class FindTheSums {

	public static String arrayToString(int[][] a) {
		String str = "";
		int counter = 0; // this keeps track of when add an extra line.

		for (int rows = 0; rows < a.length; rows++) {
			if (counter != 0) { // checks to decide to add a \n to Str.
				str += "\n";
			}
			counter++;
			for (int col = 0; col < a[rows].length; col++) {

				if (col == a[rows].length - 1) { // if we are currently at the last spot of the rows.
					str += a[rows][col]; // DO NOT add an white space after.
				} else {
					str += a[rows][col] + " "; // Otherwise, it's okay.
				}

			}

		}
		return str;
	}

	public static int[][] horizontalSums(int[][] a, int sumToFind) {

		int[][] b = new int[a.length][a[0].length]; // This creates a new Array B, fills it with 0s.
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				b[r][c] = 0;
			}
		}

		for (int rows = 0; rows < a.length; rows++) { // TRAVERSES THE ROWS

			for (int cols = 0; cols < a[0].length; cols++) { // TRAVERSES THE COLUMNS
				int sum = 0;
				int counter = 0;

				for (int i = cols; i < a[0].length; i++) { // Uses cols as a counter of where it is.
					if (sum < sumToFind) { // if sum is still smaller than the number,
						sum += a[rows][i]; // add the number to sum .
						counter++; // counter increases. (Counter is important as it keeps track how far i've
									// traversed INTO the column.
					}
				}
				if (sum == sumToFind) { // If the sum DOES = the number

					for (int j = 0; j < counter; j++) {
						b[rows][cols + j] = a[rows][cols + j]; // fill in B with the respecting details AT the correct
																// spot.

					}
				}

			}
		}
		return b;
	}

	public static int[][] verticalSums(int[][] a, int sumToFind) {
		// This is essentially the exact same thing as HORIZONTALSUMS, but the rows and
		// cols are switched.
		int[][] b = new int[a.length][a[0].length]; // This creates a new Array B, fills it with 0s.
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				b[r][c] = 0;
			}
		}

		for (int c = 0; c < a[0].length; c++) { // TRAVERSES THE COLUMNS
			for (int r = 0; r < a.length; r++) { // TRAVERSES THE ROWS
				int sum = 0;
				int counter = 0;

				for (int i = r; i < a.length; i++) {
					if (sum < sumToFind) {
						sum += a[i][c];
						counter++;
					}
				}
				if (sum == sumToFind) {
					for (int j = 0; j < counter; j++) {
						b[r + j][c] = a[r + j][c];
					}
				}
			}

		}

		return b;

	}

	public static void main(String args[]) {
//For Testing. 

	}

}
