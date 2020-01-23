package graph;

import java.util.LinkedList;

public abstract class FirstPath {
    boolean[] marked;
    int[] edgeTo;
    int source;

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
