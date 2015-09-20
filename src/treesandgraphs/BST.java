package treesandgraphs;

public class BST <Key extends Comparable<Key>, Value>{

	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int count;
		
		public Node(Key key2, Value val2) {
			// TODO Auto-generated constructor stub
			this.key = key2;
			this.val = val2;
		}
	}
	
	private Node root; 
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if (x == null) {
			return 0;
		}
		
		return x.count;
	}
	
	public Node min (Node x) {
		while (x.left != null) {
			x = x.left;
		}
		
		return x;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		//if cannot find the node with key, then create a new node with val
		if (x == null) {
			return new Node(key, val);
		}
		
		int temp = key.compareTo(x.key);
		if (temp > 0) {
			x.right = put(x.right, key, val);
		} else if (temp < 0) {
			x.left = put(x.left, key, val);
		} else if (temp == 0) {
			x.val = val; //if can find x in tree, then reset that node's value to new value in put method
		}
		
		//using recursion to calculate each node's count---very brilliant 
		x.count = 1 + size(x.left) + size(x.right);
		
		return x;
	}
	
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int temp = key.compareTo(x.key);
			if (temp > 0) {
				x = x.right;
			} else if (temp < 0) {
				x = x.left;
			} else if (temp == 0) {
				return x.val;
			}
			
		}
		
		return null;
		
	}
	
	//recursive way to do delete min
	public Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.right) + size(x.left);
		
		return x;
	}
	
	//recursive way to do delete
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		} 
		
		int temp = key.compareTo(x.key);
		if (temp > 0) {
			x.right = delete(x.right, key);
		} else if (temp < 0) {
			x.left = delete(x.left, key);
		} else {
			//already find the node, determine which case it is
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			
			//if has two children
			Node t = x;
			x = min(t.right); // set the new node be the min of right subtree
			x.right = deleteMin(t.right);//set the right node to the parent of min in the right subtree
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public Iterable<Key> iterator() {
		return null;
		
	}
	
	public BST() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
