package sortingandseraching;

public class ranking {

	private static RankNode root = null;
	
	//construct a BST
	public static void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert(number);
		}
	}
	
	public static int getRankNumber(int number) {
		return root.getRank(number);
	}
	
	private class RankNode{
		public int left_size = 0;
		public RankNode left, right;
		public int data = 0;
		public RankNode(int d) {
			data = d;
		}
		
		public void insert(int d) {
			if (d <= data) {
				//if already have node in left --- do recursion to find no left node
				if (left != null) {
					left.insert(d);
				} else {
					left = new RankNode(d);
					left_size++;
				}
			} else {
				if (right != null) {
					right.insert(d);
				} else {//no need to add the size --- NOT in the left side!!
					right = new RankNode(d);
					
				}
			}
		}
		
		public int getRank(int d) {
			if (d == data) {
				return this.left_size;
			} else if (d < data) {
				if (left == null) {
					return -1;//cannot find the node -- just return -1
				} else {
					return left.getRank(d);
				}
			} else {
				int right_rank = right == null? -1: right.getRank(d);
				if (right_rank == -1) return -1;
				else return left_size + 1 + right_rank;
			}
		}
	}
	
	public ranking() {
		// TODO Auto-generated constructor stub
	}

}
