package treesandgraphs;

public class FirstCommonAncestor {
	
	boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		
		return covers(root.left, p) || covers(root.right, p);
	}
	
	TreeNode CommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		//check out whether root is q or p---if it is, there is no need to do recursion
		if (root == q || root == p) return root;
		
		//only need to compare one side: left or right--BRILLANT!!!!
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		
		if (is_p_on_left != is_q_on_left) return root;
		
		TreeNode childSide = is_p_on_left? root.left:root.right;
		return CommonAncestorHelper(childSide, p, q);
	}

	public TreeNode FCA(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) return null;
		
		return CommonAncestorHelper(root, p, q);
	}
	
	public FirstCommonAncestor() {
		// TODO Auto-generated constructor stub
	}

}
