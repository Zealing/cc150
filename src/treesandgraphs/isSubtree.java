package treesandgraphs;

public class isSubtree {
	
	//pre-order traversal
	public boolean isMatch(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}
		
		if (n1 == null || n2 == null) {
			return false;
		}
		
		if (n1.val != n2.val) {
			return false;
		}
		
		isMatch(n1.left, n2.left);
		isMatch(n1.right, n2.right);
		
		return true;
	}
	
	//pre-order traversal
	public boolean isSubtree(TreeNode n1, TreeNode n2) {
		// TODO Auto-generated constructor stub
		//if T2 is a null tree--always be a subtree of T1
		if (n2 == null) {
			return true;
		}
		
		//cannot find
		if (n1 == null) {
			return false;
		}

		if (n1.val == n2.val) {
			if (isMatch(n1, n2)) return true;
		}

		//write return in this way rather than in isMatch() way is a little confused--but functions as a same way!!
		//choose whatever simple
		return isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
	}

}
