package treesandgraphs;

public class isBalancedImproved {

	public int checkHeight(TreeNode t) {
		if (t == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(t.left);
		if (leftHeight == -1) {
			return -1;
		} 
		
		int rightHeight = checkHeight(t.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(rightHeight, leftHeight) + 1;
		}
	}
	
	public boolean isBalancedImproved(TreeNode root) {
		// TODO Auto-generated constructor stub
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

}
