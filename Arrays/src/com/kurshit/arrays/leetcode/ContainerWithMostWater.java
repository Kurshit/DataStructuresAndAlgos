package com.kurshit.arrays.leetcode;

/*
 * 	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the 
 * most water. 
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 */

public class ContainerWithMostWater {
	
	//brute force - O(n2)
	
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		
		// For every pair oh heights, find area and consider minimum ot two height
		
		for(int i=0; i< height.length; i++) {
			
			for(int j=i+1; j < height.length; j++) {
				
				// find minimum between the two - so it can not spill water.
				
				int min = Math.min(height[i], height[j]);
				
				//find area - height * width - width is diff between those two verticle lines - diff of indexes
				
				//Over ride max, if that is not max till now.
				max = Math.max(max, min * (j-i));
			}
			
			
		}
		
		return max;
	}
	
	/*
	 *  Set two pointers - start and end. Keep moving it in the middle based on which height is smaller. 
	 *  
	 *  End loop where it meets
	 */
	
	public int maxAreaOptimized(int[] height) {
		
		int max = Integer.MIN_VALUE;
		
		int start = 0;
		int end = height.length - 1;
		
		while(start < end) {
			
			// find min height of two - 
			//calculate area and keep max area in max
			
			int min = Math.min(height[start], height[end]);
			
			max = Math.max(max, min * (end - start));
			
			//Move that pointer forward whose height is less than other.
			
			if(height[start] < height[end]) {
				start++;
			}
			else {
				end--;
			}
		}
		
		return max;
		
	}

	public static void main(String[] args) {
		
		ContainerWithMostWater container = new ContainerWithMostWater();
		
		int[] height = {1,8,6,2,5,4,8,3,7} ;
		System.out.println(container.maxArea(height));
		System.out.println(container.maxAreaOptimized(height));

	}

}
