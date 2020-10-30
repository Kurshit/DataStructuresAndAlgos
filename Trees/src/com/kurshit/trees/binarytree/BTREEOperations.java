package com.kurshit.trees.binarytree;

/*
 * This class is to test the basic BTREE operations written in BTREE.java
 * 
 * Operation Tested : 
 * 
 * 1. Add a node in BTREE.
 * 2. Traversal - PreOrder, InOrder and PostOrder recursively.
 * 3. Search an element in BTREE. 
 * 
 */

public class BTREEOperations {

	public static void main(String[] args) {
				
		BTREE btree = new BTREE();
		
		/*
		 * 								50
		 * 							/	     \
		 * 						  40		 60
		 * 					   /     \      /      \
		 *                   30       45    65      70
		 * 				  /     \     
		 * 				 10      20
		 * 
 		 */
		
		addNodesInBtree(btree);
		
		depthFirstTraversal(btree);
		
		searchElementsInTree(btree);
		
		

	}
	
	private static void searchElementsInTree(BTREE btree) {
		
		int key = 70;
		
		System.out.println("Element " + key + " exist in Tree : " + btree.contains(key));
		
		key = 102;
		
		System.out.println("Element " + key + " exist in Tree : " + btree.contains(key));
		
		key = 40;
		
		System.out.println("Element " + key + " exist in Tree : " + btree.contains(key));
		
		key = 50;
		
		System.out.println("Element " + key + " exist in Tree : " + btree.contains(key));
		
	}

	private static void depthFirstTraversal(final BTREE btree) {
		
		System.out.print("PreOrder Traversal : ");
		btree.preOrder();
		
		System.out.print("InOrder Traversal : ");
		btree.inOrder();
		
		System.out.print("PostOrder Traversal : ");
		btree.postOrder();
		
	}

	private static void addNodesInBtree(BTREE btree) {
		
		btree.add(50);
		btree.add(40);
		btree.add(60);
		btree.add(30);
		btree.add(45);
		btree.add(65);
		btree.add(70);
		btree.add(10);
		btree.add(20);
		
	}

}
