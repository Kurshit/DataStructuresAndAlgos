package com.kurshit.trees.binarytree.checkingandprinting;

import java.util.LinkedList;
import java.util.Queue;

import com.kurshit.trees.binarytree.BTREE;
import com.kurshit.trees.binarytree.BTREE.Node;

public class PrintSumOfAllNodes {


	public int sumAllStraight(Node root) {

		if(root == null)
			return 0;

		return root.data + sumAllStraight(root.left) + sumAllStraight(root.right); 
	}


	public int sumAll(Node root) {

		int sum = 0;

		sum = sumAll(root,sum);

		return sum;
	}

	public int sumAll(Node root, int sum) {

		if(root == null)
			return 0;

		sum =  sum + root.data + sumAll(root.left, sum) + sumAll(root.right, sum);

		return sum;

	}
	
	public int sumAllIterative(Node root) {
		
		if(root == null)
			return 0;
		
		int totalSum = 0;
		
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			totalSum = totalSum  + temp.data;
			
			if(temp.left != null) 
				queue.offer(temp.left);
			
			if(temp.right != null)
				queue.offer(temp.right);
			
		}		
		
		return totalSum;
		
		
		
	}

	public static void main(String[] args) {

		BTREE btree = new BTREE();

		btree.createUncoveredCoveredSumTree();

		PrintSumOfAllNodes sumAll = new PrintSumOfAllNodes();

		System.out.println("Sum Using not so straight is : "+ sumAll.sumAll(btree.root));

		System.out.println("Sum using straight is : " + sumAll.sumAllStraight(btree.root));
		
		System.out.println("Sum using iterative is : " + sumAll.sumAllIterative(btree.root));

	}

}
