package com.kurshit.trees.binarytree.traversals;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class PrintParentOfAllNodesAtGivenLevel {

	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lheight = height(root.left) + 1;
		int rheight = height(root.right) + 1;
		
		return Math.max(lheight, rheight);
		
	}
	
	public void printGivenLevel(Node root, int level, Node parent) {
		if(root == null)
			return;
		
		if(level == 1) {
			System.out.print(root.data +" Parent is : " + parent.data);
			System.out.println();
			
		}
		printGivenLevel(root.left, level - 1, root);
		printGivenLevel(root.right, level - 1, root);
	}
	
	public void levelOrderTracversalUsingHeight(Node root) {
		int height = height(root);
		
		for(int i=1; i <= height; i++) {
			printGivenLevel(root, i, null);
		}
		
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		PrintParentOfAllNodesAtGivenLevel p1 = new PrintParentOfAllNodesAtGivenLevel();
		
		p1.printGivenLevel(btree.root, 3, null);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		

	}

}
