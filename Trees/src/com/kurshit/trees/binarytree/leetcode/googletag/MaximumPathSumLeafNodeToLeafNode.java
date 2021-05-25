package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class MaximumPathSumLeafNodeToLeafNode {

	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createMaxPathSubTree2();

		/*
		 * 							    10
		 * 						 	  /	    \
		 * 						     2	      10
		 * 						  /	  \	         \
		 * 						20    1		      -25
		 * 										/	  \
[		 * 									   3        8
		 * 
		 */

		MaxResult res = new MaxResult();
		res.max = Integer.MIN_VALUE;
		getMaxPath(btree.root, res);
		System.out.println(res.max);
	}

	public static int getMaxPath(Node root, MaxResult res) {

		if(root == null)
			return 0;

		if(root.left == null && root.right == null)
			return root.data;

		int left = getMaxPath(root.left, res) ;
		int right = getMaxPath(root.right, res);

		if(root.left != null && root.right != null) {
			int temp = Math.max(left, right) + root.data;
			
			res.max = Math.max(res.max, left + right + root.data);
			
			return temp;
		}

		return root.left == null ? right + root.data : left + root.data;
	}

}
