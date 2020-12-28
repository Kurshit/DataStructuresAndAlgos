package com.kurshit.graphs.directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class DGraphWithW {

    public int V;

    public List<DPair>[] adjList;

    public DGraphWithW(int V) {
        this.V = V;
        adjList = new LinkedList[V];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    public static class DPair {
    	public int dest;
    	public int weight;
    	
    	public DPair(int dest, int weight) {
    		this.dest = dest;
    		this.weight = weight;
    	}
    }


    public void addEdge(int src, int dest, int weight) {
        adjList[src].add(new DPair(dest, weight));
    }

    public void breadthFirstTraversal(int src) {
        boolean[] visited = new boolean[this.V];

        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            Iterator<DPair> itr = adjList[src].iterator();

            while(itr.hasNext()) {
                DPair pair = itr.next();
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

        Iterator<DPair> itr = adjList[src].iterator();

        while(itr.hasNext()) {
            DPair pair = itr.next();
            
            if(!visited[pair.dest]) {
                depthFirstTraversal(pair.dest, visited);
            }
        }

    }
}
