package com.kurshit.graphs.undirected.disjointset;

public class FindUnion {

	public static int find(int[] parent, int i) {

		if(parent[i] == -1)
			return i;

		return find(parent, parent[i]);
	}

	public static void union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

}
