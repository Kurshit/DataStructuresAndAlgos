package com.kurshit.dp.atcoder.educational;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Problem Source : https://atcoder.jp/contests/dp/tasks/dp_g
 * Solution Source : https://unacademy.com/class/atcoder-dp-problem-set-2/ZTHRSSE7
 * 
 * Statement : There is a directed graph G with N vertices and M edges. The vertices are numbered 1, 2, 3 ... N and for each i <= i <= M. The ith
 * directed egde goes from vertex Xi to Yi. G does not contain directed cycles.
 * 
 * Find the length of longest directed path in G. Here the length of a directed path is number of edges in it.
 * 
 * Constraints : 
 * 	2 <= N <= 10^5
 * 	1 <= M <= 10^5.
 * 	1 <= XiYi <= N
 * 	All pairs (Xi, Yi) are distinct
 * 
 * Input : 
 * 	N	M
 * 	X1	Y1
 *  X2	Y2
 *  X3	Y3
 *  .....
 *  XM	YM
 *  
 *  Output: 
 *  
 *  Print the length of longest directed path in G.
 *  
 *  Sample Input: 
 *  	4 5
 *  	1 2 
 *    	1 3
 *    	3 2
 *    	2 4
 *    	3 4
 *    
 *  Sample Output : 
 *  	3
 */

public class LongestPath {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt(); //Number of vertices
			int M = sc.nextInt();  // Number of edges
			Graph graph = new Graph(N);
			
			for(int i=0; i < M; i++) {
				int src = sc.nextInt();
				int dest = sc.nextInt();
				
				graph.addEdge(src, dest);
			}
			int ans = Integer.MIN_VALUE;
			for(int i =1; i <= N; i++) {
				ans = Math.max(ans, longestPath(graph, i));
			}
			
			System.out.println(ans);
			
		}

	}
	static int[] dp;
	
	public static int longestPath(Graph graph, int src) {
		dp = new int[100005];
		
		return longestPathUtil(graph, src);
		
		
	}

	private static int longestPathUtil(Graph graph, int src) {
		
		int result = Integer.MIN_VALUE;
		
		boolean noNeighbour = true;
		
		for(int neighbour : graph.adjList[src]) {
			noNeighbour = false;
			result = Math.max(result, longestPathUtil(graph, neighbour));
		}
		
		return noNeighbour ? 0 : result + 1;
	}

}

class Graph {
	
	public List<Integer>[] adjList;
	int V;
	public Graph(int V) {
		this.V = V;
		adjList = new LinkedList[V + 1];
		
		for(int i=1; i <= V; i++)
			adjList[i] = new LinkedList<>();
	}
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
}
