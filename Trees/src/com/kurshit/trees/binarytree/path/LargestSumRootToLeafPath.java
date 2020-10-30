package com.kurshit.trees.binarytree.path;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.BTREE.Node;

/*
 * The problem is to find the Root To Leaf path with largest sum. 
 * 
 * Example : 
 * 
 * 				
 *		  								10
 *		  							/	     \
 *		  						  5			   20
 *		  					   /     \       /      \
 *		                    9       7     30       40
 *		  				  /    \    / \    
 *		  				 70    80  50  60 
 *		 
 * 	
 * 	Longest Sum Path : 10 + 5 + 9 + 80 = 104
 *   
 *  Path : 10 -> 5 -> 9 -> 80
 *  
 */


public class LargestSumRootToLeafPath {
	
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
		
		largestSumRootToLeafPath(btree.getRoot());
		
	}
	
	public static void largestSumRootToLeafPath(Node root) {
		
		int targetSum = SumOfNodesOnLongestPathBtree.sumOfNodesOnLongestPath(root);
		
		RootToLeafPathForGivenTotalSum.pathForGivenSum(root, targetSum);
		
	}
	

}
