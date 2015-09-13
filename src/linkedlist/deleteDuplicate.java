package linkedlist;

import java.util.Hashtable;

public class deleteDuplicate {

	public static void deleteDuplicate(LinkedListNode n) {
		Hashtable ht = new Hashtable();

		LinkedListNode previous = null;
		
		while (n != null) {
			if (ht.containsKey(n)) {
				previous.next = n.next;
			} else {
				ht.put(n.data, true);
				previous = n;
			}
			
			n = n.next;
		}
	}
	
	public static void deleteDuplicateB(LinkedListNode head) {
		//in linked list, similar to array, linked list's name is also only the host for the specific list
		LinkedListNode current = head;
		
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
