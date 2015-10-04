package sortingandseraching;

public class matrixFind {

	//very brilliant way
	public boolean find(int[][] matrix, int value) {
		int row = 0;
		int column = matrix[0].length - 1;
		
		while (row < matrix.length && column >= 0) {
			if (matrix[row][column] == value) {
				return true;
			} else if (matrix[row][column] > value) {
				//if the element larger than value -- means that all elements in that column 
				//is larger than that value -- so just decrease the column
				column--;
			} else {
				//if smaller than value -- means that all elements in that row 
				//is smaller than that value -- so just decrease the row
				row--;
			}
		}
		return false;
	}
	
	public Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
		if (!origin.inbound(x) || !dest.inbound(x)) {
			return null;
		}
		if (matrix[origin.row][origin.column] == x) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}
		
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
		Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
		Coordinate p = new Coordinate(0, 0);
		
		while (start.isBefore(end)) {
			p.setToAverage(start, end);
			if (x > matrix[p.row][p.column]) {
				start.row = p.row + 1;
				start.column = p.column + 1;
			} else if (x < matrix[p.row][p.column]) {
				end.row = p.row - 1;
				end.column = p.column - 1;
			} else {
				return p;
			}
		}
		
		//start to spilt the matrix
		return partitionAndSearch(matrix, origin, dest, start, x);
	}
	
	public matrixFind() {
		// TODO Auto-generated constructor stub
	}

}
