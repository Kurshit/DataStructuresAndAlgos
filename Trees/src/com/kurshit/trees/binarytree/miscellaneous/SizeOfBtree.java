package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

/*
 * This program is to calculate size of a tree using recursion and without using recursion.
 */

public class SizeOfBtree {
	
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

		
		System.out.println("Size of given binary tree using recusrion is : " + size(btree.getRoot()));
		
		System.out.println("Size of given binary tree using iterative approach is : " + sizeIteratively(btree.getRoot()));
				
	}
	
	public static int size(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		return size(newRoot.left) + size(newRoot.right) + 1;
	}
	
	public static int sizeIteratively(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		
		int size = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			size++;
			
			if(temp.left != null)
				queue.offer(temp.left);
			
			if(temp.right != null)
				queue.offer(temp.right);			
		}
		
		return size;
		
	}

}
