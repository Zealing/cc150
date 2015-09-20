package stackandqueue;

public class Tower {

	private int index;
	private Stack<Integer> disks;
	
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && (int)disks.peek() <= d) {
			System.out.println("error placing disk" + d);
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = (int)disks.pop();
		t.add(top);
		System.out.println("Move disk" + top + "from" + this.index() + "to" + t.index());
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
	
	public static void main(String[] args) {
		//initialization
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < n; i++) {
			towers[i] = new Tower(i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		
		//recursion
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
