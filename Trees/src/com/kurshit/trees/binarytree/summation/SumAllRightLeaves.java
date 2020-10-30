package com.kurshit.trees.binarytree.summation;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SumAllRightLeaves {
	
	public void sumAllRightLeavesUtil(Node root, RightLeaves rightLeaves) {
		
		if(root == null)
			return;
		
		if(root.right != null) {
			if(root.right.left == null && root.right.right == null)
				rightLeaves.totalSum = rightLeaves.totalSum + root.right.data;
		}
		
		sumAllRightLeavesUtil(root.left, rightLeaves);
		sumAllRightLeavesUtil(root.right, rightLeaves);
		
	}
	
	public int sumAllRightLeaves(Node root) {
		
		RightLeaves rightLeaves = new RightLeaves();
		sumAllRightLeavesUtil(root, rightLeaves);
		
		return rightLeaves.totalSum;
		
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
		
		SumAllRightLeaves sumRights = new SumAllRightLeaves();
		
		System.out.println(sumRights.sumAllRightLeaves(btree.root));


	}
	
	private class RightLeaves {
		int totalSum;
	}

}
