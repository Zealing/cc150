package stackandqueue;

import java.util.ArrayList;

public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	Node top = null;
	int capacity = 10;
	int stackPointer = -1;
	int countSize = 0;
	
	public SetOfStacks (int capacity) {
		this.capacity = capacity;
	}
	
	public void push(int item) {
		Stack last = getLastStack();
		
		if (last != null && !last.isFull()) {
			last.push(item);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(item);
			stacks.add(stack);//add the new created stack into the arraylist of stacks
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		
		int v = (int) last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		} 
		
		return v;
	}
	
	public Stack getLastStack() {
		if (stacks.size() == 0) return null;
		
		return stacks.get(stacks.size() - 1);
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
