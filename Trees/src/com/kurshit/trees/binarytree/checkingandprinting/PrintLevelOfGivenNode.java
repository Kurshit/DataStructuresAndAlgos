package com.kurshit.trees.binarytree.checkingandprinting;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class PrintLevelOfGivenNode {

	public int levelOfGivenNode(Node root, int data) {

		return levelOfGivenNodeRecursively(root,data, 1);

	}

	public int levelOfGivenNodeRecursively(Node root, int data, int level) {

		if(root == null)
			return 0;

		if(root.data == data) 
			return level;

		int resultLevel = levelOfGivenNodeRecursively(root.left, data, level + 1); 

		if(resultLevel != 0)
			return resultLevel;

		return levelOfGivenNodeRecursively(root.right, data, level +1);

	}
	
	public int levelOfGivenNodeIterativelyUsingDelim(Node root, int data) {
		
		
		if(root == null)
			return 0;
		
		int level = 1;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp == null) {
				if(!queue.isEmpty()) {
					level++;
					queue.offer(null);
				}
			}
			else {
				
				if(temp.data == data)
					return level;
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);		
				
			}
			
		}
		
		return 0;
		
	}
	
	public int levelOfGivenNodeIterativelyUsingNodeCount(Node root, int data) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		int level = 0;
		
		while(true) {			
			
			int nodeCount = queue.size();
			
			if(nodeCount == 0)
				break;
			
			level++;		
		
			
			while(nodeCount > 0) {
				Node temp = queue.poll();
				
				if(temp.data == data)
					return level;
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);
				
				nodeCount--;
			}
			
		}
		
		return 0;
	}
	
	public int levelOfGivenNodeIterativelyUsingHeightApproach(Node root, int data) {
		
		int h = height(root);
		
		for(int i = 1; i <= h; i++) {
			
			if(foundAtGivenH(root, data, i)) {
				return h;
			}
		}
		
		return 0;
		
	}
	
	public boolean foundAtGivenH(Node root, int data, int level) {
		
		if(root == null)
			return false;
		
		if(level == 1) {
			if(root.data == data)
				return true;
		}
		
		return foundAtGivenH(root.left, data, level - 1) || foundAtGivenH(root.right, data, level - 1);
		
	}
	
	public int height(Node root) {
		if(root == null)
			return 0;
		
		int lh = 1 + height(root.left);
		int rh = 1 + height(root.right);
		
		return Math.max(lh, rh);
	}

	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */

		PrintLevelOfGivenNode level = new PrintLevelOfGivenNode();
		int data = 7;
		System.out.println("Level of node " + data + " is :" +level.levelOfGivenNode(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Delim approach is :" +level.levelOfGivenNodeIterativelyUsingDelim(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Node Count approach is :" +level.levelOfGivenNodeIterativelyUsingNodeCount(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Height Count approach is :" +level.levelOfGivenNodeIterativelyUsingHeightApproach(btree.root, data));
		
		
		System.out.println("--------------------------------------------------------------------------");
		
		data = 50;
		System.out.println("Level of node " + data + " is :" +level.levelOfGivenNode(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Delim approach is :" +level.levelOfGivenNodeIterativelyUsingDelim(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Node Count approach is :" +level.levelOfGivenNodeIterativelyUsingNodeCount(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Height Count approach is :" +level.levelOfGivenNodeIterativelyUsingHeightApproach(btree.root, data));
		
		System.out.println("--------------------------------------------------------------------------");
		
		data = 10;
		System.out.println("Level of node " + data + " is :" +level.levelOfGivenNode(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Delim approach is :" +level.levelOfGivenNodeIterativelyUsingDelim(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Node Count approach is :" +level.levelOfGivenNodeIterativelyUsingNodeCount(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Height Count approach is :" +level.levelOfGivenNodeIterativelyUsingHeightApproach(btree.root, data));
		
		System.out.println("--------------------------------------------------------------------------");
		
		data = 456;
		System.out.println("Level of node " + data + " is :" +level.levelOfGivenNode(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Delim approach is :" +level.levelOfGivenNodeIterativelyUsingDelim(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Node Count approach is :" +level.levelOfGivenNodeIterativelyUsingNodeCount(btree.root, data));
		System.out.println("Level of node " + data + " using Iterative Height Count approach is :" +level.levelOfGivenNodeIterativelyUsingHeightApproach(btree.root, data));
		
		System.out.println("--------------------------------------------------------------------------");		
		
		data = 456;
		System.out.println("Level of node " + data + " is :" +level.levelOfGivenNode(null, data));
		System.out.println("Level of node " + data + " using Iterative Delim approach is :" +level.levelOfGivenNodeIterativelyUsingDelim(null, data));
		System.out.println("Level of node " + data + " using Iterative Node Count approach is :" +level.levelOfGivenNodeIterativelyUsingNodeCount(null, data));
		System.out.println("Level of node " + data + " using Iterative Height Count approach is :" +level.levelOfGivenNodeIterativelyUsingHeightApproach(null, data));
		
		System.out.println("--------------------------------------------------------------------------");
	}

}
