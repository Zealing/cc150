package sortingandseraching;

public class insersionSort1 {

	public insersionSort1() {
		// TODO Auto-generated constructor stub
	}

	public void insertSort(int[] a) {
		if (a == null) {
			return;
		}
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
				else {
					break;
				}
			}
		}
	}
}
