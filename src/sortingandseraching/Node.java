package sortingandseraching;

public class Node {

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
