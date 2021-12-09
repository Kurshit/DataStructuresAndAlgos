package com.kurshit.graphs.directed.traversals;

import com.kurshit.graphs.directed.DGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/*
    Questions : 1. Shoud it contain cycles ? No it cant - or you get infinity path
 */

public class PrintAllPaths {

    public static void main(String[] args) {
            DGraph graph = new DGraph(5);
            graph.addEdge(0,1);
            graph.addEdge(0,4);
            graph.addEdge(0,2);
            graph.addEdge(1,3);
            graph.addEdge(1,4);
            graph.addEdge(2,4);
            graph.addEdge(3,2);

            PrintAllPaths cp = new PrintAllPaths();
            cp.printAllPathsDFS(graph, 0, 4);

    }



    public void printAllPathsDFS(DGraph graph, int src, int dest) {
        List<Integer> pathsList = new LinkedList<>();
        pathsList.add(src);
        printAllPathsDFSUtil(graph, src, dest, pathsList);

    }

    private void printAllPathsDFSUtil(DGraph graph, int src, int dest, List<Integer> pathsList) {
        if(src == dest) {
            printCurrentPath(pathsList);
        } else {

            Iterator<Integer> itr = graph.adjList[src].iterator();

            while(itr.hasNext()) {
                src = itr.next();
                pathsList.add(src);
                printAllPathsDFSUtil(graph,src,dest,pathsList);
                pathsList.remove(new Integer(src));
            }
        }
    }

    public void printCurrentPath(List<Integer> pathsList) {
        for(int i : pathsList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
