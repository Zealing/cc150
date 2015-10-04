package recursionandDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class allParent {

	public Set<String> genParent(int remaining) {
		Set<String> set = new HashSet<String>();//using hash set to implement --- automatically check dupliate!!
		
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = genParent(remaining - 1);
			
			for (String str: prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						
						set.add(s);
					}
				}
				if (!set.contains("()" + str)) {
					set.add("()" + str);
				}
			}
		}
		return set;
	}
	
	//a little different from permutation which adds new char both sides of str
	private String insertInside(String str, int i) {
		return str.substring(0, i + 1) + "()" + str.substring(i + 1);
	}

	public allParent() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> genParentGood(int count) {
		char[] str = new char[count * 2]; //experimental string in char format
		ArrayList<String> list = new ArrayList<String>();//place to add permutations
		addParen(list, count, count, str, 0);
		return list;
	}

	private void addParen(ArrayList<String> list, int leftRem, int rightRem,
			char[] str, int count) {
		//first check the restriction
		if (leftRem < 0 || rightRem < leftRem) return;
		
		//if no remaining parenthesis to add, then just add this permutation into list
		if (leftRem == 0 && rightRem == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			//if has left remaining -- add ( into the string and do recursion
			if (leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			
			//if more right than left remaining---add a ) into string
			if (rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
		
		
	}
	
}
