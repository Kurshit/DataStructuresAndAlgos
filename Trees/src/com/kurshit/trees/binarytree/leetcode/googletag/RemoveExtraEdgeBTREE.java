package com.kurshit.trees.binarytree.leetcode.googletag;

import java.util.HashSet;
import java.util.Set;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

/*
 * Given a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child. 
 * Identify the defective node and remove an extra edge to fix the tree.
 * 
	  Input:
		   1
		  / \
		 2   3
		/ \ /
	   4   5

	Output:

	     1			       1
	    / \			      / \
	   2   3    or	     2   3
	  / \ 			    /   /
	 4   5		       4   5

	Explanation: We can remove either 3-5 or 2-5.

 */

public class RemoveExtraEdgeBTREE {

	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createSampleForEdgeRemoval();

		btree.inOrder();

		removeEdge(btree.root);

		btree.inOrder();
	}

	public static Node removeEdge(Node root) {
		return removeEdgeBT(root, new HashSet<>());
	}

	private static Node removeEdgeBT(Node node, Set<Node> seen) {
		if (node == null) 
			return null;
		
		if(seen.contains(node)) 
			return null;
		else {
			seen.add(node);
		}
		
		node.left = removeEdgeBT(node.left, seen);
		node.right = removeEdgeBT(node.right, seen);
		
		return node;
	}

}
