import java.util.Scanner;

/*
 * FindTheSums.java
 * Author:  Matt Morris
 *
 *Takes a 2d array of Integers ( 1-9 ) and a "Sum Number".
 *Returns a new array, similiar to the first, however if the numbers do not consecutively add up to the given Target Sum Number, the number will be replaced with a 0. 
 *Works both vertically and Horizontally, when specified. 
   
 */
public class FindTheSums {
	
	private static Scanner input = new Scanner(System.in); // Scanner for User Input
	private static boolean on = true; // ON/OFF Switch for CMD Reader.
	
	private static int[][] array1 = { 
		 { 3, 2, 1, 1 },
		 { 2, 5, 6, 2 }, 
		 { 1, 2, 9, 8 } 
		};
	private static int[][] array2 = {
		{ 7, 3, 8, 5, 6, 7, 4, 1, 9, 5 }, 
		{ 8, 1, 6, 1, 8, 4, 6, 9, 9, 6 },
		{ 9, 2, 4, 8, 6, 1, 1, 3, 6, 2 }, 
		{ 3, 6, 8, 3, 1, 9, 2, 7, 9, 6 }, 
		{ 5, 7, 7, 6, 3, 5, 6, 4, 2, 1 },
		{ 6, 4, 5, 5, 7, 6, 8, 1, 9, 7 }, 
		{ 8, 4, 5, 4, 3, 7, 1, 2, 1, 8 }, 
		{ 6, 8, 6, 7, 8, 6, 2, 4, 6, 2 },
		{ 7, 8, 6, 8, 3, 8, 2, 2, 8, 5 }, 
		{ 8, 7, 7, 6, 6, 2, 9, 9, 5, 8 } 
		};

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
				int sum = 0; // sets sum and counter ints to 0.
				int counter = 0;

				for (int i = cols; i < a[0].length; i++) { // This is essentially the MATH ENGINE that finds the
															// consecutive numbers that add up to a Sum.
					if (sum < sumToFind) { // if sum is still smaller than the number,
						sum += a[rows][i]; // add the number to sum .
						counter++; // counter increases. (Counter is important as it keeps track how far i've
									// traversed INTO the column.
					}
				}
				if (sum == sumToFind) { // If the sum DOES = the number

					for (int j = 0; j < counter; j++) {
						b[rows][cols + j] = a[rows][cols + j]; // fill in B with the respecting details( the numbers
																// that DO add up to the SUM) at their respective (
																// original ) locations in the new array.

					}
				}

			}
		}
		return b;
	}

	public static int[][] verticalSums(int[][] a, int sumToFind) {
		// This is essentially the exact same thing as HORIZONTALSUMS, however I
		// reversed the order for in which it is traversed, ENGINE is adjusted as so.
		int[][] b = new int[a.length][a[0].length];
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				b[r][c] = 0;
			}
		}

		for (int c = 0; c < a[0].length; c++) { // TRAVERSES THE COLUMNS
			for (int r = 0; r < a.length; r++) { // TRAVERSES THE ROWS
				int sum = 0;
				int counter = 0;

				for (int i = r; i < a.length; i++) { // ENGINE , i is set to rows (r) instead of cols .
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

	public static void cmdReader() {
		System.out.println("Options:  (1)  Display Array1  (2)  Display Array2  (3)  VerticalSums  (4)  HorizontaSums  (5)  Quit");
		System.out.println("Type 1, 2, 3, 4, 5 respectively...");
		int answer = input.nextInt();
		if (answer == 1) {
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println(arrayToString(array1));
		}
		if (answer == 2) {
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println(arrayToString(array2));
		}
		if (answer == 3) {
			runVerticalSums(); 
			
		}
		if (answer == 4) {
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Getting there4");
		}
		if (answer == 5) {
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Program Closing... Have a good day.") ; 
			on = false;
			System.exit(0);
		}
    }

	public static void runVerticalSums(){ 
		System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
		System.out.println("Which array would like to run the verticalSums operation on?\n(1) Array1  (2) Array2" );
		boolean valid = true; 
		int finalrvsAnswer =input.nextInt() ; 
		valid =false ;
			 


		 
	
		if  ( finalrvsAnswer ==1 ) {
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Array1 chosen. What is your target sum?") ; 
			
			int numAnswer= input.nextInt() ; 
			
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Running verticalSums with Array1, Target Number: "+numAnswer + "...") ; 
			System.out.println("Before: \n" + arrayToString(array1)) ; 
			System.out.println("") ; 
			System.out.println("After: \n"+ arrayToString(verticalSums(array1, numAnswer)) )  ; 
			System.out.println("\n \n");
		}
		if (finalrvsAnswer == 2) { 
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Array2 chosen. What is your target sum?") ; 
			
			int numAnswer= input.nextInt() ; 
			
			System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n\n \n \n \n");
			System.out.println("Running verticalSums with Array2, Target Number: "+numAnswer + "...") ; 
			System.out.println("Before: \n" + arrayToString(array2)) ; 
			System.out.println("GAB") ; 
			System.out.println("After: \n"+ arrayToString(verticalSums(array2, numAnswer)) )  ; 
			System.out.println("\n \n");

		}
	}



	public static void main(String args[]) {
		System.out.println("Welcome to FindTheSums, please choose your option:"); 
		
		while (on) { 
			cmdReader(); 
		}
	






	}

}
