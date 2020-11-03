package com.kurshit.graphs.directed.traversals;

import com.kurshit.graphs.directed.DGraph;

import java.util.Iterator;

public class CountPaths {

    public static void main(String[] args) {
            DGraph graph = new DGraph(5);
            graph.addEdge(0,1);
            graph.addEdge(0,4);
            graph.addEdge(0,2);
            graph.addEdge(1,3);
            graph.addEdge(1,4);
            graph.addEdge(2,4);
            graph.addEdge(3,2);

            CountPaths cp = new CountPaths();
            System.out.println(cp.countPaths(graph, 0, 4));

    }

    public int countPaths(DGraph graph, int src, int dest) {
        int pathCount = countPathsUtil(graph, src, dest, 0);
        return pathCount;
    }

    private int countPathsUtil(DGraph graph, int src, int dest, int count) {
        if(src == dest) {
            count++;
        } else {
            Iterator<Integer> itr = graph.adjList[src].iterator();

            while(itr.hasNext()) {
                src = itr.next();
                count = countPathsUtil(graph,src,dest,count);
            }
        }
        return count;
    }
}
