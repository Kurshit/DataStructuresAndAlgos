package com.kurshit.trees.binarytree.miscellaneous;

import com.kurshit.trees.binarytree.bst.BST;
import com.kurshit.trees.binarytree.bst.BST.Node;

public class InorderSuccessorOfNodeInBST {

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.root = new Node(50);
		Node tar = bst.root.left = new Node(30); 
		bst.root.right = new Node(70);
		bst.root.left.left = new Node(20);
		bst.root.left.right = new Node(40);
		bst.root.right.left = new Node(60);
		bst.root.right.right = new Node(80);
		bst.root.left.left.left = new Node(15);
		bst.root.left.left.right = new Node(25);
		bst.root.left.right.left = new Node(35);
		Node tar1 = bst.root.left.right.right = new Node(45);
		bst.root.left.left.left.left = new Node(10);
		
		bst.root.right.right.left = new Node(75);
		bst.root.right.right.right = new Node(85);

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
		
		Node res = inorderSuccessor(bst.root, tar);
		
		System.out.println(res.data);
		
		Node res1 = inorderSuccessor(bst.root, tar1);
		
		System.out.println(res1.data);
		
		
			
	}
	
	public static Node inorderSuccessor(Node root, Node n) {
		
		if(n.right != null) {
			return minValue(n.right);
		}
		
		Node succ = null;
		
		while(root != null) {
			if(n.data < root.data ) {
				succ = root;
				root = root.left;
			} else if(root.data < n.data) {
				root = root.right;
			} else {
				break;
			}
		}
		
		return succ;
		
	}
	
	public static Node minValue(Node root) {
		Node curr = root;
		
		while(curr.left != null) {
			curr = curr.left;
		}
		
		return curr;
	}
}
