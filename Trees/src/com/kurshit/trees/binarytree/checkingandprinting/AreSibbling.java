package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class AreSibbling {
	
	public boolean areSibblings(Node root, int a, int b) {
		
		if(root == null)
			return false;
		
		if(root.left == null || root.right == null)
			return false;
		
		if((root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a)) {
			return true;
		}
		
		
		return areSibblings(root.left, a, b) || areSibblings(root.right, a, b);
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree5();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    /
		 * 				 70    80  50  60 100
		 */
		
		AreSibbling sib = new AreSibbling();
		
		System.out.println(sib.areSibblings(btree.root, 50, 60));		
		System.out.println(sib.areSibblings(btree.root, 9, 7));
		System.out.println(sib.areSibblings(btree.root, 70, 7));
		System.out.println(sib.areSibblings(btree.root, 9, 40));
		System.out.println(sib.areSibblings(btree.root, 100, 0));

	}

}
