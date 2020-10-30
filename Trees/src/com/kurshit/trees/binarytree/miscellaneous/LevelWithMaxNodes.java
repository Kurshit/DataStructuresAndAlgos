package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class LevelWithMaxNodes {

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
			
			if(nodeCount > maxNodesAaLevel) {
				levelWithMaxNode = level;
				maxNodesAaLevel = nodeCount;
			}
			
			while(nodeCount > 0) {
				Node temp = queue.poll();
				
				if(temp.left != null)
					queue.offer(temp.left);
						
				
				if(temp.right != null)
					queue.offer(temp.right);
				
				nodeCount--;
			}
			level++;
		}	
		
		System.out.println("Level with max nodes " + maxNodesAaLevel + " is : " + levelWithMaxNode);		
		
	}
}
