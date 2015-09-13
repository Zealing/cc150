package stackandqueue;

public class StackWithMin extends Stack<NodeWithMin>{

	public void push(int value) {
		int newmin = Math.min(value, min());
	}
	
	public int min() {
		return peek().min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
