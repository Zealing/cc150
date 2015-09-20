package treesandgraphs;

public class TreeNode<Key, Value>{
	Key key;
	Value val;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(Key key2, Value val2) {
		// TODO Auto-generated constructor stub
		this.key = key2;
		this.val = val2;
	}

	public TreeNode(Key key2) {
		this.key = key2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
