package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class MaxDIffBetweenNodeAncestor {

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
		//Expected - 75 : 80-5
		System.out.println(getMaxDiff(btree.root));

	}
	
	public static int getMaxDiff(Node root) {
		if(root == null)
			return 0;
		
		return getMaxDiffUtil(root, root.data, root.data);
	}

	private static int getMaxDiffUtil(Node root, int currMax, int currMin) {
		
		if(root == null)
			return currMax - currMin;
		
		currMax = Math.max(root.data, currMax);
		currMin = Math.min(root.data, currMin);
		
		int l = getMaxDiffUtil(root.left, currMax, currMin);
		int r = getMaxDiffUtil(root.right, currMax, currMin);
		
		return Math.max(l, r);	
		
	}

}
