package com.kurshit.trees.binarytree.expressiontree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class InfixToTree {

	public static void main(String[] args) {

		String s = "a*b+c";
		CharNode ptr = build(s);
		postorder(ptr);

	}

	private static CharNode build(String s) {

		Stack<CharNode> nodeStack = new Stack<>();

		Stack<Character> charStack = new Stack<>();

		CharNode t, t1,t2;

		//Map<Character, Integer> priorityMap = new HashMap<>();

		int[] p = new int[150];
		p['+'] = 1;
		p['-'] = 1;
		p['*'] = 2;
		p['/'] = 2;
		p['^'] = 3;
		p[')'] = 0;

		//		priorityMap.put('+', 1);
		//		priorityMap.put('-', 1);
		//		priorityMap.put('*', 2);
		//		priorityMap.put('/', 2);
		//		priorityMap.put('^', 3);
		//		priorityMap.put(')', 0);
		//		
		for(int i =0; i < s.length(); i++) {
			char currChar= s.charAt(i);
			if(currChar == '(') {
				charStack.push(s.charAt(i));
			} else if(isAlphabet(currChar)) {
				t = new CharNode(currChar);
				nodeStack.push(t);
			} else if(p[currChar] > 0) {
				while(!charStack.isEmpty() && charStack.peek() != '(' && 
						((currChar != '^' && p[charStack.peek()] >= p[currChar]) 
								|| (currChar == '^'
								&& p[charStack.peek()] > p[currChar]))) {

					t = new CharNode(charStack.pop()); 

					// Get and remove the top element 
					// from the node stack 
					t1 = nodeStack.pop(); 

					// Get and remove the currently top 
					// element from the node stack 
					t2 = nodeStack.pop(); 

					// Update the tree 
					t.left = t2; 
					t.right = t1; 

					// Push the node to the node stack 
					nodeStack.push(t);

				}
				charStack.push(currChar);
			} else if(currChar == ')') {
				while (!charStack.empty() && charStack.peek() != '(')  
	            { 
	                t = new CharNode(charStack.pop()); 
	                
	                t1 = nodeStack.pop(); 
	                
	                t2 = nodeStack.pop();
	                
	                t.left = t2; 
	                t.right = t1; 
	                nodeStack.push(t); 
	            } 
	            charStack.pop(); 
			}
		}

		t = nodeStack.pop();
		return t;
	}

	private static boolean isAlphabet(char currChar) {
		
		return currChar >= 'a' && currChar <='z';
	}
	
	public static void postorder(CharNode root) {
		if(root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + " ");
	}



}

class CharNode {
	char val;
	CharNode left, right;

	public CharNode(char val) {
		this.val = val;
	}
}
