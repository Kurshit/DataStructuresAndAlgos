package com.kurshit.trees.binarytree.bst;

import java.util.Stack;

public class IsGivenPreorderBST {

	public static void main(String[] args) {

		int[] pre = {5, 2, 1, 3, 6};
		
		/*
		 * 			5
		 * 		 /	   \
		 * 		2		6
		 * 	   /  \
		 *    1   3 
		 *		  	
		 */

		//System.out.println(verifyPreorder(pre));
		System.out.println(verifyPreorderUsingStack(pre));


	}


	/*
	 * Approach 1 : Using stack  
	 * 
	 */

	public static boolean verifyPreorderUsingStack(int[] preorder) {
		int low = Integer.MIN_VALUE;
		Stack<Integer> path = new Stack<>();
		for (int p : preorder) {
			
			if (p < low)
				return false;
			
			while (!path.empty() && p > path.peek())
				low = path.pop();
			
			path.push(p);
		}
		
		return true;
	}

	/*
	 * Approach 2 : Without using extra space
	 * 
	 *  TC : O(N)
	 *  SC : O(1)
	 * 
	 */

	public static boolean verifyPreorder(int[] preorder) {
		
		int low = Integer.MIN_VALUE, i = -1;
		
		for (int p : preorder) {
			
			if (p < low)
				return false;
			
			while (i >= 0 && p > preorder[i]) {
				low = preorder[i];
				i--;
			}
			
			i++;
			preorder[i] = p;
		}
		
		return true;
	}

	/*
	 * Approach 3: Using two stacks
	 * 
	 */

	public boolean verifyPreorderUsingTwoStacks(int[] preorder) {
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> inorder = new Stack<>();

		for(int v : preorder){
		
			if(!inorder.isEmpty() && v < inorder.peek())
				return false;
			
			while(!stack.isEmpty() && v > stack.peek()){
				inorder.push(stack.pop());
			}
			stack.push(v);
			
		}
		
		return true;
	}

}
