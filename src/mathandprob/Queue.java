package mathandprob;

public class Queue<Element> {
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
	
	public void remove(Object data) {
		Node i = first;
		while (i != null) {
			if (i.data == data) {
				i.previous.next = i.next;
				i.next.previous = i.previous;
				break;
			}
		}
		return;
	}
	
	public Object peek() {
		return first.data;
	}
	
	public boolean contains(Object data) {
		Node i = first;
		while (i != null) {
			if (i.data == data) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
