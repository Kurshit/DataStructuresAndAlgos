package com.kurshit.graphs.directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DGraph {

    public int V;

    public List<Integer>[] adjList;

    public DGraph(int V) {
        this.V = V;
        adjList = new LinkedList[V];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void breathFirstTraversal(int src) {
        boolean[] visited = new boolean[this.V];

        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            Iterator<Integer> itr = adjList[src].iterator();

            while(itr.hasNext()) {
                int value = itr.next();
                if(!visited[value]) {
                    visited[value] = true;
                    q.offer(value);
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

        Iterator<Integer> itr = adjList[src].iterator();

        while(itr.hasNext()) {
            src = itr.next();

            if(!visited[src]) {
                depthFirstTraversal(src, visited);
            }
        }

    }
}
