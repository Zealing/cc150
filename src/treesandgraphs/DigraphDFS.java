package treesandgraphs;

public class DigraphDFS {

	boolean[] marked;
	int[] edgeTo;
	private int s;
	
	//create a directed graph and start from vertex s
	public DigraphDFS(Digraph G, int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		dfs(G, s);
	}
	
	public void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w: G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}

}
