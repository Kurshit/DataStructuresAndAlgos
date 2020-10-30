package com.kurshit.trees.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

/*
 * Given a binary tree, print the level order traversal in such a way that first two levels are printed 
 * from left to right, next two levels are printed from right to left, then next two from left to right 
 * and so on. So, the problem is to reverse the direction of level order traversal of binary tree 
 * after every two levels.
 * 
 * https://www.geeksforgeeks.org/level-order-traversal-direction-change-every-two-levels/
 * 
 * O(n)
 */



public class ReverseAfterEveryTwoLevel {
	
	
	public void reverseAfterTwoLevel(Node root) {
		
		if(root == null)
			return ;
		
		if(root.left == null && root.right == null)
		{
			System.out.println(root.data);
			return;
		}
				
		int nodeCount =0;
		int levelChangeCounter = 0;
		boolean rightToLeft = false;
		
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			levelChangeCounter++;
			
			nodeCount = queue.size();
			
			while(nodeCount >0) {
				
				Node temp = queue.poll();
				
				if(!rightToLeft) {
					System.out.print(temp.data + " ");
				}
				else  {
					stack.push(temp);					
				}
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				
				nodeCount--;
				
			}
						
			if(rightToLeft) {
				
				while(!stack.isEmpty()) {
					Node temp = stack.pop();
					
					System.out.print(temp.data + " ");
				}				
			}
			
			if(levelChangeCounter == 2) {
				rightToLeft = !rightToLeft;
				levelChangeCounter = 0;		
			}
			
			System.out.println("");			
		}	
		
	}
	

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree4();
		
		ReverseAfterEveryTwoLevel reverse = new ReverseAfterEveryTwoLevel();
		
		reverse.reverseAfterTwoLevel(btree.root);

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

}
