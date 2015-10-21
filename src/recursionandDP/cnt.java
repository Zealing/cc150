package recursionandDP;

public class cnt {

	public int cnta(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = cnta(n-25, map) + cnta(n-10, map) + cnta(n-5, map) + cnta(n-1, map);
			return map[n];
		}
	}
	
	public cnt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		cnt test = new cnt();
		int[] map = new int[26];
		System.out.println(test.cnta(25, map));
		int[] a = new int[10];
		int[] b = new int[10];
		int c = 9, d = 8;
		a[c--] = b[d--];
		test.hashCode();
		int i = 1;
		Long.hashCode(i);
		String s = "zzz";
		s.hashCode();
;	}
}
