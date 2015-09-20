package treesandgraphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Element> implements Iterable<Element>{
	Node first;
	Node last;
	int size;
	
	public void enqueue(Object item) {
		if (first == null) {
			first = new Node(item);
			last = first;
			size++;
		} else {
			Node l = new Node(item);
			last.next = l;
			last = l;
			size++;
		}
	}
	
	//require return content of that NODE!!
	public Object dequeue() {
		if (first != null) {
			Object content = first.data;
			first = first.next;
			size--;
			return content;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterator<Element> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<Element>(first);
	}

	
	private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) current.item;
            current = current.next; 
            return item;
        }
    }
}
