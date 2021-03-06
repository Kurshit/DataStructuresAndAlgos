package com.kurshit.graphs.undirected;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UGraphWithW {

    public int V;
    public List<UPair>[] adjList;

    public UGraphWithW(int V) {
        this.V = V;
        adjList = new LinkedList[V];

        for(int i=0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList[src].add(new UPair(dest, weight));
        adjList[dest].add(new UPair(src, weight));
    }
    
    public static class UPair {
    	public int dest;
    	public int weight;
    	
    	public UPair(int dest, int weight) {
    		this.dest = dest;
    		this.weight = weight;
    	}
    }

    public void breathFirstTraversal(int src) {
        boolean[] visited = new boolean[this.V];

        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            Iterator<UPair> itr = adjList[src].iterator();

            while(itr.hasNext()) {
                UPair pair = itr.next();
                if(!visited[pair.dest]) {
                    visited[pair.dest] = true;
                    q.offer(pair.dest);
                }

            }

        }
        System.out.println();
    }

    public void depthFirstTraversal(int src) {
        boolean[] visited = new boolean[this.V];
        depthFirstTraversal(src,visited);
        System.out.println();
    }

    public void depthFirstTraversal(int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;

        Iterator<UPair> itr = adjList[src].iterator();

        while(itr.hasNext()) {
            UPair pair = itr.next();

            if(!visited[pair.dest]) {
                depthFirstTraversal(pair.dest, visited);
            }
        }

    }
}
