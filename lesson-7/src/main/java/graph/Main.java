package graph;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.addEdge(8,7);
        graph.addEdge(9,7);
        graph.addEdge(9,4);
        graph.addEdge(9,3);
        graph.addEdge(2,3);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(7,4);
        graph.addEdge(6,2);
        graph.addEdge(0,4);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 6);
        LinkedList<Integer> result = bfp.pathTo(0);
        System.out.println("First path from vertex 6 to vertex 0 is - " + result);
        System.out.println("Length of path is - " + result.size());
    }
}
