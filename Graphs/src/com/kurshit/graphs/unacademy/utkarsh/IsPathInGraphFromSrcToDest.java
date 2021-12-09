package com.kurshit.graphs.unacademy.utkarsh;

import com.kurshit.graphs.undirected.UGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsPathInGraphFromSrcToDest {

    public static void main(String[] args) {

        UGraph g = new UGraph(4);

        g.addEdge(2,3);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,1);

        System.out.println(hasPathDFS(g, 0, 3));
        System.out.println(hasPathBFS(g, 0, 3));

        UGraph graph = new UGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(4,5);

        System.out.println(hasPathDFS(graph, 2, 4));
        System.out.println(hasPathBFS(graph, 2, 4));

        System.out.println();

        doesPathExist(graph);

    }

    static int[] reachedByNode = new int[100000];

    public static void preProcess(UGraph graph) {

        boolean[] visited = new boolean[graph.V];
        Arrays.fill(reachedByNode, -1);
        for(int i =0; i < graph.V; i++) {
            if(!visited[i]) {
                preProcessDfs(graph, i, i, visited);
            }
        }
    }

    private static void preProcessDfs(UGraph graph, int src, int startedFrom, boolean[] visited) {

        visited[src] = true;
        reachedByNode[src] = startedFrom;

        for(int dest : graph.adjList[src]) {
            if(!visited[dest]) {
                preProcessDfs(graph, dest, startedFrom, visited);
            }
        }
    }


    public static void doesPathExist(UGraph graph) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        preProcess(graph);
        for(int i=0; i < Q; i++) {
            int src = sc.nextInt();
            int dest  = sc.nextInt();

            if(reachedByNode[src] == reachedByNode[dest])
                System.out.println(true);
            else
                System.out.println(false);
        }

        sc.close();
    }

    public static boolean hasPathDFS(UGraph graph, int src, int dest) {

        boolean[] visited = new boolean[graph.V];

        return dfs(graph, src, dest, visited);

    }

    public static boolean dfs(UGraph graph, int src, int dest, boolean[] visited) {

        visited[src] = true;

        if(src == dest)
            return true;

        for(int nbr : graph.adjList[src]) {

            if(!visited[nbr]) {
                if(dfs(graph, nbr, dest, visited))
                    return true;
            }
        }

        return false;
    }

    public static boolean hasPathBFS(UGraph graph, int src, int dest) {
        return bfs(graph, src, dest);
    }

    public static boolean bfs(UGraph graph, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.V];

        queue.offer(src);

        while(!queue.isEmpty()) {
            src = queue.poll();

            if(src == dest) {
                return true;
            }

            for(int nbr : graph.adjList[src]) {
                if(!visited[nbr]) {
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }

        return false;
    }
}
