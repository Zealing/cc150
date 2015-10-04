package recursionandDP;

public class magicIndex {
	
	public int magicIndexBF(int[] set) {
		for (int i = 0; i < set.length; i++) {
			if (set[i] == i) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int magicIndexBST(int[] set, int start, int end) {
		int mid = (start + end) / 2;
		
		if (set[mid] == mid) {
			return mid;
		} else if (mid > set[mid]) {
			return magicIndexBST(set, mid + 1, end);
		} else {
			return magicIndexBST(set, start, mid - 1);
		}
		
	}

	public magicIndex() {
		// TODO Auto-generated constructor stub
	}

}
