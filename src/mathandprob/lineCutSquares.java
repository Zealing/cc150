package mathandprob;

public class lineCutSquares {
	public Square s1;
	public Square s2;
	
	private class Point {
		public double x;
		public double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private class Square {
		Point left;
		Point right;
		Point top;
		Point down;
		
		public Square(Point left, Point right, Point top, Point down) {
			this.left = left;
			this.right = right;
			this.top = top;
			this.down = down;
		}
	}
	
	public Point middle(Point left, Point right, Point top, Point down) {
		double x = (right.x + left.x) / 2.0;
		double y = (top.y + down.y) / 2.0;
		
		return new Point(x, y);
	}
	
	public Line getLine(Point m1, Point m2, Square s1, Square s2) {
		//if first square is in the top of second, do reverse to simplify the process
		if (m1.y > m2.y) return getLine(m2, m1, s2, s1);
		
		double slope;
		Point start = null;
		Point end = null;
		
		double xdir = m1.x < m2.x? 1:-1;
		double ydir = m1.y < m2.y? 1:-1;
		
		if (m1.x == m2.x && m1.y == m2.y) {
			throw new IllegalArgumentException("same square!");
		} else if (m1.x == m2.x) {
			start = new Point(m1.x, s1.down.y);
			end = new Point(m1.x, s2.top.y);
			
			return new Line(start, end);
		} else {
			slope = (m1.y - m2.y) / (m1.x - m2.x);
		}
		
		//calculate the intercept with x-coordinate
		double xintercept = m1.y - slope * m1.x;
		
		//determine the edge of the line
		if (slope > 1) {
			//intercept in the top or down of two squares
			start = new Point((s1.down.y - xintercept) / slope, s1.down.y);
			end = new Point((s2.top.y - xintercept) / slope, s2.top.y);
			
		} else if (slope == 1) {
			start = new Point(s1.left.x, s1.left.y);
			end = new Point(s1.right.x, s2.right.y);
		} else if (slope < 1) {
			
		}
		
		return new Line(start, end);
	}
	
	private class Line {
		public Point p1;
		public Point p2;
		
		public Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	public lineCutSquares() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

	}
}
