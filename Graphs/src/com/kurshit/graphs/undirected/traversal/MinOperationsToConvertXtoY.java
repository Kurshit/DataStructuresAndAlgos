package com.kurshit.graphs.undirected.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinOperationsToConvertXtoY {

	public static void main(String[] args) {
		int X = 4;
		int Y = 7;
		
		//expected - 2
		System.out.println(getMinOperations(X, Y));
		
		X = 2; 
		Y = 5;
		//expected - 4
		System.out.println(getMinOperations(X, Y));
		

	}
	
	public static int getMinOperations(int X, int Y) {
		Queue<CurrDigit> queue = new LinkedList<>();
		
		CurrDigit c = new CurrDigit(X, 0);
		queue.offer(c);
		
		while(!queue.isEmpty()) {
			
			CurrDigit temp = queue.poll();			
			
			if(temp.value == Y) {
				return temp.stepsTaken;
			}
			
			int mul = temp.value * 2;
			int sub = temp.value - 1;
			
			if(mul > 0 && mul < 1000) {
				CurrDigit cd = new CurrDigit(mul , temp.stepsTaken + 1);
				queue.offer(cd);
			}
			
			if(sub > 0 && sub < 1000) {
				CurrDigit cd = new CurrDigit(sub , temp.stepsTaken + 1);
				queue.offer(cd);
			}
		};
		return -1;
	}

}

class CurrDigit {
	public int value;
	public int stepsTaken;
	
	public CurrDigit(int value, int stepsTaken) {
		this.value = value;
		this.stepsTaken = stepsTaken;
	}
}
