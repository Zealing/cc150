package array_and_string;

public class isRotation {

	public boolean isRotation(String s, String m) {
		if (s.length() != m.length()) {
			return false;
		}
		
		String ss = new String(s + s);
		
		return isSubstring(m, ss);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
