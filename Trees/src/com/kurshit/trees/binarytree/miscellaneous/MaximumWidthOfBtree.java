package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.BTREE.Node;

public class MaximumWidthOfBtree {



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
		
		System.out.println(maxWidthOfBtreeIteratively(btree.getRoot()));


	}	

	public static int maxWidthOfBtreeIteratively(Node root) {

		if(root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);
		queue.offer(null);
		int maxWidth = 0;
		int nodeCount = 0;
		while(!queue.isEmpty()) {

			Node temp = queue.poll();


			if(temp == null) {
				
				if(queue.isEmpty()) 
					break;
				else {					
					if(nodeCount > maxWidth)
						maxWidth = nodeCount;
					nodeCount = 0;
					queue.offer(null);
				}
			} else {

				nodeCount = nodeCount + 1;

				if(temp.left != null) {
					queue.offer(temp.left);
				} 

				if(temp.right != null) {
					queue.offer(temp.right);
				}


			}

		}

		return maxWidth;
	}



}
