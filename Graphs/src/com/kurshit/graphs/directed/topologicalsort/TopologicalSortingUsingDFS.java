package com.kurshit.graphs.directed.topologicalsort;

import com.kurshit.graphs.directed.DGraph;

import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortingUsingDFS {

    public static void main(String[] args) {
        DGraph graph = new DGraph(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        int[] result = topologicalUsingDFS(graph);

        System.out.println(Arrays.toString(result));
    }

    /*
        TC : O (V + E)
        Approach : In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack.
     */

    public static int[] topologicalUsingDFS(DGraph graph) {

        int[] result = new int[graph.V];

        boolean[] visited = new boolean[graph.V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < graph.V; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        for(int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    private static void dfs(DGraph graph, int src, boolean[] visited, Stack<Integer> stack) {

        visited[src] = true;

        for(int dest : graph.adjList[src]) {
            if(!visited[dest]) {
                dfs(graph, dest, visited, stack);
            }
        }

        stack.push(src);
    }
}
