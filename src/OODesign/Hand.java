package OODesign;

import java.util.ArrayList;

//cards in hand --- maintain an array list
public class Hand<T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score() {
		int score = 0;
		for (T card: cards) {
			score += card.value;
		}
		return score;
	}

	public Hand() {
		// TODO Auto-generated constructor stub
	}

}
