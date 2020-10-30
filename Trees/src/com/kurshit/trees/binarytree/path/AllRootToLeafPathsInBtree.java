package com.kurshit.trees.binarytree.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;
import com.kurshit.trees.binarytree.SampleBinaryTrees;

/*
 * Problem Statement: Given a root of a tree, print out all of its root-to-leaf paths one per line.
 * 
 * Source : https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/ 
 *
 */

public class AllRootToLeafPathsInBtree {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		SampleBinaryTrees.createSampleBinaryTree1(btree);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /    \
		 *                   9       7     30      40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */
		
		System.out.println("1. Printing the result right away : \n ");
		allRootToLeafPaths(btree.getRoot());
		System.out.println();
		System.out.println("2. Storing all paths in List : \n");
		allRootToLeafPathsIntoList(btree.getRoot());
		System.out.println();
		System.out.println("3. Print paths iteratively : \n");
		allRootToLeafPathsIteratively(btree.getRoot());

	}
	
	/*
	 * Approach 1: Recursively, printing the path right away when leaf node is found
	 * 
	 */
	
	public static void allRootToLeafPaths(Node root) {
		
		List<Integer> paths = new ArrayList<>();
		
		allRootToLeafPaths(root, paths);
	}
	
	private static void allRootToLeafPaths(Node root, List<Integer> paths) {
		
		if(root == null)
			return;
		
		paths.add(root.data);
		
		if(root.left == null && root.right == null) {
			printPath(paths);
		}
		
		allRootToLeafPaths(root.left, paths);
		allRootToLeafPaths(root.right, paths);
		
		paths.remove(paths.size()-1);
	}
	
	private static void printPath(List<Integer> path) {
		
		for(int data : path) {
			System.out.print(data + " ");
		}
		
		System.out.println();
		
	}
	
	/*
	 * Approach 2. This method will return all paths in a List. 
	 */
	
	public static void allRootToLeafPathsIntoList(Node root) {
		
		List<Integer> paths = new ArrayList<>();
		List<List<Integer>> resultList = new ArrayList<>();
		
		allRootToLeafPathsIntoList(root, paths, resultList);
		
		resultList.stream()
				.forEach( result -> {
					result.stream()
							.forEach( e -> System.out.print(e + " "));
					
					System.out.println();
				});
	}	
	
	private static void allRootToLeafPathsIntoList(Node root, List<Integer> paths, List<List<Integer>> resultList) {
		
		if(root == null)
			return;
		
		paths.add(root.data);
		
		if(root.left == null && root.right == null) {
			resultList.add(paths);
		}
		
		allRootToLeafPaths(root.left, paths);
		allRootToLeafPaths(root.right, paths);
		
		paths.remove(paths.size()-1);
	}
	
	/*
	 * 3. This approach shows to print Root to leaf paths Iteratively.
	 * 	 
	 *  The idea is to traverse the tree in pre-order fasion using Stack and keeping parent of each node in 
	 * 	 a HashMap. Once Leaf node is encountered, we traverse back, using Map, from leaf not to root, pushing each node 
	 * 	 on a new stack. Then finally, print the stack elements.
	 * 
	 */
	
	public static void allRootToLeafPathsIteratively(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> preOrderStack = new Stack<>();
		preOrderStack.push(root);
		Map<Node, Node> parentMap = new HashMap<>();
		parentMap.put(root, null);
		
		/*
		 * In following while condition, unlike preorder tree traversal program, we don't need to check 
		 * both the condition - curr!=null and !stack.isEmpty(). Also, we will push the root 
		 * element right away in the stack.
		 * Idea here differs from preorder of B-Tree Iteratively- We will ensure all nodes are pushed into stack and will only
		 * check if current popped node is Leaf or not. If leaf, we will go and print the path. So, we will just ignore if popped
		 * node from stack if non-leaf and we act only if popped node is Leaf - because at this point we already know that our map has
		 * all the mappings of child and parent in that route. 
		 * 
		 * Also, we will ensure that we do not push NULL onto stack. by comparing left and right child of current node with
		 * whnull and then only pushing it.
		 * 
		 * While doing so, we will ensure to maintain mapping of parent and child.
		 *  
		 */
		
		while(!preOrderStack.isEmpty()) {
			
			Node current = preOrderStack.pop();
					
			if(current.left == null && current.right == null) {
				printCurrentPath(current, parentMap);
			}
			
			/*
			 * Order does not matter. Putting right child first into stack just to print path from left to right 
			 * side of tree.
			 */
			
			if(current.right != null) {
				preOrderStack.push(current.right);
				parentMap.put(current.right, current);
			}
			
			if(current.left != null) {
				preOrderStack.push(current.left);
				parentMap.put(current.left, current);				
			}			
			
		}
		
	}

	private static void printCurrentPath(Node current, Map<Node, Node> parentMap) {
		
		Stack<Node> pathStack = new Stack<>();
		
		while(current != null) {
			pathStack.push(current);
			current = parentMap.get(current);
		}
		
		while(!pathStack.isEmpty()) {
			current = pathStack.pop();
			System.out.print(current + " ");
		}
		System.out.println();
	}
}
