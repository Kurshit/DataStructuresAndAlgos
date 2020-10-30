package com.kurshit.trees.binarytree.summation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;


/*
 *  This is same like Top View/ Bottom View Of tree approach. Except - 
 *  In this case, we will call it Vertical distance and for every left node of root, 
 *  we will add 1 to vertical distance and for every right node of root, we will keep
 *  verticle distance that of parents vertical distance. 
 *  
 *  i.e -   root.left.vd = root.vd + 1;
 *  	    root.right.vd = rood.vd
 *  
 *  While in Bottom/Top View we do - 
 *  
 *  		root.left.hd = root.hd - 1;
 *  		root.right.hd = root.hd + 1;
 *  
 */

public class DiagonalTraversalOfBtree {
	
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
		
		
		System.out.println("1. Iteratively : ");
		diagnonalTraversalOfBtree(btree.getRoot());
		
		System.out.println();
		
		System.out.println("2. Recursively : ");
		diagnonalTraversalOfBtreeRecursively(btree.getRoot());

	}
	
	public static void diagnonalTraversalOfBtree(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		Map<Integer, List<Node>> map = new TreeMap<>();
		root.vd = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			int currentVd = temp.vd; 
			
			if(map.containsKey(currentVd)) {
				map.get(currentVd).add(temp);
			} else {
				List<Node> tempList = new ArrayList<>();
				tempList.add(temp);
				map.put(currentVd, tempList);
				
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
		
		for(Map.Entry<Integer, List<Node>> eachEntry : map.entrySet()) {
			
			for(Node node : eachEntry.getValue()) {
				System.out.print(node.data + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public static void diagnonalTraversalOfBtreeRecursively(Node root) {
		
		Map<Integer, List<Node>> resultMap = new HashMap<>();
		diagnonalTraversalOfBtreeRecursively(root, 0, resultMap);
		
		for(Map.Entry<Integer, List<Node>> eachEntry : resultMap.entrySet()) {
			
			for(Node node : eachEntry.getValue()) {
				System.out.print(node.data + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void diagnonalTraversalOfBtreeRecursively(Node root, int currentVd, Map<Integer, List<Node>> map) {
		
		if(root == null)
			return;
		
		if(map.containsKey(currentVd)) {
			map.get(currentVd).add(root);
		} else {
			List<Node> tempList = new ArrayList<>();
			tempList.add(root);
			map.put(currentVd, tempList);			
		}
		
		diagnonalTraversalOfBtreeRecursively(root.left, currentVd + 1, map);
		diagnonalTraversalOfBtreeRecursively(root.right, currentVd, map);
	}
	
	

}
