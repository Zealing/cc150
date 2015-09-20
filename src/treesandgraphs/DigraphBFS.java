package treesandgraphs;

public class DigraphBFS {
	private boolean[] marked;
	private int[] disTo;
	private int[] edgeTo;
	private int s;
	
	
	public DigraphBFS(Digraph G, int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		bfs(G, s);
	}
	
	public void bfs(Digraph G, int v) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(v);
		marked[v] = true;
		
		while (!q.isEmpty()) {
			q.dequeue();
			for (int w: G.adj(v)) {
				if(!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}

}
