package com.kurshit.trees.binarytree.summation;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class SumOfLongestPath {
	
	public int sumOfLongestPath(Node root) {
			
		int sum = 0;
		sumOfLongestPathUtil(root, sum, 0);
		
		return maxSum;
	}
	
	static int maxLevel;
	static int maxSum;
		
	public void sumOfLongestPathUtil(Node root, int sum, int level) {
		
		if(root == null) {
			if(level > maxLevel) {
				maxSum = sum;
				maxLevel = level;
			} else if(level == maxLevel && sum > maxSum) {
				maxSum = sum;
			}
			return;
		}		
		
		sumOfLongestPathUtil(root.left, sum + root.data, level+1);
		sumOfLongestPathUtil(root.right, sum + root.data, level+1);
			
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		SumOfLongestPath longestSum = new SumOfLongestPath();
		
		System.out.println(longestSum.sumOfLongestPath(btree.root));



	}
	

}
