package stackandqueue;

public class Node {
	Node next = null;
	Node previous = null;
	Object data;
	
	
	public Node(Object item) {
		// TODO Auto-generated constructor stub
		data = item;
	}
	
	//overwrite
	public Node(int d, Node next, Node previous) {
		// TODO Auto-generated constructor stub
		data = d;
		this.next = next;
		this.previous = previous;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
