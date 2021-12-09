package com.kurshit.graphs.directed.traversals;

import com.kurshit.graphs.directed.DGraph;

import java.util.Iterator;


/*
    Questions :
    1. Is Graph directed - Yes, It can't be undirected
    2. Is graph connected -
    3. Is there any cycle in the graph - Then paths will be infinite is that is the case
 */

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
            dfs(graph, 0, 4);
            System.out.println(count);

    }

    /*
        TC : O (N!)
        SC : O(1)
     */

    public int countPaths(DGraph graph, int src, int dest) {
        int pathCount = countPathsUtil(graph, src, dest, 0);
        return pathCount;
    }

    /*
     Since graph does not have any cycle, we can avoid use of vi
     */

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
    private static int count = 0;

    //approach 2 - using static counter
    public static void dfs(DGraph graph, int src, int dest) {
      if(src == dest) {
        count++;
      } else {
        for(int d : graph.adjList[src]) {
          dfs(graph, d, dest);
        }
      }
    }

}
