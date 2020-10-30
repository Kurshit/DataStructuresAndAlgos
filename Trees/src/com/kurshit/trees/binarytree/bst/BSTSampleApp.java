package com.kurshit.trees.binarytree.bst;

public class BSTSampleApp {
	
	

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.add(40);
		bst.add(60);
		bst.add(20);
		bst.add(30);
		bst.add(10);
		bst.add(80);
		bst.add(70);
		bst.add(100);
		bst.add(5);
		bst.add(120);
		bst.inorder();
		
		System.out.println(bst.search(100));
		System.out.println(bst.search(1000));
		
		bst.delete(80);
		
		bst.inorder();

	}

}
