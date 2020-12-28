package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.bst.BST;
import com.kurshit.trees.binarytree.bst.BST.Node;

public class KthSmallestInBST {

	public static void main(String[] args) {
		BST btree = new BST();
		
		btree.createSampleTree();

		/*
		 * 							  50
		 * 					     /         \
 		 *  				 30               70
		 *              /         \      /         \
		 *           20           40   60            80
		 *        /      \     /   \              /      \
		 *      15      25   35     45          75        85
		 *     / 
		 *    10  
		 *      
		 */
		btree.inorder();
		int K = 2;
		System.out.println(getKthSmallestInBST(btree.root, K));
		K = 3;
		System.out.println(getKthSmallestInBST(btree.root, K));
		K = 9;
		System.out.println(getKthSmallestInBST(btree.root, K));

	}
	
	public static int getKthSmallestInBST(Node root, int K) {
			
		return inorder(root, K, new Result());	
		
	}
	
	public static int inorder(Node root, int K, Result r) {
		if(root == null) {
			return 0;
		}
		
		int result = inorder(root.left, K, r);
		
		if(result != 0) {
			return result;
		}
		
		r.curr++;
		
		if(r.curr == K) {
			return root.data;
		}
		
		return inorder(root.right, K, r);
	}

}

class Result {
	int curr;
}