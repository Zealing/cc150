package sortingandseraching;

public class bubbleSort {

	public bubbleSort() {
		// TODO Auto-generated constructor stub
	}

	public void sort(int[] a) {
		if (a == null) {
			return;
		}
		boolean flag = true;
		int temp = 0;
		while (flag) {
			flag = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					flag = true;
				}
			}
		}
	}
	
}
