package treesandgraphs;

public class PathsDFS {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	//find a path in G from the source vertex s
	public PathsDFS(Graph G, int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		dfs(G, this.s);
	}
	
	public void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w: G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	//whether there is a path from s to v?
	public boolean hasPathTo(int v) {
		return marked[v];
		
	}

	//find the path from s to v, null if no path
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		} 
		
		//using stack to store the path from s to v
		Stack<Integer> path = new Stack<Integer>();
		
		//using loop to track the path
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		
		return path;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
