package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class IsSumSameCoveredUncoveredNodes {
	
	
	public boolean isSumSameCoveredUncovered(Node root) {
		
		PrintSumOfAllNodes soan = new PrintSumOfAllNodes();
		
				
		if(root == null)
			return true;
		
		int totalSum = soan.sumAll(root);
		
		int unCoveredSum = unCoveredSum(root);
		
		return unCoveredSum == (totalSum - unCoveredSum); 
		
	}
	
	//this ain't working
	
	/*public int unCoveredSumIterative(Node root) {
		
		if(root == null)
			return 0;
		
		Node curr = root;
		
		int unCoveredSum = 0;
		
		while(curr.left != null || curr.right != null) {
			
			if(curr.left == null && curr.right != null) {
				unCoveredSum = unCoveredSum + curr.data;
				curr = curr.right;
			}
			
			unCoveredSum = unCoveredSum + curr.data;	
			
			if(curr.left != null) 
				curr = curr.left;
		}
		
		curr = root.right;
		
		while(curr.left != null || curr.right != null) {
			
			if(curr.right == null && curr.left != null) {
				unCoveredSum = unCoveredSum + curr.data;
				curr = curr.left;
			}
			
			unCoveredSum = unCoveredSum + curr.data;	
			
			if(curr.right != null) 
				curr = curr.right;
		}
		
		
						
		return unCoveredSum;
		
	}*/
	
	public int unCoveredSum(Node root) {
		
		if(root ==  null)
			return 0;
		
		int left = unCoveredLeft(root.left);
		int right = unCoveredRight(root.right);
		
		return left + right + root.data;
		
		
	}
	
	public int unCoveredLeft(Node root) {
		
		if(root.left == null && root.right == null)
			return root.data;
		
		if(root.left != null)
			return root.data + unCoveredLeft(root.left);
		else 
			return root.data + unCoveredLeft(root.right);
	}
	
	public int unCoveredRight(Node root) {
		
		if(root.left == null && root.right == null)
			return root.data;
		
		if(root.right != null)
			return root.data + unCoveredRight(root.right);
		else
			return root.data + unCoveredRight(root.left);
		
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createUncoveredCoveredSumTree();
		
		IsSumSameCoveredUncoveredNodes coveredUncoveredNodes = new IsSumSameCoveredUncoveredNodes();
		
		System.out.println("Is sum of Covered and Uncovered equals : " + coveredUncoveredNodes.isSumSameCoveredUncovered(btree.root));
		
		btree.clear();
		
		btree.createSampleBinaryTree1();
		
		System.out.println("Is sum of Covered and Uncovered equals : " + coveredUncoveredNodes.isSumSameCoveredUncovered(btree.root));
		
		System.out.println();
		
		// following iterative ain't working
		//System.out.println(coveredUncoveredNodes.unCoveredSumIterative(btree.root));
		
		

	}

}
