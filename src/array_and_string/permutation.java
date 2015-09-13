package array_and_string;

public class permutation {

	public String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return content.toString();
	}
	
	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		return (sort(s).equals(sort(t)));
	}
	
	//or another way: count the number of characters appearing in those two strings and compare them
	public boolean permutationB(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int [] letters = new int [256]; //ASCII
		
		//can use for-each loop rather than normal for loop--make sure to change the string to an array
		char [] content = s.toCharArray();
		for (char c: content) {
			letters [c]++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			int tmp = (int) t.charAt(i);
			
			//fantastic!!!using the count number as a kind of flag!!
			if (--letters[tmp] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
