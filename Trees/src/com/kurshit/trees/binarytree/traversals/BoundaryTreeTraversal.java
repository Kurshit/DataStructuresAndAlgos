package com.kurshit.trees.binarytree.traversals;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class BoundaryTreeTraversal {
	
	public void boundaryTraversal(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
		
	}
	
	/*
	 * This will only print left side nodes except leaf nodes because of root.left != null condition
	 */
	
	public void printLeftBoundary(Node root) {
		
		if(root == null)
			return;
		
		// if i just give root != null, it will print leaf node as well
		
		if(root.left != null) {
			//Print first then call function to ensure top down approach
			System.out.print(root.data + " ");
			printLeftBoundary(root.left);
		}
		else if(root.right != null) {
			System.out.print(root.data + " ");
			printLeftBoundary(root.left);
		}
		
	}
	
	
	
	public void printRightBoundary(Node root) {
		
		if(root == null)
			return;
		
		if(root.right != null) {
			//Call this first before printing to ensure bottom up approach. Unlike printLeftBoundary - top-bottom
			printRightBoundary(root.right);
			System.out.print(root.data + " ");
		} else if(root.left != null) {
			printRightBoundary(root.right);
			System.out.print(root.data + " ");
		}
		
	}
	
	/*
	 * Since boundary is to be traversed from left to right (anti clockwise), we will do inorder traversal of it.
	 */
	
	
	public void printLeaves(Node root) {
		if(root == null)
			return;
		
		printLeaves(root.left);
		
		if(root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}
		
		printLeaves(root.right);
		
	}
	
 
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */

		
		BoundaryTreeTraversal boundary = new BoundaryTreeTraversal();
		boundary.boundaryTraversal(btree.root);

	}

}
