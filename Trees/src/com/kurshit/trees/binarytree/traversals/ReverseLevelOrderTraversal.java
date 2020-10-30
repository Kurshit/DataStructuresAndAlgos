package com.kurshit.trees.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class ReverseLevelOrderTraversal {

	public void reverseLevelOrderTraversal(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		Stack<Node> stack = new Stack<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			stack.push(temp);
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop().data + " ");
		
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
		
		ReverseLevelOrderTraversal reverse = new ReverseLevelOrderTraversal();
		
		reverse.reverseLevelOrderTraversal(btree.root);
		
		
		
	}

}
