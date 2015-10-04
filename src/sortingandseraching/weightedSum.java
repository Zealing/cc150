package sortingandseraching;

public class weightedSum {
	private int size;
	
	private class Node {
		int index;
		int readTime;
		Node left;
		Node right;
		int leftSum;
		int rightSum;
		int sunDiff;
		
		public Node(int readTime) {
			this.readTime = readTime;
		}
	}
	
	public int searchSum(Node[] a) {
		//get the initial point's left and right sums
		//first, get sum from left
		int i = 0;
		while (a[i].left != null) {
			a[0].leftSum += a[i].left.readTime;
			i = a[i].left.index;
		}
		//then, get sum from right
		while (a[i].right != null) {
			a[0].rightSum += a[i].right.readTime;
			i = a[i].right.index;
		}
		//get initial point's sum difference
		a[0].sunDiff = Math.abs(a[0].leftSum - a[0].rightSum);
		
		//do iteration to calculate sum difference for each node
		int l = 0;
		while (a[l].left != null) {
			a[l].left.leftSum = a[l].leftSum - a[l].left.readTime;
			a[l].left.rightSum = a[l].rightSum + a[l].readTime;
			a[l].left.sunDiff = Math.abs(a[l].left.leftSum - a[l].left.rightSum);
			l = a[l].left.index;
		}
		int r = 0;
		while (a[r].right != null) {
			a[r].right.leftSum = a[r].rightSum + a[r].readTime;
			a[r].right.rightSum = a[r].rightSum - a[r].right.readTime;
			a[r].right.sunDiff = Math.abs(a[r].right.leftSum - a[r].right.rightSum);
			r = a[r].right.index;
		}
		
		//finally, find out the magic point which have smallest sum difference
		int minIndex = 0;
		//also starting from 1 rather than 0
		for (int k = 1; k < size; k++) {
			//no necessary to care about situation of equal -- doesn't matter
			if (a[k].sunDiff < a[minIndex].sunDiff) {
				minIndex = k;
			}
		}
		
		return minIndex + 1;
	}
	
	public weightedSum(Node[] a, int size) {
		//error check
		if (a == null) {
			throw new IllegalArgumentException("wrong input list!");
		}

		//set the size be the given size
		this.size = size;
	}

	public static void main(String[] args) {
		int[] a = {2, 2, 2, 2, 1, 0, 0, 2, 9};
		Node[] test = new Node[5];
		test[0].index = 0;
		test[1].index = 1;
		test[2].index = 2;
		test[3].index = 3;
		test[4].index = 4;
		
		test[0].readTime = 2;
		test[1].readTime = 2;
		test[2].readTime = 1;
		test[3].readTime = 2;
		test[4].readTime = 2;
		
		test[0].left = test[1];
		test[1].left = test[2];
		test[2].left = test[3];
		test[3].left = test[4];
		
		test[1].right = test[0];
		test[2].right = test[1];
		test[3].right = test[2];
		test[4].right = test[3];
		
		weightedSum ws = new weightedSum(test, 5);
		System.out.println(ws.searchSum(test));
		
	}
}
