package sortingandseraching;

public class merge {

	public int[] merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerge = lastA + lastB - 1;
		
		//merge A and B starting from the last element of each arrary and ignore the value for A
		while (indexA >= 0 && indexB >= 0) {
			if (a[indexA] > b[indexB]) {
				a[indexMerge--] = a[indexA--];
			} else {
				a[indexMerge--] = b[indexB--];
				
			}
		}
		
		//after the loop--if there is element left in array B, copy to a---no need to copy a to a
		while (indexB >= 0) {
			a[indexMerge--] = b[indexB--];
		}
		
		return a;
	}
	
	public merge() {
		// TODO Auto-generated constructor stub
	}

}
