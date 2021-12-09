package com.kurshit.graphs.codencode;

import com.kurshit.graphs.undirected.UGraph;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleForUndirectedGraphBFS {

  public static void main(String[] args) {

    {

      UGraph graph = new UGraph(5);

      graph.addEdge(0, 1);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(2, 3);
      graph.addEdge(3, 4);
      //expected - true
      System.out.println(hasCycle(graph));

      UGraph graph1 = new UGraph(5);

      graph1.addEdge(0, 1);
      graph1.addEdge(1, 2);
      graph1.addEdge(1, 3);
      // graph1.addEdge(2, 3); this edge causes cycle
      graph1.addEdge(3, 4);

      //expected - false
      System.out.println(hasCycle(graph1));

      UGraph graph2 = new UGraph(4);

      graph2.addEdge(0, 1);
      graph2.addEdge(1, 2);
      graph2.addEdge(1, 3);
      // graph1.addEdge(2, 3); this edge causes cycle
      graph2.addEdge(2, 3);

      //expected - true
      System.out.println(hasCycle(graph2));




    }

  }

  public static boolean hasCycle(UGraph graph) {
      boolean[] visited = new boolean[graph.V];
      int[] parent = new int[graph.V];
      Arrays.fill(parent, -1);

      for(int i = 0; i < graph.V; i++) {

        if(!visited[i]) {
          if(bfs(graph, i, visited, parent)) {
            return true;
          }
        }
      }

      return false;
  }

  public static boolean bfs(UGraph graph, int src, boolean[] visited, int[] parent) {

    Queue<Integer> q = new LinkedList<>();

    q.offer(src);
    visited[src] = true;

    while (!q.isEmpty()) {

      src = q.poll();

      for (int dest : graph.adjList[src]) {

        if (!visited[dest]) {
          q.offer(dest);
          visited[dest] = true;
          parent[dest] = src;
        } else {
          if (dest != parent[src]) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
