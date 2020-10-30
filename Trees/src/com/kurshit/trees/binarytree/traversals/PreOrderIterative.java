package com.kurshit.trees.binarytree.traversals;

import java.util.Stack;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class PreOrderIterative {

	
	public void preOrder(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		Node curr = root;
		
		while(curr != null || !stack.isEmpty()) {
			
			
			while(curr != null) {
				System.out.print(curr.data + " ");
				
				stack.push(curr);
				
				curr = curr.left;
			}
			
			curr = stack.pop();
			
			curr = curr.right;
		}
		
	}
	
public void postOrder(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		Node curr = root;
		
		while(curr != null || !stack.isEmpty()) {
			
			
			while(curr != null) {
				System.out.print(curr.data + " ");
				
				stack.push(curr);
				
				curr = curr.left;
			}
			
			curr = stack.pop();			
			
			curr = curr.right;
		}
		
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		PreOrderIterative preorder = new PreOrderIterative();
		
		preorder.preOrder(btree.root);
		
		System.out.println();
		
		preorder.postOrder(btree.root);
		
		
		
	}

}
