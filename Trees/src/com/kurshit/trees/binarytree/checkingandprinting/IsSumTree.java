package com.kurshit.trees.binarytree.checkingandprinting;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class IsSumTree {
	
	public boolean isSumTree(Node root) {
		
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		int left =0, right = 0;
		
		if(root.left != null)
			left = root.left.data;
		
		if(root.right != null)
			right = root.right.data;
		
		return root.data == left + right && isSumTree(root.left) && isSumTree(root.right);
		
		
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSumTree();
		
		IsSumTree ist = new IsSumTree();
		System.out.println("Given tree is sum tree :");
		System.out.println(ist.isSumTree(btree.root));
		
		System.out.println("Now tree is not sum tree :");
		
		btree.clear();
		
		btree.createSampleBinaryTree1();
		
		System.out.println(ist.isSumTree(btree.root));

	}

}
