package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class AreCousins {
	
	public boolean areCousins(Node root, int a, int b) {
		
		if(root == null)
			return false;
		
		if(root.left == null || root.right == null)
			return false;
		
		return levelOfGivenNode(root, a) == levelOfGivenNode(root, b) && !areSibblings(root, a, b);
		
		
	}
	
	public int levelOfGivenNode(Node root, int key) {
		
		if(root == null) 
			return 0;
		
		return levelOfGivenNode(root, key, 1);	
		
		
	}
	
	public int levelOfGivenNode(Node root, int key, int currentLevel) {
		
		if(root == null) 
			return 0;
		
		if(root.data == key)
			return currentLevel;
		
		int levelOfNodeFoundInLeft = levelOfGivenNode(root.left, key, currentLevel + 1);
		
		if(levelOfNodeFoundInLeft != 0)
			return levelOfNodeFoundInLeft;
		
		return levelOfGivenNode(root.right, key, currentLevel + 1);		
		
	}
	
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

		
		AreCousins cousins = new AreCousins();
		
		System.out.println(cousins.areCousins(btree.root, 9, 30));
		System.out.println(cousins.areCousins(btree.root, 9, 40));
		System.out.println(cousins.areCousins(btree.root, 9, 20));
		System.out.println(cousins.areCousins(btree.root, 30, 40));

	}

}
