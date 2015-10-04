package sortingandseraching;

//find the kth largest or smallest in a given array--quite similar to quick sort
public class selection {

	public static Comparable select(Comparable[] a, int k) {
		shuffle(a);
		
		int lo = 0;
		int hi = a.length - 1;
		while (hi > lo) {
			int j = quickSort.partition(a, lo, hi);
			if (j > k) 		hi = j - 1;
			else if (j < k) lo = j + 1;
			else 			return a[k];
		}
		return a[k];
	}
	
	public selection() {
		// TODO Auto-generated constructor stub
	}

}
