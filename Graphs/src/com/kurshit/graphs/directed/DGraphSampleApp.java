package com.kurshit.graphs.directed;

public class DGraphSampleApp {

    public static void main(String[] args) {
        DGraph g = new DGraph(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,1);
        g.addEdge(2,3);

        g.breathFirstTraversal(2);
        g.depthFirstTraversal(2);

    }
}
