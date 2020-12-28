package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class BTREEToDLLUsingPrev {

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

				
		convertToDll(btree.root);
		
		printLinkedList(head);

	}
	
	private static void printLinkedList(Node head) {
		
		Node ptr = head;
		
		while(ptr.right != null) {
			System.out.print(ptr.data +  " ");
			ptr = ptr.right;
		}
		
	}
	
	static Node prev = null;
	static Node head = null;
	public static void convertToDll(Node root) {
		if(root == null)
			return;
		
		convertToDll(root.left);
		
		if(prev == null) {
			head = root;
		}
		else {
				root.left = prev;
				prev.right = root; 
		}
		
		prev = root;
		
		convertToDll(root.right);
	}
}
