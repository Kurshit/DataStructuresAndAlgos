package com.kurshit.trees.binarytree.path;

import java.util.ArrayList;
import java.util.List;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

/*
 *  Problem is to find Root to Leaf path whose sum along the path equals to given Target Sum.
 *  
 *  The problem can also be used with other problem where - 
 *  
 *  Find and print the Root to Leaf longest path. The path is longest whose sum is largest from root to leaf.
 *  
 *  In this problem, we can first find largest sum and then using largest sum as Target sum, we can find path using 
 *  problem given below.
 *  
 */

public class RootToLeafPathForGivenTotalSum {

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
		
		int targetSum = 104; 
		
		pathForGivenSum(btree.getRoot(), targetSum);
		System.out.println(allPathForGivenSum(btree.root, targetSum));
		
		BTREE btree1 = new BTREE();
		
		SampleBinaryTrees.createSampleBinaryTree4(btree1);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \   / \     / \  
		 * 				 50    80  50  60 70 80  90  100
		 * 				/  \  /   \
		 * 			 110  120 130 140
		 * 
		 */
		
		targetSum = 244;
		pathForGivenSum(btree1.getRoot(), targetSum);
		System.out.println(allPathForGivenSum(btree1.root, targetSum));
		
	}
	
	public static void pathForGivenSum(Node root, int targetSum) {
		
		List<Integer> pathList = new ArrayList<>();
		
		if(pathForGivenSum(root, targetSum, pathList)) {
			System.out.println(pathList);
		} else {
			System.out.println("Not found");
		}
	}

	private static boolean pathForGivenSum(Node root, int targetSum, List<Integer> pathList) {
		
		if(root == null)
			return false;
		
		pathList.add(root.data);
		
		if(root.left == null && root.right == null && root.data == targetSum) {
			return true;
		}
		
		targetSum = targetSum - root.data;
	
		boolean result = pathForGivenSum(root.left, targetSum, pathList); 
		
		if(result)
			return true;
		
		result = pathForGivenSum(root.right, targetSum, pathList);
		
		if(result)
			return true;
		
		pathList.remove(pathList.size() - 1);
		
		return false;
	}
	
	public static List<List<Integer>> allPathForGivenSum(Node root, int targetSum) {
		
		List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        paths(root, result, list, targetSum);
        return result;
        
	}
	
	public static void paths(Node root, List<List<Integer>> result, List<Integer> list, int targetSum) {
        
        if(root == null)
            return;
        
        list.add(root.data);
        
        if(targetSum == root.data) {            
            result.add(new ArrayList<Integer>(list));
        }
        targetSum = targetSum - root.data;
        paths(root.left, result, list, targetSum);
        paths(root.right, result, list, targetSum );
        
        list.remove(list.size() - 1);
        targetSum = targetSum + root.data;
    }
	

}
