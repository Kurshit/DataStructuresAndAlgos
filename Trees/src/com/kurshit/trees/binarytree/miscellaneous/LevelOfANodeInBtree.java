package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class LevelOfANodeInBtree {

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

		int key = 7;
		System.out.println("Level of " + key + " is :" + (levelOfANode(btree.getRoot(), key) + 1));
		System.out.println("Level of " + key + " Iteratively is :" + levelOfANodeIteratively(btree.getRoot(), key));
		System.out.println("Level of " + key + " Using Delimeter is :" + levelOfANodeUsingDelimeter(btree.getRoot(), key));
	}

	public static int levelOfANode(Node root, int key) {

		return levelOfANode(root, key, 0);

	}

	public static int levelOfANode(Node root, int key, int currentLevel) {

		if(root == null)
			return 0;

		if(root.data == key)
			return currentLevel;

		int result = levelOfANode(root.left, key, currentLevel + 1);

		if(result != 0)
			return result;

		return levelOfANode(root.right, key, currentLevel + 1);

	}

	public static int levelOfANodeIteratively(Node root, int key) {

		if(root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);
		int level = 0;

		while(true) {			

			int nc = queue.size();

			if(nc == 0)
				break;
			
			level++;
			
			while(nc > 0) {
				
				Node temp = queue.poll();
				
				if(temp.data == key)
					return level;
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);
				
				nc--;
			}	


		}

		return 0;
	}
	
	public static int levelOfANodeUsingDelimeter(Node root, int key) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		queue.offer(null);
		int level = 1;
		while(true) {
			
			Node temp = queue.poll();
			
			if(temp == null) {
				
				if(queue.isEmpty()) {
					return 0;
				}
				
				level++;
				queue.offer(null);
			} else {
				
				if(temp.data == key)
					return level;
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}
			
		}
		
		
	}
}
