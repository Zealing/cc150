package sortingandseraching;

import java.util.Hashtable;
import java.util.LinkedList;

public class anagram {

	public void sort(String[] array) {
		//first, create a hash map: key is string, value is the linked list to store anagrams
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		
		for (String s: array) {
			//sorting the string --- but do not change it!
			String key = sortChar(s);
			if (!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		//convert hash table into array
		int index = 0;
		for (String key: hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for (String t: list) {
				array[index++] = t;
			}
		}
	}
	
	public anagram() {
		// TODO Auto-generated constructor stub
	}

}
