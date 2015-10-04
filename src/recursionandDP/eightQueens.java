package recursionandDP;

import java.util.ArrayList;

public class eightQueens {

	int GRID_SIZE = 8;
	
	//no need to create a matrix---because only one queen in each row and column -- 
	//just maintain an array with index of columns and value as row
	public void placeQueen(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {//at the last step--success
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col;//place a queen
					placeQueen(row + 1, columns, results);//do recursion
				}
			}
		}
	}
	
	//very elegant way to check all rows and columns 
	private boolean checkValid(Integer[] columns, int row1, int column1) {
		// TODO Auto-generated method stub
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			
			if (column2 == column1) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2; //naturally row1 will larger than row2; 
			
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

	public eightQueens() {
		// TODO Auto-generated constructor stub
	}

}
