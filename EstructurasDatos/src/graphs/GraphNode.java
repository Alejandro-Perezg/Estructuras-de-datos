package graphs;

import java.util.LinkedList;

/**
 *
 * @author julius
 */
public class GraphNode<E> {

    public E data;
    private LinkedList<GraphNode<E>> neighbors;
    private LinkedList<GraphNode<E>> isNeighbors;
    public boolean visited;
    int visitedNei;

    public GraphNode(E data) {
        this.data = data;
        neighbors = new LinkedList<>();
        isNeighbors = new LinkedList<>();
        visited = false;
        int visitedNei;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }
    
    public LinkedList<GraphNode<E>> getIsNeighbors() {
        return isNeighbors;
    }

    @Override
    public String toString() {
        return data + "";
    }

    public boolean equals(Object o) {
        if (o instanceof GraphNode) {
            return ((GraphNode) o).data.equals(this.data);
        }
        return false;
    }

}
