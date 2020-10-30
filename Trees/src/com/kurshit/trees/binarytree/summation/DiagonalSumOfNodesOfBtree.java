package com.kurshit.trees.binarytree.summation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.BTREE.Node;

public class DiagonalSumOfNodesOfBtree {
	
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
		
		diagonalSumOfBtree(btree.getRoot());

	}
	
	public static void diagonalSumOfBtree(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		Map<Integer, Integer> map = new TreeMap<>();
		root.vd = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			int currentVd = temp.vd; 
			
			if(map.containsKey(currentVd)) {
				map.put(currentVd, map.get(currentVd) + temp.data);
			} else {				
				map.put(currentVd, temp.data);
				
			}
			
			if(temp.left != null) {
				temp.left.vd = temp.vd + 1;
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				temp.right.vd = temp.vd;
				queue.offer(temp.right);
			}			
		}
		
		for(Map.Entry<Integer, Integer> eachEntry : map.entrySet()) {
			
			System.out.print(eachEntry.getValue() + " ");
		}
		System.out.println();
		
	}

}
