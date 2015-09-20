package treesandgraphs;

public class checkBST {

	public boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBST(TreeNode n, int min, int max) {
		//base case: if all nodes are within the range
		if (n == null) {
			return true;
		}
		
		if ((int)n.val > max || (int)n.val < min) {
			return false;
		}
		
		//recursively check all subtree
		if (!checkBST(n.left, min, (int)n.val) || !checkBST(n.right, (int)n.val, max)) {
			return false;
		}
		
		return true;
	}
	
	public checkBST() {
		// TODO Auto-generated constructor stub
	}

}
