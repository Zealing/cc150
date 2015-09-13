package stackandqueue;

public class Stack<Element> {
	Node top;
	int capacity = 10;
	int size = 0;
	
	public Stack(int capacity2) {
		// TODO Auto-generated constructor stub
	}

	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			size--;
			return item;
		}
		return null;
	}
	
	public void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
		size++;
	}
	
	public Object peek() {
		return top.data;
	}

	public boolean isEmpty() {
		
		return top == null;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
}
