package treesandgraphs;

public class createMinimalBST {

	private TreeNode createMinimalBST(int arr[], int start, int end) {
		// TODO Auto-generated constructor stub
		if (start > end) return null;
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		
		return n;
	}
	
	public TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}

}
