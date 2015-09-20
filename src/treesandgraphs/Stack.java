package treesandgraphs;

import java.util.Iterator;

public class Stack<Element> implements Iterable<Integer> {
	Node top;
	int size = 0;
	int capacity;
	
	public Stack(int capacity2) {
		// TODO Auto-generated constructor stub
		capacity = capacity2;
	}

	public Stack() {
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

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
