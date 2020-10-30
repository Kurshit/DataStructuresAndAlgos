package com.kurshit.trees.binarytree.path;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

/*
 * Given a binary tree containing n nodes. The problem is to find the sum of all nodes on the longest path from root to 
 * leaf node. If two or more paths compete for the longest path, then the path having maximum sum of nodes is being 
 * considered.
 * 
 */

public class SumOfNodesOnLongestPathBtree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		SampleBinaryTrees.createSampleBinaryTree1(btree);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		System.out.println("Maximum sum on longest path is : " + sumOfNodesOnLongestPath(btree.getRoot()));
		
		BTREE btree1 = new BTREE();
		SampleBinaryTrees.createSampleBinaryTree4(btree1);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \   / \     / \  
		 * 				 50    80  50  60 70 80  90  100
		 * 				/  \  /   \
		 * 			 110  120 130 140
		 * 
		 */
		
		System.out.println("Maximum sum on longest path is : " + sumOfNodesOnLongestPath(btree1.getRoot()));		

	}
	
	private static Result result = new Result();
	
	public static int sumOfNodesOnLongestPath(Node root) {
			
		sumOfNodesOnLongestPathUtil(root, 0, 0);
		
		return result.maxSum;
		
	}
	
	private static void sumOfNodesOnLongestPathUtil(Node root, int sum, int length) {
		
		if(root == null) 
			return;
		
		if(root.left == null && root.right == null) {
			
			if(result.maxLength < length) {				
				result.maxSum = root.data + sum;
				result.maxLength = length;
			} else if(result.maxLength == length && result.maxSum < root.data + sum) {
				result.maxSum = root.data + sum;
				result.maxLength = length;				
			}		
			
		}
		
		sumOfNodesOnLongestPathUtil(root.left, sum + root.data, length + 1);
		sumOfNodesOnLongestPathUtil(root.right, sum + root.data, length + 1);
		
	}
	
	private static class Result {
		int maxSum;
		int maxLength;
	}

}
