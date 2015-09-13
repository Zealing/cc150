package linkedlist;

public class kthToLast {

	public LinkedListNode kthToLast(LinkedListNode head, int ordertolast) {
		int count = 1;
		
		LinkedListNode n = head;
		
		//get the total nodes in this list
		while (n.next != null) {
			n = n.next;
			count++;
		}
		
		//get the order to head 
		int ordertohead = count - ordertolast + 1;
		
		LinkedListNode n2 = head;
		int count2 = 1;
		
		//get the correct node using scan
		while (count2 != ordertohead) {
			n2 = n2.next;
			count2++;
		}
		
		return n2;
	}
	
	//recursive way--very clean and brilliant
	public int kthToLastRecursion(LinkedListNode head, int ordertolast) {
		if (head == null) {
			return 0;
		}
		
		int i = kthToLastRecursion(head.next, ordertolast) + 1;
		
		if (i == ordertolast) {
			System.out.println(head.data);
		}
		
		return i;
	}
	
	//iterative way--using two pointers and very brilliant!
	public LinkedListNode kthToLastIteration(LinkedListNode head, int ordertolast) {
		//constraint
		if (ordertolast <= 0) {
			return null;
		}
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for (int i = 0; i < ordertolast - 1; i++) {
			if (p2 == null) {//error check
				return null;
			}
			p2 = p2.next;
		}
		
		if (p2 == null) return null; //error check
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
