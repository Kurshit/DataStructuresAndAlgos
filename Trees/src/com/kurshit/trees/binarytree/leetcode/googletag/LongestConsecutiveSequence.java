package com.kurshit.trees.binarytree.leetcode.googletag;

import com.kurshit.trees.binarytree.BTREE.Node;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int longestConsecutive(Node root) {
		if(root == null)
			return 0;
		Result1 r = new Result1();
		longestConsecutive(root, root.data, 0, r);
		return r.max;
	}

	private static void longestConsecutive(Node root, int expected, int currLength,  Result1 r) {
		
		if(root == null)
			return;
		
		if(root.data == expected) {
			currLength++;
		} else {
			currLength = 1;
		}
		
		r.max = Math.max(r.max, currLength);
		longestConsecutive(root.left, root.data + 1, currLength, r);
		longestConsecutive(root.right, root.data + 1, currLength, r);
		
	}

}

class Result1 {
	int max;
}