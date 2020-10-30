package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class LargestValueAtEachLevel {

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
		
		levelWithMaxNodes(btree.getRoot());

	}
	
	
	public static void levelWithMaxNodes(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		int nodeCount = 0;
		
		int levelWithMaxNode = Integer.MIN_VALUE;
		int maxNodesAaLevel = Integer.MIN_VALUE;
		
		int level = 1;
		
		
		while(true) {
			
			nodeCount = queue.size();			
			
			if(nodeCount == 0)
				break;			
			
			int maxAtLevel = Integer.MIN_VALUE;
			
			while(nodeCount > 0) {
				
				Node temp = queue.poll();
				
				if(temp.data > maxAtLevel) 
					maxAtLevel = temp.data;
				
				if(temp.left != null)
					queue.offer(temp.left);
						
				
				if(temp.right != null)
					queue.offer(temp.right);
				
				nodeCount--;
			}
			
			System.out.println("Largest value at Level " + level + " is : " + maxAtLevel);	
			
			level++;			
			
		}			
	}	
}
