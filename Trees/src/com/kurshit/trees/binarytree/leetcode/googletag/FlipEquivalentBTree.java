package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class FlipEquivalentBTree {

	public static void main(String[] args) {
		
	}
	
	public static boolean isFlipEquivalent(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		if(root1.data != root2.data)
			return false;
		
		return (isFlipEquivalent(root1.left, root2.left) && isFlipEquivalent(root1.right, root2.right)) 
				|| (isFlipEquivalent(root1.left, root2.right) && isFlipEquivalent(root1.right, root2.left));
	}

}
