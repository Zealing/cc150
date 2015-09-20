package treesandgraphs;

public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Digraph(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>(); 
		}
	}
	
	//add edge from v to w
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	//get the vertices from v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	//just create a new digraph with reverse order of edges
	public Digraph reverse() {
		Digraph R = new Digraph(V);
		//iterate through all vertices and add edge to them in reverse orders
		for (int v = 0; v < V; v++) {
			for (int w: adj(v)) {
				R.addEdge(w, v);
			}
		}
		return R;
		
	}
	
	public String toString() {
		return null;
		
	}
}
