package linkedlist;

import java.util.Stack;

public class isPalindrome {

	public boolean isPalindrome (LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//if odd number, skip the middle
		if (fast == null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			
			if (slow.data != top) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
