package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class CoinDistributionInBTree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleForCoinDistribution();

		/*
		 * 								1
		 * 							/	     \
		 * 						  0			   0
		 * 					   /     
		 * 					3	
		 * 
		 */
		
		getSteps(btree.root);
		System.out.println(ans);

	}
	
	public static int ans;
	public static int getSteps(Node root) {
		if(root == null) {
			return 0;
		}
		
		int left = getSteps(root.left);
		int right = getSteps(root.right);
		ans = ans + Math.abs(left) + Math.abs(right);
		return root.data + left+ right -1;	
		
	}

}
