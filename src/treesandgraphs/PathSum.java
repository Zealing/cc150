package treesandgraphs;

public class PathSum {
	
	public void findSum(TreeNode n, int sum) {
		int depth = depth(n);
		int[] path = new int[depth];
		findSum(n, sum, path, 0);
	}

	private void findSum(TreeNode node, int sum, int[] path, int level) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		
		//add the node value into the path
		path[level] = (int) node.val;
		
		//iterate through the path from the node to the top
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		
		//do recursion to search next node
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		//remove current node if done in that node and in below nodes---even if not necessary technically
		path[level] = Integer.MIN_VALUE;
		
	}
	
	//print out the path from the start node to the end node in the path array
	private void print(int[] path, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start; i < end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	//get the depth of the tree
	private int depth(TreeNode n) {
		// TODO Auto-generated method stub
		if (n == null) {
			return 0;
		}
		
		return 1 + Math.max(depth(n.left), depth(n.right));
	}

	public PathSum() {
		// TODO Auto-generated constructor stub
	}

}
