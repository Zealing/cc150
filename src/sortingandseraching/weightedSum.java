package sortingandseraching;

import java.util.Scanner;

public class weightedSum {
	private int size;
	
//	private class Node {
//		int index;
//		int readTime;
//		Node left;
//		Node right;
//		int leftSum;
//		int rightSum;
//		int sunDiff;
//		
//		public Node(int readTime) {
//			this.readTime = readTime;
//		}
//	}
	
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
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("please enter size");
		
		int size = s.nextInt();
		Node[] test = new Node[size];
		
		System.out.println("please enter read time");
		
		for (int i = 0; i < size; i++) {
			test[i] = new Node(s.nextInt());
			test[i].index = i;
		}
		
		System.out.println("please enter relationship");
		
		int count = 0;
		while (count <= ((size * 2) - 2)) {
			int left = s.nextInt() - 1;
			int right = s.nextInt() - 1;
			test[left].right = test[right];
			test[right].left = test[left];
			count++;
		}
		
		weightedSum ws = new weightedSum(test, size);
		System.out.println(ws.searchSum(test));
	}
}
