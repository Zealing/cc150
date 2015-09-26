package OODesign;

public class Card {
	protected int value;
	
	protected Suit suit;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCard(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}

}
