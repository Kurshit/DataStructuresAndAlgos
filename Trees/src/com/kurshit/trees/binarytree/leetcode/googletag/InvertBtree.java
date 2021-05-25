package com.kurshit.trees.binarytree.leetcode.googletag;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class InvertBtree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /     \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		btree.inOrder();
		
		/* Inverted - 
		 * 
		 * 								10
		 * 							/	     \
		 * 						  20		  5
		 * 					   /     \       /   \
		 *                   40      30     7     9
		 * 				   			      /  \   /   \  
		 * 							    60   50  80   70
		 * 				  
		 */
		
		Node root = invertRecursiely(btree.root);
		
		btree.inOrder(root);
		
		//Iteratively
		
		BTREE btree1 = new BTREE();
		btree1.createSampleBinaryTree1();
		
		System.out.println();
		
		btree1.inOrder();
		
		Node root1 = invertRecursiely(btree1.root);
		
		btree1.inOrder(root1);
		

	}
	
	public static Node invertRecursiely(Node root) {
		
		if(root == null)
			return null;
		
		Node right = invertRecursiely(root.right);
		Node left = invertRecursiely(root.left);
		
		root.left = right;
		root.right = left;		
		
		return root;
	}
	
	public static Node invertIteratively(Node root) {
		
		if(root == null)
			return null;
		
		Queue<Node> q = new LinkedList<>();
		
		q.offer(root);
		
		while(!q.isEmpty()) {
			
			Node current = q.poll();
			
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;
			
			if(current.left != null) {
				q.offer(current.left);				
			}
			
			if(current.right != null) {
				q.offer(current.right);
			}
			
		}		
		
		return root;
		
	}

}
