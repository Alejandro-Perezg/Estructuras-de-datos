package graphs;

import java.util.LinkedList;

/**
 *
 * @author Julio Arriaga
 */
public interface Graph<E> {

    void addNode(E element);

    void addEdge(E source, E destiny);
    
    boolean contains(E element);

    void removeNode(E element);

    void removeEdge(E source, E destiny);

    LinkedList getNeighbors(E element);

    String BFS(E start);

    String DFS(E start);

}
