package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class HeightOfATree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		SampleBinaryTrees.createSampleBinaryTree1(btree);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60
		 *  
		 */
		
		System.out.println("Heigh of tree using Recusrion is : " + height(btree.getRoot()));
		System.out.println("Heigh of tree using Recusrion is : " + heightUsingNodeCount(btree.getRoot()));
		System.out.println("Heigh of tree using Recusrion is : " + heightUsingDelimeter(btree.getRoot()));

	}
	
	public static int height(final Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		int lh = height(newRoot.left);
		int rh = height(newRoot.right);
		
		return Math.max(lh, rh) + 1;
		
	}
	
	private static int heightUsingNodeCount(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		int height = 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		
		while(true) {
			
			int nodeCount = queue.size();
			
			if(nodeCount == 0)
				break;
		
			height++;
			
			while(nodeCount > 0) {
				Node temp = queue.poll();
				
				if(temp.left != null) {
					queue.offer(temp.left);
				} 
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				
				nodeCount--;
			}
		
		}
		
		return height;	
		
	}
	
	private static int heightUsingDelimeter(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		queue.offer(null);
		int height = 1;
		
		while(true) {
			
			Node temp = queue.poll();
			
			if(temp == null) {
				
				if(queue.isEmpty()) {
					break;
				} else {
					queue.offer(null);
					height++;
				}
			} else {
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}			
		}
		
		return height;
	}

}
