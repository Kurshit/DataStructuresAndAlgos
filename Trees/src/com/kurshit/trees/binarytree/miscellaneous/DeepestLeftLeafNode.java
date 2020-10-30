package com.kurshit.trees.binarytree.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.BTREE.Node;

public class DeepestLeftLeafNode {

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

		System.out.println("Deepest left most leaf node is : " + deepestLeftLeafNode(btree.getRoot()));

	}
	
	private static Node result;

	public static Node deepestLeftLeafNode(Node root) {
		
		Level level = new Level();
		deepestLeftLeafNode(root, 0, level, false);
				
		return result;
	}
	
	public static void deepestLeftLeafNode(Node root, int currentLevel, Level maxLevel, boolean isLeft) {
		
		if(root == null)
			return;
		
		if(isLeft && currentLevel > maxLevel.level && root.left == null && root.right == null) {
				result = root;
				maxLevel.level = currentLevel;			
		}
		
		deepestLeftLeafNode(root.left, currentLevel + 1, maxLevel, true);
		deepestLeftLeafNode(root.right, currentLevel + 1, maxLevel, false);
	}

}

class Level {
	int level;
}
