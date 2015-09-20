package stackandqueue;

public class Sort {

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while (!s.isEmpty()) {
			int temp = (int) s.pop();
			while (!r.isEmpty() && (int)r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
