package linkedlist;

public class findLoop {

	public LinkedListNode detectLoop (LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		LinkedListNode collision = null;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				collision = slow;
				break;
			}
		}
		
		return collision;
	}
	
	public LinkedListNode findLoop (LinkedListNode head) {
		LinkedListNode pTail = detectLoop(head);
		LinkedListNode pHead = head;
		
		if (pTail == null) {
			return null;
		}
		
		while (pHead != pTail) {
			pHead = pHead.next;
			pTail = pTail.next;
		}
		
		LinkedListNode start = pHead;
		
		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
