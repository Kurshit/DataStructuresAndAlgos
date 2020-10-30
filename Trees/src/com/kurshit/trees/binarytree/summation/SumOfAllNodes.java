package com.kurshit.trees.binarytree.summation;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class SumOfAllNodes {

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
		
		sumOfAllNodes(btree.getRoot());
		System.out.println("Using static variable: " + sum);
		
		System.out.println("Using Result object : " + sumOfAllNodesUsingSumObject(btree.getRoot()));
		
		System.out.println("Using iterative approach : " + sumOfAllNodesIteratively(btree.getRoot()));
	}
	
	static int sum = 0;
	
	public static void sumOfAllNodes(Node root) {
		
		if(root == null)
			return;
		
		sum = sum + root.data;
		
		sumOfAllNodes(root.left);
		sumOfAllNodes(root.right);
		
	}
	
	public static int sumOfAllNodesUsingSumObject(Node root) {
		
		Result sum = new Result();
		
		sumOfAllNodes(root, sum);
		
		return sum.sum;
	}
	
	public static void sumOfAllNodes(Node root, Result sum) {
		
		if(root == null)
			return;
		
		sum.sum = sum.sum + root.data;
		
		sumOfAllNodes(root.left, sum);
		sumOfAllNodes(root.right, sum);
	}
	
	public static int sumOfAllNodesIteratively(Node root) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		int result = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			result = result + temp.data;
			
			if(temp.left != null)
				queue.offer(temp.left);
			
			if(temp.right != null)
				queue.offer(temp.right);
		}
		
		return result;
	}
	
	private static class Result {
		int sum;
	}
}

