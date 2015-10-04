package recursionandDP;

import java.util.ArrayList;

public class allPermutation {

	public ArrayList<String> getpermutation(String str) {
		if (str == null) {
			return null;
		}
		
		ArrayList<String> permutation = new ArrayList<String>();
		
		if (str.length() == 0) {
			permutation.add("");
			return permutation;
		}
		
		char first = str.charAt(0); //get the first char
		String reminder = str.substring(1); //delete the first char
		
		ArrayList<String> words = getpermutation(reminder);//do recursion to get all permuation of last set
		for (String word: words) {
			for (int i = 0; i < word.length(); i++) {
				String s = insertCharAt(word, first, i);
				permutation.add(s);
			}
		}
		
		return permutation;
	}
	
	private String insertCharAt(String word, char first, int i) {
		String temp = word.substring(0, i) + first + word.substring(i);
		return temp;
	}
	
	public allPermutation() {
		// TODO Auto-generated constructor stub
	}

}
