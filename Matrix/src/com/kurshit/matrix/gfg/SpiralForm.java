package com.kurshit.matrix.gfg;

/*
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * Solution: Print given matrix in spiral form
 * 
 * Example: 
 * 
 * Input:  
 *      1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
 * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
 * Explanation: The output is matrix in spiral format. 

 * Input: 
 *      1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
 * 
 * Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 * 
 * Explanation :The output is matrix in spiral format.
 * 
 */

/* 
 * Solution Idea: Read source url to see algo
 */

public class SpiralForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { {1, 2, 3, 4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}				
		};

		spiralForm(arr, arr.length, arr[0].length);
		System.out.println();
		spiralFormRecursively(arr, 0, 0, arr.length, arr[0].length);

	}

	/*
	 * Approach 1 : Iteratiev style
	 * 
	 *  TC: O(m * n)
	 */	


	public static void spiralForm(int[][] arr, int m, int n) {
		int i;
		int sr = 0, sc = 0;

		int er = m, ec = n;

		/*
		 * sr - starting row index
		 * er - ending row index
		 * sc - starting column index
		 * ec - ending column index
		 */

		while (sr < er && sc < ec) {
			// Print the first row from the remaining rows
			for (i = sc; i < ec; i++) {
				System.out.print(arr[sr][i] + " ");
			}
			sr++;

			// Print the last column from the remaining
			// columns
			for (i = sr; i < er; i++) {
				System.out.print(arr[i][ec - 1] + " ");
			}
			ec--;

			// Print the last row from the remaining rows */
			if (sr < er) {
				for (i = ec - 1; i >= sc; i--) {
					System.out.print(arr[er - 1][i] + " ");
				}
				er--;
			}

			// Print the first column from the remaining
			// columns */
			if (sc < ec) {
				for (i = er - 1; i >= sr; i--) {
					System.out.print(arr[i][sc] + " ");
				}
				sc++;
			}
		}		
	}

	/*
	 * Approach 2: The above problem can be solved by printing the boundary of the Matrix recursively. 
	 * In each recursive call, we decrease the dimensions of the matrix. The idea of printing the boundary or loops is the same.
	 * 
	 */

	public static void spiralFormRecursively(int[][] arr, int sr, int sc, int er, int ec) {


		if(sr >= er || sc >= ec) {
			return;
		}


		// Print the first row from the remaining rows
		for (int i = sc; i < ec; i++) {
			System.out.print(arr[sr][i] + " ");
		}
		

		// Print the last column from the remaining
		// columns
		for (int i = sr + 1; i < er; ++i) {
			System.out.print(arr[i][ec - 1] + " ");
		}
		

		// Print the last row from the remaining rows */
		if ((er - 1) != sr) {
			for (int i = ec - 2; i >= sc; --i) {
				System.out.print(arr[er - 1][i] + " ");
			}
			
		}

		// Print the first column from the remaining
		// columns */
		if ((ec - 1) != sc) {
			for (int i = er - 2; i > sr; --i) {
				System.out.print(arr[i][sc] + " ");
			}
			
		}
		
		spiralFormRecursively(arr, sr+ 1, sc+ 1, er-1 , ec-1);


	}

}
