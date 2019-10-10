package trees;

public interface Tree<E> {
	/**
     * Recursively adds a new element
     *
     * @param element
     */
    void add(E element);

    /**
     * Recursively checks if an element is contained
     *
     * @param element
     */
    boolean contains(E element);

    /**
     * Recursively removes the specified element
     *
     * @param element
     * @return True if the element was removed, false otherwise
     */
    boolean remove(E element);

    /**
     * Checks if the tree has no nodes
     *
     * @return True if the tree is empty
     */
    boolean isEmpty();

    /**
     * Deletes all the nodes from the tree
     */
    void clear();

    /**
     * Recursive InOrder traversal of the tree
     *
     * @return a String representation of an inOrder traversal of the tree
     */
    String inOrder();

    /**
     * Recursive PreOrder traversal of the tree
     *
     * @return a String representation of a preOrder traversal of the tree
     */
    String preOrder();

    /**
     * Recursive PostOrder traversal of the tree
     *
     * @return a String representation of a postOrder traversal of the tree
     */
    String postOrder();

    /**
     * Breadth first traversal of the tree
     *
     * @return a String representation of a breadth first traversal of the tree
     */
    String breadthFirst();

    /**
     * Finds the predecessor (one left, then right) of an element
     *
     * @param element
     * @return the predecessor of the given element, or null if not present
     */
    E predecessor(E element);

    /**
     * Finds the successor (one right, then left) of an element
     *
     * @param element
     * @return the successor of the given element, or null if not present
     */
    E successor(E element);

    /**
     * Finds the largest element
     *
     * @return the largest element in the tree
     */
    E getLargest();

    /**
     * Finds the lowest element
     *
     * @return the lowest element in the tree
     */
    E getLowest();

    /**
     * Total number of leaves (nodes without children)
     *
     * @return the number of leaves in the tree
     */
    int numLeaves();

    /**
     * Total number of nodes (internal nodes and leaves)
     *
     * @return the number of nodes in the tree
     */
    int size();

    /**
     * Gets the sibling of the given element
     *
     * @param element
     * @return the sibling of the element, or null if not present
     */
    E getSibling(E element);

    /**
     * Gets the parent of the given element
     *
     * @param element
     * @return the parent of the element, or null if not present
     */
    E getParent(E element);
}
