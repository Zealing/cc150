package treesandgraphs;

public class CC {
	private boolean marked[];
	private int[] id;
	private int count;//num of components
	
	//find connected components of graph G
	public CC(Graph G) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		//iterate through all vertices in graph
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}
	
	//modified dfs algorithm
	private void dfs(Graph G, int v) {
		marked[v] = true;
		
		//change the id to the count---so BRILLIANT!!using count both as components number and as order
		id[v] = count;
		
		for (int w: G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	//number of conneted components
	public int count() {
		return count;
	}
	
	//component identifier
	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
