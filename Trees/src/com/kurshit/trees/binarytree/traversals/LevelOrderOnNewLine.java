package com.kurshit.trees.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class LevelOrderOnNewLine {
	
	static BTREE btree = new BTREE();
		
	public void levelOrderHeightApproach(Node root) {
		if(root == null)
			return;
		
		int h = btree.height(root);
		
		for(int i=1; i<=h; i++) {
			printNodesAtGivenLevel(root,i);
			System.out.println();
		}
	}
	
	public void printNodesAtGivenLevel(Node root, int level) {
		if(root == null)
			return;
		
		if(level == 1) {
			System.out.print(root.data + " ");
		}
		
		printNodesAtGivenLevel(root.left, level-1);
		printNodesAtGivenLevel(root.right, level-1);
	}
	
	public void levelOrderTwoQueueApproach(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue1 = new LinkedList<>();
		Queue<Node> queue2 = new LinkedList<>();
		
		queue1.offer(root);
		
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			
			while(!queue1.isEmpty()) {
				Node temp = queue1.poll();
				System.out.print(temp.data + " ");
				
				if(temp.left != null) {
					queue2.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue2.offer(temp.right);
				}
			}
			
			System.out.println();
			
			while(!queue2.isEmpty()) {
				Node temp = queue2.poll();
				System.out.print(temp.data + " ");
				
				if(temp.left != null) {
					queue1.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue1.offer(temp.right);
				}
			}
			
			System.out.println();
			
		}
	}
	
	public void levelOrderDelimiterApproach(Node root) {
				
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp == null) {
				if(queue.isEmpty())
					return;
				else {
					System.out.println();
					queue.offer(null);
				}
			} else {
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					queue.offer(temp.left);
					
				if(temp.right != null)
					queue.offer(temp.right);
				
			}
					
		}
	}
	
	public void levelOrderNodeCountApproach(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		int nc = 0;
		
		while(!queue.isEmpty()) {
		
			nc = queue.size();
			
			if(nc == 0)
				return;
			
			while(nc > 0) {
				
				Node temp = queue.poll();
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				
				nc--;
				
			}
			
			System.out.println();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		btree.createSampleBinaryTree3();
		

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */
		
		LevelOrderOnNewLine lnl = new LevelOrderOnNewLine();
		
		lnl.levelOrderHeightApproach(btree.root);
		System.out.println("\nUsing two queues: \n");
		lnl.levelOrderTwoQueueApproach(btree.root);
		System.out.println("\nUsing Node count approach:\n");
		lnl.levelOrderNodeCountApproach(btree.root);
		
		System.out.println("\nUsing dlimeter approach");
		lnl.levelOrderDelimiterApproach(btree.root);
		

	}

}
