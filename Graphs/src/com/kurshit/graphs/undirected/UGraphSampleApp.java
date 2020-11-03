package com.kurshit.graphs.undirected;

public class UGraphSampleApp {

    public static void main(String[] args) {
        UGraph g = new UGraph(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,1);
        g.addEdge(2,3);

        g.breathFirstTraversal(2);
        g.depthFirstTraversal(2);

    }
}
