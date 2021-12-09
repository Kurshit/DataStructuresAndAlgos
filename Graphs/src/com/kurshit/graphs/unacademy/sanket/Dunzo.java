package com.kurshit.graphs.unacademy.sanket;

/*
     Problem Source : https://unacademy.com/class/graph-interview-problems-part-1/B9V2XRWD
     Solution Source : Sanket - https://unacademy.com/class/graph-interview-problems-part-1/B9V2XRWD

     You have undirected TREE of N nodes. Some nodes have color A, some B and some C. It is for sure that nodes with color A & B  colors are always present.
     Fine the number of edgdes you can remove from tree such that removing  (one) edge divides the tree into two components where in one component
        - No node has color A - all color B
        - and in one   component, no node has color B - all color A
        But there can be an occurrence of color C

        Eg.
                Three colors as A, B, C

                A           C
                    \   /
                      C
                   /     \
                 B        A

         Now removing edge B-C will leave 2 components -
          B   - which has only B color and NO A

          other - has A and C color and NOT B

 */

/*
    Approach : Few points :
        -- Being a tree, if you remove any edge it will divide it in two components as it always have N - 1 edges.
        -- We have to find all the valid edges
        -- When we remove an edge - We have 2 components C1 & C2. So in C1, the count of red nodes will be c1.red == totalCountOfRed (original red nodes) also
            the count of c2.red == totalCountOfBlue nodes.
        -- We can one by one come to difft node and do dfs. For each subtree do two things count the red nodes and count blue nodes. At any point of time, your subtree at which you are going - the count of red == originalCountOfRed & count of blue becomes 0, then you can remove that edge.
        -- So, just do the DFS one by one and for any subtree or subgraph you are going, keep a count of redNodes and blueNodes. If above is met, increase the count.
        -- Black is mostly to confuse the candidate.
        -- DFS can be started from any node.
 */


import com.kurshit.graphs.undirected.UGraph;

import java.util.Scanner;

public class Dunzo {

    static int countRed = 0;
    static int countBlue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        colors = new char[V];
        for(int i = 0; i < V; i++) {
            char color = sc.next().charAt(0);
            colors[i] = color;
            if(color == 'A') {
                countRed += 1;
            }

            if(color == 'B') {
                countBlue += 1;
            }
        }
        UGraph graph = new UGraph(V);
        //edges will be V - 1 - since it is a tree
        for(int i = 0; i < V -1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.adjList[u].add(v);
            graph.adjList[v].add(u);

        }

        dfs(graph, 0, -1);
        System.out.println(ans);

        sc.close();

    }
    static int ans = 0;
    static char[] colors;
    static Pair dfs(UGraph graph, int src, int parent) {
        int red = 0;
        int blue = 0;
        if(colors[src] == 'A') {
            red = 1;
        }

        if(colors[src] == 'B') {
            blue = 1;
        }

        for(int dest : graph.adjList[src]) {
            if(dest != parent) {
                Pair result = dfs(graph, dest, src);
                if(result.first == countRed && result.second == 0) {
                    ans = ans + 1;
                }

                if(result.second == countBlue && result.first == 0) {
                    ans = ans + 1;
                }

                red = red + result.first;
                blue = blue + result.second;

            }
        }

        return new Pair(red, blue);
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
