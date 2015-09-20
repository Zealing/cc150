package treesandgraphs;

public class PathsBFS {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	//find a path in G from the source vertex s
	public PathsBFS(Graph G, int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		bfs(G, this.s);
	}
	
	private void bfs(Graph G, int v) {
		//using queue to store the path
		Queue<Integer> q = new Queue<Integer>();
		
		//first, enqueue the source node
		q.enqueue(v);
		marked[v] = true;
		
		while (!q.isEmpty()) {
			q.dequeue();
			for (int w: G.adj(v)) {
				if (!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
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
