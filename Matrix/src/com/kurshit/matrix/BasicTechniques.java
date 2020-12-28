package com.kurshit.matrix;

public class BasicTechniques {

	public static void main(String[] args) {
			
		int[][] m = {{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9, 10, 11, 12}};
		
		
		//To get number of rows
		
		System.out.println("Number of rows : " + m.length);
		
		//TO get number of columns
		
		System.out.println("Number of columns : " + m[0].length);
		
		//To get entire row - let's say first row
		
		int[] firstRow = m[0];
		System.out.println("First row elements ");
		for(int i : firstRow) {
			System.out.print(i + " ");
		}
		
		
	}

	

}
