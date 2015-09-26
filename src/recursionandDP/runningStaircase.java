package recursionandDP;

public class runningStaircase {

	public int countWays (int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n = 2) + countWays(n - 3);
		}
	}
	
	public int countWaysDP (int n) {
		int[] set = new int[n];
		
		if (n < 0) {
			return 0;
			
		} else if (n == 0) {
			return 1;
		} else if (set[n] > -1) {
			return set[n];
		} else {
			set[n] = countWaysDP(n - 1) + countWaysDP(n - 2) + countWaysDP(n - 3);
			return set[n];
		}
		
	}
	
	public runningStaircase() {
		// TODO Auto-generated constructor stub
	}

}
