package com.kurshit.trees.binarytree.path;

import java.util.ArrayList;
import java.util.List;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;
import com.kurshit.trees.binarytree.miscellaneous.HeightOfATree;

/*
 * Problem Statement : Print deepest Root to Leaf path in Binary Tree.
 * 
 *  If there are many deep node paths, print them all
 */

public class DeepestNodeRootToLeafPath {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		SampleBinaryTrees.createSumTree(btree);
		
		/*
		 * 								50
		 * 							/	     \
		 * 						  20		 30
		 * 					   /     \      /      \
		 *                   15       5    27       3
		 * 				  /      
		 * 				 15
		 * 
		 */	
		
		deepestNodeRootToLeafPath(btree.getRoot());
		
		BTREE btree1 = new BTREE();
		SampleBinaryTrees.createSampleBinaryTree1(btree1);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		deepestNodeRootToLeafPath(btree1.getRoot());
	}
	
	public static void deepestNodeRootToLeafPath(Node root) {
		List<Integer> pathList = new ArrayList<>();
		int targetLevel = HeightOfATree.height(root);
		deepestNodeRootToLeafPath(root, targetLevel, 1, pathList);
	}	
		
	private static void deepestNodeRootToLeafPath(Node root, int targetLevel, int currentLevel, List<Integer> pathList) {
		
		if(root == null)
			return;
		
		pathList.add(root.data);
		
		if(currentLevel == targetLevel) {
			printPath(pathList);
		}
		
		deepestNodeRootToLeafPath(root.left, targetLevel, currentLevel + 1, pathList);
		deepestNodeRootToLeafPath(root.right, targetLevel, currentLevel + 1, pathList);	
		
		pathList.remove(pathList.size() - 1);	
		
	}

	private static void printPath(List<Integer> pathList) {
		
		for(int i : pathList) {
			System.out.print(i + " ");
		}
		
		System.out.println();		
	}
}
