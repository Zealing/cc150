package linkedlist;

public class partitionList {
	
	public LinkedListNode partition (LinkedListNode head, int value) {
		LinkedListNode p1start = null;
		LinkedListNode p1end = null;
		LinkedListNode p2start = null;
		LinkedListNode p2end = null;
		
		LinkedListNode n = head;
		
		while (n != null) {
			//store the n's next node
			LinkedListNode next = n.next;
			n.next = null;
			
			if (n.data < value) {
				if (p1start == null) {
					p1start = n;
					p1end = p1start;
				} else { //insert at the END!
					p1end.next = n;
					p1end = n;//change the end to the node n
				}
			} else {
				if (p2start == null) {
					p2start = n;
					p2end = p2start;
				} else {
					p2end.next = n;
					p2end = n;//change the end to the node n
				}
			}
			n = next;
		}
		
		if (p1start == null) {
			return p2start;
		}
		
		//merge them into one list!
		p1end.next = p2start;
		
		return p1start;
	}

	public LinkedListNode partitionB (LinkedListNode node, int value) {
		LinkedListNode p1start = null;
		LinkedListNode p2start = null;
		
		while (node != null) {
			LinkedListNode next = node.next;//store the next node before editing it!!
			
			if (node.data < value) {
				//先把node.next 改成 p1start 这个节点--再把start 的节点改为 node 所在的位置--这样 p1start就可以维持在开始的地方
				node.next = p1start;
				p1start = node;
			} else {
				node.next = p2start;
				p2start = node;
			}
			
			node = next;//node所指的节点会最终指向null--超出了链表的范围
		}
		
		if (p1start == null) {
			return p2start;
		}
		
		//merge them
		LinkedListNode head = p1start;
		while (p1start.next != null) {
			p1start = p1start.next;
		}
		p1start.next = p2start;
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
