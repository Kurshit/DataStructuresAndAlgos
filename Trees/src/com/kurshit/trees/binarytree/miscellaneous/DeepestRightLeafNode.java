package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.BTREE.Node;

public class DeepestRightLeafNode {
	
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
		
		System.out.println("Deepest right most leaf node is : " + deepsetRightLeafNode(btree.getRoot()));
		
	}
	
	public static Node deepsetRightLeafNode(Node root) {
		
		if(root == null)
			return null;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		Node result = null;
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
				result = temp.right;
			}
		}
		
		return result;
	}

}
