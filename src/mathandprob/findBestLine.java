package mathandprob;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class findBestLine {

	public Line findBestLine(Point[] points) {
		// TODO Auto-generated constructor stub
		Line bestLine = null;
		int bestCount = 0;
		HashMap<Double, ArrayList<Line>> lineBySlope = new HashMap<Double, ArrayList<Line>>();
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = new Line(points[i], points[j]);
				insertLine(lineBySlope, line);
				int count = countEquivalents(lineBySlope, line);
				if (count > bestCount) {
					bestLine = line;
					bestCount = count;
				}
			}
		}
		return bestLine;
	}

	private void insertLine(HashMap<Double, ArrayList<Line>> lineBySlope, Line line) {
		ArrayList<Line> lines = null;
		
		double key = line.floorToNearestEpsilon(line.slope);
		if (!lineBySlope.containsKey(key)) {
			lines = new ArrayList<Line>();
			lineBySlope.put(key, lines);
		} else {
			lines = lineBySlope.get(key);
		}
		
		lines.add(line);
	}
	
	public int countEquivalents(HashMap<Double, ArrayList<Line>> lineBySlope, Line line) {
		double key = line.floorToNearestEpsilon(line.slope);
		double eps = Line.epsilon;
		
		//get similar value key from hash table +-epsilon
		int count = countEquivalentLines(lineBySlope.get(key), line) + 
				countEquivalentLines(lineBySlope.get(key - eps), line) + 
				countEquivalentLines(lineBySlope.get(key + eps), line);
		
		return count;
	}
	
	private int countEquivalentLines(ArrayList<Line> lines, Line line) {
		if (lines == null) return 0;
		
		int count = 0;
		for (Line parallelLine: lines) {
			if (parallelLine.isEquivalent(line)) {
				count++;
			}
		}
		return count;
	}
	
	
	public class Line {
		public double slope;
		public double intercept;
		private boolean infinite_slope = false;
		public final static double epsilon = 0.0001;
		
		public Line(Point p1, Point p2) {
			if (Math.abs(p1.x - p2.x) > epsilon) {
				slope = (p1.y - p2.y) / (p1.x - p2.x);
				intercept = p1.y - slope * p1.x;
			} else {
				infinite_slope = true;
				intercept = p1.x;
			}
		}
		
		public  double floorToNearestEpsilon(Double d) {
			//in this way, can get the int format of a floating number 
			int r = (int)(d / epsilon);
			return ((double) r) * epsilon;
		}

		public boolean isEquivalent(Line o) {
			if (isEquivalent(o.slope, slope) && isEquivalent(o.intercept, intercept) && o.infinite_slope == infinite_slope) {
				return true;
			} else {
				return false;
			}
		}

		private boolean isEquivalent(double a, double b) {
			// TODO Auto-generated method stub
			return Math.abs(a - b) < epsilon;
		}
	}
	
	private class Point {
		double x;
		double y;
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
