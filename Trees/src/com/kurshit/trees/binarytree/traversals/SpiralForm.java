package com.kurshit.trees.binarytree.traversals;

import java.util.Stack;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class SpiralForm {

	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lh = height(root.left) + 1;
		int rh = height(root.right)  + 1;
		
		return Math.max(lh, rh);
	}
	
	public void printAtGivenLevel(Node root, int level, boolean itr) {
		
		if(root == null)
			return;
		
		if(level == 1) {
			System.out.print(root.data + " ");
		}
		
		if(itr) {
			printAtGivenLevel(root.left, level - 1, itr);
			printAtGivenLevel(root.right, level - 1, itr);
		} else {
			printAtGivenLevel(root.right, level - 1, itr);
			printAtGivenLevel(root.left, level - 1, itr);
		}
		
	}
	
	public void spiralTraverUsingHeight(Node root) {
		
		if(root == null)
			return;
		
		int h = height(root);
		boolean itr = false;
		
		for(int i=1; i<=h; i++) {
			
			printAtGivenLevel(root, i, itr);
			itr = !itr;
			System.out.println();
		}
	}
	
	public void spiralUsingQueueStack(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack1 = new Stack<>();
		
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()) {
				
				Node temp = stack1.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.right != null) {
					stack2.push(temp.right);
				}
				
				if(temp.left != null) {
					stack2.push(temp.left);
				}
			}
			
			System.out.println();
			
			while(!stack2.isEmpty()) {
				
				Node temp = stack2.pop();
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null) {
					stack1.push(temp.left);
				}
				
				if(temp.right != null) {
					stack1.push(temp.right);
				}
				
				
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		SpiralForm spiral = new SpiralForm();
		
		spiral.spiralTraverUsingHeight(btree.root);
		
		System.out.println("\nUsing Queue and Stack : \n");
		spiral.spiralUsingQueueStack(btree.root);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
	}

}
