package com.kurshit.trees.binarytree.summation;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class SumOfAllLeftLeaves {

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
		
		System.out.println("Sum of all left leaves using recusrion is : " + sumOfAllLeftLeaves(btree.getRoot()));
		System.out.println("Sum of all left leaves using Iterative approach is : " + sumOfAllLeftLeavesIteratively(btree.getRoot()));

	}
	
	public static int sumOfAllLeftLeaves(Node root) {
		Result result = new Result();
		sumOfAllLeftLeaves(root, result, false);
		return result.sum;
	}
	
	
	
	public static void sumOfAllLeftLeaves(Node root, Result result, boolean isLeft) {
		
		if(root == null)
			return;
		
		if(root.left == null && root.right == null && isLeft) {
			result.sum = result.sum + root.data;
		}
		
		sumOfAllLeftLeaves(root.left, result, true);
		sumOfAllLeftLeaves(root.right, result, false);
			
	}
	
	public static int sumOfAllLeftLeavesIteratively(Node root) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		int sum = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left != null) {
				
				if(temp.left.left == null && temp.left.right == null) {
					sum = sum + temp.left.data;
				}
				
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}
		
		return sum;
		
	}
	
	private static class Result {
		int sum;
	}
}


