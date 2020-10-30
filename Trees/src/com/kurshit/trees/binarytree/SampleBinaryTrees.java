package com.kurshit.trees.binarytree;


public class SampleBinaryTrees {

	public static void createSampleBinaryTree1(BTREE btree) {

		btree.add(10);
		btree.add(5);
		btree.add(20);
		btree.add(9);
		btree.add(7);
		btree.add(30);
		btree.add(40);
		btree.add(70);
		btree.add(80);
		btree.add(50);
		btree.add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */



	}

	public static void createSampleBinaryTree5(BTREE btree) {

		btree.add(10);
		btree.add(5);
		btree.add(20);
		btree.add(9);
		btree.add(7);
		btree.add(30);
		btree.add(40);
		btree.add(70);
		btree.add(80);
		btree.add(50);
		btree.add(60);
		btree.add(100);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    /
		 * 				 70    80  50  60 100
		 */



	}


	public static void createSampleBinaryTree2(BTREE btree) {

		btree.add(10);
		btree.add(5);
		btree.add(20);
		btree.add(9);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     
		 *                   9       
		 * 		
		 */



	}

	//WIth duplicateLeafNode

	public static void createSampleBinaryTree3(BTREE btree) {

		btree.add(10);
		btree.add(5);
		btree.add(20);
		btree.add(9);
		btree.add(7);
		btree.add(30);
		btree.add(40);
		btree.add(50);
		btree.add(80);
		btree.add(50);
		btree.add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */



	}

	public static void createSampleBinaryTree4(BTREE btree) {

		btree.add(10);
		btree.add(5);
		btree.add(20);
		btree.add(9);
		btree.add(7);
		btree.add(30);
		btree.add(40);
		btree.add(50);
		btree.add(80);
		btree.add(50);
		btree.add(60);

		btree.add(70);
		btree.add(80);
		btree.add(90);
		btree.add(100);

		btree.add(110);
		btree.add(120);
		btree.add(130);
		btree.add(140);


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



	}


	public static void createSumTree(BTREE btree) {

		btree.add(50);
		btree.add(20);
		btree.add(30);
		btree.add(15);
		btree.add(5);
		btree.add(27);
		btree.add(3);
		btree.add(15);


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



	}

	public static void createSumTreeLeftRight(BTREE btree) {

		btree.add(26);
		btree.add(10);
		btree.add(3);
		btree.add(4);
		btree.add(6);
		btree.add(3);		

		/*
		 *
		 *     	  	  26
		 *   		/   \
		 * 		   10     3
		 *		 /    \     \
		 *		4      6      3
		 *
		 */



	}
	
	

}
