package sortingandseraching;

public class interspersedSearch {

	public int search(String[] strings, String str) {
		//error check
		if (strings == null || str == null || str == "") {
			return -1;
		}
		
		return searchR(strings, str, 0, strings.length - 1);
	}
	
	private int searchR(String[] strings, String str, int first, int last) {
		if (first > last) {
			return -1;
		}
		
		int mid = (first + last) / 2;
		//if mid is empty --- find the closest non-empty node
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			
			while (true) {
				//error check
				if (left < first && right > last) {
					return -1;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				}
				left++;
				right++;
			}
		}
		
		//do recursion to find the string
		if (strings[mid].equals(str)) {
			return mid;
		} else if (strings[mid].compareTo(str) < 0) {
			return searchR(strings, str, mid + 1, last);
		} else {
			return searchR(strings, str, first, mid - 1);
		}
	}

	public interspersedSearch() {
		// TODO Auto-generated constructor stub
	}

}
