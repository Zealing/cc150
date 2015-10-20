package sortingandseraching;

public class selectionSort {

	public selectionSort() {
		// TODO Auto-generated constructor stub
	}

	public void seleSort(int[] a) {
		if (a == null) {
			return;
		}
		int min = a[0];
		int minIndex = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			//swap them after comparison 
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
	
}
