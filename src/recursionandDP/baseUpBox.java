package recursionandDP;

import java.util.ArrayList;

public class baseUpBox {

	public ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		return max_stack;
	}
	
	public baseUpBox() {
		// TODO Auto-generated constructor stub
	}

	private class Box {
		
	}
}
