package graphs;

public class TestTopo {
	public static void main(String[] args) {
		DiGraph<String> g = new DiGraph<>();
	    System.out.println("Testing DiGraph");
	    g.addNode("A");
	    g.addNode("B");
	    g.addNode("C");
	    g.addNode("D");
	    g.addNode("E");
	    g.addNode("F");
	    g.addNode("G");
	    g.addNode("H");
	    g.addNode("I");
	    g.addNode("J");
	    g.addNode("K");
	    g.addNode("L");
	    g.addNode("M");
	    System.out.println("");
	    g.addEdge("A", "B");
	    g.addEdge("B", "C");
	    g.addEdge("C", "D");
	    g.addEdge("D", "E");
	    g.addEdge("B", "G");
	    g.addEdge("E", "G");
	    g.addEdge("G", "I");
	    g.addEdge("F", "B");
	    g.addEdge("F", "I");
	    g.addEdge("H", "G");
	    g.addEdge("J", "G");
	    g.addEdge("J", "K");
	    g.addEdge("K", "H");
	    g.addEdge("L", "J");
	    g.addEdge("M", "L");
	    System.out.println("Graph: " + g.toString());
	    System.out.println(g.topo());
	}
	
}
