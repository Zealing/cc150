package array_and_string;

public class setZeros {

	public void setZeroes (int[][] m) {
		boolean[] row = new boolean[m.length];
		boolean[] cln = new boolean[m[0].length];
		
		//make sure to scan the column first!!--space efficiency
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					row[i] = true;
					cln[j] = true;
				}
			}
		}
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (row[i] || cln[j]) {
					m[i][j] = 0;
				}
			}
		}
	}
	
}
