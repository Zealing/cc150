package sortingandseraching;

public class insertionSort {
	public static void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a[j], a[j - 1]);
				} else break;
			}
		}
	}

	public static boolean less(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		if (comparable.compareTo(comparable2) == -1) return true;
		
		return false;
	}

	public static void exch(Comparable comparable, Comparable comparable2) {
		// TODO Auto-generated method stub
		Comparable temp = comparable;
		comparable = comparable2;
		comparable2 = temp;
	}
	public insertionSort() {
		// TODO Auto-generated constructor stub
	}

}
