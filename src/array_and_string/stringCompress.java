package array_and_string;

public class stringCompress {

	public String compressbad(String s) {
		String content = "";
		int count = 1;
		char before = s.charAt(0);
		
		//start from 1 rather than 0---already put s[0] in line
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == before) {
				count++;
			} else { //add before chars into array and renew before and count
				content = content + before + "" + count;
				before = s.charAt(i);
				count = 1;
			}
		}
		
		return content + before + "" + count;
	}
	
	public String compressbetter(String s) {
		StringBuffer sb = new StringBuffer();
		
		int count = 1;
		char before = s.charAt(0);
		
		//start from 1 rather than 0---already put s[0] in line
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == before) {
				count++;
			} else { //add before chars into array and renew before and count
				sb.append(before);
				sb.append(count);
				before = s.charAt(i);
				count = 1;
			}
		}
		
		sb.append(before);
		sb.append(count);
		
		//check the size of compressed string
		if (sb.toString().length() >= s.length()) {
			return s;
		}
		
		return sb.toString();
	}
	
	//using character array rather than String to reduce running time
	public String compressgood(String s) {
		if (s.length() <= countCompression(s)) {
			return s;
		}
		
		char[] chars = s.toCharArray();
		
		//make sure that the new array will NOT overlength the original one!!--use a new method
		char[] content = new char[chars.length];
		int count = 1;
		int index = 0;
		char before = chars[0];
		
		//start from 1 rather than 0---already put s[0] in line
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == before) {
				count++;
			} else { //add before chars into array and renew before and count
				//make sure to convert the int into chars!!
				index = setChar(content, index, before, count);
				before = s.charAt(i);
				count = 1;
			}
		}
		
		index = setChar(content, index, before, count);
		
		return content.toString();
	}
	private int setChar(char[] array, int index, char before, int count) {
		array[index] = before;
		index++;
		
		//convert int into char
		char[] cnt = String.valueOf(count).toCharArray();
		
		//copy cnt into original array
		for (char x: cnt) {
			array[index] = x;
			index++;
		}
		
		return index;
	}
	private int countCompression(String s) {
		if (s.isEmpty() || s == null) {
			return 0;
		}
		
		int size = 0;
		int count = 1;
		char before = s.charAt(0);
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == before) {
				count++;
			} else {
				size = size + 1 + String.valueOf(count).length();
				before = s.charAt(i);
				count = 1;
			}
		}
		
		size = size + 1 + String.valueOf(count).length();
		
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
