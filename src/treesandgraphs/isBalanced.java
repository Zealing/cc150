package treesandgraphs;

public class isBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		if (heightDiff > 1) {
			return false;
		} else {
			//using recursion from top to bottom to find out whether each subtree has similar height
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	//using recursion to find out the height of every node
	public int getHeight(TreeNode t) {
		if (t == null) {
			return 0;
		}
		
		return Math.max(getHeight(t.left), getHeight(t.right)) + 1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
