package com.kurshit.trees.binarytree.leetcode;

import java.util.ArrayList;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;


public class LCAInBTREE {
	
	public int lcaUsingArrayList(Node root, int n1, int n2) {
		
		ArrayList<Integer> pathN1 = new ArrayList<>();
		ArrayList<Integer> pathN2 = new ArrayList<>();
		
		boolean n1Path = hasPathAndGetPath(root,n1,pathN1);
		
		boolean n2Path = hasPathAndGetPath(root,n2,pathN2);
		
		if(!n1Path || !n2Path) {
			System.out.println("Invalid nodes");
			return -1;
		}
		
		int i;
		for(i = 0; i< pathN1.size() && i < pathN2.size(); i++) {
			
			if(pathN1.get(i) != pathN2.get(i)) {
				break;
			}
		}
		
		return pathN1.get(i - 1);
		
		
	}
	
	public boolean hasPathAndGetPath(Node root, int x, ArrayList<Integer> path) {
		
		if(root == null)
			return false;
		
		path.add(root.data);
		
		if(root.data== x) {
			return true;
		}
		
		if(hasPathAndGetPath(root.left, x, path) || hasPathAndGetPath(root.right, x, path)) {
			return true;
		}
		
		path.remove(path.size() - 1);
		
		return false;
		
	}
	
	
	public int lcaUsingRecursion(Node root, int n1, int n2) {
		
		
		if(root == null) 
			return -1;
		
		if(root.data == n1 || root.data == n2)
			return root.data;
		
		int lcaLeft = lcaUsingRecursion(root.left, n1, n2);
		
		int lcaRight = lcaUsingRecursion(root.right, n1, n2);
		
		if(lcaLeft != -1 && lcaRight != -1) {
			return root.data;
		}
		
		return lcaLeft == -1 ? lcaRight : lcaLeft;
	
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */

		
		LCAInBTREE lca = new LCAInBTREE();
		int n1 = 5; int n2 = 30;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
		
		n1 = 70; n2 = 20;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
		
		n1 = 5; n2 = 50;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
		
		n1 = 70; n2 = 60;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
		
		n1 = 30; n2 = 40;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
				
		n1 = 30; n2 = 150;
		System.out.println("LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingArrayList(btree.root, n1, n2));
		System.out.println("Recursion k sath LCA of "+ n1 + " , " + n2 + "  :" +lca.lcaUsingRecursion(btree.root, n1, n2));
		System.out.println();
	}

}
