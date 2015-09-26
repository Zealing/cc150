package mathandprob;

public class primeFactor {

	public int removeMin(Queue<Integer> q) {
		int min = (int) q.peek();
		
		for (Integer v: q) {
			if (min > v) {
				min = v;
			}
		}
		
		while (q.contains(min)) {
			q.remove(min);
		}
		return min;
	}
	
	public static void addProducts(Queue<Integer> q, int v) {
		q.enqueue(v * 3);
		q.enqueue(v * 5);
		q.enqueue(v * 7);
	}
	
	public int getKthNumber(int k) {
		if (k < 0) return 0;
		
		int val = 1;
		Queue<Integer> q = new Queue<Integer>();
		addProducts(q, 1);
		for (int i = 0; i < k; i++) {
			val = removeMin(q);
			addProducts(q, val);
		}
		return val;
	}
	
	public boolean isPrime(int n) {
		
	}
	
	public int primeFactor(int n) {
		
	}
	
	public primeFactor() {
		// TODO Auto-generated constructor stub
	}

}
