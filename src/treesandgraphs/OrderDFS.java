package treesandgraphs;

public class OrderDFS {
	private boolean[] marked;
	private Stack<Integer> reversePost;
	
	public OrderDFS(Digraph G) {
		// TODO Auto-generated constructor stub
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}
	
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w: G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);	
			}
		}
		
		//after DFS complete, add the finished vertex into stack
		reversePost.push(v);
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
