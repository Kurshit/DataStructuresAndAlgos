package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class CountLeafNode {

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
		 */
		
		countLeafNodes(btree.getRoot());
		System.out.println("No of leaf nodes in BTREE are : " + count);
		int result = coundLeafNodeIteratively(btree.getRoot());
		System.out.println("No of leaf nodes in BTREE using Iterative approach are : " + result);

	}
	public static int count;
	
	public static void countLeafNodes(Node root) {
		
		if(root == null)
			return;
		
		if(root.left == null && root.right == null) {
			count++;
		}
		
		countLeafNodes(root.left);
		countLeafNodes(root.right);
		
	}
	
	public static int coundLeafNodeIteratively(Node root) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		int leafCount = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left == null && temp.right == null) {
				leafCount++;
			}
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
			
		}
		
		return leafCount;	
	
	}

}
