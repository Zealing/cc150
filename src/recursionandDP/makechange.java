package recursionandDP;

public class makechange {

	public int cnt(int n, int demon) {
		int next_d = 0;
		switch(demon) {
		case(25):
			next_d = 10;
			break;
		case(10):
			next_d = 5;
			break;
		case(5):
			next_d = 1;
			break;
		case(1):
			return 1;
		}
		
		int cnt = 0;
		for (int i = 0; i * demon <= n; i++) {
			cnt += cnt(n - i * demon, next_d);
		}
		return cnt;
	}
	
	public makechange() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		makechange test = new makechange();
		System.out.println(test.cnt(25, 25));
	}
}
