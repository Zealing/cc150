package linkedlist;

public class LinkedListNode {
	LinkedListNode next = null;
	LinkedListNode previous = null;
	int data;
	
	
	public LinkedListNode(int d) {
		// TODO Auto-generated constructor stub
		data = d;
	}
	
	//overwrite
	public LinkedListNode(int d, LinkedListNode next, LinkedListNode previous) {
		// TODO Auto-generated constructor stub
		data = d;
		this.next = next;
		this.previous = previous;
	}
	
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
