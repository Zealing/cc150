package recursionandDP;

import java.awt.Color;

import treesandgraphs.Graph;

public class paintFill {

	//recursion approach: x is vertical and y is horizon -- y, x represent the specific point
	public boolean paintFillRecursion(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
			return false;
		}
		
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			paintFillRecursion(screen, x - 1, y, ocolor, ncolor);
			paintFillRecursion(screen, x + 1, y, ocolor, ncolor);
			paintFillRecursion(screen, x, y - 1, ocolor, ncolor);
			paintFillRecursion(screen, x, y + 1, ocolor, ncolor);
			
		}
		return true;
	}
	
	public boolean paintFillRecursion(Color[][] screen, int x, int y, Color ncolor) {
		if (screen[y][x] == ncolor) return false;
		return paintFillRecursion(screen, x, y, screen[y][x], ncolor);	
		}
	
	public paintFill() {
		// TODO Auto-generated constructor stub
	}
	
	//BFS approach
	public boolean pointFillBFS(Graph screen, int nodeIndex, Color ocolor, Color ncolor) {
		
	}

}
