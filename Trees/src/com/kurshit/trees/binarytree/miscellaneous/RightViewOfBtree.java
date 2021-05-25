package com.kurshit.trees.binarytree.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class RightViewOfBtree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		System.out.println(rightSideView(btree.root));

	}

	public static List<Integer> rightSideView(Node root) {
		List<Integer> list = new ArrayList<>();
		
		if(root == null)
			return list;
		MaxLevel m = new MaxLevel();
		rightSideViewUtil(root, list, m, 1); // pass 1 here
		return list;
		
		
	}

	private static void rightSideViewUtil(Node root, List<Integer> list, MaxLevel max, int currLevel) {
		
		if(root == null)
			return;
		
		if(currLevel > max.max) {
			max.max = currLevel;
			list.add(root.data);
		}
		
		rightSideViewUtil(root.right, list, max, currLevel + 1);
		rightSideViewUtil(root.left, list, max, currLevel + 1);
		
		
	}

}

class MaxLevel {
	int max;
}
