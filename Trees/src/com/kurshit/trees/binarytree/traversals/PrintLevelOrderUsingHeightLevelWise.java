package com.kurshit.trees.binarytree.traversals;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class PrintLevelOrderUsingHeightLevelWise {

	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lheight = height(root.left) + 1;
		int rheight = height(root.right) + 1;
		
		return Math.max(lheight, rheight);
		
	}
	
	public void printGivenLevel(Node root, int level) {
		if(root == null)
			return;
		
		if(level == 1)
			System.out.print(root.data +" ");
		
		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}
	
	public void levelOrderTracversalUsingHeight(Node root) {
		int height = height(root);
		
		for(int i=1; i <= height; i++) {
			printGivenLevel(root, i);
		}
		
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		PrintLevelOrderUsingHeightLevelWise p1 = new PrintLevelOrderUsingHeightLevelWise();
		p1.levelOrderTracversalUsingHeight(btree.root);
		
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
