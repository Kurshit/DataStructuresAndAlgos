package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE.Node;

public class CreatingTreeFromPreAndInorder { 
	Node root; 
	static int preIndex = 0; 

	/* Recursive function to construct binary of size len from 
	Inorder traversal in[] and Preorder traversal pre[]. 
	Initial values of inStrt and inEnd should be 0 and len -1. 
	The function doesn't do any error checking for cases where 
	inorder and preorder do not form a tree */
	
	Node buildTree(int in[], int pre[], int inStrt, int inEnd) 
	{ 
		if (inStrt > inEnd) 
			return null; 

		/* Pick current node from Preorder traversal using preIndex 
		and increment preIndex */
		Node newRoot = new Node(pre[preIndex++]); 

		/* If this node has no children then return */
		if (inStrt == inEnd) 
			return newRoot; 

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, newRoot.data); 

		/* Using index in Inorder traversal, construct left and 
		right subtress */
		newRoot.left = buildTree(in, pre, inStrt, inIndex - 1); 
		newRoot.right = buildTree(in, pre, inIndex + 1, inEnd); 

		return newRoot; 
	} 

	/* UTILITY FUNCTIONS */

	/* Function to find index of value in arr[start...end] 
	The function assumes that value is present in in[] */
	int search(int arr[], int strt, int end, int value) 
	{ 
		int i; 
		for (i = strt; i <= end; i++) { 
			if (arr[i] == value) 
				return i; 
		} 
		return i; 
	} 

	/* This funtcion is here just to test buildTree() */
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.left); 

		/* then print the data of node */
		System.out.print(node.data + " "); 

		/* now recur on right child */
		printInorder(node.right); 
	} 

	// driver program to test above functions 
	public static void main(String args[]) 
	{ 
		CreatingTreeFromPreAndInorder tree = new CreatingTreeFromPreAndInorder(); 
		int in[] = new int[] {9,10,15,20,7}; 
		int pre[] = new int[] {10,9,20,15,7}; 
		int len = in.length; 
		Node root = tree.buildTree(in, pre, 0, len - 1); 
		
		/*
		 * 							   10
		 * 						 	  /	    \
		 * 						     9		 20
		 * 								   /    \
		 * 								 15      7
		 * 
		 */

		// building the tree by printing inorder traversal 
		System.out.println("Inorder traversal of constructed tree is : "); 
		tree.printInorder(root); 
	} 
} 

//This code has been contributed by Mayank Jaiswal 

