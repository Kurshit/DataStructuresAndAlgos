package com.kurshit.trees.binarytree.bst;

public class BST {

	public Node root;

	public static class Node {
		public int data;
		public Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}


	public void add(int data) {
		root = addNode(root, data);
	}

	public Node addNode(Node newRoot, int data) {

		Node newNode = new Node(data);

		if(newRoot == null) {
			return newNode;
		}


		if(data < newRoot.data)
			newRoot.left = addNode(newRoot.left, data);
		else 
			newRoot.right = addNode(newRoot.right, data);

		return newRoot;

	}


	public void inorder() {
		inorderNode(root);
		System.out.println();

	}

	public void inorderNode(Node newRoot) {

		if(newRoot == null)
			return;

		inorderNode(newRoot.left);
		System.out.print(newRoot.data + " ");
		inorderNode(newRoot.right);
	}


	public boolean search(int data) {
		return searchNode(root, data);
	}

	public boolean searchNode(Node newRoot, int data) {

		if(newRoot == null)
			return false;

		if(newRoot.data == data)
			return true;

		if(data < newRoot.data)
			return searchNode(newRoot.left, data);
		else
			return searchNode(newRoot.right, data);

	}
	
	public void delete(int data) {
		root = deleteNode(root,data);
	}
	
	public Node deleteNode(Node newRoot, int data) {
		
		if(newRoot == null)
			return null;
		
		if(data < newRoot.data) 
			newRoot.left = deleteNode(newRoot.left, data);
		else if(data > newRoot.data)
			newRoot.right = deleteNode(newRoot.right, data);
		else {
			
			if(newRoot.left == null)
				return newRoot.right;
			else if (newRoot.right == null)
				return newRoot.left;
			
			newRoot.data = getInorderSuccessor(newRoot.right);
			
			newRoot.right = deleteNode(newRoot.right, newRoot.data);			
			
		}
		
		return newRoot;
	}
	
	public int getInorderSuccessor(Node root) {
		
		if(root == null)
			return 0;
		
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		return min;
	}

	public void createSampleTree() {
		add(50);
		add(30);
		add(70);
		add(20);
		add(40);
		add(60);
		add(80);
		add(15);
		add(25);
		add(35);
		add(45);
		add(75);
		add(85);
		add(10);
		
		
		/*
		 * 							  50
		 * 					     /         \
 		 *  				 30               70
		 *              /         \      /         \
		 *           20           40   60            80
		 *        /      \     /   \              /      \
		 *      15      25   35     45          75        85
		 *     / 
		 *    10  
		 *      
		 */

	}

}
