package stackandqueue;

public class Queue {
	Node first;
	Node last;
	
	public void enqueue(Object item) {
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			Node l = new Node(item);
			last.next = l;
			last = l;
		}
	}
	
	//require return content of that NODE!!
	public Object dequeue() {
		if (first != null) {
			Object content = first.data;
			first = first.next;
			return content;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
