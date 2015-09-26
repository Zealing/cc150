package sorting;

public class mergeSort {

	private static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		//using assertion to hep DEBUGGING
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		
		//copy whole array into auxiliary array to do merge
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		//do merge
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			//if i pointer exhausted--that is out of range, then just put j's value into array
			if (i > mid) 					a[k] = aux[j++];
			//vice versa 
			else if (j > hi) 				a[k] = aux[i++];
			//course's method is OK but writing in a different way---more tricky
			else if (less(aux[j], aux[i]))  a[k] = aux[j++];
			else 							a[k] = aux[i++];
		}
		
		assert isSorted(a, lo, hi);
	}
	
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		for (int i = lo; i < hi; i++) {
			if (a[i].compareTo(a[i+1]) == 1) return false; 
		}
		return true;
	}

	private static boolean less(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		if (comparable.compareTo(comparable2) == -1) return true;
		
		return false;
	}

	//the main sorting code is relatively simpler than merge--just recursion
	public static void sort (Comparable[] a, Comparable[] aux, int lo, int hi) {
		//check input bug
		if (hi <= lo) return;
		
		int mid = (lo + hi) / 2;
		sort(a, aux,lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
		
	}
	
	public static int CUTOFF = 7;
	public static void sortWithInsertion(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		
		//pay attention to corner number!!
		if (hi <= lo + CUTOFF - 1) {
			insertionSort.sort(a, lo, hi);
			return;
		}
		
		int mid = (lo + hi) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sortPartially (Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		
		int mid = (hi + lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		//check out whether the last element in former array is smaller or equal to the first in latter array
		if(!less(a[mid + 1], a[mid])) return;
		
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sortNoCopy(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		
		int mid = (hi + lo) / 2;
		//switch the role of a and aux in each recursive call
		sortNoCopy(aux, a, lo, mid);
		sortNoCopy(aux, a, mid + 1, hi);
		//pay attention to the position of a and aux in each recursive call!!
		merge(a, aux, lo, mid, hi);
	}
	
	private static void mergeNoCopy(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		//do merge
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			//pay attention to the position of aux and a!!
			if (i > mid) 					aux[k] = a[j++];
			else if (j > hi) 				aux[k] = a[i++];
			else if (less(aux[j], aux[i]))  aux[k] = a[j++];
			else 							aux[k] = a[i++];
		}
	}
	
	//bottom up version of merge sort--very concise but easy to write it BUGGY
	private static Comparable[] aux;
	public static void sortBottomUp(Comparable[] a) {
		int n = a.length;
		aux = new Comparable[n];
		for (int sz = 1; sz < n; sz += sz) {
			for (int lo = 0; lo < n - sz; lo += sz + sz) {
				//note that lo pointer should jump 2sz to get next piece of array
				//take care of lo, mid and hi pointer
				merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz -1, n - 1));
			}
		}
	}
	
	public mergeSort(Comparable[] a) {
		// TODO Auto-generated constructor stub
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

}
