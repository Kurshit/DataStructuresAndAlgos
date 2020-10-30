package com.kurshit.trees.binarytree.constructionandconversion;

import java.util.Scanner;

import com.kurshit.trees.binarytree.bst.BST;
import com.kurshit.trees.binarytree.bst.BST.Node;


public class PreOrderToTree {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		
		System.out.println(i);
		
		BST bst = new BST();
		
		int[] arr = {10,5,1,7,14,12,15};
		
		PreOrderToTree preToBST = new PreOrderToTree();
		
		//Node root = preToBST.preOrderToBST(arr, new Index(), 0, arr.length - 1, arr.length);
		
		Node root = preToBST.preOrderToBSTMethod2(arr, new Index(), arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE, arr.length);
		
		bst.inorderNode(root);
		scan.close();

	}
	
	public Node preOrderToBST(int[] pre, Index preIndex, int low, int high, int size) {
		// Base case 
        if (preIndex.index >= size || low > high) { 
            return null; 
        } 
  
        // The first node in preorder traversal is root. So take the node at 
        // preIndex from pre[] and make it root, and increment preIndex 
        Node root = new Node(pre[preIndex.index]); 
        preIndex.index = preIndex.index + 1; 
  
        // If the current subarry has only one element, no need to recur 
        if (low == high) { 
            return root; 
        } 
  
        // Search for the first element greater than root 
        int i; 
        for (i = low; i <= high; ++i) { 
            if (pre[i] > root.data) { 
                break; 
            } 
        } 
  
        // Use the index of element found in preorder to divide  
        // preorder array in two parts. Left subtree and right subtree 
        root.left = preOrderToBST(pre, preIndex, preIndex.index,  
                                      i - 1, size); 
        root.right = preOrderToBST(pre, preIndex, i, high, size); 
  
        return root; 
	}
	
	//O(n)
	
	Node preOrderToBSTMethod2(int pre[], Index preIndex, int key, 
            int min, int max, int size) { 
  
        // Base case 
        if (preIndex.index >= size) { 
            return null; 
        } 
  
        Node root = null; 
  
        // If current element of pre[] is in range, then 
        // only it is part of current subtree 
        if (key > min && key < max) { 
  
            // Allocate memory for root of this  
            // subtree and increment *preIndex 
            root = new Node(key); 
            preIndex.index = preIndex.index + 1; 
  
            if (preIndex.index < size) { 
  
                // Contruct the subtree under root 
                // All nodes which are in range {min .. key}  
                // will go in left subtree, and first such  
                // node will be root of left subtree. 
                root.left = preOrderToBSTMethod2(pre, preIndex,  
                            pre[preIndex.index], min, key, size); 
  
                // All nodes which are in range {key..max}  
                // will go in right subtree, and first such 
                // node will be root of right subtree. 
                root.right = preOrderToBSTMethod2(pre, preIndex,  
                             pre[preIndex.index], key, max, size); 
            } 
        } 
  
        return root; 
    } 

}

class Index {
	int index = 0;
}
