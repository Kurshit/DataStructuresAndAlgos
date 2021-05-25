package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class MaximumPathSumAnyNodeToAnyNode {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createMaxPathSubTree1();
		
		/*
		 * 							   -10
		 * 						 	  /	    \
		 * 						     9		 20
		 * 								   /    \
		 * 								 15      7
		 * 
		 */
		
		MaxResult res = new MaxResult();
		getMaxPath(btree.root, res);
		System.out.println(res.max);
	}
	
	public static int getMaxPath(Node root, MaxResult res) {
		
		if(root == null)
			return 0;
		
		int left = getMaxPath(root.left, res);
		int right = getMaxPath(root.right, res);
		
		int temp = Math.max(Math.max(left, right) + root.data, root.data);
		int ans = Math.max(temp, left+right+root.data);
		res.max = Math.max(res.max, ans);
		
		return temp;
	}

}


class MaxResult {
	int max;
}

