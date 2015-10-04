package sortingandseraching;

public class rotateSearch {

	public int search(int[] a, int value) {
		int lo = 0;
		int hi = a.length - 1;
		int mid;
		
		if (a[lo] < a[hi]) {
			while (lo <= hi) {
				mid = (lo + hi) / 2;
				if (a[mid] < value) {
					lo = mid + 1;
				} else if (a[mid] > value) {
					hi = mid - 1;
				} else {
					return mid;
				}
			}
		} else {
			while (lo >= hi) {
				mid = (lo + hi) / 2;
				if (a[mid] < value) {
					hi = mid - 1;
				} else if (a[mid] > value) {
					lo = mid + 1;
				} else {
					return mid;
				}
			} 
		}
		return -1;
	}
		
	
	public rotateSearch() {
		// TODO Auto-generated constructor stub
	}

}
