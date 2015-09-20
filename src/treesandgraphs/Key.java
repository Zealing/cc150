package treesandgraphs;

public class Key<Item> {
	
	Item item;

	public Key() {
		// TODO Auto-generated constructor stub
	}
	
	public int compareTo(Key<Item> key2) {
		if ((int)this.item > (int)key2.item) {
			return 1;
		} else if ((int)this.item == (int)key2.item) {
			return 0;
		} else if ((int)this.item == (int)key2.item) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
