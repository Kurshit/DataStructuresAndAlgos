package com.kurshit.trees.binarytree.leetcode.googletag;

import java.util.HashSet;
import java.util.Set;

import com.kurshit.trees.binarytree.bst.BST;
import com.kurshit.trees.binarytree.bst.BST.Node;

/*
 * Given a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child. 
 * Identify the defective node and remove an extra edge to fix the tree.
 * 
		Input:
	       3
		  / \
		 2   5
		/ \ /
	   1   4
	
	Output:
	       3
		  / \
		 2   5
		/   /
	   1   4
	
	Explanation: In this case we can only remove 2-4 because if we remove 5-4 the BST will be invalid.

 */

public class RemoveExtraEdgeBST {

	public static void main(String[] args) {

		BST bst = new BST();
		bst.createSampleForEdgeRemoval();

		bst.inorder();

		removeEdge(bst.root);

		bst.inorder();
	}

	public static Node removeEdge(Node root) {
		return removeEdgeBST(root, null, null);
	}

	private static Node removeEdgeBST(Node node, Integer min, Integer max) {
		if (node == null) 
			return null;
	    
		if ((max != null && node.data >= max) || (min != null && node.data <= min)) 
	    	return null;
	    
		node.left = removeEdgeBST(node.left, min, node.data);
	    node.right = removeEdgeBST(node.right, node.data, max);
	    
	    return node;
	}

}

//Input:
//    3
//	  / \
//	 2   5
//	/ \ /
//1   4
