package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.TreeNode;

/**
 *
 * @author julius
 */
public class DiGraph<E> implements Graph<E> {

	private LinkedList<GraphNode<E>> nodes;

	public DiGraph() {
		nodes = new LinkedList<>();
	}

	@Override
	public void addNode(E element) {
		if (!contains(element)) {
			nodes.add(new GraphNode<>(element));
		}
	}

	private GraphNode<E> getNode(E element) {
		int i = nodes.indexOf(new GraphNode<>(element));
		if (i >= 0) {
			return nodes.get(i);
		}
		return null;
	}

	@Override
	public void addEdge(E source, E destiny) {
		GraphNode<E> s = getNode(source);
		GraphNode<E> d = getNode(destiny);
		if (s == null) {
			addNode(source);
			s = getNode(source);
		}
		if (d == null) {
			addNode(destiny);
			d = getNode(destiny);
		}
		s.getNeighbors().add(d);
		d.getIsNeighbors().add(s);
		s.visitedNei++;
	}

	@Override
	public boolean contains(E element) {
		return getNode(element) != null;
	}

	@Override
	public void removeNode(E element) {
		GraphNode<E> s = getNode(element);
		for (GraphNode n : nodes) {
			n.getNeighbors().remove(s);
		}
		nodes.remove(s);
	}

	@Override
	public void removeEdge(E source, E destiny) {
		GraphNode<E> s = getNode(source);
		GraphNode<E> d = getNode(source);
		if (s != null) {
			s.getNeighbors().remove(new GraphNode(destiny));
			d.getIsNeighbors().remove(new GraphNode(source));
		}
	}

	@Override
	public LinkedList getNeighbors(E element) {
		GraphNode<E> node = getNode(element);
		if (node != null) {
			return node.getNeighbors();
		}
		return null;
	}
	
	public LinkedList getIsNeighbors(E element) {
		GraphNode<E> node = getNode(element);
		if (node != null) {
			return node.getIsNeighbors();
		}
		return null;
	}

	private void reset() {
        for (GraphNode node : nodes) {
            node.visited = false;
        }
    }

    @Override
    public String BFS(E start) {
        reset();
        ArrayList<GraphNode<E>> q = new ArrayList<>();
        GraphNode<E> first = getNode(start);
        first.visited = true;
        q.add(first);
        String bfs = first.toString();
        while (!q.isEmpty()) {
            GraphNode<E> n = q.remove(0);
            for (GraphNode<E> neighbor : n.getNeighbors()) {
                if (neighbor.visited == false) {
                    neighbor.visited = true;
                    q.add(neighbor);
                    bfs += neighbor.toString();
                }
            }
        }
        return bfs;
    }

    @Override
    public String DFS(E start) {
        reset();
        Stack<GraphNode<E>> s = new Stack<>();
        GraphNode<E> first = getNode(start);
        first.visited = true;
        s.push(first);
        String dfs = first.toString();
        while (!s.isEmpty()) {
            GraphNode<E> n = s.peek();
            boolean noNeighbors = true;
            for (GraphNode<E> neighbor : n.getNeighbors()) {
                if (neighbor.visited == false) {
                    neighbor.visited = true;
                    s.push(neighbor);
                    dfs += neighbor.toString();
                    noNeighbors = false;
                    break;
                }
            }
            if (noNeighbors) {
                s.pop();
            }
        }
        return dfs;
    }
	
	public String topo() {
		reset();
		String topo = "";
		Stack<GraphNode<E>> stk = new Stack<>();
		LinkedList<GraphNode<E>> que = new LinkedList<>();
		GraphNode<E> first = null;
		for (GraphNode node : nodes) {
			if(node.visitedNei == 0) {
				first = node;
				first.visited = true;
				stk.push(first);
				for (GraphNode<E> nei : first.getIsNeighbors()) {
					nei.visitedNei --;
					que.addFirst(nei);
				}
				break;
			}
		}
		while(!stk.isEmpty()) {
			topo = stk.peek() + topo ;
			first = stk.pop();
			int contador = 0;
			for (GraphNode<E> nei : first.getIsNeighbors()) {
				if(!nei.visited && nei.visitedNei == 0) {
					stk.push(nei);
					first = nei;
					contador++;
					break;
				}
			}
		if(contador == 0 && !stk.isEmpty()) {
				first = stk.pop();
			}
		else if(contador == 0 && stk.isEmpty()) {
			for(int i = 0; i < que.size(); i++) {
				if(que.peek().visited) {
					que.remove();
				}
				else {
					first = que.remove();
					first.visited = true;
					stk.push(first);
					break;
				}
			}
		}
		for (GraphNode<E> nei : first.getIsNeighbors()) {
			nei.visitedNei --;
		}
			
		}
		
		return topo;
	}
	
	

	public String toString() {
		String s = "";
		for (GraphNode node : nodes) {
			s += node + ": " + node.getNeighbors().toString() + " ";
		}
		return s;
	}

}
