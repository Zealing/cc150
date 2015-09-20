package treesandgraphs;

public class Graph {

	private final int V; //num of vertices
	int E; //num of edges
	private Bag<Integer>[] adj;
	
	//create an empty graph with V vertices 
	public Graph(int V) {
		this.V = V;
		
		//create a new bag list to store each vertex
		adj = (Bag<Integer>[])new Bag [V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>(); //let each vertex as a bag
		}
	}
	
	//create graph from input stream
	public Graph(In in) {
		
	}
	
	//add an edge (v, w)
	public void addEdge(int v, int w) {
		adj[v].add(w);//using bag's method add(int item)
		adj[w].add(v);
	}
	
	//return vertices adjacent to node v
	public Iterable<Integer> adj(int v) {
		return adj[v];
		
	}
	
	public String toString() {
		return null;
		
	}
	
	public int V() {
		return V;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
