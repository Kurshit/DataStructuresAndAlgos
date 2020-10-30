package com.kurshit.arrays.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {

	//Approach 1 : Brute force - takes O(n3)

	static void findTriplets(int[] arr, int n) 
	{ 
		boolean found = true; 
		for (int i=0; i<n-2; i++) 
		{ 
			for (int j=i+1; j<n-1; j++) 
			{ 
				for (int k=j+1; k<n; k++) 
				{ 
					if (arr[i]+arr[j]+arr[k] == 0) 
					{ 
						System.out.print(arr[i]); 
						System.out.print(" "); 
						System.out.print(arr[j]); 
						System.out.print(" "); 
						System.out.print(arr[k]); 
						System.out.print("\n"); 
						found = true; 
					} 
				} 
			} 
		} 

		// If no triplet with 0 sum found in array 
		if (found == false) 
			System.out.println(" not exist "); 

	} 

	//Approach 2 : Using Hashing O(n2) and extra space


	static void findTripletsHashing(int arr[], int n)  
	{ 
		boolean found = false; 

		for (int i = 0; i < n - 1; i++)  
		{ 
			// Find all pairs with sum equals to 
			// "-arr[i]" 
			HashSet<Integer> s = new HashSet<Integer>(); 
			for (int j = i + 1; j < n; j++)  
			{ 
				int x = -(arr[i] + arr[j]); 
				if (s.contains(x))  
				{ 
					System.out.printf("%d %d %d\n", x, arr[i], arr[j]); 
					found = true; 
				}  
				else 
				{ 
					s.add(arr[j]); 
					
					/*
					 *  We hash a[j] . WHy ? Note that hashset gets rest after every iteration. Thus hash set will have differetn values in each iteration. 
					 *  
					 *  Since j traverses all values but 0th index,we keep it onto stack to match with other two. a + b + c = 0; Thus, c = -(a+b). In our case, 
					 *  c is x. What we basically do is, we keep one element on stack, treat it as base, and check if other two adds upto it and equals to zero. 
					 *  Or in a way to say, we check elements of hash as X and check using traditional way where in we check if two array elements equal to given sum.
					 *  
					 *  Hash set from j =1 to j <n will have - 
					 *  
					 *  1st pass (j=1) HS--> -1, 2, -3, 1 
					 *  2nd pass HS j = 2 -->  2 , -3, 1
					 *  3rd pass HS j =3 --> -3,1
					 *  4th pass HS (j = 4) ---> 1
					 *  
					 */
				} 
			} 
		} 

		if (found == false) 
		{ 
			System.out.printf(" No Triplet Found\n"); 
		} 
	} 
	
	// Approach 3 : Sorting and traditional prog to check for sum equal to two using start/end ptr - O(n2)
	
	/*
	 * In this, starting from left to right - we fix one element at first a[i] and then for remaining i+1 to n elements, check if x + a + b = 0.
	 * Using start and end ptr. 
	 * 
	 */
	
	static void findTripletsUsingSorting(int arr[], int n) 
	{ 
	    boolean found = false; 
	  
	    // sort array elements 
	    Arrays.sort(arr); 
	  
	    for (int i=0; i<n-1; i++) 
	    { 
	        // initialize left and right 
	        int l = i + 1; 
	        int r = n - 1; 
	        int x = arr[i]; 
	        while (l < r) 
	        { 
	            if (x + arr[l] + arr[r] == 0) 
	            { 
	                // print elements if it's sum is zero 
	                    System.out.print(x + " "); 
	                    System.out.print(arr[l]+ " "); 
	                    System.out.println(arr[r]+ " "); 
	      
	                l++; 
	                r--; 
	                found = true; 
	            } 
	  
	            // If sum of three elements is less 
	            // than zero then increment in left 
	            else if (x + arr[l] + arr[r] < 0) 
	                l++; 
	  
	            // if sum is greater than zero than 
	            // decrement in right side 
	            else
	                r--; 
	        } 
	    } 
	  
	    if (found == false) 
	            System.out.println(" No Triplet Found"); 
	} 
	

	public static void main(String[] args) {

		int arr[] = {0, -1, 2, -3, 1}; 
		int n = arr.length; 
		findTripletsHashing(arr, n); 
		
	}

}
