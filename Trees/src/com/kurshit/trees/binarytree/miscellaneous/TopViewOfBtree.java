package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

public class TopViewOfBtree {

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
		
		topViewOfBtree(btree.getRoot());
	}
	
	public static void topViewOfBtree(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		root.hd = 0;
		queue.add(root);
		
		Map<Integer, Integer > nodesMap = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(!nodesMap.containsKey(temp.hd))
				nodesMap.put(temp.hd, temp.data);
			
			if(temp.left != null) {
				temp.left.hd = temp.hd - 1;
				queue.offer(temp.left);
				
			}
			
			if(temp.right != null) {
				temp.right.hd = temp.hd + 1;
				queue.offer(temp.right);
				
			}
		}
		
		for (Map.Entry<Integer, Integer> nodes : nodesMap.entrySet() ) {
			
			System.out.print(nodes.getValue() + " ");
		}
					
	}

}
