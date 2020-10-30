package com.kurshit.arrays.matrix;

public class FloodFill {
	
	/*
	 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535)
	 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
	 * and a pixel value newColor, "flood fill" the image.
	 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to 
	 * the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to 
	 * those pixels (also with the same color as the starting pixel), and so on. 
	 * Replace the color of all of the aforementioned pixels with the newColor.
	 */
	
	/*
	 * Complexity : O(n) - n is no of pixels in image
	 * Space : O(n) - call stack
	 * 
	 */
	
	public int[][] floodFill(int[][] image, int srcRow, int srcCol, int newColor) {
		
		//if the cordinates already have samee color
		
		if(image[srcRow][srcCol] == newColor) {
			return image;
		}
		
		fill(image, srcRow, srcCol, image[srcRow][srcCol], newColor);
		return image;
	}
	
	//We take the initial srcRow and srcCol, then start finding its 4 neighbours - those have same value - same color,we change it.
	
	public void fill(int[][] image, int r, int c, int currentColor, int newColor) {
		
		if(image[r][c] == currentColor) {
			
			image[r][c] = newColor;
			if(r >= 1) 
				fill(image,r-1,c,currentColor,newColor);
			
			if(c >=1)
				fill(image,r,c-1,currentColor,newColor);
			
			if(r+1 < image.length)
				fill(image,r+1,c,currentColor,newColor);
			
			if(c+1 < image[0].length)
				fill(image,r-1,c+1,currentColor,newColor);				
			
		}
		
	}
	
	public static void main(String[] args) {
		

	}

}
