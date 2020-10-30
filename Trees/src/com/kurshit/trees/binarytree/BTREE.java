package com.kurshit.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BTREE {

	public Node root;	
	
	public static class Node {

		public int data;
		public Node left, right;
		public int hd;
		public int vd;

		public Node(int data) {
			this.data = data;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void add(final int data) {

		if(this.root == null) {
			 this.root = new Node(data);
			 return;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.offer(this.root);


		while(!queue.isEmpty()) { 

			Node temp = queue.poll();

			if(temp.left == null) {
				temp.left = new Node(data);
				break;
			} else {
				queue.offer(temp.left);
			}

			if(temp.right == null) {
				temp.right = new Node(data);
				break;
			} else {
				queue.offer(temp.right);
			}
		}			
	}
	
	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}
	
	public int height(Node newRoot) {

		if(newRoot ==null)
			return 0;

		int lheight = height(newRoot.left) + 1;
		int rheight = height(newRoot.right) + 1;

		return Math.max(lheight, rheight);

	}
	
	private void preOrder(final Node newRoot) {
		
		if(newRoot == null)
			return;
		
		System.out.print(newRoot.data + " ");
		preOrder(newRoot.left);
		preOrder(newRoot.right);
	}
	
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}
	
	private void inOrder(final Node newRoot) {
		if(newRoot == null)
			return;
		
		inOrder(newRoot.left);
		System.out.print(newRoot.data + " ");
		inOrder(newRoot.right);
	}
	
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}
	
	private void postOrder(final Node newRoot) {
		if(newRoot == null)
			return;
		
		postOrder(newRoot.left);
		postOrder(newRoot.right);
		System.out.print(newRoot.data + " ");
	}
	
	public boolean contains(int data) {
		return contains(this.root, data);
	}
	
	private boolean contains(Node newRoot, int data) {
		
		
		if(newRoot == null) {
			return false;
		}
		
		if(newRoot.data == data) 
			return true;
		
		/*
		 * Alternatively, Can be written as - 
		 * 
		 *  boolean result = contains(newRoot.left, data);
		 *  if(result)
		 *	    return true;
		 *	    
		 */		
		
		return contains(newRoot.left, data) || contains(newRoot.right, data);
	}
	
	public void createSampleBinaryTree1() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(70);
		add(80);
		add(50);
		add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */



	}
	
	public void createSampleBinaryTree5() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(70);
		add(80);
		add(50);
		add(60);
		add(100);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    /
		 * 				 70    80  50  60 100
		 */



	}
	
	
	public void createMaxPathSubTree1() {

		root = new Node(-10);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		

		/*
		 * 							   -10
		 * 						 	  /	    \
		 * 						     9		 20
		 * 								   /    \
		 * 								 15      7
		 * 
		 */



	}


	public void createSampleBinaryTree2() {

		add(10);
		add(5);
		add(20);
		add(9);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     
		 *                   9       
		 * 		
		 */



	}

	//WIth duplicateLeafNode

	public void createSampleBinaryTree3() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(50);
		add(80);
		add(50);
		add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */



	}

	public void createSampleBinaryTree4() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(50);
		add(80);
		add(50);
		add(60);
		
		add(70);
		add(80);
		add(90);
		add(100);
		
		add(110);
		add(120);
		add(130);
		add(140);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \   / \     / \  
		 * 				 50    80  50  60 70 80  90  100
		 * 				/  \  /   \
		 * 			 110  120 130 140
		 * 
 		 */



	}

	
	public void createSumTree() {

		add(50);
		add(20);
		add(30);
		add(15);
		add(5);
		add(27);
		add(3);
		add(15);
		

		/*
		 * 								50
		 * 							/	     \
		 * 						  20		 30
		 * 					   /     \      /      \
		 *                   15       5    27       3
		 * 				  /      
		 * 				 15
		 * 
 		 */



	}
	
	public void createSumTreeLeftRight() {

		add(26);
		add(10);
		add(3);
		add(4);
		add(6);
		add(3);		
		
		 /*
		 *
		 *     	  	  26
	     *   		/   \
	     * 		   10     3
	     *		 /    \     \
	  	 *		4      6      3
		 *
		 */



	}

	public void createUncoveredCoveredSumTree() {

		root = new Node(10); 
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40); 
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        
        root.left.right.left = new Node(45);
         
        root.left.right.right = new Node(100); 
        
         
        root.left.left.left.right = new Node(5); 

		/*
		 * 								10
		 * 							/	     \
		 * 						  20		 30
		 * 					   /     \      /      \
		 *                   40       50    60      70
		 * 				  /          /  \    
		 * 				 80         45   100
		 *                 \
		 * 					5
 		 */



	}


	public void clear() {
		root = null;
	}

}
