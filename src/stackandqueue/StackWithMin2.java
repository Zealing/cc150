package stackandqueue;

public class StackWithMin2 extends Stack<Integer>{

	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		
		super.push(value);
	}
	
	public Integer pop() {
		int value = (int) super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return (int) s2.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
