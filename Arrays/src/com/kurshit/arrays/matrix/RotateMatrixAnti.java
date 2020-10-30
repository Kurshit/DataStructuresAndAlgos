package com.kurshit.arrays.matrix;


import java.io.*; 

class RotateMatrixAnti 
{ 


	public static void rotateClockwiseUsingTranspose(int N, int[][] matrix) {
		int n = N;

		// transpose matrix
		for (int x = 0; x < n; x++) {
			for (int y = x; y < n; y++) {
				int tmp = matrix[y][x];
				matrix[y][x] = matrix[x][y];
				matrix[x][y] = tmp;
			}
		}
		// reverse each column
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n/2 ; y++) {
				int tmp = matrix[x][y];
				matrix[x][y] = matrix[x][n - 1 - y];
				matrix[x][n - 1 - y] = tmp;
			}
		}
	}
	

	public static void rotateAntiClockwiseUsingTranspose(int N, int[][] matrix) {
		int n = N;

		// transpose matrix
		for (int x = 0; x < n; x++) {
			for (int y = x; y < n; y++) {
				int tmp = matrix[y][x];
				matrix[y][x] = matrix[x][y];
				matrix[x][y] = tmp;
			}
		}
		// reverse each row
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n/2 ; x++) {
				int tmp = matrix[x][y];
				matrix[x][y] = matrix[n - 1 - x][y];
				matrix[n - 1 - x][y] = tmp;
			}
		}
	}

	// An Inplace function to rotate a N x N matrix 
	// by 90 degrees in anti-clockwise direction 
	static void rotateMatrixAntiClockWise(int N, int mat[][]) 
	{ 
		// Consider all squares one by one 
		for (int x = 0; x < N / 2; x++) 
		{ 
			// Consider elements in group of 4 in 
			// current square 
			for (int y = x; y < N-x-1; y++) 
			{ 
				// store current cell in temp variable 
				int temp = mat[x][y]; 

				// move values from right to top 
				mat[x][y] = mat[y][N-1-x]; 

				// move values from bottom to right 
				mat[y][N-1-x] = mat[N-1-x][N-1-y]; 

				// move values from left to bottom 
				mat[N-1-x][N-1-y] = mat[N-1-y][x]; 

				// assign temp to left 
				mat[N-1-y][x] = temp; 
			} 
		} 
	} 

	static void rotateMatrixClockWise(int N, int mat[][]) 
	{ 
		// Consider all squares one by one 
		for (int x = 0; x < N / 2; x++) 
		{ 
			// Consider elements in group of 4 in 
			// current square 
			for (int y = x; y < N-x-1; y++) 
			{ 
				// store current cell in temp variable 
				int temp = mat[x][y]; 

				// move values from right to top 
				mat[x][y] = mat[N-1-y][x]; 

				// move values from bottom to right 
				mat[N-1-y][x] = mat[N-1-x][N-1-y]; 

				// move values from left to bottom 
				mat[N-1-x][N-1-y] = mat[y][N-1-x]; 

				// assign temp to left 
				mat[y][N-1-x] = temp; 
			} 
		} 
	} 



	// Function to print the matrix 
	static void displayMatrix(int N, int mat[][]) 
	{ 
		for (int i = 0; i < N; i++) 
		{ 
			for (int j = 0; j < N; j++) 
				System.out.print(" " + mat[i][j]); 

			System.out.print("\n"); 
		} 
		System.out.print("\n"); 
	} 

	/* Driver program to test above functions */
	public static void main (String[] args) 
	{ 


		int N = 4;

		int mat1[][] = 
			{ 
					{1, 2, 3, 4}, 
					{5, 6, 7, 8}, 
					{9, 10, 11, 12}, 
					{13, 14, 15, 16} 
			}; 

		int mat2[][] = 
			{ 
					{1, 2, 3, 4}, 
					{5, 6, 7, 8}, 
					{9, 10, 11, 12}, 
					{13, 14, 15, 16} 
			};

		int mat3[][] = 
			{ 
					{1, 2, 3, 4}, 
					{5, 6, 7, 8}, 
					{9, 10, 11, 12}, 
					{13, 14, 15, 16} 
			};

		int mat4[][] = 
			{ 
					{1, 2, 3, 4}, 
					{5, 6, 7, 8}, 
					{9, 10, 11, 12}, 
					{13, 14, 15, 16} 
			};

		/*		

		int N = 3;

		int mat[][] = { 
				{1, 2, 3}, 
				{4, 5, 6}, 
				{7, 8, 9} 
		}; 

		int mat2[][] = { 
				{1, 2, 3}, 
				{4, 5, 6}, 
				{7, 8, 9} 
		}; 

		int mat3[][] = { 
				{1, 2, 3}, 
				{4, 5, 6}, 
				{7, 8, 9} 
		};

		 */

		System.out.println("Before Rotation : ");
		displayMatrix(N,mat1); 
		System.out.println();


		rotateMatrixAntiClockWise(N,mat1);
		
		System.out.println("Anti Clock Wise : ");
		displayMatrix(N,mat1);
		System.out.println();

		
		rotateAntiClockwiseUsingTranspose(N,mat2);
		
		System.out.println(" Anti Clock Wise Using Transpose: ");
		displayMatrix(N,mat2);
		System.out.println();

//-----------------------------------------------------------		
		
		rotateMatrixClockWise(N,mat3);
		
		System.out.println("Clock Wise: ");
		displayMatrix(N,mat3);
		System.out.println();

		rotateClockwiseUsingTranspose(N,mat4);

		System.out.println("Clock Wise Using Transpose: ");
		displayMatrix(N,mat4);



	} 
} 
