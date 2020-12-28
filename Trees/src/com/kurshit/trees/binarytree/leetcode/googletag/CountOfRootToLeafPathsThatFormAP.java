package com.kurshit.trees.binarytree.leetcode.googletag;

import java.util.ArrayList;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

/*
 * https://www.geeksforgeeks.org/count-of-root-to-leaf-paths-in-a-binary-tree-that-form-an-ap/
 * 
 * Given a Binary Tree, the task is to count all paths from root to leaf which forms an Arithmetic Progression.
 * 
 * AP can be on any side
 * 
 */

public class CountOfRootToLeafPathsThatFormAP {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTreeAP();
		System.out.println(countAP(btree.root));
		
		/*
		 * 								1
		 * 							/	     \
		 * 						  3			   6
		 * 					   /     \       /      \
		 *                   5       7     11       23
		 * 				  
		 * 				 
		 */


	}
	
	/*
	 * DO the preorder traversal and store all series and check if it forms AP
	 */
	
	public static int countAP(Node root) {
		
		return countAP(root, new ArrayList<Integer>());
	}

	private static int countAP(Node root, ArrayList<Integer> list) {
		
		if(root == null)
			return 0;
		
		list.add(root.data);
		
		if(root.left == null && root.right == null) {
			if(check(list)) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int x = countAP(root.left, list);
		int y = countAP(root.right, list);
		
		return x + y;
	}
	
	static boolean check(ArrayList<Integer> arr)  
	{  
	    if (arr.size() == 1)  
	        return true;  
	  
	    // If size of arr is greater than 2  
	    int d = arr.get(1) - arr.get(0); 
	  
	    for(int i = 2; i < arr.size(); i++)  
	    {  
	        if (arr.get(i) - arr.get(i - 1) != d)  
	            return false;  
	    }  
	    return true;  
	}  

}
