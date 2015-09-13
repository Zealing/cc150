package linkedlist;

public class addDigit {

	public LinkedListNode addDigit(LinkedListNode p1, LinkedListNode p2, int carry) {
		if (p1 == null && p2 == null && carry == 0) {
			return null;
		}
		
		LinkedListNode result = new LinkedListNode(carry, null, null);
		
		//adding value
		int value = carry;
		if (p1 != null) {
			value += p1.data;
		}
		
		if (p2 != null) {
			value += p2.data;
		}
		
		result.data = value % 10; //getting the first digit for the adding operation to result
		
		//recursion
		if (p1 != null || p2 != null) {
			LinkedListNode more = addDigit(p1 == null? null:p1.next, p2 == null? null:p2.next, value >= 10? 1:0);
			
			result.setNext(more);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
