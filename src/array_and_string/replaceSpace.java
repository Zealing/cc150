package array_and_string;

public class replaceSpace {

	public String replaceSpace (String s) {
		char[] content = s.toCharArray();
		int cnt = 0;
		for (int i = 0 ; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				cnt++;
			}
		}
		
		int newlength = s.length() + cnt * 2;
		
		content[newlength] = '\0';
		
		for (int i = content.length; i > 0; i--) {
			if (content[i] == ' ') {
				content[newlength - 1] = '0';
				content[newlength - 2] = '2';
				content[newlength - 3] = '%';
				newlength = newlength - 3;
			} else {
				content[newlength - 1] = content[i];
				newlength--;
			}
		}
		
		return " ";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
