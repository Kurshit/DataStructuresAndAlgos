package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

/*
  * In the following implementation, we traverse the tree in inorder fashion. We add nodes at the beginning of current linked list and update head of the list using 
  * pointer to head pointer. Since we insert at the beginning, we need to process leaves in reverse order. For reverse order, we first traverse the right subtree before 
  * the left subtree. i.e. do a reverse inorder traversal.
  */

public class BTREEToDLL {
	Node root; 
	
	// 'head' - reference to head node of created 
	//double linked list 
	Node head; 

	// A simple recursive function to convert a given 
	// Binary tree to Doubly Linked List 
	void btreeToDLL(Node root) 
	{ 
		// Base cases 
		if (root == null) 
			return; 

		// Recursively convert right subtree 
		btreeToDLL(root.right); 

		// insert root into DLL 
		root.right = head; 

		// Change left pointer of previous head 
		if (head != null) 
			head.left = root; 

		// Change head of Doubly linked list 
		head = root; 

		// Recursively convert left subtree 
		btreeToDLL(root.left); 
	} 

	// Utility function for printing double linked list. 
	void printList(Node head) 
	{ 
		System.out.println("Extracted Double Linked List is : "); 
		while (head != null) 
		{ 
			System.out.print(head.data + " "); 
			head = head.right; 
		} 
	} 

	public static void main(String[] args) {
		
		BTREEToDLL dll = new BTREEToDLL();
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		dll.btreeToDLL(btree.root);
		

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		dll.printList(dll.head);
		

	}

}

