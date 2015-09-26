package recursionandDP;

import java.util.ArrayList;
import java.util.HashMap;

public class getPath {

	private class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public boolean getPath(int x, int y, ArrayList<Point> path) {
		Point p = new Point(x, y);
		//base case
		if (x == 0 && y == 0) {
			return true; //found the path
		} 
		boolean success = false;
		if (x >= 1&& isFree(x - 1, y)) {
			success = getPath(x - 1, y, path);
		}
		
		if (!success && y >= 1 && isFree(x, y - 1)) {
			success = getPath(x, y - 1, path);
		}
		if (success) {
			path.add(p);//a feasible point -- add it to the path arraylist
		}
		
		return success;
	}
	
	public boolean getPathDP (int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> table) {
		Point p = new Point(x, y);
		//check if the hash map already has the point, if yes -- return the point boolean value directly
		if (table.containsKey(p)) {
			return table.get(p);
		}
		
		boolean success = false;
		if (x >= 1 && isFree(x - 1, y)) {
			success = getPathDP(x - 1, y, path, table);
		}
		
		if (!success && y >= 1 && isFree(x, y - 1)) {
			success = getPathDP(x, y - 1, path, table);
		}
		if (success) {
			path.add(p);
		}
		table.put(p, success); //if the point is a success point -- cache the result into hash map
		return success;
	}
	
	public getPath() {
		// TODO Auto-generated constructor stub
	}

}
