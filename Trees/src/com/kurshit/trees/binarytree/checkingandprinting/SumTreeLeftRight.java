package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class SumTreeLeftRight {
	
	/*
	 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. 
	 * An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
	 * 
	 * Ex: 
	 * 
	 *     	  	  26
     *   		/   \
     * 		   10     3
     *		 /    \     \
  	 *		4      6      3
	 *
	 */
	
	public static boolean isSumTree(Node root) {
		
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		int ls = sum(root.left);
		int rs = sum(root.right);
		
		return (root.data == ls + rs) && isSumTree(root.left) && isSumTree(root.right);
		
		
	}
	
	public static int sum(Node root) {
		if(root == null)
			return 0;
		
		return root.data + sum(root.left) + sum(root.right);
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSumTreeLeftRight();
		
		BTREE btree2 = new BTREE();
		btree2.createSumTree();
		
		System.out.println(isSumTree(btree.root));
		
		System.out.println(isSumTree(btree2.root));
	}

}
