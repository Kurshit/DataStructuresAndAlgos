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
 * Solution Idea: Read source url0 to see algo
 */

public class SpiralForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = 
			  { {1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10,11,12},
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


	public static void spiralForm(int[][] arr, int R, int C) {
				
		int top = 0, down = R - 1;

		int left = 0, right = C - 1;
		
		int dir = 0;
		
		/*
		 * top - starting row index
		 * down - ending row index
		 * left - starting column index
		 * right - ending column index
		 */

		while (top <= down && left <= right) {
			//Left to right
			if(dir == 0) {
				for (int i = left; i <= right; i++) {
					System.out.print(arr[top][i] + " ");
					
				}
				top++;
			} else if(dir == 1) {
				for(int i = top; i <= down; i++) {
					System.out.println(arr[i][right]);
					
				}
				right--;
			} else if(dir == 2) {
				for(int i = right; i >= left; i-- ) {
					System.out.println(arr[down][i]);					
				}
				down--;
			} else if(dir == 3) {
				for(int i = down; i >= top; i--) {
					System.out.println(arr[i][left]);
				}
				left++;
			}
			
		 
			dir = (dir+1) % 4;			
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
