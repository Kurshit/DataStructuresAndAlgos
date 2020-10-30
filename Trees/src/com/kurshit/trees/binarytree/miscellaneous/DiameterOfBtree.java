package com.kurshit.trees.binarytree.miscellaneous;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

/*
 * The program is to find the diameter of a B-tree. 
 * 
 * Diamater of BTREE : Number of nodes on longest path from two node ends
 */

public class DiameterOfBtree {
	
	public static int diameter(Node root) {
		
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		int ld = diameter(root.left);
		int rd = diameter(root.right);
		
		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}
	
	public static int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		return Math.max(lh, rh) + 1;
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		SampleBinaryTrees.createSampleBinaryTree1(btree);
		

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		System.out.println("Diameter of a BTREE is : "  + diameter(btree.getRoot()));
			
		
	}
}
