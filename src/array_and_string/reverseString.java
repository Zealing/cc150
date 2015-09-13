

public class reverseString {

	public void reverseString(String s) {
		char tmp;
		int end = s.length() - 1;
		int start = 0;
		while (start < end) {
			tmp = s.charAt(start);
			s.charAt(start) = s.charAt(end);
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
