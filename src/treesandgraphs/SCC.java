package treesandgraphs;

public class SCC {
	private boolean marked[];
	private int[] id;
	private int count;//num of components
	
	//find connected components of graph G
	public SCC(Digraph G) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		//using G's reverse to do topological sorting to find out the reverse postorder
		OrderDFS dfs = new OrderDFS(G.reverse());
		
		//iterate through all vertices in graph following the reverse order
		for (int v: dfs.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}
	
	//modified dfs algorithm
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		
		//change the id to the count---so BRILLIANT!!using count both as components number and as order
		id[v] = count;
		
		for (int w: G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean sccConnected(int v, int w) {
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
