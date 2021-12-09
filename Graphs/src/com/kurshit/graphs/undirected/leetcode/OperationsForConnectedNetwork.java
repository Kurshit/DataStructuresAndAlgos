package com.kurshit.graphs.undirected.leetcode;

/*
    Problem : Number of operations to make network connected #1319
    Problem Source : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    Solution approach : https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/717403/C%2B%2B-or-DFS-or-Number-of-Islands-or-Detailed-explanation
    Problem : There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a
    connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

    Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected
    computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible,
    return -1.

    Input: n = 4, connections = [[0,1],[0,2],[1,2]]
    Output: 1
    Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
    Output: 2
    Example 3:

    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
    Output: -1
    Explanation: There are not enough cables.
    Example 4:

    Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
    Output: 0

 */


/*
    Solution Approach :

    Goal: We need to connect all the computers (directly or indirectly). We have to return the minimum number of operations that are required to connect the computers. An operation consists of removing a cable between two directly connected computers and put it between two disconnected computers.

    This problem is a simple variation of counting the number of islands.

    We know that the minimum number of edges required for a graph with n nodes to remain connected is n - 1. Similarly, if there are k components in a disconnected graph, then we need at least k - 1 edges to connect every component.

    With that in our mind, we will start with our base condition. If the number of edges in the graph is greater than n - 1 or not. If not, we will return -1.

    Next, we will count the number of components (k). As I already mentioned, we will need k - 1 operations to connect the computers (components). And that is our answer!

    We can also solve this using Union-Find approach and count the number of components. I solved this problem using DFS and the code is shown below.

    Please leave any of your doubts/comments in the comments section!

 */

import com.kurshit.graphs.undirected.UGraph;

public class OperationsForConnectedNetwork {

    public static void main(String[] args) {

        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int N = 6;
        System.out.println(makeConnected(N, connections));

    }

    public static int makeConnected(int N, int[][] connections) {

        if(connections.length < N-1) {
            return -1;
        }

        UGraph graph = new UGraph(N);

        for(int[] conn : connections) {
            graph.addEdge(conn[0], conn[1]);
        }

        return operations(graph, N);

    }

    private static int operations(UGraph graph, int N) {
        int islands = 0;
        boolean[] visited = new boolean[N];
        for(int i = 0; i < graph.V; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited);
                islands++;
            }
        }

        return islands - 1;
    }

    private static void dfs(UGraph graph, int src, boolean[] visited) {

        visited[src] = true;

        for(int dest : graph.adjList[src]) {
            if(!visited[dest]) {
                dfs(graph, dest, visited);
            }
        }
    }
}
