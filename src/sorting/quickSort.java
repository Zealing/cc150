package sorting;

public class quickSort {

	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		
		while (true) {
			while (less(a[++i], a[lo])) {
				if (i == hi) break;
			}
			
			while (less(a[lo], a[--j])) {
				if (j == lo) break;//not necessary -- never could touch it!
			}
			
			//check if two pointers are crossed!!
			if (i >= j) break;
			exch(a, i, j);
		}
		
		exch(a, lo, j);//exchange the value of pointers lo and j
		return j; //return the partitioning index after partitioning
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		// TODO Auto-generated method stub
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		if (comparable.compareTo(comparable2) == -1) return true;
		
		return false;
	}
	
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		
		//pay attention to the cornoer number!!
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	//3-way quick sort to solve duplicate keys
	private static void sort3way (Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int lt = lo; 
		int gt = hi;
		//store the original lo key
		Comparable v = a[lo];
		
		int i = lo;
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) 		exch(a, lt++, i++);
			else if (cmp > 0)   exch(a, i, gt--);
			else 				i++;
		}
		
		sort3way(a, lo, lt - 1);
		sort3way(a, gt + 1, hi);
	}
	
	public quickSort() {
		// TODO Auto-generated constructor stub
	}

}
